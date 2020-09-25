import {
    successGenRandNum,
    failGenRandNum,
    ADD_TODO,
    REMOVE_TODO,
    CLEAR_ALL,
    RESTORE,
    EDIT_TODO,
    TOGGLE_TODO_STATUS,
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    SET_ACCESS_TOKEN,
    SET_MY_INFO,
    /* eslint-disable no-unused-vars */
    DESTROY_ACCESS_TOKEN,
    DESTROY_MY_INFO,
    SAVE_MY_ID, ERASE_MY_ID,
    SAVE_MY_COUNT
} from './mutation-types'
import axios from 'axios'
import router from '../router'
export default {

    async crawlFindOne ({ commit }, newsNo) {
        axios.get('http://localhost:7777/news/' + `${newsNo}`)
            .then(({ data }) => {
                console.log('/news/newsNo res: ' + data)
                commit('FINDONE', data)
                router.push('/CrawlCategory/news')
            })
    },
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/boards')
            .then(res => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard ({ commit }, userNo) {
        console.log('fetchBoard ' + commit + ', userNo = ' + userNo)
        return axios.get(`http://localhost:7777/boards/${userNo}`)
            .then(res => {
                console.log('fetchBoard - res: ' + res.data)
                commit(FETCH_BOARD, res.data)
            })
    },
    editTodo ({ commit }, payload) {
        commit(EDIT_TODO, payload)
    },
    toggleTodoStatus ({ commit }, id) {
        commit(TOGGLE_TODO_STATUS, id)
    },
    save ({ state }) {
        const data = {
            todoItems: state.todoItems,
            nextTodoId: state.nextTodoId
        }
        localStorage.setItem('todo-app-data', JSON.stringify(data))
    },
    restore ({ commit }) {
        const data = localStorage.getItem('todo-app-data')
        if (data) {
            console.log('data: ' + JSON.parse(data))
            commit(RESTORE, JSON.parse(data))
        }
    },
    generateRandomNumber ({ commit }) {
        console.log(commit)
        axios.get('http://localhost:7777/random')
            .then((res) => {
                commit(successGenRandNum,
                    parseInt(res.data.randNumber))
            })
            .catch((res) => {
                commit(failGenRandNum, res)
            })
    },
    addTodo (context, payload) {
        context.commit(ADD_TODO, payload)
    },
    removeTodo (context, payload) {
        context.commit(REMOVE_TODO, payload)
    },
    clearAll (context, payload) {
        context.commit(CLEAR_ALL)
    },
    login ({ commit }, payload) {
        console.log('actions login')
        return axios.post(`http://localhost:7777/api/authenticate?username=${payload.userid}&password=${payload.password}`, {
            username: payload.userid,
            password: payload.password
        }).then(res => {
            console.log('actions after post')
            const { authorization } = res.headers
            const accessToken = authorization.substring(7)
            commit(SET_ACCESS_TOKEN, accessToken)
            return axios.get('http://localhost:7777/users/myinfo')
        }).then(res => {
            console.log('After Get Auth Info')
            commit(SET_MY_INFO, res.data)
        })
    },
    loginByToken ({ commit }, token) {
        commit(SET_ACCESS_TOKEN, token)
        return axios.get('http://localhost:7777/users/myinfo')
            .then(res => {
                commit(SET_MY_INFO, res.data)
            })
    },
    logout ({ commit }) {
        commit(DESTROY_MY_INFO)
        commit(DESTROY_ACCESS_TOKEN)
    },
    saveId ({ commit }, a) {
        console.log('SAVED a : ' + a )
        commit(SAVE_MY_ID, a)
    },
    eraseId ({ commit }, b) {
        console.log('ERASED b : ' + b)
        commit(ERASE_MY_ID, b)
    },
    saveCount ({ commit }, c) {
        commit(SAVE_MY_COUNT, c)

    }
}