import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'

const app=createApp(App)
const axios=require('axios')
axios.default.baseUrl = 'http://localhost:8081'
app.mount('#app')
app.use(ElementPlus)
