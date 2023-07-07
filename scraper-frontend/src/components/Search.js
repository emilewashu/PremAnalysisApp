import React, { useEffect, useState } from "react";

const Search = () => {
	const [data, setData] = useState([]);
	useEffect(() => {
		const fetchData = async () => {
			try {
				const response = await fetch("http://localhost:8080/stats/data");
				const json = await response.json();
				setData(json);
			} catch (error) {
				console.error("Error fetching data:", error);
			}
		};

		fetchData();
	}, []);

	const [searchTerm, setSearchTerm] = useState("");

	return (
		<>
			<header id='tableheader'> Find Your Favorite Goal Scorer! </header>
			<input
				className='search'
				type='text'
				placeholder="Enter Scorer's Name..."
				onChange={(event) => {
					setSearchTerm(event.target.value);
				}}
			/>
			<div className='filter'>
				{data
					.filter((val) => {
						if (searchTerm == "") {
							return val;
						} else if (val.name.toLowerCase().includes(searchTerm)) {
							return val;
						}
					})
					.map((val, key) => {
						return (
							<div>
								{" "}
								{val.name} | Goals: {val.goals} | Club : {val.club} | Games:{" "}
								{val.games} | Goals per Game: {val.gpg} | Goal Conversion:{" "}
								{val.goalConversion}% | Shot Accuracy: {val.shotAcc}%{" "}
							</div>
						);
					})}
			</div>
		</>
	);
};

export default Search;
