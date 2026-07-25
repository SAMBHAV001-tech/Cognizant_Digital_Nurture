import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Student } from '../../models/student.model';
import { StudentService } from '../../services/student.service';
import { PortalStateService } from '../../services/portal-state.service';
import { StudentCardComponent } from '../student-card/student-card.component';
import { SearchFilterPipe } from '../../pipes/search-filter.pipe';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule, FormsModule, StudentCardComponent, SearchFilterPipe],
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  private studentService = inject(StudentService);
  private portalState = inject(PortalStateService);

  students: Student[] = [];
  searchText: string = '';
  selectedStudent: Student | null = null;

  ngOnInit(): void {
    this.studentService.getStudents().subscribe(data => {
      this.students = data;
    });
  }

  onStudentSelected(student: Student): void {
    this.selectedStudent = student;
    this.portalState.setSelectedStudent(student.name);
  }
}
