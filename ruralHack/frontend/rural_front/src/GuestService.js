import axios from 'axios';


const GUEST_BASE_REST_API_URL="http://localhost:8080/guests";

class GuestService{

getAllGuests(){
return axios.get(GUEST_BASE_REST_API_URL);
}

createGuest(guest){
return axios.post(GUEST_BASE_REST_API_URL, guest);
}

getGuestById(guestId){
return axios.get(GUEST_BASE_REST_API_URL, + '/' + guestId);
}

updateGuest(guestId, guest){
return axios.put(GUEST_BASE_REST_API_URL + '/' + guestId, guest);
}

deleteGuest(guestId){
return axios.delete(GUEST_BASE_REST_API_URL + '/' + guestId);
}


}

export default new GuestService;