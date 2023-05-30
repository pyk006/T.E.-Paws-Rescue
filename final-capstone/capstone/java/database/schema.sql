BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	security_ans varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_application_id FOREIGN KEY (application_id) REFERENCES applications(application_id)
);

CREATE TABLE applications (
	application_id SERIAL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	social_security varchar(25) NOT NULL,
	home_address varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	phone_number varchar(25) NOT NULL,
	bkgrnd_check_approved boolean,
	admin_approval boolean,
	
	CONSTRAINT PK_user PRIMARY KEY (application_id)
);


COMMIT TRANSACTION;
