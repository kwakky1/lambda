<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">이미지</th>
                    <th class="text-left">노래제목</th>
                    <th class="text-left">가  수</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of bugsmusic" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td><img :src="item.thumbnail"></td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.artist }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>
        </div>
    </div>


</template>

<script>


    export default {
        methods :{
            search(){

            }
        }
    };
</script>