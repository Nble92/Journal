<template>
    <div class="hello">
      <h1>LO.FI</h1>
      <p>
  Register
      </p>
      <ul>
        <label for="DisplayName">DisplayName</label>
        <br>
        <input class="DisplayName" name="Display Name" v-model="user.displayName" />
        <br>
        <label for="EmailAddress">Email</label>
        <br>
        <input class="EmailAddress" name="Email Address" v-model="user.emailAddress" />
        <br>
        <label for="EmailAddress">Confirm Email</label>
        <br>
        <input class="EmailAddress" name="Email Address" v-model="user.confirmEmail" />
        <br>
        <label for="password">Password</label>
        <br>
        <input type="password" class="password" name="password" v-model="user.password" />
        <br>
        <label for="password">Confirm Password</label>
        <br>
        <input type="password" class="password" name="password" v-model="user.confirmPassword" />
  
      </ul>
      <button class="btn btn-submit" v-on:click="register()">
        <img class="underbutton" src="https://art.pixilart.com/1ed3967e592552f.gif" alt="">
  
  
      </button>
      <br>
      ____________________________________
  
  
    </div>
  </template>
    
  <script>
  import UserService from "../services/UserService"
  export default {
  
    data() {
      return {
        show: false,
        user: {
          displayName: "",
          emailAddress: "",
          confirmEmail:"",
          password: "",
          confirmPassword: "",
        
        },
        invalidCredentials: false
      }
    },
    computed: {
      soundFile() {
        return require('../assets/sounds/Final Fantasy VII Sound Effects - Save and Load.mp3')
      },
  
    },
    methods: {
      async register() {
localStorage.removeItem("token")
 UserService.register(this.user)
 .then(response => {
   if (response.status == 200) {
     console.log(response)
alert("Registered!")
     this.$router.push("/login");
   }
 }
 ).catch(error => {
   const response = error.response;

   if (response.status === 401) {
     this.invalidCredentials = true;
   }
 });

}
  
      }
    
  
  }
  </script>
    
    <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  * {
  
    background: transparent;
  }
  
  
  #p {
  
  
    font-size: large;
  
  
  }
  
  .EmailAddress {
    border-style: dashed;
    margin: 10px;
    padding: 10px;
    background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
    background-size: 120% 170%;
    background-repeat: no-repeat;
    background-position: center;
    resize: none;
    height: auto;
  }
  
  
  
  .underbutton {
  
    height: 40px;
  }
  
  button {
  
    border: 0ch;
  
  }
  
  /* input.mood{
    
    text-align: center;
    
    } */
  
  .password {
    border-style: dashed;
    background-size: auto auto;
    white-space: nowrap;
    overflow-y: auto;
    margin: 10px;
    size: 50px;
    padding: 010px 50px;
    background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
    background-repeat: no-repeat;
    background-position: center;
  }
  
  .meds {
    border-style: dashed;
    size: 40px;
    margin: 10px;
    padding: 10px;
    background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
    background-size: auto auto;
    background-repeat: no-repeat;
    background-position: center;
  }
  
  .hello {
  
    background: transparent;
  }
  </style>
    