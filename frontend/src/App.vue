<template>
  <div id="app">
    <nav class="navbar">
      <a class="navbar-brand">Open NLP Demo</a>
      <a class="navbar-link" href="/swagger-ui.html">Swagger</a>
    </nav>
    <router-view />
  </div>
</template>

<style lang="stylus">
.navbar
  background #2d2d2d
  color #fff
  padding 8px
  margin -8px -8px 16px -8px
  display flex
  justify-content space-between

.navbar-brand
  margin 16px
  font-size 1.5em

.navbar-link
  margin 4px
  padding 16px
  text-decoration none
  border-radius 40%
  background #008288
  color #fff
.navbar-link:hover
  background #00ADB5

#app
  font-family Avenir, Helvetica, Arial, sans-serif
  -webkit-font-smoothing antialiased
  -moz-osx-font-smoothing grayscale
  text-align center
  color #2c3e50
</style>
