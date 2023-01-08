<template>
  <table class="display-entries">
    <tr>
      <th class="leftest-cell">Entry</th>
      <th class="rightest-cell">Mood</th>
    </tr>
    <!-- this allows the key to be the index of the array -->
    <tr v-for="(entry, index) in text" v-bind:key="index">
      <td class="preview">{{ entry.entry }}</td>
      <td>{{ entry.mood }}</td>
    </tr>
  </table>
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

      entries.forEach((entry) => {
        const index = entry.entry.indexOf(".");
        if (index !== -1) {
          displayedEntry.entry = entry.entry.substring(0, index + 1);
                  displayedEntries.push(displayedEntry);
        } else if (index == -1) {
          displayedEntry.entry = entry.entry.substring(0, 20);
                  displayedEntries.push(displayedEntry);
        } else {
          displayedEntry.entry = entry.entry.substring(0, index);
                  displayedEntries.push(displayedEntry);

        }
      });
      return displayedEntries;
    },
  },

  methods: {
    async populateEntries() {
      journalService.getEntries().then((response) => {
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
</style>