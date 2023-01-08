<template>
  <div class="home">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <entries/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Entries from '@/components/Entries.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld,
    Entries
  }
}
</script>
