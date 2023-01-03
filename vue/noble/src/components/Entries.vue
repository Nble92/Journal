<template>
  <table class="display-entries">
    <tr>
      <th class="leftest-cell">Entry</th>
      <th class="rightest-cell">Mood</th>
    </tr>
    <tr v-for="(entry,index) in this.$store.state.entries" v-bind:key="index">
      <td>{{ entry.entry }}</td>
      <td>{{ entry.mood }}</td>
    </tr>
  </table>
</template>

<script>
import journalService from "../services/JournalService";
export default {
  created() {
  this.populateEntries()

},



  data() {
    return {
      entries: "",
      entry: {
        entry: "",
        mood: "",
        meds: "",
        date: "",
      },
    }
  },
  methods: {

    async populateEntries() {
    journalService.getEntries().then(response =>{
    this.$store.commit("SET_ENTRIES", response.data)    })
  
}
  }
}
</script>

<style>
</style>