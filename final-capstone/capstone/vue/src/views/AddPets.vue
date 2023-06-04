<template>
  <div class="form-container">
      <label for="image-upload">Image (PNG only):</label>
      <CloudinaryComp />

        <label for="animal-name">Name:</label>
        <input type="text" id="animal-name" v-model="form.animalName" required />

        <label for="animal-type">Type:</label>
        <input type="text" id="animal-type" v-model="form.animalType" required />

        <label for="gender">Gender:</label>
        <input type="text" id="gender" v-model="form.gender" required />

        <label for="description">Description:</label>
        <input type="text" id="dob" v-model="form.age" required />

        <label for="breed">Breed:</label>
        <input type="text" id="breed" v-model="form.breed" required />

        <label for="age">Age:</label>
        <input type="text" id="Age" v-model="form.age" required />

          <label for="isAdoptable"> Adoptable:</label>
          <div class="radio-buttons">
            <label for="opt-in-yes">Yes</label>
            <input
              type="radio"
              id="opt-in-yes"
              value="true"
              v-model="form.optInText"
          />
          <label for="opt-in-no">No</label>
            <input
              type="radio"
              id="opt-in-no"
              value="false"
              v-model="form.optInText"
            />
<br>
            <button type="submit">Submit</button>
        
      </div>
    </div>


</template>

<script>
import petService from '../services/PetService'
import CloudinaryComp from '../components/CloudinaryComp.vue'

export default {
  name: "addPets",
  components: {
    CloudinaryComp
  },
  data() {
    return {
      form: {
        animalName: "",
        animalType: "",
        gender: "",
        age: "",
        description: "",
        breed: "",
        isAdoptable: false,
      
      },
    };
  },

methods: {
submitForm() {
      petService.submitForm(this.form).then((response) => {
        if (response.status === 201) {
          console.log(response.status);
          this.showForm = false; //hide after successful submission
          this.$router.push({ name: "addPets" });
        }
      });
    }
  },
};


</script>

<style>
.form-container {
  display: flex;
  flex-direction: column;
  border: 4px solid rgb(5, 81, 119); 
  padding: 5px; 
  align-items: center; 
  justify-content: center; 
  max-width: 400px;
  color:rgb(5, 81, 119); 
}

.form-container label {
  margin: 2px 0;
}

.form-container input[type="text"] {
  padding: 5px;
  width: 200px;
}



</style>