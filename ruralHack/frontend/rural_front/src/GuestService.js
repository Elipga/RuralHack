import axios from 'axios';


const GUEST_BASE_REST_API_URL="http://localhost:8080/guests";

class GuestService{

getAllGuests(){
return axios.get(GUEST_BASE_REST_API_URL);
}
}

export default new GuestService;