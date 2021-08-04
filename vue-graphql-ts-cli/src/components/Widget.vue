<template>
    <div id="widget">
    <v-app id="inspire">
        <grid></grid>
    </v-app>
    </div>
</template>

<script>
import Grid from './Grid.vue';
export default {
    name: 'widget',
    components: {
        'grid' : Grid
    }
}
</script>