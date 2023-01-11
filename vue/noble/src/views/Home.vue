<template>
    
  <div class="home">
    <img src="https://media2.giphy.com/media/S0DbjCzN7un1Z9Ku7p/giphy.gif?cid=ecf05e4794vxqp2p1f731hwnrbr8jv0nbp46mnjusghf4fne&rid=giphy.gif&ct=g"  style="width: 300px; height: 200px; object-fit: cover;" alt="">
    <QuickForm msg="Welcome to Your Vue.js App"/>
    <entries/>
  </div>

</template>

<script>
// @ is an alias to /src
import QuickForm from '@/components/QuickForm.vue'
import Entries from '@/components/Entries.vue'

export default {
  name: 'Home',
  components: {
    QuickForm,
    Entries,
  }
}
</script>

<style>
.home {
background-image: url("https://i.imgur.com/lLfM33a.gif");
background-repeat: no-repeat;
background-position: center;
background-size: cover;
height: 100%;
overflow: hidden;

}



</style>
