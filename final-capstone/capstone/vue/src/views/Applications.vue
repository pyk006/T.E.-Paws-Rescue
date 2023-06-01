<template>
  <div>
    <h1>Applications</h1>
    <table>
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Date of Birth</th>
          <!-- Add more table headers for other application fields -->
        </tr>
      </thead>
      <tbody>
        <tr v-for="application in applications" :key="application.id">
          <td>{{ application.firstName }}</td>
          <td>{{ application.lastName }}</td>
          <td>{{ application.dateOfBirth }}</td>
          <!-- Display other application fields in the table rows -->
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";

export default {
  data() {
    return {
      applications: [],
    };
  },
  created(){
      this.fetchApplications();
      
  },
  methods: {
    fetchApplications() {
      volunteerService.getApplications().then(response => {
          this.applications = response.data;
          console.log(response.data);
        })
        .catch(error => {
          console.error("Error fetching applications:", error);
        });
    },
  },
};
</script>