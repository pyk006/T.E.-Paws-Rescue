<template>
  <div class="available-container">
    <h1 class="availablepets">Available Pets</h1>
    <div class="pet-card-container">
    <div class="pet-card" v-for="pet in pets" :key="pet.animal_id">
      <pet
        :animalName="pet.animalName"
        :animalType="pet.animalType"
        :gender="pet.gender"
        :age="pet.age"
        :description="pet.description"
        :breed="pet.breed"
        :isAdoptable="pet.adoptable"
      />
      </div>
    </div>
  </div>
</template>

<script>
import Pet from '@/components/PetCard.vue';
import petService from '../services/PetService'

export default {
  components: {
    Pet
  },
  data() {
    return {
      pets: [] 
    };
  },
  created() {
    this.fetchPets();
  },
  methods: {
    fetchPets() {
      petService.getPet()
        .then(response => {
          this.pets = response.data;
          console.log(response.data);
          console.log(response.data[0].adopotable);
        })
        .catch(error => {
          console.error("Error loading pets.", error);
        });
    },

  },
};

</script>


<style>
.availablepets {
  text-align: center;
  margin-bottom: 20px;
}

.pet-card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
}

.pet-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 300px;
  margin: 10px;
}

</style>
