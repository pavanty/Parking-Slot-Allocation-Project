import React from 'react'
import { Link } from 'react-router-dom'
const navbar={
  margin:"0px",
  

}
export default function Menu1() {
    return(
        <div>
            <nav style={navbar}class="navbar navbar-expand-lg navbar-Dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Parking Slot Application</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav ">
        <li class="nav-item">
          <Link class="nav-link active" aria-current="page" to="">Home</Link>
          {/* <Link class="nav-link active" aria-current="page" to="/user">User</Link>
          <Link class="nav-link active" aria-current="page" to="/admin">Admin</Link> */}
          
        </li>
        <li class="nav-item">
        <Link class="nav-link active" aria-current="page" to="/user">User Registration</Link>
        </li>

        <li class="nav-item">
        <Link class="nav-link active" aria-current="page" to="/admin">Admin Registration</Link>
</li>
<li class="nav-item">
<Link class="nav-link" to="/login1">Admin Login</Link>
</li>


        <li class="nav-item">
          <Link class="nav-link" to="/login">User Login</Link>
          {/* <Link class="nav-link" to="/login1">Login1</Link> */}
        </li>
       
        {/* <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ParkingSlot
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><Link class="dropdown-item" to="Book-Parking-Slot">BookParkingSlot</Link></li>
            <li><Link class="dropdown-item" to="Get-Slot-By-Id">GetSlotById</Link></li>
            <li><Link class="dropdown-item" to="Display-All-Parking-Slots">DisplayAllParkingSlots</Link></li>
            <li><Link class="dropdown-item" to="Cancel-Slot">CancelSlot</Link></li>
          </ul>
        </li>
       
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#AddPayment" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            payment     </a>
        
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <li><Link class="dropdown-item" to="/addPayment">add Payment</Link></li>
          <li><Link class="dropdown-item" to="/viewAllPayment">view All Payment</Link></li>
            </ul>
          </li>

          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#AddVehicle" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            vehicle     </a>
        
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <li><Link class="dropdown-item" to="/addVehicle">add Vehicle</Link></li>
          <li><Link class="dropdown-item" to="/viewAllVehicle">view All Vehicle</Link></li>
          <li><Link class="dropdown-item" to="/viewVehicleByVehicleNumber">view Vehicle By Vehicle Number</Link></li>
         </ul>
         </li> */}
         


      </ul>
      
    </div>
  
  </div>
</nav>

        </div>
    )
}