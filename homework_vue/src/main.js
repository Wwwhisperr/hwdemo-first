import Vue from 'vue'
import App from './App.vue'
import router from "./router.js";//拿到路由器
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import axios from "axios";

Vue.prototype.$axios=axios
Vue.config.productionTip = false
Vue.use(Antd);

new Vue({
  router:router,
  render: h => h(App),
}).$mount('#app')
