<template>
  <div class="directory-container">
    <h1 class="volunteer-directory">Volunteer Directory</h1>
    <div class="volunteer-card-container">
      <div class="volunteer-cards">
        <!-- add volunteer loop info -->
      </div>
    </div>
  </div>
</template>

<script>
export default {};
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
  justify-content: space-between;
  align-items: flex-start;
  color: rgb(5, 81, 119);
}

.volunteer-cards {
  border: 3px solid rgb(5, 81, 119);
  border-radius: 10px;
  width: 250px;
  height: 350px;
  padding: 0 20px;
  margin-bottom: 20px;
}
</style>