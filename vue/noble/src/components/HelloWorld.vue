<template>
  <div class="hello">
    <p>
      Welcome - Express your feelings, describe your mood. Track your meds.
    </p>
    <h3>Journal</h3>
    <ul>
<input class="entry" type="text" size="50"  name="entry" id="string1" placeholder="What's on your mind?" v-model="newEntry.entry" />
<br>
<input class="mood" type="number" name="number" id="number" min="0" max="100" placeholder="Mood from 0 - 100" v-model="newEntry.mood" />
<br>
<input class="meds" type="text" name="string2" id="string2" placeholder="What meds did you take?" v-model="newEntry.meds" />

    </ul>
    <button class="btn btn-submit" v-on:click.prevent="addEntry()">
          Save
        </button>  

        <button class="btn btn-submit" v-on:click.prevent="converter()">
          convert
        </button> 
  </div>
</template>

<script>
import wFCCconvert from "../services/wFCCconverter"
import journalService from "../services/JournalService"
export default {
  name: 'HelloWorld',
  props: {
    msg: String,
    
  },
  data(){ 
    return {
      newEntry: {
        entry: "",
        mood: "",
        meds: "",
      },
      entries:[]
}
  },
   methods: {

     addEntry(){
       journalService.addEntry(this.newEntry)    
      //this adds it to the store for it to display on the page.

 this.$store.commit("ADD_ENTRIES", this.newEntry);
 
 //This is needed to clear the entry object and avoid that mirroring problem
 this.newEntry =  {
        entry: "",
        mood: "",
        meds: "",
      }
     },
     async converter(){

       wFCCconvert.converter();


     }
   }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.entry {
width: auto;
white-space: nowrap;
 overflow-y:auto;
 border: 10px;
 margin: 10px;
 padding: 10px;

}
.mood {
width: 150px;
white-space: nowrap;
 overflow-y:auto;
 border: 10px;
 margin: 10px;
 padding: 10px;

}
.meds {
width: 150px;
 border-style:dashed;
 border: 10px;
 margin: 10px;
 padding: 10px;

}
</style>
