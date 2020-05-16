<template>
  <div class="quote-view">
    <QuoteLogin />
    <QuoteInput v-if="$store.state.user.name !== ''"/>
    <Quote
      v-for="(quote, index) in $store.state.quotes"
      v-bind:key="index"
      :quote="quote"
    />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import QuoteInput from "@/components/QuoteInput.vue";
import Quote from "@/components/Quote.vue";
import QuoteLogin from "@/components/QuoteLogin.vue";

@Component({
  components: {
    QuoteLogin,
    QuoteInput,
    Quote
  }
})
export default class QuoteView extends Vue {
  user = { name: "" };
  mounted() {
    this.$http.get("/examinedQuotes").then((response: any) => {
      this.$store.dispatch("loadQuotes", response.body);
    });
    this.$http.get("/user").then((response: any) => {
      this.$store.dispatch("setUser", response.body);
    });
  }
}
</script>

<style scoped lang="stylus">
</style>
