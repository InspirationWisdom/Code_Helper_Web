import { createRouter, createWebHistory } from 'vue-router'
import index from '../index.vue'


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            redirect: "/home",
        },
        {
            path: "/home",
            name: "home",
            component: index,
            meta: {
              title: "Main Page",
            }
        }
    ]
})

export default router