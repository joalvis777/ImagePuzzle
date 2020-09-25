<style>
  table.type09 {
      border-collapse: collapse;
      text-align: left;
      line-height: 1.5;

  }
  table.type09 thead th {
      padding: 10px;
      font-weight: bold;
      vertical-align: top;
      color: #369;
      border-bottom: 3px solid #036;
  }
  table.type09 tbody th {
      width: 150px;
      padding: 10px;
      font-weight: bold;
      vertical-align: top;
      border-bottom: 1px solid #ccc;
      background: #f3f6f7;
  }
  table.type09 td {
      width: 350px;
      padding: 10px;
      vertical-align: top;
      border-bottom: 1px solid #ccc;
  }

  button {
    background-color: #555555;
    border: none;
    color: white;
    padding: 10px 23px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
  }
  td {
    font-weight: 500;
  }
</style>

<template>
  <div>
    <table class="type09" border="1">
        <thead>
          <tr>
            <th align="center" width="100">userNo</th>
            <th align="center" width="100">userId</th>
            <th align="center" width="100">userPw</th>
            <th align="center" width="250">userName</th>
          </tr>
          <tr v-for="board in paginatedData" :key="board.userNo">
            <td>{{ board.userNo }}</td>
            <td>{{ board.userId }}</td>
            <td>{{ board.userPw }}</td>
            <td>{{ board.userName }}</td>
          </tr>
      </thead>
    </table>
    <br>
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
  name: 'VuetifyListPageForm',
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
      default: 7
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