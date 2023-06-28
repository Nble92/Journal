import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import style from './assets/sass/style.scss'



Vue.config.productionTip = false



// axios.defaults.baseURL = "http://localhost:8080/api/v1";
axios.defaults.baseURL = "https://3.224.247.73:8080/api/v1/";


new Vue({
  router,
  store,
  style,
  render: h => h(App)
}).$mount('#app')
