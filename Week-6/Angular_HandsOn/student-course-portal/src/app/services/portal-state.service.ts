import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortalStateService {
  private selectedStudentSubject = new BehaviorSubject<string>('None');
  public selectedStudent$: Observable<string> = this.selectedStudentSubject.asObservable();

  private totalEnrolledSubject = new BehaviorSubject<number>(4);
  public totalEnrolled$: Observable<number> = this.totalEnrolledSubject.asObservable();

  setSelectedStudent(name: string): void {
    this.selectedStudentSubject.next(name);
  }

  incrementEnrolled(): void {
    this.totalEnrolledSubject.next(this.totalEnrolledSubject.value + 1);
  }
}
