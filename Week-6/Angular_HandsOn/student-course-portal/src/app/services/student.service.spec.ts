import { TestBed } from '@angular/core/testing';
import { StudentService } from './student.service';
import { firstValueFrom } from 'rxjs';

describe('StudentService', () => {
  let service: StudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return initial list of students', async () => {
    const students = await firstValueFrom(service.getStudents());
    expect(students.length).toBeGreaterThan(0);
  });

  it('should add a new student', async () => {
    const newStudent = {
      name: 'Test Student',
      email: 'test@example.com',
      department: 'Computer Science',
      gpa: 3.8,
      enrolledDate: '2026-01-01',
      status: 'Active' as const,
      courses: ['Testing 101']
    };

    const student = await firstValueFrom(service.addStudent(newStudent));
    expect(student.id).toBeDefined();
    expect(student.name).toBe('Test Student');
  });
});
