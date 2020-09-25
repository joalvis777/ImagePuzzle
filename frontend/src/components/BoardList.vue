<template>
  <div>
    <h3>Board List View</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">No</th>
        <th align="center" width="320">Title</th>
        <th align="center" width="100">Writer</th>
        <th align="center" width="180">Registration Date</th>
      </tr>
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          List is empty
        </td>
      </tr>
      <tr v-else v-for="board in boards" :key="board.userNo">
        <td align="center">{{ board.userNo }}</td>
        <td align="left"></td>
        <td align="right">{{ board.userId }}</td>
        <td align="center">{{ board.userPw }}</td>
        <td align="center">{{ board.userName }}</td>
      </tr>
    </table>
  </div>
</template>
<script>
export default {
  name: 'BoardList',
  props: {
    boards: {
      type: Array
    }
  }
}
</script>