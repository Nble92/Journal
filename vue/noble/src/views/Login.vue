<template>

  <div class="home">

    <body>

      <!-- <div id="bg_container">
        <iframe id="bg" src="https://www.youtube.com/embed/j4sJkuOPUP8?&autoplay=1&mute=1" frameborder="0"></iframe>
      </div> -->

      <div class="components">
        <LoginForm id="LoginForm" />

        <Modal id="modal" />

      </div>

    </body>

  </div>

</template>

<script>
// @ is an alias to /src
import Modal from '../components/Modal.vue';
import LoginForm from '../components/LoginForm.vue';

export default {
  name: 'Login',
  components: {
    Modal,
    LoginForm
},

  data() {
    return {
      showModal: false,

    };
  },
  methods: {


  }
}
</script>

<style>
#bg_container {
  height: 150%;
  overflow: hidden;
}

#bg {
  width: 150%;
  height: 900px;
  align-content: center;
  
}



.components {
  top: 8%;
  left: 15%;
  z-index: 2;
  align-items: center;
}

#entries {
  display: grid;
  justify-items: center;
}



#modal {


  z-index: 100;
  position: absolute;
  top: 8%;
  left: 15%;

}
</style>
