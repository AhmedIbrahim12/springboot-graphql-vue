<template>
  <div id="app">
    <v-app id="inspire">
        <data-widget></data-widget>
    </v-app>
</div>
</template>

<script>
import Widget from './components/Widget.vue'
export default {
  name: 'app',
  components:{
    'data-widget' : Widget
  }
}
</script>