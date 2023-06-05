<template>
  <div class="directory-container">
    <h1 class="volunteer-directory">Volunteer Directory</h1>
    <div class="volunteer-card-container">
      <div class="volunteer-card" v-for="application in applications" :key="application.id">
        <img src="@/assets/blank-profile.png" alt="Profile Image" class="profile-image" />
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
        // this.applications = response.data.filter(application => application.adminApproval === "Approved");
      }).catch((error) => {
        console.error("Error fetching volunteers:", error);
      });
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
  width: 250px;
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

</style>