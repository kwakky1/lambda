<template>
    <div>
        영화
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        computed :{
            ...mapState({
                count : state => state.movie.count,
                movie : state => state.movie.movie
            })
        }
    }
</script>

<style scoped>

</style>