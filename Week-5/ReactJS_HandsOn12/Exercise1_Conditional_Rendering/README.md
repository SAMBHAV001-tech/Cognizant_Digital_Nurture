# Exercise 1: Conditional Rendering in React

This project demonstrates React conditional rendering using a Ticket Booking application that switches between Guest and User views based on login state.

## Key Concepts

### 1. Boolean State for Conditional Rendering
A single `isLoggedIn` boolean state in `App` controls which components are rendered:
```javascript
const [isLoggedIn, setIsLoggedIn] = useState(false);
```

### 2. Conditional Button Rendering (Inline Ternary)
Only one button is displayed at a time using the ternary operator:
```javascript
{isLoggedIn
  ? <LogoutButton onLogout={handleLogout} />
  : <LoginButton onLogin={handleLogin} />
}
```

### 3. Greeting Component with Conditional Child Rendering
The `Greeting` component accepts `isLoggedIn` as a prop and uses an `if` statement to decide which view to render:
```javascript
function Greeting({ isLoggedIn }) {
  if (isLoggedIn) return <UserGreeting />;
  return <GuestGreeting />;
}
```

### 4. Component Roles
| Component | Purpose |
|---|---|
| `LoginButton` | Fires `handleLogin` → sets `isLoggedIn = true` |
| `LogoutButton` | Fires `handleLogout` → sets `isLoggedIn = false` |
| `GuestGreeting` | Shown when logged out — view-only flight list |
| `UserGreeting` | Shown when logged in — bookable flight list |
| `Greeting` | Wrapper that conditionally renders the above two |
