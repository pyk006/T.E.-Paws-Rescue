<template>
  <div>
      <button v-on:click="upload">Upload</button><br>
  </div>
</template>

<script>
export default {
  name: 'CloudinaryWidget',
  data() {
    return {
      myWidget : {}
    }
  },
  methods: {
    upload() {
    this.myWidget.open({
      cloudName: 'dfg9ft030',
      uploadPreset: 'animalPhotoCloud'
    });
  }
  },
  events: {
  'file-upload-done'(result) {
    if (result.event === 'success' && result.info && result.info.url) {
      const imageUrl = result.info.url;
      console.log('Photo uploaded:', imageUrl);
      this.$emit('photo-uploaded', imageUrl);
    }
  }
},
  mounted() {
       this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Insert your cloud name and presets here, 
        // see the documentation
        cloudName: 'dfg9ft030', 
        uploadPreset: 'animalPhotoCloud'
        
      }, 
      (error, result) => { 
        if (!error && result && result.event === "success") { 
          console.log('Done! Here is the image info: ', result.info); 
          console.log("Image URL: " + result.info.url);
        }
      }
    );

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
