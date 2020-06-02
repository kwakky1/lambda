import axios from "axios";
import router from "@/router";

const state = {
    context: "http://localhost:5000/",
    bugsmusic: [],
    soccer : [],
    movie : [],
    count: 0
};
const actions = {
    async find({commit},searchWord){
        switch (searchWord) {
            case '벅스':
                axios.get(state.context+`bugsMusic/`+searchWord)
                    .then(({data})=>{
                        commit("SEARCH",data)
                        router.push("/retriever")
                    })
                    .catch(()=>{
                        alert("통신실패")
                    })
                break;
            case '축구':
                axios.get(state.context+`soccer/`+searchWord)
                    .then(({data})=>{
                        commit("SEARCH",data)
                        router.push("/soccer")
                    })
                    .catch(()=>{
                        alert("통신실패")
                    })
                break;
            case '영화':
                axios.get(state.context+`movie/list/0/${searchWord}`)
                    .then(({data})=>{
                        commit("SEARCH",data)
                        router.push("/movie")
                    })
                    .catch(()=>{
                        alert("통신실패")
                    })
                break;
        }
    }
};
const mutations = {
    SEARCH(state, data) {
        switch (data.searchWord) {
            case "벅스": state.bugsmusic = [];
                state.count = data.count;
                data.list.forEach(item => {
                    state.bugsmusic.push({
                        seq: item.sqe,
                        artist: item.artists,
                        title: item.title,
                        thumbnail: item.thumbnail
                    });
                });
                break;
            case "축구": state.soccer = data
                break;
            case "영화": state.movie =[];
                state.count = data.count
                data.list.forEach(item=>{
                    state.movie.push({
                        movieSeq: item.movieSeq,
                        rank : item.rank,
                        title : item.title,
                        rankDate : item.rankDate
                    })
                })
                break;
        }
    }
};
const getters = {
    bugsmusic: state => state.bugsmusic,
    movie : state=> state.movie,
    count: state => state.count,
    soccer : state => state.soccer
};

export default {
    name: "find",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};