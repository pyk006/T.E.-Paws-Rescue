<template>
  <div>
    <h1>Applications</h1>
    <table>
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Date of Birth</th>
          <th>Address</th>
          <th>Age</th>
          <th>School Mascot</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Opt-in Text</th>
          <th>Experience</th>
          <th>Transportation</th>
          <th>Status</th>
          <th>Admin Approval</th>
        </tr>
      </thead>
      <tbody>
        <!-- Loop through the applications data and populate the table rows -->
        <tr v-for="application in applications" :key="application.id">
          <td>{{ application.firstName }}</td>
          <td>{{ application.lastName }}</td>
          <td>{{ application.dateOfBirth }}</td>
          <td>{{ application.homeAddress }}</td>
          <td>{{ application.age }}</td>
          <td>{{ application.schoolMascot }}</td>
          <td>{{ application.email }}</td>
          <td>{{ application.phoneNumber }}</td>
          <td>{{ application.optInText }}</td>
          <td>{{ application.experience }}</td>
          <td>{{ application.transportation }}</td>
          <td>{{ application.status }}</td>
          <td>{{ application.adminApproval }}</td>
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