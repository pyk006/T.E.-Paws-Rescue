<template>
  <div id="app">
    <div id="nav">
      <img
        :src="require('@/assets/PRLogo.png')"
        alt="PR Logo"
        class="pr-logo"
      />
      <nav>
        <router-link class="button-link" v-bind:to="{ name: 'home' }">Home</router-link
        >&nbsp;
        <router-link class="button-link" v-bind:to="{ name: 'volunteer' }">Volunteer</router-link
        >&nbsp;
        <router-link class="button-link" v-bind:to="{ name: 'register' }">Register </router-link>
        &nbsp;
        <router-link class="button-link" v-bind:to="{ name: 'login' }">Login </router-link>
        &nbsp;
        <router-link class="button-link last-button-link"
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </nav>
    </div>
 
    <router-view />
 </div>
 
</template>

<style>
#app {
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
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
  background-color: #ED815A;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.8); 
  color: #0870a3;
  cursor: pointer;
}

.last-button-link {
  margin-right: 10px;
}

.button-link:hover{
  background-color: #ED815A;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}


</style>
