<template>
  <div>
    <input type="file" @change="handleFileUpload" ref="fileInput" />
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedFile: null,
    };
  },
  methods: {
    handleFileUpload(event) {
      this.selectedFile = event.target.files[0];
    },
    uploadImage() {
      const formData = new FormData();
      formData.append("file", this.selectedFile);
      formData.append("upload_preset", "animalPhotoCloud"); 

      return fetch(
        `https://api.cloudinary.com/v1_1/dfg9ft030/upload`, 
        {
          method: "POST",
          body: formData,
        }
      )
        .then((response) => response.json())
        .catch((error) => {
         console.error(error);
       // Handle error if upload fails
      });
       
    },
  },
};
</script>



