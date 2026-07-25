export interface Course {
  id: number;
  code: string;
  name: string;
  instructor: string;
  credits: number;
  fee: number;
  startDate: string;
  duration: string;
  status: 'Active' | 'Upcoming';
  prerequisites: string[];
}
