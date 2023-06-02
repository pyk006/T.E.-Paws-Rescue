import axios from 'axios';

export default {

    submitForm(formData) {
        return axios.post(`/volunteer/submit-form`, formData)
    },

    getApplications() {
        return axios.get('/applications');
    },

    updateApplication(data) {
        const url = "/applications";
        return axios.put(url, data);
    },

}