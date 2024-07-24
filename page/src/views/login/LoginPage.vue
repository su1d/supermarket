<template>
  <div class="login-wrapper">
    <div class="login-container">
      <h2>欢迎来到洗剪吹超市</h2>
      <form @submit.prevent="submitForm">
        <label for="username">用户名</label>
        <input
            type="text"
            id="username"
            v-model="credentials.username"
            placeholder="请输入用户名"
            required
        />
        <label for="password">密码</label>
        <input
            type="password"
            id="password"
            v-model="credentials.password"
            placeholder="请输入密码"
            required
        />
        <button type="submit" class="login-button" :class="{ disabled: !canSubmit }">登录</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      credentials: {
        username: '',
        password: '',
      },
    };
  },
  computed: {
    canSubmit() {
      return this.credentials.username.trim() !== '' && this.credentials.password.trim() !== '';
    },
  },
  methods: {
    submitForm() {
      if (this.canSubmit) {
        axios.post("/system/login",{
          username: this.credentials.username,
          password: this.credentials.password,
        }).then(res=>{
          console.log(res);
        })
      }
    },
  },
};
</script>

<style scoped>
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-image: linear-gradient(to right, #6dd5ed, #2193b0);
}

.login-container {
  background: white;
  padding: 2rem;
  border-radius: 5px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 0.5rem;
  margin-top: 8px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

.login-button {
  background-color: #2193b0;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-button.disabled {
  background-color: #aaaaaa;
  cursor: default;
}

.login-button:not(.disabled):hover {
  background-color: #1a7a94;
}
</style>