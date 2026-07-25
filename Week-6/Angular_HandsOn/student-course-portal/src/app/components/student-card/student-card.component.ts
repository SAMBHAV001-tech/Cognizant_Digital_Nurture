import { Component, Input, Output, EventEmitter, OnInit, OnChanges, OnDestroy, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../models/student.model';
import { HighlightDirective } from '../../directives/highlight.directive';

@Component({
  selector: 'app-student-card',
  standalone: true,
  imports: [CommonModule, HighlightDirective],
  templateUrl: './student-card.component.html',
  styleUrls: ['./student-card.component.css']
})
export class StudentCardComponent implements OnInit, OnChanges, OnDestroy {
  @Input() student!: Student;
  @Output() selectStudent = new EventEmitter<Student>();

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
  }

  ngOnDestroy(): void {
  }

  onSelect(): void {
    this.selectStudent.emit(this.student);
  }
}
