import axios from "axios"

export default {

addEntry(newEntry){

    return axios.post('/journal', newEntry)
  },

getEntries(){

return axios.get('/journal')

}
    
}