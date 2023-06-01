<template>
  <div class="available-container">
    <h1 class="availablepets">Available Pets</h1>
    <div v-for="pet in pets" :key="pet.animal_id">
      <pet
        :animalName="pet.animal_name"
        :animalType="pet.animal_type"
        :gender="pet.gender"
        :age="pet.age"
        :description="pet.description"
        :breed="pet.breed"
        :isAdoptable="pet.is_adoptable"
      />
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
    this.loadPets();
  },
  methods: {
    fetchPets() {
      petService.getPets()
        .then(response => {
          this.pets = response.data;
          console.log(response.data);
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
  margin: 30px;
}

.pet-info {
  display: inline-block;
  margin-right: 30px;
}
</style>
