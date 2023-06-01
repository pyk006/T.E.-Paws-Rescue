BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO animals (animal_name, animal_type, gender, age, energy_level, is_social, is_long_hair, is_fixed, is_adoptable, is_on_walk) VALUES ('Billy', 'Goat', 'Male', 3, 5, false, false, false, true, false);
INSERT INTO animals (animal_name, animal_type, gender, age, energy_level, is_social, is_long_hair, is_fixed, is_adoptable, is_on_walk) VALUES ('Bowser', 'Dog', 'Male', 5 , 1 ,false, false, false, true, true);
INSERT INTO animals (animal_name, animal_type, gender, age, energy_level, is_social, is_long_hair, is_fixed, is_adoptable, is_on_walk) VALUES ('Velvet', 'Cat', 'Female', 7, 9, false, false, false, true, false);

INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Jim', 'Trussel', '1999-10-10', '5555 Morningglory Ct., Portland, OR, 97218',
        '18', 'Trojan', 'jtruss@aol.com', '555-897-0543', true, false, true, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Nicole', 'Win', '2000-08-17', '999 Juniper St., Portland, OR, 97220',
        '10', 'Bulldogs', 'nwinning99@gmail.com', '555-213-9945', true, true, false, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('John', 'Smith', '1989-02-01', '777 Apple Rd., Portland, OR, 97218',
        '25', 'Eagles', 'JohnSmith1234@hotmail.com', '555-898-1735', false, true, true, 'Pending', 'Pending');
COMMIT TRANSACTION;
