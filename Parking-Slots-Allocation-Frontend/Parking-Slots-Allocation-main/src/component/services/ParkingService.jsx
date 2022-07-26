import axios from 'axios'
  class ParkingService
{

    addparkingslot(vehicleId,parkingslot)
    {
      console.log(parkingslot)
       return  axios.post("http://localhost:8087/parkingslot/bookparkingslot?vehicle_id="+vehicleId,parkingslot)
      
    }
   
}

export default new ParkingService()