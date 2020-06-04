<template>
    <div>
        <td>{{item.movieSeq}}</td>
        <td>{{item.rank}}</td>
        <td>{{item.title}}</td>
        <td>{{item.rankDate}}</td>
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        computed :{
            ...mapState({
                item : state => state.search.item
            })
        }
    }
</script>

<style scoped>

</style>