<template>
  <div>
    <h2>{{ animalName }}</h2>
    <p>Type: {{ animalType }}</p>
    <p>Gender: {{ gender }}</p>
    <p>Age: {{ age }}</p>
    <p>Description: {{ description }}</p>
    <p>Breed: {{ breed }}</p>
    <p v-if="isAdoptable">Status: Adoptable</p>
    <p v-else>Status: Not Adoptable</p>
  </div>
</template>

<script>
export default {
  props: {
    animalName: String,
    animalType: String,
    gender: String,
    age: Number,
    description: String,
    breed: String,
    isAdoptable: Boolean
  }
};
</script>