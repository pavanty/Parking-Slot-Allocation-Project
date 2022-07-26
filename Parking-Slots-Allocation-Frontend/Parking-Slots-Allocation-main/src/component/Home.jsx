import React from 'react'
import Menu1 from "../component/Menu1";
import parkslot from "../assets/images/parkslot.jpg"

export default function Home(){
    return(
        <div className="container">
            <Menu1/>
            <center>
                <br></br><h2 className="text-info">Welcome To Parking Slot Application
            </h2>
            <br></br>
            <div>
            <img src={parkslot} alt="" />
            </div>
            </center>
            <hr/>
            
        </div>
    )
}