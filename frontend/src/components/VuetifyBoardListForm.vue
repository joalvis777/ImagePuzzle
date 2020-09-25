<template>
  <div>
    <table board=1>
      <tr>
        <th>userNo</th>
        <th>userId</th>
        <th>userPw</th>
        <th>userName</th>
      </tr>
      <tr v-for="page in paginatedData" :key="page.no">
        <td>{{ page.userNo }}</td>
        <td>{{ page.userId }}</td>
        <td>{{ page.userPw }}</td>
        <td>{{ page.userName }}</td>
      </tr>
    </table>

    <div class="btn-cover">
      <button :disabled="pageNum === 0"
        @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1"
        @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'VuetifyBoardListForm',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 10
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  },
  computed: {
    pageCount () {
      const listLen = this.listArray.length
      const listSize = this.pageSize
      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }
      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>