BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS animals;

CREATE TABLE applications (
	application_id SERIAL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	social_security varchar(25) NOT NULL,
	home_address varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	phone_number varchar(25) NOT NULL,
	bkgrnd_check_approved varchar(25),
	admin_approval boolean,
	
	CONSTRAINT PK_application PRIMARY KEY (application_id)
);

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	security_ans varchar(50),
	application_id int,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_application_id FOREIGN KEY (application_id) REFERENCES applications(application_id)
);

CREATE TABLE animals(
	animal_id serial,
	animal_name varchar(50) NOT NULL,
	animal_type varchar(50) NOT NULL,
	gender varchar(20) NOT NULL,
	age int NOT NULL,
	description varchar(250),
	energy_level int NOT NULL,
	is_social boolean NOT NULL,
	is_long_hair boolean NOT NULL,
	is_fixed boolean NOT NULL,
	is_adoptable boolean NOT NULL,
	is_on_walk boolean NOT NULL,
	
	CONSTRAINT PK_animal PRIMARY KEY (animal_id)
);


COMMIT TRANSACTION;
