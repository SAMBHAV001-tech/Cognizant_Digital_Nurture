import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore
        Name="Rahul"
        School="DAV Public School"
        Total={350}
        Goal={5}
      />
    </div>
  );
}

export default App;

