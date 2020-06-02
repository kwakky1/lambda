<template>
    <div>
        <h3>검색결과 : {{pager.rowCount}}</h3>
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
                    <td>{{item.title}}</td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
            <div  style="margin: 0 auto; width : 500px; height: 100px; ">
            <span v-if= existPre style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px;">이전</span>
            <span v-for = "i in pages" :key="i"  style="width: 50px; height: 50px; border: 1px solid black;">{{i}}</span>
            <span v-if= existNext style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px;">다음</span>
            </div>
            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    import axios from "axios";
    export default {
        data(){
            return{
                pageNumber : 0,
                existPre : true,
                existNext : true,
                pages : [],
                list: [],
                pager: {},
                totalCount: '',
            }
        },
        created(){
            alert("무비 크리티드 실행됨")
            axios.get( `${this.$store.state.search.context}/movie/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res=>{
                    res.data.list.forEach(elem => {this.list.push(elem)})
                    this.pager = res.data.pager
                    let i = this.pager.pageStart+1
                    let arr = []
                    for(;i<=this.pager.pageEnd+1;i++){
                        arr.push(i)
                    }
                    this.pages = arr
                })
                .catch(err=>{
                    alert(`통신실패! ${err}`)
                })
        },
        computed :{
            ...mapState({
                count : state => state.crawling.count,
                movie : state => state.crawling.movie,

            })
        }
    }
</script>

<style scoped>

</style>