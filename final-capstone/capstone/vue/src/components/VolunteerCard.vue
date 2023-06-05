<template>
  <div class="volunteer-card">
      <div class="volunteer-info">
          <h3>{{ firstName }} {{ lastName }}</h3>
          <p>Phone Number: {{ phoneNumber }}</p>
          <p>Email: {{ email }}</p>
      </div>
  </div>
</template>

<script>
export default {
    props: {
        firstName: String,
        lastName: String,
        phoneNumber: String,
        email: String
    },

}
</script>

<style>

</style>