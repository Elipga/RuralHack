import React, { useEffect, useState } from 'react';
import GuestService from './GuestService.js';
import axios from 'axios';



export const ListGuestsComponent = () => {

  const [guests, setGuests] = useState([])

  useEffect(() =>{
  GuestService.getAllGuests().then(response => {
  setGuests(response.data);
  console.log(response.data);
  }).catch(error =>{
  console.log(error);
  })
  },[])

  return (
    <div className = 'container'>
    <h2 className = 'text-center'> Guests list </h2>
    <table className = 'table table-bordered table-striped'>
    <thead>
        <th>Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Birthdate</th>
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
        </tr>
      ))
    }
    </tbody>

    </table>
     ListGuestsComponent </div>
  );
};

export default ListGuestsComponent;