<template>
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
    </div>
    <div class="walk-status">
      <p>On a Walk: {{ isOnWalk ? "Yes" : "No" }}</p>
      <button @click="handleToggleWalkAndModalVisibility">{{ isOnWalk ? "End Walk" : "Start Walk" }}</button>
          <Modal
      v-show="isModalVisible"
      @close="closeModal"/>
    </div>
  </div>
</template>

<script>
import Modal from './Modal.vue';
export default {
  props: {
    animalName: String,
    animalType: String,
    gender: String,
    age: Number,
    description: String,
    breed: String,
    isAdoptable: Boolean
  },
  data() {
    return {
      isModalVisible: false,
      isOnWalk: false
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
  triggerInit() {
      this.$root.$emit('Locations');
    },
  },
  watch: {
    isOnWalk(value) {
      if (value) {
        // Need to do an API update to make it show  when the pet start the walk
      
        console.log("The pet is on a walk!");
      } else {
        // Need to do an API update to make it show  when the pet ends the walk
       
        console.log("The pet has finished the walk.");
      }
    }
  }
};
</script>