<template>
  <div class="home">
    <QuoteView />
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from "@/components/HelloWorld.vue";
import QuoteView from "@/components/QuoteView";
export default {
  name: "Home",
  components: {
    QuoteView
  }
};
</script>
