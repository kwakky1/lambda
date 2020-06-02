
import router from "@/router";

const state = {
    context : "http://localhost:5000",
    searchWord : 'null',
    pageNumber: '0',
    soccers : [],
    movies : [],
    musics: [],
    pager: {}
};
const actions = {
    async find({commit},searchWord){
        commit("SEARCHWORD",searchWord)
        switch (searchWord) {
            case '벅스': router.push("/music")
                break;
            case '축구': router.push("/soccer")
                break;
            case '영화': router.push("/movie")
                break;
        }
    },
};
const mutations = {
    SEARCHWORD(state, data) {
        alert(`TEST ${data}`)
        state.searchWord = data
    }
};
const getters = {
};

export default {
    name: "search",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};