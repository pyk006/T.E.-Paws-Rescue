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
      formData.append("upload_preset", 'un133o5a'); //insert your Cloudinary upload preset

      return fetch(
        `https://api.cloudinary.com/v1_1/dydfdj1r5/upload`, //insert your Cloudinary cloudName 
        {
          method: "POST",
          body: formData,
        }
      )
        .then((response) => response.json())
        .catch((error) => {
         alert("An error occurred" + error.message);
       // Handle error if upload fails
      });
       
    },
  },
};
</script>



