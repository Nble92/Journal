import axios from "axios"


export default {

  async login(user) {
      return await axios.post('/login', user);
    
  },
  //IF YOU INPUT THE WRONG URL, CHROME WILL GIVE YOU A CORS INSTEAD OF A 404!!!!
   async register(user) {
      return await axios.post('/user/registration', user)
    },
}