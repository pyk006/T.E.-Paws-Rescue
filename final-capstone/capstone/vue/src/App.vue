<template>
  <div id="app">
    <div id="nav">
      <img
        :src="require('@/assets/PRLogo.png')"
        alt="PR Logo"
        class="pr-logo"
      />
      <nav>
        <router-link class="button-link" v-bind:to="{ name: 'home' }"
          >Home</router-link
        >&nbsp;
        <router-link class="button-link" v-bind:to="{ name: 'volunteer' }"
          >Volunteer</router-link
        >&nbsp;
        <!-- <router-link class="button-link" v-bind:to="{ name: 'login' }"
          >Login
        </router-link>
        &nbsp; -->
        <router-link class="button-link" v-bind:to="{ name: 'register' }"
          >Register
        </router-link>
        &nbsp;
        <router-link class="button-link" v-bind:to="{ name: 'login' }">
          {{ loginButtonText }}
        </router-link>
      </nav>
    </div>

    <router-view />
  </div>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
    loginButtonText() {
      return this.isLoggedIn ? "Login" : "Logout";
    },
  },
};
</script>

<style>
#app {
  font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS", sans-serif;
  background-color: #b2d8f5;
  min-height: 100vh;
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.pr-logo {
  display: flex;
  justify-items: start;
  align-items: center;
  width: 300px;
  margin-right: auto;
}

#nav {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.button-link {
  font-weight: bold;
  text-decoration: none;
  background-color: #ed815a;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: #055983;
  cursor: pointer;
}

.button-link:last-child {
  margin-right: 10px;
}

.button-link:hover {
  background-color: #ed815a;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}
</style>
