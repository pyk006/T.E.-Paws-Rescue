<template>
  <div class="new-pets">
    <router-link
      class="button-link-last"
      v-if="isLoggedIn"
      v-bind:to="{ name: 'addPets' }"
      >Add Pets</router-link
    >

    <div class="available-container">
      <h1 class="availablepets">Available Pets</h1>
      <div class="pet-card-container">
        <div class="pet-cards" v-for="pet in pets" :key="pet.animal_id">
          <pet
            :photo="pet.photo"
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
import Pet from "@/components/PetCard.vue";
import petService from "../services/PetService";

export default {
  components: {
    Pet,
  },
  data() {
    return {
      pets: [],
    };
  },
  created() {
    this.fetchPets();
  },
  methods: {
    fetchPets() {
      petService
        .getPet()
        .then((response) => {
          this.pets = response.data;
          console.log(response.data);
          console.log(response.data[0].adopotable);
        })
        .catch((error) => {
          console.error("Error loading pets.", error);
        });
    },
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
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
  border: 3px solid rgb(5, 81, 119);
  border-radius: 10px;
  width: 250px;
  height: 700px;
  padding: 0 10px;
  margin-bottom: 20px;
}

.pet-cards .pet-photo {
  width: 100%;
  height: 200;
  object-fit: cover;
  border-radius: 10px;
  margin-top: 5px;
}

.pet-cards .pet-info {
  padding: 0px;
}


</style>
