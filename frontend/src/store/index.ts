import Vue from "vue";
import Vuex from "vuex";
import { QuoteModel } from "@/models/QuoteModel";
import {UserModel} from "@/models/UserModel";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    quotes: Array<QuoteModel>(),
    user: new UserModel()
  },
  mutations: {
    SET_QUOTES: (state, quotes) => {
      Vue.set(state, "quotes", [...quotes]);
    },
    SET_USER: (state, user) => {
      Vue.set(state, "user", {...user});
    }
  },
  actions: {
    loadQuotes: (context, quotes) => {
      context.commit("SET_QUOTES", quotes);
    },
    setUser: (context, user) => {
      context.commit("SET_USER", user);
    }
  },
  modules: {}
});
