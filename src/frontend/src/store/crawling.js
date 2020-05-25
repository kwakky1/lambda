import axios from 'axios'
import router from '../router'
const state={
    context : 'http://localhost:5000/',
    searchResult : []

}
const actions={
    async search({commit},searchWord){
        alert('검색어 :'+ searchWord)
        const url = state.context + `crawler/`
        const headers = {
            authorization : 'JWT fefege..',
            Accept : 'application/json',
            ContentType : 'application/json'
        }
        axios.post(url,searchWord,headers)
            .then(({data})=>{
                alert('검색된 결과 수 '+data.count)
                commit('SEARCH',data)
            })
            .catch(()=>{
                alert('서버전송실패')
            })
    }

}
const mutations={
    SEARCH(state, data){
        state.searchResult = []
        state.searchResult =data.list
        router.push('/bugs')
        // data.forEach(iteam =>{
        //     alert(itme)
        //     state.searchResult.push([])
        // })
    }
}
const getters={
    searchResult : state => state.searchResult
}
export default {
    name : 'crawling',
    state,
    namespaced : true,
    actions,
    mutations,
    getters
}