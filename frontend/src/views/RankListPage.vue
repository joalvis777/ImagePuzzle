<template>
  <div align="center">
    <h2>R A N K</h2>
    <br>
    <br>
    <rank-list :page="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import RankList from '@/components/RankList.vue'

export default {
    name: 'RankListPage',
    components: {
        RankList
    },
    data () {
        return {
          pageArray: []
        }
    },
    mounted () {
        console.log('a')
        axios.get('http://localhost:7777/rank')
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