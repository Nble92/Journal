<template>
  <div class="hello">

    <h1>LO.FI</h1>
    <p>
      Express your feelings, describe your mood. Track your meds.
    </p>
    <ul>
      <label for="entry">What's on your mind?</label>
      <br>
      <textarea class="entry" name="textTest" id="" cols="30" rows="4" v-model="newEntry.entry"></textarea>

      <!-- <input class="entry" type="text" name="entry" size="25" id="string1" 
        v-model="newEntry.entry"/> -->
      <br>
      <label for="mood">Mood from 1 - 100</label>
      <br>
      <input class="mood" type="number" name="mood" id="number" min="0" max="100" v-model="newEntry.mood" />
      <br>
      <label for="med">What meds did you take?</label>
      <br>
      <input class="meds" type="text" name="meds" size="25" id="string2" v-model="newEntry.meds" />

    </ul>
    <button class="btn btn-submit" v-on:click="addEntry(soundFile)">
      <img class="underbutton" src="https://art.pixilart.com/1ed3967e592552f.gif" alt="Submit">

    </button>
    <br>
    <!-- <button class="btn btn-submit"  v-on:click="logout()">
      LOGOUT
    </button> -->
    ____________________________________


  </div>
</template>

<script>
import journalService from "../services/JournalService"
export default {

  data() {
    return {
      show: false,
      newEntry: {
        entry: "",
        mood: "0",
        meds: ""
      },
      entries: []
    }
  },
  computed: {
    soundFile() {
      return require('../assets/sounds/Final Fantasy VII Sound Effects - Save and Load.mp3')
    },
    // lofi(){
    //   return require('https://www.youtube.com/watch?v=j4sJkuOPUP8')
    // }
  },
  methods: {
    async addEntry(sound) {
      if (this.newEntry.entry != "" && this.newEntry.mood != 0 && this.newEntry.mood <= 100) {
        journalService
          .addEntry(this.newEntry)
          .then((response) => {
            alert(response.status)
            if (response.status === 200) {

              this.playSound(sound)

              this.$store.commit("SHOW_MODAL")
              this.$store.commit("ADD_ENTRIES", this.newEntry);

              this.newEntry = {
                entry: "",
                mood: "",
                meds: "",
              }
            }
            else if (response.status === 401) {
              this.logout()

            }

            else {

              alert("Write your thoughts in your entry and set your mood from 1 - 100.")
            }


          }
          )
      }
    },


    //this adds it to the store for it to display on the page.


    //This is needed to clear the entry object and avoid that mirroring problem



    playSound(sound) {
      console.log(sound)
      let audio = new Audio(sound)
      // let audio = new Audio(this.soundFile);

      audio.play()

    },

    logout() {

      this.$store.commit("LOGOUT")
      this.$router.push("/login");

    }


  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {

  background: transparent;
}


#p {


  font-size: large;


}

.entry {
  border-style: dashed;
  margin: 10px;
  padding: 10px;
  background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
  background-size: 120% 170%;
  background-repeat: no-repeat;
  background-position: center;
  resize: none;
  height: auto;
}



.underbutton {

  height: 40px;
}

button {

  border: 0ch;

}

/* input.mood{

text-align: center;

} */

.mood {
  border-style: dashed;
  background-size: auto auto;
  white-space: nowrap;
  overflow-y: auto;
  margin: 10px;
  size: 50px;
  padding: 010px 50px;
  background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
  background-repeat: no-repeat;
  background-position: center;
}

.meds {
  border-style: dashed;
  size: 40px;
  margin: 10px;
  padding: 10px;
  background-image: url(https://pixelartmaker-data-78746291193.nyc3.digitaloceanspaces.com/image/d2042f0d1983300.png);
  background-size: auto auto;
  background-repeat: no-repeat;
  background-position: center;
}

.modal-container {
  /* this is the box */
  width: 300px;
  margin: auto;
  padding: 20px 30px;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  background-image: url(https://i.imgur.com/zVHEwQd.gif);
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
}
.hello {

  background: transparent;
}
</style>
