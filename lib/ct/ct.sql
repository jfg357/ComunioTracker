DROP TABLE PlayerPosition_T;
DROP TABLE Position_T;
DROP TABLE Player_T;
DROP TABLE Teams_T;
DROP TABLE LeagueTeams_T;
DROP TABLE League_T;
DROP TABLE Team_T;


CREATE TABLE League_T (
	LeagueID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	LeagueName VARCHAR (30) NOT NULL,
	LeagueCountry VARCHAR (30) NOT NULL,
	LeagueConfederation VARCHAR (20) NOT NULL,
	LeagueNoTeams INT NOT NULL,
	LeagueWebsite VARCHAR (2083),
	LeagueEmblem VARCHAR (2083),
CONSTRAINT League_PK PRIMARY KEY (LeagueID));

CREATE TABLE Team_T (
	TeamID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	TeamName VARCHAR (30) NOT NULL,
	TeamCoachFirstName VARCHAR (30) NOT NULL,
	TeamCoachMiddleName VARCHAR (30),
	TeamCoachLastName VARCHAR (30) NOT NULL,
	TeamCity VARCHAR (30) NOT NULL,
	TeamWebsite VARCHAR (2083),
	TeamEmblem VARCHAR (2083),
	TeamHomeKit VARCHAR (2083),
	TeamAwayKit VARCHAR (2083),
	TeamThirdKit VARCHAR (2083),
CONSTRAINT Team_PK PRIMARY KEY (TeamID));

CREATE TABLE Player_T (
	PlayerID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	PlayerFirstName VARCHAR (30) NOT NULL,
	PlayerMiddleName VARCHAR (30),
	PlayerLastName VARCHAR (30) NOT NULL,
	PlayerCountry VARCHAR (30) NOT NULL,
	PlayerPhoto VARCHAR (2083),
	PlayerHeatMap VARCHAR (2083),
CONSTRAINT Player_PK PRIMARY KEY (PlayerID));

CREATE TABLE Position_T (
	PositionID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	PositionAbbreviation CHAR (3) NOT NULL,
	PositionName VARCHAR (30) NOT NULL,
CONSTRAINT Position_PK PRIMARY KEY (PositionID));

CREATE TABLE LeagueTeams_T (
	LeagueID INT NOT NULL,
	TeamID INT NOT NULL,
CONSTRAINT LeagueTeams_PK PRIMARY KEY (LeagueID, TeamID),
CONSTRAINT LeagueTeams_FK1 FOREIGN KEY (LeagueID) REFERENCES League_T(LeagueID),
CONSTRAINT LeagueTeams_FK2 FOREIGN KEY (TeamID) REFERENCES Team_T(TeamID));

CREATE TABLE Teams_T (
	TeamID INT NOT NULL,
    PlayerID INT NOT NULL,
CONSTRAINT Teams_PK PRIMARY KEY (TeamID, PlayerID),
CONSTRAINT Teams_FK1 FOREIGN KEY (TeamID) REFERENCES Team_T(TeamID),
CONSTRAINT Teams_FK2 FOREIGN KEY (PlayerID) REFERENCES Player_T(PlayerID));

CREATE TABLE PlayerPosition_T (
	PlayerID INT NOT NULL,
    PositionID INT NOT NULL,
CONSTRAINT PlayerPosition_PK PRIMARY KEY (PlayerID, PositionID),
CONSTRAINT PlayerPosition_FK1 FOREIGN KEY (PlayerID) REFERENCES Player_T(PlayerID),
CONSTRAINT PlayerPosition_FK2 FOREIGN KEY (PositionID) REFERENCES Position_T(PositionID));

INSERT INTO League_T (LeagueName, LeagueCountry, LeagueConfederation, LeagueNoTeams, LeagueWebsite, LeagueEmblem)
	VALUES ('La Liga','Spain','UEFA',20,'https://www.laliga.es','https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/LaLiga.svg/375px-LaLiga.svg.png'),
	('Premier League','England','UEFA',20,'https://www.premierleague.com','https://upload.wikimedia.org/wikipedia/en/thumb/f/f2/Premier_League_Logo.svg/375px-Premier_League_Logo.svg.png'),
	('Serie A','Italy','UEFA',20,'http://www.legaseriea.it/','https://upload.wikimedia.org/wikipedia/en/0/02/Serie_A_logo_%282018%29.png'),
	('Bundesliga','Germany','UEFA',18,'https://www.bundesliga.com/','https://upload.wikimedia.org/wikipedia/en/thumb/d/df/Bundesliga_logo_%282017%29.svg/285px-Bundesliga_logo_%282017%29.svg.png');

