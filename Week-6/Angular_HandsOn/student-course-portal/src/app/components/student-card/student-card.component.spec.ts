import { ComponentFixture, TestBed } from '@angular/core/testing';
import { StudentCardComponent } from './student-card.component';
import { Student } from '../../models/student.model';

describe('StudentCardComponent', () => {
  let component: StudentCardComponent;
  let fixture: ComponentFixture<StudentCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentCardComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(StudentCardComponent);
    component = fixture.componentInstance;
    component.student = {
      id: 1,
      name: 'Aarav Sharma',
      email: 'aarav@example.com',
      department: 'Computer Science',
      gpa: 3.85,
      enrolledDate: '2025-08-01',
      status: 'Active',
      courses: ['Angular']
    };
    fixture.detectChanges();
  });

  it('should create student card component', () => {
    expect(component).toBeTruthy();
  });

  it('should emit student when select button is clicked', () => {
    let emitted: Student | null = null;
    component.selectStudent.subscribe(s => emitted = s);
    component.onSelect();
    expect(emitted).toEqual(component.student);
  });
});
