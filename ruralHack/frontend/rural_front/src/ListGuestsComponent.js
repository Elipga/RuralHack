import React, { useEffect, useState } from 'react';
import GuestService from './GuestService.js';
import axios from 'axios';
import { Link } from 'react-router-dom';


export const ListGuestsComponent = () => {

  const [guests, setGuests] = useState([])

  useEffect(() =>{
  getGuests()
  },[])

  const getGuests = () =>{
  GuestService.getAllGuests().then(response => {
    setGuests(response.data);
    console.log(response.data);
    }).catch(error =>{
    console.log(error);
    })
  }


  const deleteGuest = (guestId) => {
  GuestService.deleteGuest(guestId).then(response => {
  getGuests();
  }).catch(error =>{
  console.log(error);
  })
  }

  return (
    <div className = 'container'>
    <h2 className = 'text-center'> Guests list </h2>
    <Link to='/add-guest' className='btn btn-primary mb-2'>Add guest</Link>
    <table className = 'table table-bordered table-striped'>
    <thead>
        <th>Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Birthdate</th>
        <th>Actions</th>

    </thead>
    <tbody>
    {
      guests.map(guest => (
        <tr key={guest.id}>
          <td>{guest.id}</td>
          <td>{guest.firstName}</td>
          <td>{guest.lastName}</td>
          <td>{guest.email}</td>
          <td>{guest.birthDate}</td>
          <td>
          <Link className='btn btn-info' to={`/edit-guest/${guest.id}`}>Update</Link>
          <button style={{marginLeft: "10px"}} className = 'btn btn-danger' onClick = {() => deleteGuest(guest.id)}>Delete</button>
          </td>
        </tr>
      ))
    }
    </tbody>

    </table>
     ListGuestsComponent </div>
  );
};

export default ListGuestsComponent;