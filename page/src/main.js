import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from './router'

const app=createApp(App).use(router).use(ElementPlus)
const axios=require('axios')
axios.default.baseUrl = 'http://localhost:8081'
app.mount('#app')
