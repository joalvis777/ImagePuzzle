<template>
  <div id="app">
    <header>
      <h1>P U Z Z L E</h1>
    </header>
    <br><br>
    <Board ref="board" v-show="playing" @restart="restart" @a="stop_time" />
    <OptionsPane ref="optionsPane" @gameStart="start" v-show="!playing" />
    <br><br><br>
    <p>{{formattedElapsedTime}}</p>
  </div>
</template>

<script>
import Board from '../components/Board'
import OptionsPane from '../components/OptionsPane'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  name: 'app',
  components: {
    Board,
    OptionsPane
  },
  data () {
    return {
      timeData : 0,
      finalTime : 0,
      playing: false,
      elapsedTime: 0,
      timer: undefined,
      userId : ''
    }
  },
  computed: {
    formattedElapsedTime() {
        const date = new Date(null);
        date.setSeconds(this.elapsedTime / 1000);
        const utc = date.toUTCString();
        return utc.substr(utc.indexOf(":") - 2, 8);
        },
        ...mapState(['myId']),
        ...mapState(['myCount'])
    },
  methods: {
    start (...args) {
     this.timer = setInterval(() => {
                this.elapsedTime += 1000;
        }, 1000);
      this.playing = true
      this.$refs.board.start(...args)
      console.log('a')
    },
    restart () {
      this.playing = false
      this.$refs.optionsPane.reset()
    },
    stop_time () {

      console.log('STOP TIME')
      clearInterval(this.timer)

      this.finalTime = this.elapsedTime / 1000
      console.log('finalTime : '+ this.finalTime)

      var timeData =  this.finalTime
      console.log('timeData: ' + timeData)

      var userId = this.myId
      console.log('userId : ' + userId)

      var lastMove = this.myCount
      console.log('lastMove : ' + lastMove)

        axios.post('http://localhost:7777/users/timeData',
                { userId , timeData, lastMove })
                .then(res => {
                    alert('DATA SENT' + res)
                    this.$router.push({
                        name: 'Home'
                    })
                })
                .catch(err => {
                    alert(err.response.data)
                })

    }
  }
}
</script>

<style lang="scss">

*, *::before, *::after {
  box-sizing: border-box;
}
a {
  text-decoration: none;
  color: #368ba0;
}
p {
    font-size: 80px;
    color: #8BF2D5;
    text-align: center;
    -webkit-animation: glow 1s ease-in-out infinite alternate;
    -moz-animation: glow 1s ease-in-out infinite alternate;
    animation: glow 1s ease-in-out infinite alternate;
}
@-webkit-keyframes glow {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #F739E8, 0 0 30px #F739E8, 0 0 40px #F739E8, 0 0 50px #F739E8, 0 0 60px #F739E8, 0 0 70px #cc66ff;
  }
  to {
    text-shadow: 0 0 20px #fff, 0 0 30px #C305B4, 0 0 40px #C305B4, 0 0 50px #C305B4, 0 0 60px #C305B4, 0 0 60px #C305B4, 0 0 80px #c040ff;
  }
}
#app {
  font: 14px/20px sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  header {
    h1 {
      font-weight: 450;
      height: 80px;
      line-height: 80px;
      font-size: 45px;
    }
  }
  footer {
    color: #555;
    margin-top: 60px;
  }
}
</style>