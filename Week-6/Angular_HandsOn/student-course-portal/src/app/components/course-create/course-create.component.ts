import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormArray, Validators, ReactiveFormsModule, AbstractControl, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { delay, map } from 'rxjs/operators';
import { CourseService } from '../../services/course.service';

function feeRangeValidator(min: number, max: number) {
  return (control: AbstractControl): ValidationErrors | null => {
    if (control.value !== null && (isNaN(control.value) || control.value < min || control.value > max)) {
      return { feeRange: { min, max, actual: control.value } };
    }
    return null;
  };
}

@Component({
  selector: 'app-course-create',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './course-create.component.html',
  styleUrls: ['./course-create.component.css']
})
export class CourseCreateComponent implements OnInit {
  private fb = inject(FormBuilder);
  private courseService = inject(CourseService);
  private router = inject(Router);

  courseForm!: FormGroup;
  submitted = false;

  ngOnInit(): void {
    this.courseForm = this.fb.group({
      code: ['', [Validators.required, Validators.pattern(/^[A-Z]{2,4}-\d{3,4}$/)], [this.codeAsyncValidator.bind(this)]],
      name: ['', [Validators.required, Validators.minLength(5)]],
      instructor: ['', Validators.required],
      credits: [3, [Validators.required, Validators.min(1), Validators.max(6)]],
      fee: [15000, [Validators.required, feeRangeValidator(1000, 50000)]],
      startDate: ['', Validators.required],
      duration: ['8 Weeks', Validators.required],
      status: ['Active', Validators.required],
      prerequisites: this.fb.array([
        this.fb.control('TypeScript Basics')
      ])
    });
  }

  get prerequisitesArray(): FormArray {
    return this.courseForm.get('prerequisites') as FormArray;
  }

  addPrerequisite(): void {
    this.prerequisitesArray.push(this.fb.control('', Validators.required));
  }

  removePrerequisite(index: number): void {
    this.prerequisitesArray.removeAt(index);
  }

  codeAsyncValidator(control: AbstractControl): Observable<ValidationErrors | null> {
    if (!control.value) return of(null);
    return this.courseService.isCodeExists(control.value).pipe(
      delay(300),
      map(exists => (exists ? { codeTaken: true } : null))
    );
  }

  onSubmit(): void {
    if (this.courseForm.valid) {
      const formVal = this.courseForm.value;
      this.courseService.addCourse({
        code: formVal.code,
        name: formVal.name,
        instructor: formVal.instructor,
        credits: formVal.credits,
        fee: formVal.fee,
        startDate: formVal.startDate,
        duration: formVal.duration,
        status: formVal.status,
        prerequisites: formVal.prerequisites.filter((p: string) => p.trim().length > 0)
      }).subscribe(() => {
        this.submitted = true;
        setTimeout(() => {
          this.router.navigate(['/courses']);
        }, 1500);
      });
    } else {
      this.courseForm.markAllAsTouched();
    }
  }
}
