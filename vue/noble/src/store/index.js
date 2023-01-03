import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    entries: [],
    entry: {
      entry: '',
      mood: '',
      date: ''
    },
  },
  mutations: {
    SET_ENTRIES(state, data) {
      state.entries = data;
    }, 
    ADD_ENTRIES(state, data) {
      state.entries.push(data);
    },


  },
  actions: {
  },
  modules: {
  }
})
