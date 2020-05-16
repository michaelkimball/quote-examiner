<template>
  <div id="app">
    <QuoteNav />
    <router-view />
  </div>
</template>

<style lang="stylus">
#app
  font-family Avenir, Helvetica, Arial, sans-serif
  -webkit-font-smoothing antialiased
  -moz-osx-font-smoothing grayscale
  text-align center
  color #2c3e50
</style>
<script>
import { Component, Vue } from "vue-property-decorator";
import QuoteNav from "@/components/QuoteNav";
@Component({
  components: { QuoteNav }
})
export default class App extends Vue {}
</script>
