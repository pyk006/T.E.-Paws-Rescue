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
      formData.append("upload_preset", "animalPhotoCloud"); // Replace with your Cloudinary upload preset

      fetch(
        `https://api.cloudinary.com/v1_1/dfg9ft030/upload`, // Replace with your Cloudinary cloud name
        {
          method: "POST",
          body: formData,
        }
      )
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          // Handle the response from Cloudinary
          // You can store the uploaded image URL or perform any other actions
        })
        .catch((error) => {
          console.error(error);
          // Handle error if upload fails
        });
    },
  },
};
</script>



