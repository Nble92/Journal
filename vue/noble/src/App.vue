<template>
  <div id="app">
    <title>Lo.Fi</title>
    <nav>
      <button class="btn btn-submit" v-show="loggIN" v-on:click="logout()">
        [LOGOUT]
      </button>
    </nav>

    <body>

      <Teleport to="body">
        <!-- use the modal component, pass in the prop -->
        <modal :show="showModal" @close="flipModal()">
          <template #header>
            <h3>custom header</h3>
          </template>
        </modal>
      </Teleport>



      <iframe width="320" height="240" controls src="https://www.youtube.com/embed/hi1cYzaLEig"></iframe>



    </body>

    <router-view />
  </div>
</template>
<script>
import Modal from './components/Modal.vue';

export default {
  name: 'App',
  components: {
    Modal,
  },

  computed: {

    showModal() {

      return this.$store.state.showModal
    },
    loggIN() {

      return this.$store.state.loggedIn
    }

  },
  methods: {
    flipModal() {

      this.$store.commit("SHOW_MODAL")

    },
    logout() {

      this.$store.commit("LOGOUT")
      this.$router.push("/login");


    }



  }

}
</script>
<style >
* {
  font-family: '8-bit-hud';
  color: tan;
  text-align: center;
}


body {
  background-image: url('https://i.imgur.com/lLfM33a.gif');
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  background-blend-mode: darken;
  background-attachment: fixed;

}

.modal-mask {
  /* this is the background covering for when the box appears */
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  transition: opacity 0.3s ease;

}

.modal-container {
  /* this is the box */
  width: 300px;
  margin: auto;
  padding: 20px 30px;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  background-image: url(https://i.imgur.com/zVHEwQd.gif);
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
}


.modal-body {
  margin: 20px 0;
}


.modal-default-button {
  float: right;
}

.modal-enter-from {
  opacity: 0;
}

.modal-leave-to {
  /* this is a transition setting */
  opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
  /* this is a transition setting 
        that resizes the image upon showing 
        and hiding */
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
