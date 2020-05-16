<template>
  <div class="login" v-if="$store.state.user.name === ''">
    Login with
    <a class="oauth" href="/oauth2/authorization/github">
      <font-awesome-icon :icon="['fab', 'github']" />
      Github
    </a>
    or
    <a class="oauth" href="/oauth2/authorization/google">
      <font-awesome-icon :icon="['fab', 'google']" />
      Google
    </a>
  </div>
  <div class="user" v-else>
    Logged in as: <span class="username">{{ $store.state.user.name }}</span>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class QuoteLogin extends Vue {}
</script>

<style scoped lang="stylus">
.login
    margin-top 2em
.oauth
    margin 4px
    padding 16px
    text-decoration none
    border-radius 4px
    background #008288
    color #fff
.oauth:hover
    background #00ADB5
</style>
