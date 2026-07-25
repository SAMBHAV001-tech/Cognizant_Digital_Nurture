import React from 'react';

function LoginButton({ onLogin }) {
  return (
    <button id="btn-login" className="btn btn-login" onClick={onLogin}>
      Login
    </button>
  );
}

export default LoginButton;
