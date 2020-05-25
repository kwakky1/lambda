import Vue from 'vue';
import Router from 'vue-router';
import Bugs from "../components/Bugs";

Vue.use(Router)
export default new Router({
    mode: 'history',
    routers :[
        {path : '/bugs',component:Bugs }
    ]
})