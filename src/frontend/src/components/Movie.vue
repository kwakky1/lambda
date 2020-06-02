<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
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
                <tr v-for="item of movie" :key="item.seq">
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
            <span v-for = "i in arr" :key="i"  style="width: 50px; height: 50px; border: 1px solid black;">{{i}}</span>
            <span v-if= existNext style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px;">다음</span>
            </div>
            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        data(){
            return{
            existPre : true,
            existNext : true,
            arr : [6,7,8,9,10]
            }
        },
        created() {

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