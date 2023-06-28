<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">

            <div class="modal-container">

                <div class="modal-body">
                    <!-- this is the text body in the modal box -->
                    

                </div>
                <slot name="footer">
                <button class="modal-default-button" @click="$emit('close')">OK</button>
            </slot>
            </div>
            </div>

    </Transition>

</template>

<script>

export default {
    props: {
        show: Boolean
    }
}
</script>

<style>

.modal-mask{
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
  height: 250px;
  margin: auto;
  padding: 20px 30px;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}


.modal-body {
  margin: 20px 0;
}


.modal-default-button {
display: inline;
margin-right: 120px;
margin-top: 120px;
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