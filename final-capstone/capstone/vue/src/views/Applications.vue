<template>
  <div>
    <h1>Applications</h1>
    <table id="tblApplications">
      <thead>
        <tr>
          <th>Status</th>
          <th>Admin Approval</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Date of Birth</th>
          <th>Address</th>
          <th>School Mascot</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Opt-in Text</th>
          <th>Prior Experience</th>
          <th>Transportation</th>
          
        </tr>
      </thead>
      <tbody>
        <tr v-for="application in applications" :key="application.id">
          <td>{{ application.status }}</td>
          <td>
            <select
              v-model="application.adminApproval"
              @change="updateAdminApproval(application)"
            >
              <option value="approve">Approve</option>
              <option value="decline">Decline</option>
            </select>
          </td>
          <td>{{ application.firstName }}</td>
          <td>{{ application.lastName }}</td>
          <td>{{ application.dateOfBirth }}</td>
          <td>{{ application.homeAddress }}</td>
          <td>{{ application.schoolMascot }}</td>
          <td>{{ application.email }}</td>
          <td>{{ application.phoneNumber }}</td>
          <td>{{ application.optInText }}</td>
          <td>{{ application.experience }}</td>
          <td>{{ application.transportation }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";

export default {
  name: "applications-list",
  data() {
    return {
      applications: [],
    };
  },
  created() {
    this.fetchApplications();
  },
  methods: {
    fetchApplications() {
      volunteerService
        .getApplications()
        .then((response) => {
          this.applications = response.data.map((application) => ({
            ...application,
            status: "pending", // Set the status as "pending" for all applications
          }));
          console.log(response.data);
        })
        .catch((error) => {
          console.error("Error fetching applications:", error);
        });
    },
    updateAdminApproval(application) {
      const newStatus =
        application.adminApproval === "approve" ? "approved" : "declined";
      volunteerService
        .updateApplication(application.id, { status: newStatus })
        .then((response) => {
          console.log("Admin approval updated successfully:", response.data);
        })
        .catch((error) => {
          console.error("Error updating admin approval:", error);
        });
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 100vw;
  margin: 0 auto;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  margin-bottom: 20px;
}

th,
td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

tr:hover {
  background-color: #ddd;
}
</style>