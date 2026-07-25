import React from 'react';

function GuestGreeting() {
  return (
    <div className="greeting-panel guest-panel">
      <h2>Welcome, Guest!</h2>
      <p className="sub">Please log in to book your flight tickets.</p>
      <div className="flight-list">
        <h3>Available Flights</h3>
        <div className="flight-card">
          <span className="route">Delhi → Mumbai</span>
          <span className="price">₹ 4,500</span>
        </div>
        <div className="flight-card">
          <span className="route">Bangalore → Chennai</span>
          <span className="price">₹ 3,200</span>
        </div>
        <div className="flight-card">
          <span className="route">Kolkata → Hyderabad</span>
          <span className="price">₹ 5,800</span>
        </div>
        <div className="flight-card">
          <span className="route">Mumbai → Goa</span>
          <span className="price">₹ 2,900</span>
        </div>
      </div>
    </div>
  );
}

export default GuestGreeting;
