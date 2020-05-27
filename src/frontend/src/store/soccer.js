import axios from 'axios'
import router from '../router'
const state={
    context : "http://localhost:5000/",
    soccer : [],

}
const actions ={
    async search({commit},searchWord){
        axios.post(state.context+`soccer`,searchWord,{
            authorization : 'JWT fkdfj..',
            Accept: 'application/json',
            ContentType : 'application/json'
        })
            .then(({data})=>{
                commit("SEARCH",data)
                router.push("/soccer")
            })
            .catch(()=>{
                alert("통신실패")
            })
    }
}
const mutations ={
    SEARCH(state,data){
        state.soccer = data
    }
}
const getters ={

}

export default {
    name: "soccer",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}