import React from 'react';

function LogoutButton({ onLogout }) {
  return (
    <button id="btn-logout" className="btn btn-logout" onClick={onLogout}>
      Logout
    </button>
  );
}

export default LogoutButton;
