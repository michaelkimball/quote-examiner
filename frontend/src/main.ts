import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VueResource from "vue-resource";
import VueCookies from "vue-cookies-ts";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faGithub, faGoogle } from "@fortawesome/free-brands-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
library.add(faGithub, faGoogle);
Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.config.productionTip = false;
Vue.use(VueResource);
Vue.use(VueCookies);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