INSERT INTO Team_T (TeamName, TeamCoachFirstName, TeamCoachMiddleName, TeamCoachLastName, TeamCity, TeamWebsite, TeamEmblem, TeamHomeKit, TeamAwayKit, TeamThirdKit)
	VALUES ('Real Madrid Club de Futbol','Santiago','','Solari','Madrid','https://www.realmadrid.com','https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Real_Madrid_CF.svg/225px-Real_Madrid_CF.svg.png','https://assets.adidas.com/images/w_600,f_auto,q_auto/394716900cbb423a8ba0a90600a7ec45_9366/Real_Madrid_Home_Authentic_Jersey_White_CG0561_.jpg','https://assets.adidas.com/images/w_600,f_auto,q_auto/7c34fb88589d4575899fa90600a7c514_9366/Real_Madrid_Away_Authentic_Jersey_Grey_CY6329_.jpg','https://assets.adidas.com/images/w_840,h_840,f_auto,q_auto,fl_lossy/e8b8090ae0e8424ca6eca8f50102fed4_9366/Real_Madrid_Third_Jersey_Red_DP5445_01_laydown.jpg'),
	('FC Barcelona','Ernesto','','Valverde','Barcelona','https://www.fcbarcelona.com','https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_%28crest%29.svg/330px-FC_Barcelona_%28crest%29.svg.png','https://c.static-nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/ubr6llfqekg7tlgvbquf/2018-19-fc-barcelona-vapor-match-home-mens-soccer-jersey-BJJWpo.jpg','https://c.static-nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/qb6j62gyjewy7ppdk1cz/2018-19-fc-barcelona-vapor-match-away-mens-soccer-jersey-hm8hdn.jpg','https://c.static-nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/gkpsfodhtjeyicewh0pb/fc-barcelona-vaporknit-strike-drill-mens-long-sleeve-soccer-top-RTZ4Lx.jpg');

INSERT INTO Player_T (PlayerFirstName, PlayerMiddleName, PlayerLastName, PlayerCountry, PlayerPhoto, PlayerHeatMap)
	VALUES ('Lionel','Andres','Messi','Argentina','https://media-public.fcbarcelona.com/20157/0/document_thumbnail/20197/49/219/190/96394033/1.0-1/96394033.jpg?t=1534859847000','https://i.redd.it/oetgmn96u0001.jpg'),
	('James','David','Rodriguez','Colombia','https://www.realmadrid.com/img/vertical_380px/10_james.jpg','https://pbs.twimg.com/media/BrPtJKqCMAAg_Gj.png');

INSERT INTO Position_T (PositionAbbreviation, PositionName)
	VALUES ('GK','Goalkeeper'),
	('CFB','Center Fullback'),
	('RFB','Right Fullback'),
	('LFB','Left Fullback'),
	('CB','Central Back'),
	('RCB','Right Center Back'),
	('LCB','Left Center Back'),
	('TCB','Trail Center Back'),
	('ST','Stopper'),
	('D','Defender'),
	('CD','Central Defender'),
	('SW','Sweeper'),
	('L','Libero'),
	('OFB','Outside Fullback'),
	('OB','Outside Back'),
	('RB','Right Back'),
	('LB','Left Back'),
	('CHB','Center Halfback'),
	('RHB','Right Halfback'),
	('LHB','Left Halfback'),
	('M','Midfielder'),
	('CM','Central Midfielder'),
	('AM','Attacking Midfielder'),
	('CAM','Center Attacking Midfielder'),
	('HM','Holding Midfielder'),
	('DM','Defensive Midfielder'),
	('CDM','Center Defensive Midfielder'),
	('PM','Passing Midfielder'),
	('OM','Outside Midfielder'),
	('RM','Right Midfielder'),
	('LM','Left Midfielder'),
	('WB','Wing Back'),
	('WM','Wide Midfielder'),
	('CF','Center Forward'),
	('F','Forward'),
	('IF','Inside Forward'),
	('RI','Right Inside'),
	('LI','Left Inside'),
	('W','Wing Forward'),
	('RW','Right Wing'),
	('LW','Left Wing'),
	('S','Striker'),
	('C','Center Striker'),
	('RCF','Right Center Forward'),
	('LCF','Left Center Forward'),
	('TCF','Trail Center Forward'),
	('WF','Withdrawn Forward'),
	('SS','Secondary Striker'),
	('WS','Wide Striker'),
	('RWS','Wing Striker'),
	('LWS','Left Wing Striker');


INSERT INTO LeagueTeams_T (LeagueID, TeamID)
	VALUES (1,1),
	(1,2);
	
INSERT INTO Teams_T (TeamID, PlayerID)
	VALUES (1,2),
	(2,1);

INSERT INTO PlayerPosition_T (PlayerID, PositionID)
	VALUES (1,50),
	(2,23);




