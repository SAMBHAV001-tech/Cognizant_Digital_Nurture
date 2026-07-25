import React, { useState } from 'react';
import './App.css';
import LoginButton from './LoginButton';
import LogoutButton from './LogoutButton';
import Greeting from './Greeting';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  function handleLogin() {
    setIsLoggedIn(true);
  }

  function handleLogout() {
    setIsLoggedIn(false);
  }

  return (
    <div className="App">
      <header className="app-header">
        <h1 className="main-title">✈ Ticket Booking App</h1>
        <div className="auth-btn">
          {isLoggedIn
            ? <LogoutButton onLogout={handleLogout} />
            : <LoginButton onLogin={handleLogin} />
          }
        </div>
      </header>
      <main className="app-main">
        <Greeting isLoggedIn={isLoggedIn} />
      </main>
    </div>
  );
}

export default App;
