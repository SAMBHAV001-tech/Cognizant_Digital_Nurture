import React from 'react';

function ListOfPlayers() {
  const players = [
    { name: 'Virat Kohli', score: 85 },
    { name: 'Rohit Sharma', score: 92 },
    { name: 'KL Rahul', score: 65 },
    { name: 'Rishabh Pant', score: 78 },
    { name: 'Hardik Pandya', score: 45 },
    { name: 'Ravindra Jadeja', score: 55 },
    { name: 'Jasprit Bumrah', score: 12 },
    { name: 'Mohammed Shami', score: 8 },
    { name: 'Yuzvendra Chahal', score: 4 },
    { name: 'Shikhar Dhawan', score: 68 },
    { name: 'Shreyas Iyer', score: 72 }
  ];

  const playersBelow70 = players.filter(player => player.score < 70);

  return (
    <div className="players-list-container">
      <div className="players-section">
        <h2>All Players</h2>
        <ul className="players-ul">
          {players.map((player, index) => (
            <li key={index} className="player-li">
              <span className="player-name">{player.name}</span>
              <span className="player-score">{player.score}</span>
            </li>
          ))}
        </ul>
      </div>
      <div className="players-section filtered">
        <h2>Players with Score Below 70</h2>
        <ul className="players-ul">
          {playersBelow70.map((player, index) => (
            <li key={index} className="player-li below-70">
              <span className="player-name">{player.name}</span>
              <span className="player-score">{player.score}</span>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default ListOfPlayers;
