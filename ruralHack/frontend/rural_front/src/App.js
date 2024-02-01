import logo from './logo.svg';
import './App.css';
import ListGuestsComponent from './ListGuestsComponent.js';
import HeaderComponent from './HeaderComponent.js';
import FooterComponent from './FooterComponent.js';
import AddGuestComponent from './AddGuestComponent.js';

import { BrowserRouter, Routes, Route } from 'react-router-dom';


function App() {
  return (
    <div>
    <BrowserRouter>
     <HeaderComponent/>
     <div className = 'container'>
     <Routes>
     <Route exact path = '/' element ={<ListGuestsComponent/>}></Route>
     <Route exact path = '/guests' element ={<ListGuestsComponent/>}></Route>
     <Route exact path = '/add-guest' element ={<AddGuestComponent/>}></Route>
     <Route exact path = '/edit-guest/:id' element ={<AddGuestComponent/>}></Route>
     </Routes>
     </div>
    </BrowserRouter>
    </div>
  );
}

export default App;
