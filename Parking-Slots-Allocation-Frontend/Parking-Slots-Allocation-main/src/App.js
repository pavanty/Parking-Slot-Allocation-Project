import {
  BrowserRouter as Router,
  Routes,
  Route,

} from 'react-router-dom';

import Menu from "./component/Loginuserinfo";
import MenuA from "./component/Admindashboardinfo";

import Home from "./component/Home";
import { BookParkingSlot } from "./component/BookParkingSlot";
import { GetSlotById } from "./component/GetSlotById";
import { DisplayAllParkingSlots } from "./component/DisplayAllParkingSlots";
import { CancelSlot } from "./component/CancelSlot";
import {User} from "./component/User";
import {Login} from "./component/Login";
import {AddPayment} from "./component/AddPayment";
import {ViewAllPayment} from "./component/ViewAllPayment";
// import {AddVehicle} from "./component/AddVehicle";
import { ViewAllVehicle } from "./component/ViewAllVehicle";
import { ViewVehicleByVehicleNumber } from "./component/ViewVehicleByVehicleNumber";
import Admin from "./component/Admin";
import { Login1 } from "./component/Login1";
import {RetrivePassword} from "./component/RetrivePassword";
import { AddPremise } from "./component/AddPremise";
import {GetPremiseById} from "./component/GetPremiseById";
import {DisplayAllPremise} from "./component/DisplayAllPremise";
import {DeletePremise} from "./component/DeletePremise";
import AddVehicle  from "./component/AddVehicle";
import UpdateVehicle from './component/UpdateVehicle';
import {DeleteVehicleByVehicleNumber} from "./component/DeleteVehicleByVehicleNumber";
import { GetVehicleById } from "./component/GetVehicleById";
import UpdateVehicleById from "./component/UpdateVehicleById";
import {AllUsers} from "./component/AllUsers";
import {ViewUser} from "./component/ViewUser";

function App(){
  return(
    <div>
        <Router>
        <Routes>
       
      {/* <Menu1/> */}
      <Route exact path="/" element={<Home/>}/>
      <Route exact path="/Book-Parking-Slot"element={<BookParkingSlot/>}/>
      <Route exact path="/Cancel-slot" element={<CancelSlot/>}/>
      <Route exact path="/Get-Slot-By-Id" element={<GetSlotById/>}/>
      <Route exact path="/Display-All-Parking-Slots" element={<DisplayAllParkingSlots/>}/>
      <Route exact path="/user" element={<User/>}/>
      <Route exact path="/login" element={<Login/>}/>
      <Route exact path="/addPayment" element={<AddPayment/>}/>
      <Route exact path="/viewAllPayment" element={<ViewAllPayment/>}/>
      <Route exact path="/addVehicle" element={<AddVehicle/>}/>
      <Route exact path="/viewAllVehicle"element={<ViewAllVehicle/>}/>
      <Route exact path="/viewVehicleByVehicleNumber"element={<ViewVehicleByVehicleNumber/>}/>
      <Route exact path="/admin" element={<Admin/>}/>
      <Route exact path="/login1" element={<Login1/>}/>
      <Route exact path="/menuA" element={<MenuA/>}/>
      <Route exact path="/menu" element={<Menu/>}/>
      <Route exact path="/retrive" element={<RetrivePassword/>}/>
      <Route exact path="/addPremise" element={<AddPremise/>}/>
      <Route exact path="/getPremiseById" element={<GetPremiseById/>}/>
      <Route exact path="/displayAllPremise" element={<DisplayAllPremise/>}/>
      <Route exact path="/deletePremise" element={<DeletePremise/>}/>
      <Route exact path="/deleteVehicleByVehicleNumber" element={<DeleteVehicleByVehicleNumber/>}/>
      <Route exact path="/updateVehicle/:id" element={<UpdateVehicle/>}/>
      <Route exact path="/viewvehiclebyid" element={<GetVehicleById/>}/>
      <Route exact path="/updateVehiclebyid" element={<UpdateVehicleById/>}/>
      <Route exact path="/allusers" element={<AllUsers/>}/>
      <Route exact path="/viewuser" element={<ViewUser/>}/>
      
      </Routes>
      </Router> 
    </div>
  );
}

export default App;