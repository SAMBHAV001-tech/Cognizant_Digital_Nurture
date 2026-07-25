import React from 'react';

function CourseBadge({ status }) {
  if (status === 'Active') {
    return <span className="badge badge-active">Enrollment Open</span>;
  }
  return <span className="badge badge-upcoming">Upcoming</span>;
}

function CourseDetails() {
  const courses = [
    { id: 301, name: 'React Development Certification', date: 'Starts 10th August 2026', status: 'Active' },
    { id: 302, name: 'Advanced JavaScript Mastery', date: 'Starts 25th August 2026', status: 'Upcoming' },
    { id: 303, name: 'Full Stack Web Architecture', date: 'Starts 1st September 2026', status: 'Active' }
  ];

  return (
    <div className="card-section">
      <h2 className="section-title">🎓 Course Details</h2>
      <p className="section-subtitle">Upcoming and Active Certification Programs</p>
      <div className="item-grid">
        {courses.map(course => (
          <div key={course.id} className="item-card course-card">
            <div className="card-header">
              <h3>{course.name}</h3>
              <CourseBadge status={course.status} />
            </div>
            <p className="date-text">
              📅 <strong>Schedule:</strong> {course.date}
            </p>
            <p className="status-indicator">
              Status: {course.status === 'Active' ? <span className="highlight-green">Available Now</span> : <span className="highlight-blue">Opening Soon</span>}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CourseDetails;
