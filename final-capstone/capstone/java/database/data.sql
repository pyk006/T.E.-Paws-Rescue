BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO animals (animal_name, animal_type, gender, age, energy_level, is_social, is_long_hair, is_fixed, is_adoptable, is_on_walk) VALUES ('Billy', 'Goat', 'Male', 3, 5, false, false, false, true, false);
INSERT INTO animals (animal_name, animal_type, gender, age, energy_level, is_social, is_long_hair, is_fixed, is_adoptable, is_on_walk) VALUES ('Bowser', 'Dog', 'Male', 5 , 1 ,false, false, false, true, true);
INSERT INTO animals (animal_name, animal_type, gender, age, energy_level, is_social, is_long_hair, is_fixed, is_adoptable, is_on_walk) VALUES ('Velvet', 'Cat', 'Female', 7, 9, false, false, false, true, false);

COMMIT TRANSACTION;
