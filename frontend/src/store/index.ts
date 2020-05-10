import Vue from "vue";
import Vuex from "vuex";
import { QuoteModel } from "@/models/QuoteModel";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    quotes: Array<QuoteModel>()
  },
  mutations: {
    SET_QUOTES: (state, quotes) => {
      Vue.set(state, "quotes", [...quotes]);
    }
  },
  actions: {
    loadQuotes: (context, quotes) => {
      context.commit("SET_QUOTES", quotes);
    }
  },
  modules: {}
});
