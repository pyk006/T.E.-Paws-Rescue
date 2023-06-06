import axios from 'axios';

export default {

    getPet() {
        return axios.get('/availablePets');
    },

submitForm(formData) {
        return axios.post(`/availablePets/addPets`, formData)
    },

    editPet(animalId) {
    return axios.put('/animals', animalId)
},
}