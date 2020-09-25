<template>
  <form id="optionsForm" @submit.prevent="start">
    <img :src="image" v-if="image">
        <div class="vue-template">
          <div>
            <label for="file">
              이미지 선택
              <input type="file"
                id="file"
                accept="image/*"
                @change="fileChanged">
            </label>
            타일 개수 :
            <input type="number" name="width" min="2" max="10" v-model.number="size.horizontal">
            ×
            <input type="number" name="height" min="2" max="10" v-model.number="size.vertical">
            <br><br>
          </div>
          <button v-if="image" class="btn btn-warning" >게임 시작하기</button>
          <button v-on:click="openNew" class="btn btn-dark">사용자 전환</button>
        </div>


  </form>
</template>

<script>
import loadImage from 'blueimp-load-image'
export default {
  data () {
    return {
      image: null,
      size: {
        horizontal: 3,
        vertical: 3
      }
    }
  },
  methods: {
    fileChanged (e) {
      if (!e.target.files.length) {
        this.image = null
        console.log('b')
        return
      }
      loadImage(e.target.files[0], canvas => {
        this.image = canvas.toDataURL()
      }, {
        maxWidth: 600,
        maxHeight: 600,
        minWidth: 200,
        minHeight: 200,
        canvas: true
      })
    },
    openNew: function() {
        this.$router.push({
            name: 'LoginPage'
        })
        console.log('d')
    },

    start () {
      this.$emit('gameStart', {
        image: this.image,
        size: this.size
      })
      console.log('e')
    },
    stop_time () {
        clearInterval(this.timer);
        console.log('f')
    },
    /**
     * Reset the options.
     */
    reset () {
      this.image = null
      document.querySelector('#optionsForm').reset()
      console.log('g')
    }
  }
}
</script>

<style lang="scss" scoped>
img {
  border: 1px solid #ccc;
  margin-bottom: 8px;
}
label[for=file] {
  color: #FF4F33;
  cursor: pointer;
  display: inline-block;
  margin-right: 12px;
  font-size : 14px;
  font-weight: 550;
}
input[type=number] {
  height: 24px;
  font-size: 14px;
  border: 1px solid #ccc;
}
input[type=file] {
  display: none;
}
button-2 {
  -webkit-appearance: none;
  padding: 6px 12px;
  background: #1ca76a;
  color: #fff;
  border-radius: 3px;
  border: 0;
  font-size: 14px;
  cursor: pointer;
  margin-top: 10px;
}
div {
  color : #07B211;
  font-size : 14px;
   font-weight: 550;
}
</style>