import React from 'react';

function BookDetails() {
  const books = [
    { id: 101, title: 'Mastering React', price: 650 },
    { id: 102, title: 'JavaScript Essentials', price: 450 },
    { id: 103, title: 'Node.js in Action', price: 580 },
    { id: 104, title: 'Full Stack Guide', price: 720 }
  ];

  let headerMessage = <p className="section-subtitle">Featured Books Collection</p>;

  return (
    <div className="card-section">
      <h2 className="section-title">📚 Book Details</h2>
      {headerMessage}
      <div className="item-grid">
        {books.map(book => (
          <div key={book.id} className="item-card">
            <h3>{book.title}</h3>
            <p className="price-tag">
              Price: <span className={book.price > 500 ? 'highlight-green' : 'highlight-blue'}>₹{book.price}</span>
            </p>
            {book.price > 600 && <span className="badge">Premium Edition</span>}
          </div>
        ))}
      </div>
    </div>
  );
}

export default BookDetails;
