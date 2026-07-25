import React from 'react';

function IndianPlayers() {
  const indianTeam = [
    'Virat Kohli',
    'Rohit Sharma',
    'Jasprit Bumrah',
    'Ravindra Jadeja',
    'KL Rahul',
    'Mohammed Shami',
    'Rishabh Pant',
    'Hardik Pandya',
    'Shreyas Iyer',
    'Yuzvendra Chahal',
    'Shikhar Dhawan'
  ];

  const [
    player1,
    player2,
    player3,
    player4,
    player5,
    player6,
    player7,
    player8,
    player9,
    player10,
    player11
  ] = indianTeam;

  const oddPlayers = [player1, player3, player5, player7, player9, player11];
  const evenPlayers = [player2, player4, player6, player8, player10];

  const T20Players = ['Virat Kohli', 'Rohit Sharma', 'Hardik Pandya'];
  const RanjiTrophyPlayers = ['Ajinkya Rahane', 'Cheteshwar Pujara', 'Hanuma Vihari'];

  const mergedPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div className="indian-players-container">
      <div className="players-section odd-team">
        <h2>Odd Team Players</h2>
        <ul className="players-ul">
          {oddPlayers.map((player, index) => (
            <li key={index} className="player-li odd">
              {player}
            </li>
          ))}
        </ul>
      </div>
      <div className="players-section even-team">
        <h2>Even Team Players</h2>
        <ul className="players-ul">
          {evenPlayers.map((player, index) => (
            <li key={index} className="player-li even">
              {player}
            </li>
          ))}
        </ul>
      </div>
      <div className="players-section merged-team">
        <h2>Merged Player List</h2>
        <ul className="players-ul">
          {mergedPlayers.map((player, index) => (
            <li key={index} className="player-li merged">
              {player}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default IndianPlayers;
