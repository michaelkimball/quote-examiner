<template>
  <div class="quote">
    <div class="quote-text">
      <div class="blockquote-original">
        <h3 class="blockquote-header">Original Quote</h3>
        <blockquote class="blockquote">
          {{ quote.original }}
        </blockquote>
      </div>
      <div class="blockquote-stripped">
        <h3 class="blockquote-header">Stripped Quote</h3>
        <blockquote class="blockquote">
          {{ quote.stripped }}
        </blockquote>
      </div>
    </div>
    <div class="quote-parts">
      <ul class="quote-list">
        <li class="list-group-quote">
          nouns
          <span class="quote-value">{{ quote.nouns }}</span>
        </li>
        <li class="list-group-quote">
          verbs
          <span class="quote-value">{{ quote.verbs }}</span>
        </li>
        <li class="list-group-quote">
          periods
          <span class="quote-value">{{ quote.periods }}</span>
        </li>
        <li class="list-group-quote">
          you
          <span class="quote-value">{{ quote.you }}</span>
        </li>
        <li class="list-group-quote">
          that
          <span class="quote-value">{{ quote.that }}</span>
        </li>
        <li class="list-group-quote">
          thing
          <span class="quote-value">{{ quote.thing }}</span>
        </li>
        <li class="list-group-quote">
          they
          <span class="quote-value">{{ quote.they }}</span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { QuoteModel } from "@/models/QuoteModel";

@Component
export default class Quote extends Vue {
  @Prop() quote!: QuoteModel;
  constructor() {
    super();
  }
}
</script>

<style scoped lang="stylus">
.quote
  display flex
  flex-wrap wrap
  font-family 'Khula', sans-serif
  margin-top 24px
.quote-text
  display flex
  flex-direction column
  flex-basis 400px
  flex-grow 1
.blockquote-original
  background #EEE
  padding 24px
  border-radius 12px
.quote-parts
  flex-basis 200px
.list-group-quote
  text-align start
  list-style none
.quote-value
  background #00ADB5
  padding 0 .6em
  color #FFF
  border-radius 10rem
  line-height 1
  font-size 75%
</style>
