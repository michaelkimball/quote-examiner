<template>
  <nav class="navbar">
    <h1 class="navbar-brand">Open NLP Demo</h1>
    <div class="navbar-group" v-if="$store.state.user.name != ''">
      <a class="navbar-link" href="/swagger-ui.html">Swagger</a>
      <button class="navbar-button" v-on:click="logout">Logout</button>
    </div>
  </nav>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class QuoteNav extends Vue {
  logout() {
    const headers = {
      "X-XSRF-TOKEN": this.$cookies.get("XSRF-TOKEN")
    };
    this.$http.post("/logout", {}, { headers }).then(response => {
      console.log(response);
      this.$store.dispatch("setUser", { name: "" });
      this.$store.dispatch("loadQuotes", []);
    });
  }
}
</script>

<style scoped lang="stylus">
.navbar
  background #2d2d2d
  color #fff
  padding 8px
  margin -8px -8px 16px -8px
  display flex
  justify-content space-between

.navbar-group
  display flex

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

.navbar-button
  width 10%
  min-width: 5rem;
  font-size 1rem
  background #008288
  border none
  color #fff
  line-height 1.2rem
  border-radius 4px

.navbar-button:hover
  font-size 1.1rem
  cursor pointer
  background #00ADB5
</style>
