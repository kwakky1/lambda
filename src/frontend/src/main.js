import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router/'
import {store} from './store'
import vuex from 'vuex'
import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$http = axios
new Vue({
  vuetify,
  router,
  store,
  vuex,
  axios,
  render: h => h(App)
}).$mount('#app')
