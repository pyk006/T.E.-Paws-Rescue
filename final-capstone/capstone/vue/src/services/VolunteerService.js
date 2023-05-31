import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {

    submitForm(formData){
        return http.post(`/volunteer/submit-form`, formData)
    }

}