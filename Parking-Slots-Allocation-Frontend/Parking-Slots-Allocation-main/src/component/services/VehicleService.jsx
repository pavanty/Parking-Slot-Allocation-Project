import axios from 'axios'
export class VehicleService {
    url="http://localhost:8087/vehicle/addvehicle"
    addVehicle(vehicle)
    {
        return axios.post(this.url,vehicle)
    }
   
}
export default new VehicleService()