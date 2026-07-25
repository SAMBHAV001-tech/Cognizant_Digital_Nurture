import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 201, title: 'React 18 Features Overview', author: 'Alex Johnson', description: 'Explore automatic batching, concurrent rendering, and new hooks in React 18.', featured: true },
    { id: 202, title: 'CSS Grid vs Flexbox', author: 'Sarah Williams', description: 'A complete comparison between Grid and Flexbox for modern web layouts.', featured: false },
    { id: 203, title: 'Building REST APIs with Express', author: 'David Lee', description: 'Step by step guide to creating scalable web APIs using Node and Express.', featured: true }
  ];

  function renderBlogStatus(isFeatured) {
    if (isFeatured) {
      return <span className="badge badge-featured">Trending Post</span>;
    } else {
      return <span className="badge badge-standard">Standard Post</span>;
    }
  }

  return (
    <div className="card-section">
      <h2 className="section-title">📰 Blog Details</h2>
      <p className="section-subtitle">Latest Articles and Tech Insights</p>
      <div className="item-grid">
        {blogs.map(blog => (
          <div key={blog.id} className="item-card blog-card">
            <div className="card-header">
              <h3>{blog.title}</h3>
              {renderBlogStatus(blog.featured)}
            </div>
            <p className="author-text">By <strong>{blog.author}</strong></p>
            <p className="description-text">{blog.description}</p>
            {blog.featured && <p className="read-time">⭐ Highly Recommended</p>}
          </div>
        ))}
      </div>
    </div>
  );
}

export default BlogDetails;
