<template>
  <div id="app">
    <body>
  <div class="blur" style="background-image: url('https://i.imgur.com/lLfM33a.gif');">
    <button id="show-modal" @click="showModal = true">Show Modal</button>

<Teleport to="body">
  <!-- use the modal component, pass in the prop -->
  <modal :show="showModal" @close="showModal = false">
    <template #header>
      <h3>custom header</h3>
    </template>
  </modal>
</Teleport>
  
  </div> 
</body>
  
    <router-view/>
  </div>



</template>
<script>
import Modal from './components/Modal.vue';
export default {
  name: 'App',
components: {
    Modal,
  },
  data() {
    return {
      showModal:false,

    };
  

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
  background-size:cover;
  background-blend-mode: darken;
  background-attachment: fixed;

}

</style>
