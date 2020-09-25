<template>
  <div align="center">
    <h2>U S E R </h2>
    <br>
    <br>
    <board-list-page-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import BoardListPageForm from '@/components/BoardListPageForm.vue'


export default {
    name: 'VuetifyBoardListPage',
    components: {
    BoardListPageForm
    },
    data () {
    return {
      pageArray: []
    }
    },
    created () {
    axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
    }
}
</script>