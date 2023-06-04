<template>
  <div class="new-pets">
    <template v-if="isLoggedIn">
      <router-link class="button-link-last" v-bind:to="{ name: 'addPets' }">Add Pets</router-link>
    </template>

    <div class="available-container">
      <h1 class="availablepets">Available Pets</h1>
      <div class="pet-card-container">
        <div class="pet-cards" v-for="pet in pets" :key="pet.animal_id">
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
  </div>
</template>

<script>
import Pet from '@/components/PetCard.vue';
import petService from '../services/PetService';

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
          console.log(response.data[0].adoptable);
        })
        .catch(error => {
          console.error("Error loading pets.", error);
        });
    },
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== '';
    },
  },
};
</script>

<style>
.availablepets {
  text-align: center;
  margin-bottom: 20px;
  color: rgb(5, 81, 119);
}

.pet-card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
  color: rgb(5, 81, 119);
}

.pet-cards {
  border: 3px solid black;
  border-radius: 10px;
  width: 250px;
  height: 350px;
  padding: 0 20px;
  margin-bottom: 20px;
}
</style>