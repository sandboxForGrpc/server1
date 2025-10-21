import { createRouter, createWebHistory } from 'vue-router'
import Home from './views/Home.vue'
import Api from './components/Api.vue'
import Lifecycle from './components/Lifecycle.vue'
import Annotation from './components/Annotation.vue'
import Upload from './components/Upload.vue'
import Hey from './components/Hey.vue'

export const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'main', component: Home },
    { path: '/api', name: 'api', component: Api },
    { path: '/lifecycle', name: 'lifecycle', component: Lifecycle },
    { path: '/annotation', name: 'annotation', component: Annotation },
    { path: '/upload', name: 'upload', component: Upload },
    { path: '/hey', name: 'hey', component: Hey },
  ],
})
