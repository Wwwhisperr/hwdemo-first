import VueRouter from "vue-router";//import是导入
import Vue from "vue";
import App from "./App";
import AddPage from "./components/add"
import ListPage from "./components/list"

//路由和vue框架整合
Vue.use(VueRouter);
const router =new VueRouter({
    routes: [ //数组就是具体的路由集合
        {
            path: "/",
            redirect: "/add",
            component: App,
            children: [
                {
                    path: "add",
                    name: "add",
                    component: AddPage,
                },
                {
                    path: "list",
                    name: "list",
                    component: ListPage,
                }
            ]
        }
    ]
})
export default router//export是导出