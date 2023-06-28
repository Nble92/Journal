<template>
    <div>
<input type="number" v-bind="id"/>
<button @click="getEntry"></button>
      <!-- this allows the key to be the index of the array -->
      <tr v-for="(entry, index) in text" v-bind:key="index">
        <td class="preview" @click="showMod">{{ entry.entry }}</td>
        <td>{{ entry.mood }}</td>
      </tr>
</div>
</template>

<script>
import JournalService from '../services/JournalService';
 export default {
data(){
    return{
id:"",
entry: {
        entry: "",
        mood: "",
        meds: "",
        date: "",
      },

}
},
computed: {

    currentEntry(){


        return JournalService.getEntry(this.id)
    }


},

methods:{

    getEntry(){

        JournalService.getEntry(this.id)

    }

}


}

</script>

<style lang="scss" scoped>

</style>