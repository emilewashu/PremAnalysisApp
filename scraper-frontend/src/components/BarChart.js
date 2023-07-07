import React, { useEffect, useState } from 'react';
import {Bar} from 'react-chartjs-2'
import {Chart as ChartJS} from 'chart.js/auto'

const BarChart = ({ chartData }) => {
  return (
    <div>
      <header id = "tableheader">Interactive Chart of the Top Scorers</header>
      <Bar data={chartData} />
    </div>
  );
};

export default BarChart;