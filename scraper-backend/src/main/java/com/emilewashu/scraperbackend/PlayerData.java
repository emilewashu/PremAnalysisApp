package com.emilewashu.scraperbackend;

public class PlayerData {
    
        private String name;
        private String club;
        private int rank;
        private int goals;
        private int games;
        private double goalsperGame;
        private int goalconversion;
        private int shotaccuracy;
    
        public PlayerData(int rank, String name, String club, int goals, int games, int goalconversion, int shotaccuracy)
        {
        this.rank = rank;
        this.name = name;
        this.club = club;
        this.goals = goals;
        this.games = games;
        this.goalsperGame = (double) goals/games; 
        this.goalconversion = goalconversion;       
        this.shotaccuracy = shotaccuracy;
        
        }
    
        public PlayerData()
        {
    
        }
        public String getName()
        {
            return name;
        }
        public Integer getRank()
        {
            return rank;
        }
        public Integer getGoals()
        {
            return goals;
        }
        public String getClub()
        {
            return club;
        }
        public Integer getGames()
        {
        
            return games;
        }
        public double getGPG()
        {
            return goalsperGame;
        }
        public int getGoalConversion()
        {
            return goalconversion;
        }
        public int getShotAcc()
        {
            return shotaccuracy;
        }
        
    
    }
    
