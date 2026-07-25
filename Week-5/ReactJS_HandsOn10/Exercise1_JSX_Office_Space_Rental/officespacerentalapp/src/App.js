import React from 'react';
import './App.css';

function App() {
  const featuredOffice = {
    name: 'DBS House',
    rent: 55000,
    address: 'Sec-V, Salt Lake, Kolkata'
  };

  const officesList = [
    { name: 'Smartworks Hub', rent: 75000, address: 'Kondapur, Hyderabad' },
    { name: 'WeWork Galleria', rent: 60000, address: 'MG Road, Bangalore' },
    { name: 'Regus Centre', rent: 45000, address: 'Connaught Place, New Delhi' },
    { name: 'Awfis Space', rent: 58000, address: 'Andheri East, Mumbai' },
    { name: 'Innov8 Coworking', rent: 65000, address: 'Saket, New Delhi' }
  ];

  return (
    <div className="App">
      <h1 className="main-title">Office Space, at Affordable Range</h1>
      
      <div className="image-container">
        <img src="/office.jpg" alt="Office Space" className="office-img" />
      </div>

      <div className="featured-office-section">
        <h2>Featured Office Space</h2>
        <div className="office-card featured">
          <h3>{featuredOffice.name}</h3>
          <p><strong>Address:</strong> {featuredOffice.address}</p>
          <p>
            <strong>Monthly Rent:</strong>{' '}
            <span style={{ color: featuredOffice.rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
              Rs. {featuredOffice.rent}
            </span>
          </p>
        </div>
      </div>

      <div className="office-list-section">
        <h2>All Available Office Spaces</h2>
        <div className="office-grid">
          {officesList.map((office, index) => (
            <div key={index} className="office-card">
              <h3>{office.name}</h3>
              <p><strong>Address:</strong> {office.address}</p>
              <p>
                <strong>Monthly Rent:</strong>{' '}
                <span style={{ color: office.rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
                  Rs. {office.rent}
                </span>
              </p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;

