import Vue from 'vue'
import Home from '../views/Home.vue'
import VueRouter from 'vue-router'

import LoginPage from '../views/LoginPage'
import AdminSetupPage from '../views/AdminSetupPage.vue'

import BoardListPage from '../views/VuetifyBoardListPage'
import VuetifyBoardListPage from '../views/VuetifyBoardListPage'

import Puzzle from '../views/Puzzle'

import RankListPage from '../views/RankListPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/VuetifyBoardListPage',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/Puzzle',
    name: 'Puzzle',
    components: {
      default: Puzzle
    },
    props: {
      default: true
    }
  },
  {
    path: '/RankListPage',
    name: 'RankListPage',
    components: {
      default: RankListPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
