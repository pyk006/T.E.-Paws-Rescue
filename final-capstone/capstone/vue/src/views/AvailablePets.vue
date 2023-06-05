<template>
  <div class="new-pets">
    <div class="search-container">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search by animal type"
      />
      <button @click="searchPets">Search</button>
    </div>

    <router-link
      class="button-link-last"
      v-if="isLoggedIn"
      v-bind:to="{ name: 'addPets' }"
      >Add Pets</router-link
    >

    <div class="available-container">
      <h1 class="availablepets">Available Pets</h1>
      <div class="pet-card-container">
        <div class="pet-cards" v-for="pet in filteredPets" :key="pet.animal_id">
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
      searchQuery: "",
    };
  },
  created() {
    this.fetchPets();
  },
  methods: {
    fetchPets() {
      petService
        .getPet(this.searchQuery)
        .then((response) => {
          this.pets = response.data;
          console.log(response.data);
          console.log(response.data[0].adoptable);
        })
        .catch((error) => {
          console.error("Error loading pets.", error);
        });
    },
    searchPets() {
      this.fetchPets();
    },
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
    filteredPets() {
      if (this.searchQuery) {
        return this.pets.filter((pet) =>
          pet.animalType.toLowerCase().includes(this.searchQuery.toLowerCase())
        );
      } else {
        return this.pets;
      }
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
  width: 490px;
  height: 750px;
  padding: 0 10px;
  margin-bottom: 20px;
}

.pet-cards .pet-photo {
  width: 100%;
  height: 400px; 
  object-fit: cover;
  border-radius: 10px;
  margin-top: 5px;
}

.pet-cards .pet-info {
  padding: 0px;
}

.search-container {
  margin-bottom: 10px;
}

.search-container input {
  width: 200px;
  padding: 10px;
  margin-right: 10px;
}

.search-container button {
  background-color: rgb(5, 81, 119);
  color: white;
  padding: 10px 30px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width: 100px;
  }

.search-container button {
  background-color: rgb(5, 81, 119);
  color: white;
  padding: 5px 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.button-link-last {
  display: inline-block;
  margin-bottom: 10px;
  background-color: rgb(5, 81, 119);
  color: white;
  padding: 5px 10px;
  border-radius: 5px;
  text-decoration: none;
}

.button-link-last:hover {
  opacity: 0.8;
}
</style>
