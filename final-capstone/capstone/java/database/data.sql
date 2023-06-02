BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Billy', 'Goat', 'Male', 3, 'description 1', 'unknown', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Bowser', 'Dog', 'Male', 5 , 'description 2', 'Bassett Hound', false);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Velvet', 'Cat', 'Female', 7, 'description 3', 'Tuxedo', false);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Si', 'Cat', 'Female', 3, 'description 4', 'Tabby', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Spike', 'Dog', 'Male', 2, 'description 9', 'German Shepherd', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Cotton', 'Rabbit', 'Female', 1, 'description 7', 'Holland Lop', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Whiskers', 'Cat', 'Male', 4, 'description 5', 'Siamese', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Buddy', 'Dog', 'Male', 3, 'description 2', 'Golden Retriever', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Peanut', 'Hamster', 'Male', 1, 'description 1', 'Syrian', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Whiskers', 'Rabbit', 'Female', 2, 'description 6', 'Netherland Dwarf', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Milo', 'Cat', 'Male', 5, 'description 4', 'Maine Coon', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Rocky', 'Dog', 'Male', 6, 'description 8', 'Bulldog', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Nibbles', 'Guinea Pig', 'Female', 1, 'description 10', 'American', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Simba', 'Cat', 'Male', 3, 'description 12', 'Bengal', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Lucky', 'Dog', 'Female', 4, 'description 11', 'Labrador Retriever', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Bella', 'Rabbit', 'Female', 3, 'description 14', 'Flemish Giant', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Oscar', 'Cat', 'Male', 2, 'description 13', 'Persian', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Charlie', 'Dog', 'Male', 1, 'description 15', 'Poodle', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Patches', 'Cat', 'Female', 2, 'description 16', 'Calico', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Cooper', 'Dog', 'Male', 5, 'description 18', 'Boxer', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Lola', 'Rabbit', 'Female', 1, 'description 17', 'Mini Rex', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Shadow', 'Cat', 'Male', 4, 'description 19', 'Russian Blue', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Max', 'Dog', 'Male', 3, 'description 20', 'Beagle', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Daisy', 'Cat', 'Female', 1, 'description 22', 'Tabby', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Bailey', 'Dog', 'Female', 6, 'description 21', 'Siberian Husky', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Coco', 'Rabbit', 'Female', 2, 'description 24', 'Lionhead', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Leo', 'Cat', 'Male', 7, 'description 23', 'Scottish Fold', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Lucy', 'Dog', 'Female', 2, 'description 25', 'Dachshund', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Oliver', 'Cat', 'Male', 5, 'description 27', 'Ragdoll', true);
INSERT INTO animals (animal_name, animal_type, gender, age, description, breed, is_adoptable) VALUES ('Oreo', 'Rabbit', 'Male', 3, 'description 29', 'Dutch', true);

INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Jim', 'Trussel', '1999-10-10', '5555 Morningglory Ct., Portland, OR, 97218',
        '18', 'Trojan', 'jtruss@aol.com', '555-897-0543', true, false, true, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Nicole', 'Win', '2000-08-17', '999 Juniper St., Portland, OR, 97220',
        '10', 'Bulldogs', 'nwinning99@gmail.com', '555-213-9945', true, true, false, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('John', 'Smith', '1989-02-01', '777 Apple Rd., Portland, OR, 97218',
        '25', 'Eagles', 'JohnSmith1234@hotmail.com', '555-898-1735', false, true, true, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Jane', 'Doe', '1995-06-12', '123 Main St., Seattle, WA, 98101',
 '40', 'Tigers', 'JaneDoe5678@gmail.com', '555-123-4567', true, false, true, 'Approved', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Michael', 'Johnson', '1992-09-22', '456 Oak Ave., Los Angeles, CA, 90001',
 '30', 'Lions', 'MichaelJohnson9012@yahoo.com', '555-987-6543', false, true, false, 'Approved', 'Approved');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Emily', 'Brown', '1998-03-15', '789 Elm Rd., Chicago, IL, 60601',
 '20', 'Bulldogs', 'EmilyBrown3456@hotmail.com', '555-456-7890', true, true, true, 'Approved', 'Approved');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('David', 'Davis', '1990-11-28', '321 Pine St., Denver, CO, 80202',
 '35', 'Panthers', 'DavidDavis7890@gmail.com', '555-234-5678', true, false, true, 'Rejected', 'Rejected');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Sarah', 'Wilson', '1994-07-09', '987 Cedar Ave., San Francisco, CA, 94101',
 '15', 'Hawks', 'SarahWilson2345@yahoo.com', '555-567-8901', false, true, true, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Daniel', 'Taylor', '1996-04-18', '654 Maple Rd., Austin, TX, 78701',
 '40', 'Cougars', 'DanielTaylor6789@hotmail.com', '555-901-2345', true, true, true, 'Approved', 'Approved');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Olivia', 'Anderson', '1993-08-25', '321 Oak Ave., Boston, MA, 02101',
 '25', 'Wolves', 'OliviaAnderson0123@gmail.com', '555-345-6789', false, true, true, 'Rejected', 'Rejected');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Matthew', 'Martinez', '1987-12-04', '789 Pine St., Miami, FL, 33101',
 '30', 'Eagles', 'MatthewMartinez4567@yahoo.com', '555-678-9012', true, false, false, 'Pending', 'Pending');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES ('Ava', 'Wilson', '1999-01-10', '456 Elm Rd., Dallas, TX, 75201',
 '35', 'Tigers', 'AvaWilson8901@hotmail.com', '555-901-2345', false, true, true, 'Approved', 'Approved');




COMMIT TRANSACTION;
