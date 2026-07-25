import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ Name, School, Total, Goal }) {
  const average = (Total / Goal).toFixed(2);

  return (
    <div className="score-container">
      <div className="score-card">
        <h2 className="card-title">Student Details</h2>
        <div className="card-content">
          <div className="info-row">
            <span className="info-label">Name:</span>
            <span className="info-value">{Name}</span>
          </div>
          <div className="info-row">
            <span className="info-label">School:</span>
            <span className="info-value">{School}</span>
          </div>
          <div className="info-row">
            <span className="info-label">Total Marks:</span>
            <span className="info-value">{Total}</span>
          </div>
          <div className="info-row highlight">
            <span className="info-label">Average Score:</span>
            <span className="info-value">{average}</span>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CalculateScore;
