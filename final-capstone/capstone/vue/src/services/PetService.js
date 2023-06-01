import axios from 'axios';

export default {

    getPet() {
        return axios.get('/availablePets');
    },

}