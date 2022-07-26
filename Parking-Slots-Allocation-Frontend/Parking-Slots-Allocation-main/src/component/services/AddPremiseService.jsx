import axios from 'axios'
  class AddPremiseService
{

    addpremise(premise)
    {
      console.log(premise)
       return  axios.post("http://localhost:8087/admin/addPremise",premise)
      
    }
   
}

export default new AddPremiseService()