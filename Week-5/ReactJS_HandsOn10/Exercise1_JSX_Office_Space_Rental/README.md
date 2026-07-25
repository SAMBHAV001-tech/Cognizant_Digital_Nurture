# Exercise 1: Office Space Rental using JSX

This project demonstrates the use of JSX syntax in React to display structured data, embed multimedia (images), map collections, and format text using dynamic inline CSS.

## Key Concepts and Implementation Details

### 1. JSX Heading and Image Embedding
JSX allows writing HTML-like tags directly inside JavaScript. We render a structured heading and reference an image located in our public directory:
```javascript
<h1 className="main-title">Office Space, at Affordable Range</h1>
<img src="/office.jpg" alt="Office Space" className="office-img" />
```

### 2. Office Object Representation
We define a featured office object containing details such as Name, Rent, and Address, and display its attributes directly inside JSX:
```javascript
<div className="office-card featured">
  <h3>{featuredOffice.name}</h3>
  <p><strong>Address:</strong> {featuredOffice.address}</p>
</div>
```

### 3. Rendering Collections using map()
To render multiple office spaces dynamically, we define an array of office objects and iterate over it using `.map()`:
```javascript
{officesList.map((office, index) => (
  <div key={index} className="office-card">
    <h3>{office.name}</h3>
    ...
  </div>
))}
```

### 4. Inline CSS with Ternary Color Selection
Dynamic styling is achieved by assigning a JavaScript style object to the `style` attribute. A ternary operator inspects the rent value and changes the font color dynamically:
```javascript
<span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
  Rs. {office.rent}
</span>
```
- Rent below 60,000 is colored **Red**.
- Rent 60,000 and above is colored **Green**.
