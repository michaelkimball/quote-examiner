<template>
  <div class="quote-view">
    <QuoteInput />
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

@Component({
  components: {
    QuoteInput,
    Quote
  }
})
export default class QuoteView extends Vue {
  mounted() {
    this.$http.get("/examinedQuotes").then(response => {
      this.$store.dispatch(
        "loadQuotes",
        response.data._embedded.examinedQuotes
      );
    });
  }
}
</script>

<style scoped lang="stylus"></style>
