<template>
  <div class="volunteer">
    <h1>Volunteer With Us.</h1>
    <p>TE Paw Rescue is seeking dedicated and compassionate volunteers to make a meaningful impact on the lives of animals
      in their care. Qualifications include being 18 years or older, having animal experience (preferable but not mandatory),
      committing a minimum of 15 hours per week, understanding the position is non-paid, and being physically capable of
      lifting at least 25 pounds. Volunteer responsibilities include assisting with animal care, socialization, adoption support,
      facility maintenance, and participating in special events. By joining the volunteer team, individuals can contribute to
      the well-being of animals and be part of a supportive community.</p>

    <div class="form-container">
      <form class="form" @submit.prevent="submitForm">
        <label for="full-name">Full Name:</label>
        <input type="text" id="full-name" v-model="fullName" required>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" v-model="dateOfBirth" required>

        <label for="">Availabilities:</label>
        <input type="availabilities" id="availabilities" v-model="availabilities" required>

        <label for="">Location(for on call):</label>
        <input type="location" id="location" v-model="location" required>

        <label for="school-mascot">School Mascot:</label>
        <input type="text" id="school-mascot" v-model="schoolMascot">

        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required>

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" v-model="phoneNumber" required>

        <label for="opt-in">Opt-in for Text Messages:</label>

        <div>
          <label for="opt-in-yes">Yes</label>
          <input type="radio" id="opt-in-yes" value="yes" v-model="optInTextMessages">

          <label for="opt-in-no">No</label>
          <input type="radio" id="opt-in-no" value="no" v-model="optInTextMessages">
        </div>

        <label for="opt-in">Would you submit a background check:</label>
        <div>
          <label for="opt-in-yes">Yes</label>
          <input type="radio" id="opt-in-yes" value="yes" v-model="optInTextMessages">

          <label for="opt-in-no">No</label>
          <input type="radio" id="opt-in-no" value="no" v-model="optInTextMessages">
        </div>

        <label for="opt-in">Do you have any experience working with animals at a shelter or vet clinic:</label>

        <div>
          <label for="opt-in-yes">Yes</label>
          <input type="radio" id="opt-in-yes" value="yes" v-model="optInTextMessages">

          <label for="opt-in-no">No</label>
          <input type="radio" id="opt-in-no" value="no" v-model="optInTextMessages">
        </div>

        <label for="opt-in">Do you have a means of transportation: </label>

        <div>
          <label for="opt-in-yes">Yes</label>
          <input type="radio" id="opt-in-yes" value="yes" v-model="optInTextMessages">

          <label for="opt-in-no">No</label>
          <input type="radio" id="opt-in-no" value="no" v-model="optInTextMessages">
        </div>
        

        <button type="submit">Submit</button>
      </form>
    </div>
  </div>
</template>

<script>
import volunteerService from '../services/VolunteerService';

export default {
  name: "volunteer",
  data() {
    return {
      form: {
      fullName: "",
      dateOfBirth: "",
      availabilities: "",
      location:"",
      schoolMascot: "",
      email: "",
      phoneNumber: "",
      optInTextMessages: "no",
      WouldYouSubmitABackGroundCheck: "no",
      DoYouHaveAnyExperienceWorkingWithAnimalsAtAShelterOrVetClinic: "no",
      DoYouHaveAMeansOfTransportation: "no"
      }
    };
  },
  methods: {
    submitForm() {
      //info goes here
      volunteerService.submitForm(this.form).then(response => {
        if(response.status === 201){
          this.$router.push({name: "volunteer"})
        }
      });
      console.log("Form submitted");
    }
  }
};
</script>

<style scoped>
.volunteer {
  color: #023047;
  
}

.form-container {
  margin-top: 20px;
  border: 5px solid #055983;
}
form {
 margin-left: 20px;
 margin-bottom: 20px;
 margin-top: 10px;
}
label {
  display: block;
  margin-bottom: 5px;
}
.opt-in-container {
  display: inline-block;
}
.opt-in-container input[type="radio"] {
  margin-right: 5px;
}

button[type="submit"] {
  margin-top: 10px;
}
</style>


