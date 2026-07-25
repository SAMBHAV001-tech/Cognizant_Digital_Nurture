import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';
import { PortalStateService } from '../../services/portal-state.service';
import { CourseCardComponent } from '../course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  private courseService = inject(CourseService);
  private portalState = inject(PortalStateService);

  courses: Course[] = [];
  enrolledCourseName: string | null = null;

  ngOnInit(): void {
    this.courseService.getCourses().subscribe(data => {
      this.courses = data;
    });
  }

  onCourseEnrolled(course: Course): void {
    this.enrolledCourseName = course.name;
    this.portalState.incrementEnrolled();
  }
}
