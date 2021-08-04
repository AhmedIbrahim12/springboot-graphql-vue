import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import ApolloClient from "apollo-boost"
import VueApollo from "vue-apollo"
import StudentService from "./graphql/students/StudentsService";

Vue.config.productionTip = false

export const eventBus = new Vue();
export const apolloClient = new ApolloClient({
  uri: "http://localhost:8080/graphql",
})

Vue.use(VueApollo)
const apolloProvider = new VueApollo({
  defaultClient: apolloClient,
})

export const studentsService = new StudentService();

new Vue({
  router,
  store,
  vuetify,
  apolloProvider,
  render: h => h(App)
}).$mount('#app')
