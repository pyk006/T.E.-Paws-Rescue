
<template>
  <div class="modal-backdrop">
    
    <div class="modal">
        <h2>Update Photo</h2>
        <label for="image-upload">Image (PNG only):</label>
        <!-- Add CloudinaryComp for file upload -->
        <CloudinaryComp ref="cloudinaryComp" @image-uploaded="handleImageUploaded" />

      <footer class="modal-footer">
        <button
          type="button"
          class="btn-theme"
          @click="close"
        >
          Exit Update Photo
        </button>
      </footer>
    </div>
  </div>
</template>

<script>

import CloudinaryComp from './CloudinaryComp.vue';

export default {
  name: 'UpdatePhotoModal',
  components: {
   
    CloudinaryComp,
  },
  props: {
    petInfo: Object, // Prop to pass the pet information from the parent component
  },
  methods: {
    close() {
      this.$emit('close');
    },
    handleUploadSuccess(newPhotoUrl) {
      this.$emit('update-photo', newPhotoUrl);
    },
  },
};
</script>

<style>
  .modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.6);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .modal {
    background: #FFFFFF;
    box-shadow: 2px 2px 40px 1px;
    display: flex;
    flex-direction: column;
  }

  .modal-footer {
    padding: 15px;
    display: flex;
  }

  .modal-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
    justify-content: flex-end;
  }

  .modal-body {
    position: relative;
    padding: 20px 10px;
  }


  .btn-theme {
    color: #0870a3;
    background: #ED815A;
    border: 1px solid #ED815A;
    width: 200px;
    border-radius: 8px;
  }
  .btn-theme:hover {
      cursor: pointer;
          background: #f5b59e;
    border: 1px solid #f5b59e;
  }
</style>