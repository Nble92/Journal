<template>
  <div class="hello">
    <p>
      Welcome - Express your feelings, describe your mood. Track your meds.
    </p>
    <h3>Journal</h3>
    <ul>
<input class="entry" type="text" size="60"  name="entry" id="string1" placeholder="What's on your mind?" v-model="newEntry.entry" 
/>

<br>
<input class="mood" type="number" name="number" id="number" min="0" max="100" placeholder="Mood from 0 - 100" v-model="newEntry.mood" />
<br>
<input class="meds" type="text" name="string2" id="string2" placeholder="What meds did you take?" v-model="newEntry.meds" />

    </ul>
    <button class="btn btn-submit" v-on:click.prevent="addEntry()">
      <img class="underbutton" src="https://art.pixilart.com/1ed3967e592552f.gif" alt="">
          
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

*{

  background: transparent;
}


#p {


font-size: large;


}

.entry {
width: 250px;
 border: 10px;
 margin: 10px;
 padding: 10px;
background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
background-size: contain;
background-repeat: no-repeat;
background-position: center;
height: 30px;
}



.underbutton{

height: 40px;
}

button {

border: 0ch;

}

.mood {
width: 150px;
white-space: nowrap;
 overflow-y:auto;
 border: 10px;
 margin: 10px;
 padding: 10px;
 background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
background-size: contain;
background-repeat: no-repeat;
background-position: center;
}

.meds {
width: 150px;
 border-style:dashed;
 border: 10px;
 margin: 10px;
 padding: 10px;
background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
background-size: contain;
background-repeat: no-repeat;
background-position: center;
}

.hello {

  background: transparent;
}
</style>
