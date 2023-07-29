import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/admin/Login'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import Home from '../components/Home'

Vue.use(Router)
Vue.use(ElementUI)
Vue.prototype.axios = axios

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
