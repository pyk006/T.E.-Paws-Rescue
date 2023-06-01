package com.techelevator.dao;

import com.techelevator.model.Animals;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAnimalsDao implements AnimalsDao{

    private final JdbcTemplate jdbcTemplate;

    public  JdbcAnimalsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Animals> getAllAnimals() {
        List<Animals> animalsList = new ArrayList<>();
        String sql = "SELECT animal_id, animal_name, animal_type, gender, age, " +
                " description, breed, is_adoptable " +
                " FROM animals;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            animalsList.add(mapRowToAnimals(results));
        }
        return animalsList;
    }

    @Override
    public boolean createAnimal(String animalName, String animalType, String gender, int age, String description, String breed, boolean isAdoptable) {
        String sql = "INSERT INTO animals (animal_name, animal_type, gender, age, description, " +
                " breed, is_adoptable) VALUES (?, ?, ?, ?, ?, ?, ?);";

        return jdbcTemplate.update(sql, animalName, animalType, gender, age, description, breed, isAdoptable) == 1;
    }

    @Override
    public Animals getAnimalById(int animalId) {
        String sql = "SELECT animal_id, animal_name, animal_type, gender, age, " +
                " description, breed, is_adoptable " +
                " FROM animals WHERE animal_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, animalId);
        if(results.next()){
            return mapRowToAnimals(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean updateAnimal(Animals animal) {
        String sql = "UPDATE animals SET animal_name = ?, animal_type = ?, gender = ?, age = ?, " +
                " description = ?, breed = ?, is_adoptable = ? WHERE animal_id = ?";

        return jdbcTemplate.update(sql, animal.getAnimalName(), animal.getAnimalType(), animal.getGender(),
                animal.getAge(), animal.getDescription(), animal.getBreed(), animal.isAdoptable(), animal.getAnimalId()) == 1;
    }

    @Override
    public boolean deleteAnimal(int animalId) {
        String sql = "DELETE FROM animals WHERE animal_id = ?";
        // TODO delete other table's dependencies
        return jdbcTemplate.update(sql, animalId) == 1;
    }

    private Animals mapRowToAnimals(SqlRowSet result){
        Animals animals = new Animals();
        animals.setAnimalId(result.getInt("animal_id"));
        animals.setAnimalName(result.getString("animal_name"));
        animals.setAnimalType(result.getString("animal_type"));
        animals.setGender(result.getString("gender"));
        animals.setAge(result.getInt("age"));
        animals.setDescription(result.getString("description"));
        animals.setBreed(result.getString("breed"));
        animals.setAdoptable(result.getBoolean("is_adoptable"));

        return animals;
    }
}
