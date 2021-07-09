CREATE TABLE IF NOT EXISTS games (
  id SERIAL PRIMARY KEY,
  red_team_player_1 VARCHAR(55) NOT NULL,
  red_team_player_2 VARCHAR(55) NOT NULL,
  red_team_score INT NOT NULL,
  blue_team_player_1 VARCHAR(55) NOT NULL,
  blue_team_player_2 VARCHAR(55) NOT NULL,
  blue_team_score INT NOT NULL
);