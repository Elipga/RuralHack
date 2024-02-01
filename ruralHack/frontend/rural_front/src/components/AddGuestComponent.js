import React,  { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import GuestService from '../services/GuestService';
import { Link } from 'react-router-dom';


export const AddGuestComponent = () => {

const[id, setId] = useState('');
const[firstName, setFirstName] = useState('');
const[lastName, setLastName] = useState('');
const[email, setEmail] = useState('');
const[birthDate, setBirthDate] = useState('');
const navigate = useNavigate();
const{id: routeId} = useParams();


const saveOrUpdateGuest = (e) => {
e.preventDefault();
const guest = {id, firstName, lastName, email, birthDate};
if(routeId){
GuestService.updateGuest(routeId,guest).then((response) => {
console.log(response.data);
navigate('/guests');
}).catch(error =>{
console.log(error)
})
}
else{
GuestService.createGuest(guest).then((response) => {
console.log(response.data);
navigate('/guests');
}).catch(error =>{
console.log(error)
})
}

}

useEffect(() =>{
GuestService.getGuestById(id).then((response) => {
setFirstName(response.data.firstName);
setLastName(response.data.lastName);
setEmail(response.data.email);
}).catch(error =>{
  console.log(error)
  })
},[])

const tittle = () => {
if(routeId){
return <h2 className = 'text-center'>Guest Update</h2>
}
else{
return <h2 className = 'text-center'>Guest Registration</h2>
}
}

return (
<div>
<div className='container'>
<div className = 'row'></div>
<div className = 'card col-md-6-offset-md-3 offset-md-3'>
<h2 className = 'text-center'>
{
tittle()
}
</h2>
<div className = 'card-body'>
<form>

<div className= 'form-group mb-2'>
<label className = 'form-label'>Id</label>
<input
                            type="text"
                            name="id"
                            id="id"
                            className="form-control"
                            value={id}
                            onChange={(e) => setId(e.target.value)}
                    />
</div>
<div className= 'form-group mb-2'>
<label className = 'form-label'>First Name</label>
<input
                            type="text"
                            name="firstName"
                            id="firstName"
                            className="form-control"
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                    />
</div>
<div className= 'form-group mb-2'>
<label className = 'form-label'>Last Name</label>
<input
                            type="text"
                            name="lastName"
                            id="lastName"
                            className="form-control"
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                    />
</div>

<div className= 'form-group mb-2'>
<label className = 'form-label'>Email</label>
<input
                            type="text"
                            name="email"
                            id="email"
                            className="form-control"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                    />
</div>

<div className= 'form-group mb-2'>
<label className = 'form-label'>Birth Date</label>
<input
                            type="date"
                            name="birthDate"
                            id="birthDate"
                            className="form-control"
                            value={birthDate}
                            onChange={(e) => setBirthDate(e.target.value)}
                    />
</div>
<button className = 'btn btn-success' onClick={ (e) => saveOrUpdateGuest(e) }> Save</button>
&nbsp;&nbsp;
<Link to='/guests' className= 'btn btn-danger'>Cancel</Link>
</form>
</div>
</div>

</div>
 </div>
);
};

export default AddGuestComponent;