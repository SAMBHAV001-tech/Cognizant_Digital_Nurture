# Exercise 1: Blogger Application

This project demonstrates list rendering using the `.map()` method and multiple conditional rendering techniques in React.

## Core Concepts Implemented

### 1. List Rendering with map()
All three components (`BookDetails`, `BlogDetails`, and `CourseDetails`) render arrays of objects dynamically using `.map()`, assigning a unique `key` prop to every rendered item:
```javascript
{books.map(book => (
  <div key={book.id} className="item-card">
    <h3>{book.title}</h3>
  </div>
))}
```

### 2. Conditional Rendering Techniques

#### A. Element Variables
Variables store JSX elements based on logic before returning:
```javascript
let headerMessage = <p className="section-subtitle">Featured Books Collection</p>;
```

#### B. Logical && Operator
Displays content only when a condition evaluates to true:
```javascript
{book.price > 600 && <span className="badge">Premium Edition</span>}
```

#### C. Ternary Operator (? :)
Selects styles or text dynamically:
```javascript
<span className={book.price > 500 ? 'highlight-green' : 'highlight-blue'}>₹{book.price}</span>
```

#### D. if...else Statements
Used within helper functions to return different JSX tags:
```javascript
function renderBlogStatus(isFeatured) {
  if (isFeatured) {
    return <span className="badge badge-featured">Trending Post</span>;
  } else {
    return <span className="badge badge-standard">Standard Post</span>;
  }
}
```

#### E. Conditional Component Rendering
Helper components render different output based on props:
```javascript
function CourseBadge({ status }) {
  if (status === 'Active') return <span className="badge badge-active">Enrollment Open</span>;
  return <span className="badge badge-upcoming">Upcoming</span>;
}
```
