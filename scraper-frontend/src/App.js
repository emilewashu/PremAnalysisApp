import React, { useEffect, useState } from 'react';
import './App.css';
import BarChart from './components/BarChart';
import Search from './components/Search';
import Table from './components/Table';



function App() {

  const [selectedStat, setSelectedStat] = useState('goals');

  const [userData, setUserData] = useState({
    labels: [],
    datasets: [{
      label: "Goals",
      data: []
    }]
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/stats/data');
        const json = await response.json();

        const chartData = {

          labels: json.map((data) => data.name),
          datasets: [{
            label: selectedStat,
            data: json.map((data) => data[selectedStat]),
            backgroundColor: [
              "#311465"

            ],
            borderColor: "black",
            borderWidth: 2,
          }]
        };

        setUserData(chartData);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, [selectedStat]);

  

const handleStatChange = (selectedOption) => {
    setSelectedStat(selectedOption);
    
  };


  return (
  <>
    <header id = "header">
      <h1 id = "head"> <img src="prem.png" alt="Logo" className="logo-img"/> Premier League Goal Analysis App (2022/2023) </h1>
    </header> 
    <Search/>
    <Table/>
    <BarChart chartData = {userData} className = "barchart"/>
    <select className = "dropdown" value={selectedStat} onChange={(e) => handleStatChange(e.target.value)}>
        <option value="goals"> Goals </option>
        <option value="goalConversion"> Goal Conversion </option>
        <option value="shotAcc"> Shot Accuracy </option>
        <option value="gpg"> Goals per Game</option>
    </select>

  
  </>

  );
}



export default App;
