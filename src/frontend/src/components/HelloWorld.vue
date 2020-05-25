<template>
  <div id="app">
    <div>
      <img alt="Google" height="92"  src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"><br><br><br>
      <div>
        <input @keyup.enter="search" type="text" v-model ="searchWord" id="searchBar"/>
        <button id="search" type="submit">검색</button>
      </div>
    </div>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  export default {
    computed:{
      ...mapState({
        searchResult : (state)=> state.crawling.searchResult
      })
    },
    data() {
      return {searchWord : ''}
    },
    methods :{
      search(){
        this.$store.dispatch('crawling/search',{searchWord : this.searchWord})
      }
    }
  }
</script>
<style scoped>
  #app {
    position: absolute;
    text-align: center;
    top: 50%;
    left: 50%;
    width: 500px; height: 500px;
    margin-left: -250px;
    margin-top: -200px;
  }
  #searchBar {
    border: solid 3px #cccccc;
    width: 400px;
    height: 40px;
    padding-right: 30px;
    border-radius: 30px;
  }
  #searchBar[type="text"] {
    padding-left: 30px;
  }
  #search {
    position: relative;
    left: 30px;
    background: lightblue;
    width: 80px;
    height: 40px;
    border-radius: 60px;
  }
  #search:hover {
    background: skyblue;
  }

</style>