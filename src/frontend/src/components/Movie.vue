<template>
    <div>
        <h3>검색결과 : {{pager.rowCount}}</h3>
        <span  style="float: right">
            <input id="searchWord"  @keyup.enter="search" type="text" style="border: 1px solid black">
            <button @click="search()" style="cursor: pointer">
                검색
            </button>
        </span>
        <a @click="myAlert('aaaa')">테스트</a>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">순위 날짜</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.movieSeq">
                    <td>{{ item.movieSeq }}</td>
                    <td>{{ item.rank }}</td>
                    <td><a @click="retrieveOne(item.movieSeq)" href="#">{{item.title}}</a></td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
            <div  style="margin: 0 auto; width : 500px; height: 100px; ">
            <span @click="transferPage(pager.prevBlock)" v-if= pager.existPrev style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">이전</span>
            <span @click="transferPage(i-1)" v-for = "i in pages" :key="i"  style="width: 50px; height: 50px; border: 1px solid black; cursor: pointer;">{{i}}</span>
            <span @click="transferPage(pager.nextBlock)" v-if= pager.existNext style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">다음</span>
            </div>
            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    import {proxy} from "./mixins/proxy";
    export default {
        mixins :[proxy],
        created(){
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movie/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp

        },
        computed :{
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager

            })
        },
        methods :{
            transferPage(d){
                alert("페이지: "+(d-1))
                this.$store.dispatch('search/transferPage',{cate :'movie',searchWord :'null', pageNumber : d})
            },
            search(){
                let searchWord = document.getElementById('searchWord').value
                if(searchWord === '') searchWord = 'null'
                this.$store.dispatch('search/transferPage',{cate :'movie',searchWord : searchWord, pageNumber : 0})
            },
            retrieveOne(d){
                this.$store.dispatch('search/retrieveOne',{cate :'movie',searchWord : d})
            }


        }

    }


</script>

<style scoped>

</style>