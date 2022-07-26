import axios from "axios"

class UserService
{
    url="http://localhost:8087/user/register"
    addUser(user)
    {
        return axios.post(this.url,user)

    }
}
export default new UserService()