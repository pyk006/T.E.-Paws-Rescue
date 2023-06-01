package com.techelevator.controller;

import com.techelevator.dao.AnimalsDao;
import com.techelevator.model.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AnimalsController {

    @Autowired
    AnimalsDao animalsDao;

    @GetMapping(path = "/availablePets")
    public List<Animals> listAnimals() { return animalsDao.getAllAnimals(); }

    @PostMapping("/animals-create")
    public void createAnimal(@RequestBody Animals animals){
        animalsDao.createAnimal(animals.getAnimalName(), animals.getAnimalType(), animals.getGender(),
                animals.getAge(), animals.getDescription(), animals.getBreed(), animals.isAdoptable());
    }

    @RequestMapping(path = "/animals", method = RequestMethod.PUT)
    public void updateAnimal(@RequestBody Animals animals){
        animalsDao.updateAnimal(animals);
    }

    @RequestMapping(path = "/animals/{id}", method = RequestMethod.DELETE)
    public void deleteAnimal(@PathVariable int id){
        animalsDao.deleteAnimal(id);
    }
}
