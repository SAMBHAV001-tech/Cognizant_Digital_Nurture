export interface Student {
  id: number;
  name: string;
  email: string;
  department: string;
  gpa: number;
  enrolledDate: string;
  status: 'Active' | 'Inactive';
  courses: string[];
}
