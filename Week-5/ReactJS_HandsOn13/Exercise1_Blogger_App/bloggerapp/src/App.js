import React from 'react';
import './App.css';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <h1 className="main-title">🌐 Blogger Application</h1>
        <p className="main-subtitle">Knowledge Hub for Books, Technical Blogs & Courses</p>
      </header>
      <main className="app-main">
        <BookDetails />
        <BlogDetails />
        <CourseDetails />
      </main>
    </div>
  );
}

export default App;
