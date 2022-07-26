import axios from "axios"

class AdminService
{
    url="http://localhost:8087/admin/add"
    saveParkingPremise(admin)
    {
        return axios.post(this.url,admin)

    }
}
export default new AdminService()