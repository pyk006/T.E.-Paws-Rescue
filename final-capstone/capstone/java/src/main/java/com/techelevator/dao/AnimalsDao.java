package com.techelevator.dao;

import com.techelevator.model.Animals;

import java.util.List;

public interface AnimalsDao {

    List<Animals> getAllAnimals();

    boolean createAnimal(String animalName, String animalType, String gender, int age, String description, String breed, boolean isAdoptable);

    Animals getAnimalById(int animalId);

    boolean updateAnimal(Animals animal);

    boolean deleteAnimal(int animalId);

}
