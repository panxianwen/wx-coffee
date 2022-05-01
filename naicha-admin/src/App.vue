<template>
  <div id="app">
    <OrderMessage style="position: fixed; z-index: 1000"></OrderMessage>
    <router-view/>
  </div>
</template>

<script>
  import OrderMessage from "./components/app/OrderMessage"

    export default {
        name: 'App',
        components: {OrderMessage}
    }
</script>

<style>
  * {
    margin: 0;
    padding: 0;
  }

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin: 0 auto;
    height: 100vh;
  }

  a {
    text-decoration: none;
    color: #000;
  }
</style>
