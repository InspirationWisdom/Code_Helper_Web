import { createRouter, createWebHistory } from 'vue-router'
import h5c3 from '../h5c3.vue'
import welcome from '../welcome.vue'
import python from '../pythonPage.vue'


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
            component: welcome,
            meta: {
              title: "Welcome Page",
            }
        },
        {
            path: "/html",
            name: "HTML",
            component: h5c3,
            meta: {
              title: "HTML + CSS3 Page",
            }
        },
        {
            path: "/python",
            name: "Python",
            component: python,
            meta: {
              title: "Python Page",
            } 
        },
    ]
})

export default router