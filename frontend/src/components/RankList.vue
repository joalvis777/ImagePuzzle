<style>
tbody>:nth-child(1){
  color:white;
background-color: hsl(180, 61%, 72%);
 text-shadow: 2px 2px 2px red;
  border: 1px solid;
}
tbody>:nth-child(2){
 color:white;
background-color: hsl(180, 61%, 81%);
text-shadow: 2px 2px 2px blue;
}
tbody>:nth-child(3){
 color:white;
 font-weight: bold;
background-color: hsl(178, 70%, 90%);
text-shadow: 2px 2px 2px green;


}
thead, tfoot {

  background: url(qqq.jpg);
  text-shadow: 0.5px 0.5px 0.5px black;

}

thead th, tfoot th, tfoot td {
  border:  3mm ridge rgba(170, 50, 220, .6);

}

td {
    font-weight: bold;

    }
</style>


<template>
  <div>
    <v-data-table
        :headers="headers"
        :items="page"
         class="elevation-1"
    >
    </v-data-table>
  </div>
</template>
<script>
export default {
  name: 'RankList',
  data () {
    return {
      pageNum: 0,
      headers: [
        {
            text: 'ID',
            align: 'center',
            sortable: false,
            value: 'userId',
            width: '10%',
            color: 'red',
        },
        {
            text: '걸린 시간',
            align: 'center',
            sortable: true,
            value: 'timeData'

        },
        {
            text: '움직인 횟수',
            align: 'center',
            sortable: true,
            value: 'lastMove',
            width: '10%'

        }
      ]
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
      default: 8
    },
    page: {
        type: Array
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