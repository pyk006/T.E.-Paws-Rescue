<template>
  <div class="available-container">
    <div class="available-title">
      <h1 class="availablepets">Available Pets</h1>
    </div>

    <div class="pet-info">
      <router-link class="Charlie" to="/Charlie">
        <img src="@/assets/ChocoLab/Lab1.png" alt="Pet Image" />
      </router-link>
      <h2 class="CharlieInfo">Charlie <br> Age: 3 years</h2>
    </div>

    <div class="pet-info">
      <router-link class="max" to="/Max">
        <img src="@/assets/WhiteLab/Whitelab1.png" alt="Pet Image" />
      </router-link>
      <h2 class="CharlieInfo">Max <br> Age: 1.5 years</h2>
    </div>
  </div>
</template>

<style>
.available-title {
  text-align: center;
  margin: 30px;
}

.pet-info {
  display: inline-block;
  margin-right: 30px;
}
</style>
