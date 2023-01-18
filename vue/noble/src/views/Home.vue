<template>

  <div class="home">


    <div class="components">
      <QuickForm id="QuickForm" />

      <entries id="entries" />
      <Modal id="modal"/>

    </div>
  </div>

</template>

<script>
// @ is an alias to /src
import QuickForm from '@/components/QuickForm.vue'
import Entries from '@/components/Entries.vue'
import Modal from '../components/Modal.vue';

export default {
  name: 'Home',
  components: {
    QuickForm,
    Entries,
    Modal,
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
.components {
  display: inline-block;
  top: 8%;
  left: 15%;
  z-index: 2;
  align-items: center;
}

#entries {
  display: grid;
  justify-items: center;
}



#modal{


z-index: 100;
position: absolute;
top: 8%;
left: 15%;

}
</style>
