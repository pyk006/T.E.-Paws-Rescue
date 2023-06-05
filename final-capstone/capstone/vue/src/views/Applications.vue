<template>
  <div>
    <div class="directory-link">
      <template v-if="isLoggedIn">
        <router-link
          class="volunteer-directory-link"
          v-bind:to="{ path: '/directory' }"
          >Volunteer Directory</router-link
        >
      </template>
    </div>
    <h1>Applications</h1>
    <table id="tblApplications">
      <thead>
        <tr>
          <!-- <th>
            <input type="text" v-model="searchFilters.firstName" placeholder="Search by First Name" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.lastName" placeholder="Search by Last Name" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.dateOfBirth" placeholder="Search by Date of Birth" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.homeAddress" placeholder="Search by Address" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.schoolMascot" placeholder="Search by School Mascot" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.email" placeholder="Search by Email" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.phoneNumber" placeholder="Search by Phone Number" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.optInText" placeholder="Search by Opt-in Text" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.experience" placeholder="Search by Prior Experience" />
          </th>
          <th>
            <input type="text" v-model="searchFilters.transportation" placeholder="Search by Transportation" />
          </th> -->

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
        <tr
          v-for="application in applications"
          :key="application.applicationId"
        >
          <td>
            <select
              v-model="application.adminApproval"
              @change="updateAdminApproval(application)"
            >
              <option
                value="Pending"
                v-if="application.adminApproval === 'Pending'"
                selected
              >
                Pending
              </option>
              <option
                value="Approved"
                v-if="application.adminApproval === 'Approved'"
                selected
              >
                Approve
              </option>
              <option
                value="Declined"
                v-if="application.adminApproval === 'Declined'"
                selected
              >
                Decline
              </option>
              <option value="Pending">Pending</option>
              <option value="Approved">Approve</option>
              <option value="Declined">Decline</option>
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
import authService from "../services/AuthService";

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
            adminApproval: application.adminApproval, // Set the status from the database
          }));
        })
        .catch((error) => {
          console.error("Error fetching applications:", error);
        });
    },
    updateAdminApproval(application) {
      const newStatus =
        application.adminApproval === "Approved" ? "Approved" : "Declined";
      const isNewlyApproved = newStatus === "Approved";
      volunteerService
        .updateApplication({
          adminApproval: newStatus,
          applicationId: application.applicationId,
        })
        .then((response) => {
          console.log("Admin approval updated successfully:", response.data);
          const updatedApplicationIndex = this.applications.findIndex(
            (app) => app.id === application.id
          );
          if (updatedApplicationIndex !== -1) {
            // Update the admin approval status
            this.applications[updatedApplicationIndex].adminApproval =
              newStatus;
          }
          if (!isNewlyApproved) {
            // Remove the application from the list view
            this.applications.splice(updatedApplicationIndex, 1);
          }
          if (isNewlyApproved) {
            // Register the user as a new user with an auto-generated password
            const newUser = {
              username: application.email,
              password: "tepawsvolunteer",
              confirmPassword: "tepawsvolunteer",
              role: "user",
            };
            authService
              .register(newUser)
              .then((registerResponse) => {
                if (registerResponse.status === 201) {
                  console.log(
                    "User registered successfully:",
                    registerResponse.data
                  );
                  // push new user to the database..
                  window.alert("New user added successfully");
                }
              })
              .catch((registerError) => {
                console.error("Error registering user:", registerError);
              });
          }
        })
        .catch((error) => {
          console.error("Error updating admin approval:", error);
        });
    },
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
    // filteredApplications(){
    //   const filters = this.searchFilters;
    //   return this.applications.filter(application => {
    //     return (
    //       application.firstName.toLowerCase().includes(filters.firstName.toLowerCase()) &&
    //       application.lastName.toLowerCase().includes(filters.lastName.toLowerCase()) &&
    //       application.dateOfBirth.toLowerCase().includes(filters.dateOfBirth.toLowerCase()) &&
    //       application.homeAddress.toLowerCase().includes(filters.homeAddress.toLowerCase()) &&
    //       application.schoolMascot.toLowerCase().includes(filters.schoolMascot.toLowerCase()) &&
    //       application.email.toLowerCase().includes(filters.email.toLowerCase()) &&
    //       application.phoneNumber.toLowerCase().includes(filters.phoneNumber.toLowerCase()) &&
    //       application.optInText.toLowerCase().includes(filters.optInText.toLowerCase()) &&
    //       application.experience.toLowerCase().includes(filters.experience.toLowerCase()) &&
    //       application.transportation.toLowerCase().includes(filters.transportation.toLowerCase())
    //     );
    //   });
    // },
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

.volunteer-directory-link {
  display: inline-block;
  margin-top: 10px;
  margin-left: 10px;
  font-weight: bold;
  padding: 4px 8px;
  background-color: #ed815a;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: #0870a3;
  text-decoration: none;
}

.volunteer-directory-link:hover {
  background-color: #ed815a;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}
</style>