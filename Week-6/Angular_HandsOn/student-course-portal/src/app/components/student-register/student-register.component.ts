import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from '../../services/student.service';

@Component({
  selector: 'app-student-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './student-register.component.html',
  styleUrls: ['./student-register.component.css']
})
export class StudentRegisterComponent {
  private studentService = inject(StudentService);
  private router = inject(Router);

  studentModel = {
    name: '',
    email: '',
    department: 'Computer Science',
    gpa: 3.5,
    status: 'Active' as const,
    courses: []
  };

  submitted = false;

  onSubmit(form: any): void {
    if (form.valid) {
      this.studentService.addStudent({
        ...this.studentModel,
        enrolledDate: new Date().toISOString().split('T')[0]
      }).subscribe(() => {
        this.submitted = true;
        setTimeout(() => {
          this.router.navigate(['/students']);
        }, 1500);
      });
    }
  }
}
