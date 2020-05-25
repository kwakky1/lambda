<template>
    <div>
        벅스뮤직 차트
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        data(){return{

        }},
        computed:{
            ...mapState({
                searchResult : (state)=> state.crawling.searchResult
            })
        },
        name: "bugs"
    }
</script>

<style scoped>

</style>