import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private courses: Course[] = [
    {
      id: 101,
      code: 'ANG-2026',
      name: 'Angular 21 Enterprise Development',
      instructor: 'Dr. Vikram Sen',
      credits: 4,
      fee: 15000,
      startDate: '2026-08-10',
      duration: '8 Weeks',
      status: 'Active',
      prerequisites: ['TypeScript Fundamentals', 'HTML5 & CSS3']
    },
    {
      id: 102,
      code: 'TS-301',
      name: 'Advanced TypeScript & Design Patterns',
      instructor: 'Prof. Meera Nair',
      credits: 3,
      fee: 12000,
      startDate: '2026-08-20',
      duration: '6 Weeks',
      status: 'Active',
      prerequisites: ['JavaScript ES6+']
    },
    {
      id: 103,
      code: 'RXJS-401',
      name: 'Reactive Programming with RxJS & NgRx',
      instructor: 'Karan Malhotra',
      credits: 4,
      fee: 18000,
      startDate: '2026-09-01',
      duration: '10 Weeks',
      status: 'Upcoming',
      prerequisites: ['Angular Basics', 'Promises & Observables']
    }
  ];

  private coursesSubject = new BehaviorSubject<Course[]>(this.courses);
  public courses$ = this.coursesSubject.asObservable();

  getCourses(): Observable<Course[]> {
    return of(this.courses);
  }

  getCourseById(id: number): Observable<Course | undefined> {
    const course = this.courses.find(c => c.id === id);
    return of(course);
  }

  addCourse(course: Omit<Course, 'id'>): Observable<Course> {
    const newCourse: Course = {
      ...course,
      id: 100 + this.courses.length + 1
    };
    this.courses.push(newCourse);
    this.coursesSubject.next([...this.courses]);
    return of(newCourse);
  }

  isCodeExists(code: string): Observable<boolean> {
    const exists = this.courses.some(c => c.code.toLowerCase() === code.toLowerCase());
    return of(exists);
  }
}
