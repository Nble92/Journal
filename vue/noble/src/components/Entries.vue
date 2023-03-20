<template>
  <div class="transparency">
    <table class="display-entries">
      <tr>
        <th class="leftest-cell">Entry
<br>
-------------

        </th>
        
        <th class="rightest-cell">Mood
          <br>
-------------
        </th>
        
      </tr>
      <!-- this allows the key to be the index of the array -->
      <tr v-for="(entry, index) in text" v-bind:key="index">
        <td class="preview">{{ entry.entry }}</td>
        <td>{{ entry.mood }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import journalService from "../services/JournalService";
export default {
  created() {
    this.populateEntries();
  },

  data() {
    return {
      // entries: [],
      entry: {
        entry: "",
        mood: "",
        meds: "",
        date: "",
      },
    };
  },
  computed: {
    text() {
      const entries = this.$store.state.entries;
      let displayedEntries = [];
      let displayedEntry = {
        entry: "",
        mood: "",
        meds: "",
        date: "",
      }

      //how the preview entries are displayed on the page.

      entries.forEach((entry) => {
        const index = entry.entry.indexOf(".");
        if (index !== -1) {
          displayedEntry = entry
          displayedEntry.entry = entry.entry.substring(0, index + 1);
          displayedEntries.unshift(displayedEntry);
        } else if (index == -1) {
          displayedEntry = entry
          displayedEntry.entry = entry.entry.substring(0, 20);
          displayedEntries.unshift(displayedEntry);
        } else {
          displayedEntry = entry
          displayedEntry.entry = entry.entry.substring(0, index);
          displayedEntries.unshift(displayedEntry);

        }

      });
      //This limits the number of entries to 5.
      displayedEntries = displayedEntries.filter((entry, index) => index <= 5);

      return displayedEntries;
    },

  },

  methods: {
    async populateEntries() {
      await journalService.getEntries().then((response) => {
        this.$store.commit("SET_ENTRIES", response.data);
      });
    },
  },
};
</script>

<style>
/* .preview {
  max-width: 50px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
} */

/* .transparency {

  background: transparent;
margin-top: 35px;
margin-left: 35%;
margin-right: auto;
} */

.display-entries {

  font-family: Helvetica, White;
}
</style>