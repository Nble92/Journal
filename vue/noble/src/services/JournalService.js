import axios from "axios"

export default {

  addEntry(newEntry){
    return axios.post('/journal', newEntry, {
      auth: {
        username:'noble',
        password:'Spartan117'
        
        
                },
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json'
        }
        
    })
  },

getEntries(){

return axios.get('/journal', {
  auth: {
    username:'noble',
    password:'Spartan117'
    
    
            },
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
    }
    
})

}
    
}