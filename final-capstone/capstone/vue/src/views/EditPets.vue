<template>
  <div>
    <div class="pet-card">
      <div class="pet-info">
        <h2>{{ animalName }}</h2>
        <p>Type: {{ animalType }}</p>
        <p>Gender: {{ gender }}</p>
        <p>Age: {{ age }}</p>
        <p>Description: {{ description }}</p>
        <p>Breed: {{ breed }}</p>
        <p v-if="isAdoptable">Status: Adoptable</p>
        <p v-else>Status: Not Adoptable</p>
        <slot></slot>
      </div>
      <div class="walk-status" v-if="animalType === 'Dog'">
        <p>On a Walk: {{ isOnWalk ? "Yes" : "No" }}</p>
        <button v-if="isLoggedIn" @click="handleToggleWalkAndModalVisibility">{{ isOnWalk ? "End Walk" : "Start Walk" }}</button>
        <Modal v-show="isModalVisible" @close="closeModal"/>
      </div>
    </div>

    <form @submit.prevent="updateAnimal">
      <h3>Edit Pet Card</h3>
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
      
      <!-- <label for="isAdoptable">Adoptable:</label>
      <input type="checkbox" id="isAdoptable" v-model="updatedIsAdoptable"> -->
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
    </form>
  </div>
</template>

<script>
import Modal from '../components/Modal.vue';
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
      isModalVisible: false,
      isOnWalk: false,
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
    Modal,
  },
  methods: {
    handleToggleWalkAndModalVisibility() {
      this.toggleWalkStatus();
      this.showModal();
      this.triggerInit();
    },
    toggleWalkStatus() {
      this.isOnWalk = !this.isOnWalk;
    },
    showModal() {
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
      this.isOnWalk = false;
    },
    updateAnimal() {
      console.log(this.pet.animalId);
      console.log(this.updatedIsAdoptable);
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
        .then(() => {
          console.log(this.updatedIsAdoptable);
          console.log(updatedAnimalObject);
          this.$emit('update-pet', updatedAnimalObject);
          // console.log('Animal updated:', response.data);

        })
        .catch((error) => {
          console.error('Error updating animal:', error);
        });
    },
    triggerInit() {
      this.$root.$emit('Locations');
    },
  },
  watch: {
    isOnWalk(value) {
      if (value) {
        
        console.log('The pet is on a walk!');
      } else {
       
        console.log('The pet has finished the walk.');
      }
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
/* Add your CSS styles here */
</style>