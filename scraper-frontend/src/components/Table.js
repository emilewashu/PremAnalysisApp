import React, { useEffect, useState } from 'react';

const Table = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/stats/data');
        const json = await response.json();
        setData(json);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <>
      <header id = "tableheader">Table of the Premier League's Top Scorers</header>

      <div className = "table-container">
        <table>
          <thead>
            <tr>
              <th>Rank</th>
              <th>Name</th>
              <th>Club</th>
              <th>Goals</th>
              <th>Games</th>
              <th>Goals per Game</th>
              <th>Goal Conversion (%)</th>
              <th>Shot Accuracy (%)</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item, index) => (
              <tr key={index}>
                <td>{item.rank}</td>
                <td>{item.name}</td>
                <td>{item.club}</td>
                <td>{item.goals}</td>
                <td>{item.games}</td>
                <td>{item.gpg}</td>
                <td>{item.goalConversion}</td>
                <td>{item.shotAcc}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default Table;