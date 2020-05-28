import axios from "axios"
import router from "../router"

const state ={
    context : "http://localhost:5000/",
    movie : [],
    count : 0
}
const actions ={
    async search({commit},searchWord){
        alert(searchWord)
        axios.get(state.context+`movie/`+searchWord)
            .then(({data})=>{
                commit("SEARCH",data)
                router.push('/movie')
            })
            .catch(()=>{
                alert("통신실패")
            })
    }
}
const mutations ={
    SEARCH(state,data){
        state.movie =[];
        state.count = data.count
        data.list.forEach(item=>{
            state.movie.push({
                seq : item.movieNo,
                movieName : item.movieName
            })
        })
    }
}
const getters = {
    movie : state=> state.movie,
    count : state=> state.count
}
export default {
    name:"movie",
    namespaced : true,
    state,
    actions,
    mutations,
    getters
}