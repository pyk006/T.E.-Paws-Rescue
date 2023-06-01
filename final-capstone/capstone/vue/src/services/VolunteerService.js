import axios from 'axios';

export default {

    submitForm(formData){
        return axios.post(`/volunteer/submit-form`, formData)
    }

}