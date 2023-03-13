import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = ""

"JSON.parse(localStorage.getItem('user'))"


// if(currentToken != null) {
//   axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
// }
export default new Vuex.Store({
  state: {
    entries: [],
    entry: {
      entry: '',
      mood: '',
      meds: '',
      date: ''
    },
    showModal:false,      
    token: currentToken || '',
    user: currentUser || {},
  },
  mutations: {
    SET_ENTRIES(state, data) {
      state.entries = data;
    }, 
    ADD_ENTRIES(state, data) {
      state.entries.push(data);
    },

    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },

    SHOW_MODAL(state){

      state.showModal = !state.showModal
    },
    SET_AUTH_TOKEN(state, data) {
      state.token = data; 
      localStorage.setItem('token', state.token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${state.token}`
      // axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded';

    }
  },
  actions: {
  },
  modules: {
  }
}

)


