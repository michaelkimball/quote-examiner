<template>
  <div class="quote-input">
    <form class="new-quote-form" v-on:submit.prevent="onFormSubmit">
      <div class="quote-input-control">
        <label for="quoteTextarea">New Quote</label>
        <div class="quoteTextOutline">
          <textarea
            v-model="newQuote"
            id="quoteTextarea"
            name="quoteTextarea"
            rows="3"
            placeholder="To be or not to be..."
          ></textarea>
        </div>
      </div>
      <div class="quote-submit">
        <button type="submit" class="quote-submit-button">Add</button>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class QuoteInput extends Vue {
  newQuote = "";
  onFormSubmit() {
    this.$http
      .post("/nlp", { paragraph: this.newQuote })
      .then(() => this.$http.get("/examinedQuotes"))
      .then(
        response => {
          this.$store.dispatch(
            "loadQuotes",
            response.data._embedded.examinedQuotes
          );
          this.newQuote = "";
        },
        error => console.error(error)
      );
  }
}
</script>

<style scoped lang="stylus">
label
  font-family: 'Cormorant Garamond', serif;
.quote-input
  font-family 'Khula', sans-serif
  font-weight 700
  font-size 2em
  display flex
  justify-content center
.quote-input-control
  display flex
  flex-wrap wrap
.quoteTextOutline
  border 1px solid black
  border-radius 10rem
  padding 2em
#quoteTextarea
  outline: 0;
  box-shadow: none;
  border: none;
  border-radius: 0;
  box-sizing: border-box;
  background-color: transparent;
  flex-basis 400px
  padding: 1.5rem 0;
.quote-submit
  display flex
  justify-content flex-end
.quote-submit-button
  border none
  background #17202D
  color #FFF
  padding 4px 16px
  border-radius 8rem
.quote-submit-button:hover
  background #3F4855
  cursor pointer
</style>
