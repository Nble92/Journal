import axios from "axios"



export default {
  

  addEntry(newEntry){
    return axios.post('/journal', newEntry, {
     
        // headers: {
        //     'Access-Control-Allow-Origin': '*',
        //     'Content-Type': 'application/json',
        //     Authorization: "Bearer " + token
        // }
        
    })
  },

getEntries(){

return axios.get('/journal')

},

getEntry(){

  return axios.get('/journal/id')
  
  }
    
}