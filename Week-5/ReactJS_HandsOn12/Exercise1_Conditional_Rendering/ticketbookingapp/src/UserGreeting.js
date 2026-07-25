import React from 'react';

function UserGreeting() {
  return (
    <div className="greeting-panel user-panel">
      <h2>Welcome Back, User!</h2>
      <p className="sub">You are now logged in. Book your tickets below.</p>
      <div className="flight-list">
        <h3>Book a Flight</h3>
        <div className="flight-card bookable">
          <span className="route">Delhi → Mumbai</span>
          <span className="price">₹ 4,500</span>
          <button className="book-btn">Book Now</button>
        </div>
        <div className="flight-card bookable">
          <span className="route">Bangalore → Chennai</span>
          <span className="price">₹ 3,200</span>
          <button className="book-btn">Book Now</button>
        </div>
        <div className="flight-card bookable">
          <span className="route">Kolkata → Hyderabad</span>
          <span className="price">₹ 5,800</span>
          <button className="book-btn">Book Now</button>
        </div>
        <div className="flight-card bookable">
          <span className="route">Mumbai → Goa</span>
          <span className="price">₹ 2,900</span>
          <button className="book-btn">Book Now</button>
        </div>
      </div>
    </div>
  );
}

export default UserGreeting;
