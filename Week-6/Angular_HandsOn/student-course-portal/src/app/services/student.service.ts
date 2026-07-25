import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Student } from '../models/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private students: Student[] = [
    {
      id: 1,
      name: 'Aarav Sharma',
      email: 'aarav.sharma@example.com',
      department: 'Computer Science',
      gpa: 3.85,
      enrolledDate: '2025-08-01',
      status: 'Active',
      courses: ['Angular Mastery', 'TypeScript Deep Dive']
    },
    {
      id: 2,
      name: 'Priya Patel',
      email: 'priya.patel@example.com',
      department: 'Information Technology',
      gpa: 3.92,
      enrolledDate: '2025-08-15',
      status: 'Active',
      courses: ['Full Stack Architecture', 'RxJS In Action']
    },
    {
      id: 3,
      name: 'Rohan Gupta',
      email: 'rohan.gupta@example.com',
      department: 'Electronics',
      gpa: 3.40,
      enrolledDate: '2025-09-01',
      status: 'Active',
      courses: ['Cloud Computing']
    },
    {
      id: 4,
      name: 'Ananya Verma',
      email: 'ananya.verma@example.com',
      department: 'Data Science',
      gpa: 3.75,
      enrolledDate: '2025-09-10',
      status: 'Active',
      courses: ['Machine Learning', 'Data Pipelines']
    }
  ];

  private studentsSubject = new BehaviorSubject<Student[]>(this.students);
  public students$ = this.studentsSubject.asObservable();

  getStudents(): Observable<Student[]> {
    return of(this.students);
  }

  getStudentById(id: number): Observable<Student | undefined> {
    const student = this.students.find(s => s.id === id);
    return of(student);
  }

  addStudent(student: Omit<Student, 'id'>): Observable<Student> {
    const newStudent: Student = {
      ...student,
      id: this.students.length + 1
    };
    this.students.push(newStudent);
    this.studentsSubject.next([...this.students]);
    return of(newStudent);
  }
}
