<template>
  <div class="form-container">
      <label for="image-upload">Image (PNG only):</label>
      <CloudinaryComp ref="cloudinaryComp" @image-uploaded="handleImageUploaded" />

        <label for="animal-name">Name:</label>
        <input type="text" id="animal-name" v-model="form.animalName" required />

        <label for="animal-type">Type:</label>
        <input type="text" id="animal-type" v-model="form.animalType" required />

        <label for="gender">Gender:</label>
        <input type="text" id="gender" v-model="form.gender" required />

        <label for="description">Description:</label>
        <input type="text" id="dob" v-model="form.description" required />

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
            <!-- <button type="submit">Submit</button> -->
        
      </div>
      <button type="submit" @click="submitForm">Submit</button>
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
        photo: "", // Variable to store the image URL
      },
    };
  },


methods: {
 submitForm() {
  const cloudinaryComp = this.$refs.cloudinaryComp;
  if (cloudinaryComp.selectedFile) {
    cloudinaryComp.uploadImage().then((data) => {
      // Access the image URL from the response data
      const imageUrl = data.url;

      // Emit the image-uploaded event with the image URL
        this.handleImageUploaded(imageUrl);

        // Submit the form data with the image URL to the backend
        this.submitFormData();
     })
      .catch((error) => {
        console.error(error);
        // Handle error if image upload fails
      });
  } else {
    console.log("Please select an image to upload");
  }
},
submitFormData() {
  // Send the form data to the backend
  petService.submitForm(this.form)
    .then((response) => {
      if (response.status === 201) {
        console.log(response.status);
        this.showForm = false; // hide after successful submission
        window.alert("Form submitted successfully");
      }
    })
    .catch((error) => {
      console.error(error);
      // Handle error if form submission fails
    });
},


  handleImageUploaded(imageUrl) {
  this.form.photo = imageUrl; // Assign the image URL to the form's photo field
  console.log(imageUrl);

   // Emit the image-uploaded event with the image URL
  this.$emit("image-uploaded", imageUrl);
},

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