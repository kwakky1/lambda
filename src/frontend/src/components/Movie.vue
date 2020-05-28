<template>
    <div>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">영화제목</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of movie" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td>{{item.movieName}}></td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
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