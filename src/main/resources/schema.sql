
	CREATE TABLE IF NOT EXISTS Sickovci (
	id INTEGER AUTO_INCREMENT,
	name varchar(256) NOT NULL,
	last_name varchar(256) NOT NULL,
	level varchar(50) NOT NULL,
	age INTEGER,
	date_added TIMESTAMP,
	date_modified TIMESTAMP,
	primary key(id)
	);

	INSERT INTO Sickovci (name, last_name, level, age, date_added, date_modified)
	VALUES ('Dejan', 'Jevtovic', 'PRO', 34, CURRENT_DATE, CURRENT_DATE),
	('Aleksandar', 'Davidov', 'PRO', 33, CURRENT_DATE, CURRENT_DATE),
	('Nenad', 'Djordjevic', 'PRO', 33, CURRENT_DATE, CURRENT_DATE);


