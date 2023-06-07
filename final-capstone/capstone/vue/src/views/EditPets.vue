<template>
  <div>
    <form @submit.prevent="updateAnimal" class="editPetForm">
      <h3>Edit Pet Card</h3> 
      <div class="form-column">
      <label for="animalName">Name:</label>
      <input type="text" id="animalName" v-model="updatedAnimalName" required>
      
      <label for="animalType">Type:</label>
      <input type="text" id="animalType" v-model="updatedAnimalType" required>
      
      <label for="gender">Gender:</label>
      <input type="text" id="gender" v-model="updatedGender" required>
      
      <label for="age">Age:</label>
      <input type="number" id="age" v-model="updatedAge" required>
      
      <label for="description">Description:</label>
      <textarea id="description" v-model="updatedDescription" required></textarea>
      
      <label for="breed">Breed:</label>
      <input type="text" id="breed" v-model="updatedBreed" required>

      <label for="isAdoptable">Adoptable:</label>
            <label for="adoptable-yes">Yes</label>
            <input
              type="radio"
              id="adoptable-yes"
              value="true"
              v-model="updatedIsAdoptable"
            />

            <label for="adoptable-no">No</label>
            <input
              type="radio"
              id="adoptable-no"
              value="false"
              v-model="updatedIsAdoptable"
            />

      
      <button type="submit">Save Changes</button>
      </div>
    </form>
    <router-link class="editPet-link" v-bind:to="{ name: 'availablePets' }">Go to Available Pets</router-link>
  </div>
</template>

<script>
// import Modal from '../components/Modal.vue';
import PetService from '../services/PetService'

export default {
  props: {
    pet: Object,
    photo: String,
    animalName: String,
    animalType: String,
    gender: String,
    age: Number,
    description: String,
    breed: String,
    isAdoptable: Boolean,
    animalId: Number,
  },
  data() {
    return {
      updatedAnimalName: '',
      updatedAnimalType: '',
      updatedGender: '',
      updatedAge: 0,
      updatedDescription: '',
      updatedBreed: '',
      updatedIsAdoptable: false,
      
    };
  },
  components: {

  },
  methods: {
    updateAnimal() {
      const updatedAnimalObject = {
        animalId: this.pet.animalId,
        animalName: this.updatedAnimalName,
        animalType: this.updatedAnimalType,
        gender: this.updatedGender,
        age: this.updatedAge,
        description: this.updatedDescription,
        breed: this.updatedBreed,
        isAdoptable: this.updatedIsAdoptable,
      };

      PetService.editPet(updatedAnimalObject)
        .then((response) => {
          this.$emit('update-pet', updatedAnimalObject);
          window.alert(`${updatedAnimalObject.animalName} has been changed!`)
          console.log('Animal updated:', response.data);
        })
        .catch((error) => {
          console.error('Error updating animal:', error);
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
.editPetForm {
  border: 3px solid rgb(5, 81, 119);
  border-radius: 10px;
  max-width: 400px;
  height: 500px;
  padding: 0 10px;
  margin: 10px;
  background: rgb(5, 81, 119);;
  color: rgb(160, 187, 226);
}

.form-column {
  display: flex;
  flex-direction: column;
  margin-right: 20px;
}

label {
  margin-bottom: 5px;
}
.editPet-link{
  display: flex;
  justify-content: center;
  font-weight: bold;
  text-decoration: none;
  background-color: #ed815a;
  padding: 10px 7px;
  border-radius: px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: #0870a3;
  cursor: pointer;
  margin-top: 10px;
  max-width: 150px;
  margin-left: 100px;
}

</style>