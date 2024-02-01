import logo from './logo.svg';
import './App.css';
import ListGuestsComponent from './components/ListGuestsComponent.js';
import HeaderComponent from './components/HeaderComponent.js';
import AddGuestComponent from './components/AddGuestComponent.js';

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
