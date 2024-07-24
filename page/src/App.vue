<template>
  <nav>
    <login-page></login-page>
  </nav>
  <router-view/>
</template>

<script>
import loginPage from '@/views/login/LoginPage.vue'
export default {
  name: 'App',
  components: {
    loginPage
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
