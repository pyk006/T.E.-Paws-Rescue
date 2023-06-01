<template>
  <div class="home">
    <router-link v-bind:to="{ name: 'adoptedPets' }">Adopted Pets</router-link>&nbsp;|&nbsp;
    <router-link v-bind:to="{ name: 'availablePets' }">Available Pets</router-link>&nbsp;|&nbsp;

       <div class="main-content">
      <div id="who-we-are">WHO WE ARE</div>
      <p id="who">
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Suscipit error
        atque expedita possimus ipsum sapiente quibusdam. Omnis hic saepe
        distinctio beatae a alias eligendi! Quisquam quasi tempora distinctio
        quam cupiditate.
      </p>
      <div id="our-goals">OUR GOALS</div>
      <p id="goals">
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Suscipit error
        atque expedita possimus ipsum sapiente quibusdam. Omnis hic saepe
        distinctio beatae a alias eligendi! Quisquam quasi tempora distinctio
        quam cupiditate.
      </p>

      <div id="how-to-help">HOW TO HELP</div>
      <p id="help">
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Suscipit error
        atque expedita possimus ipsum sapiente quibusdam. Omnis hic saepe
        distinctio beatae a alias eligendi! Quisquam quasi tempora distinctio
        quam cupiditate.
      </p>
    </div>

    <footer>
      <div id="contact-us">Contact Us:</div>
      <div id="find-us">Find Us:</div>
      <div id="follow-us">Follow Us:</div>
    </footer>
  </div>
  
</template>

<script>
export default {
  name: "home"
};
</script>

<style>

#who{
  grid-area: who;
}

#help{
  grid-area: help;
}

#goals{
  grid-area: goals;
}

.main-content {
  display: grid;
  align-content: center;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas:
    "who-we-are who-we-are who-we-are"
    "our-goals our-goals our-goals"
    "how-to-help how-to-help how-to-help"
    "who goals help";
  grid-gap: 20px;
  background-color: #219ebc;
  padding: 20px;
}

footer {
  background-color: #055983;
  padding: 20px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  color: white;
}

</style>