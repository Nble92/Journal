import axios from "axios"

export default {

  addEntry(newEntry){
    return axios.post('/journal', newEntry, {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json'
        }
    })
  },

getEntries(){

return axios.get('/journal', {
  headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json'
  }
})

}
    
}