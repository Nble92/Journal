<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">

            <div class="modal-container">

                <div class="modal-body">
                    <!-- this is the text body in the modal box -->
                    <slot name="body">I am a weenee</slot>
                </div>
                <button class="modal-default-button" @click="$emit('close')">OK</button>

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

</style>