<template>
  <div class="directory-container">
    <h1 class="volunteer-directory">Volunteer Directory</h1>
    <div class="volunteer-card-container">
      <div class="volunteer-card" v-for="application in applications" :key="application.id">
        <img :src="getPhoto(application.photo)" alt="Profile Image" class="profile-image" />
        <div class="volunteer-card-content">
          <h3>{{ application.firstName }} {{ application.lastName }}</h3>
          <p>Phone Number: {{ application.phoneNumber }}</p>
          <p>Email: {{ application.email }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService"

export default {
  name: "VolunteerDirectory",
  data(){
    return {
      applications: [],
    };
  },
  created(){
    this.fetchVolunteers();
  },
  methods: {
    fetchVolunteers(){
      volunteerService.getVolunteers().then((response) => {
        this.applications = response.data;
      }).catch((error) => {
        console.error("Error fetching volunteers:", error);
      });
    },

    getPhoto(photo){
      if (photo && photo.trim() !== ""){
        return photo;
      } else {
        return require("@/assets/blank-profile.png");
      }
    },

  },

};
</script>

<style>
.volunteer-directory {
  text-align: center;
  margin-bottom: 20px;
  color: rgb(5, 81, 119);
}

.volunteer-card-container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  color: whitesmoke;
}

.volunteer-card {
  border: 3px solid rgb(5, 81, 119);
  background-color: rgb(5, 81, 119);
  border-radius: 10px;
  width: 300px;
  height: 250px;
  padding: 0 20px;
  margin: 10px;
}

.profile-image {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 50%;
  margin-top: 10px;
}

.applications-link {
  font-weight: bold;
  text-decoration: none;
  color: rgb(5, 81, 119);
  margin-left: 10px;
}

.applications-link:hover {
  color: #ED815A;
}

@media (max-width: 576px) {
  .directory-container {
    margin: 0 20px; /* Adjust the margin as desired */
  }

  .volunteer-card {
    width: 100%; /* Make the cards take full width */
  }
}

</style>