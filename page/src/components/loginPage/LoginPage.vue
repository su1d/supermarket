<script>
import axios from "axios";
import { ElButton,ElInput,ElRow } from 'element-plus'

export default {
  name: "Login-Page",
  components:{
     // 引入element-ui的el-input和el-button
    ElButton,ElInput,ElRow
  },
  data() {
    return {
      name: null,
      password: null
    }
  },
  methods: {
    login() {
      // 假设账号和密码为admin
      if (this.name === 'admin' && this.password === 'admin') {
        axios.post('/api/system/login', {
          username: 'admin',
          password: 'admin'
        }).then(response => {
          console.log(response);
        }).catch(error => {
          console.log(error);
          alert('登录失败')
        })
      } else {
        alert('账号或密码不正确')
      }
    }
  }
}
</script>

<template>
  <ElRow>
  账号:
  <ElInput v-model="name" placeholder="请输入你的账号"></ElInput></ElRow>
  <ElRow>
  密码:
    <ElInput type="password" v-model="password" placeholder="请输入你的密码"></ElInput></ElRow>
  <ElRow>
    <ElButton type="primary" @click="login">登录</ElButton> 
  </ElRow>
</template>

<style scoped>

</style>