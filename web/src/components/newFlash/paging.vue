<template>
  <el-card>
    <!-- 用户列表区域 -->
    <el-table
      :data="
        rightsList.slice((currentPage - 1) * pagesize, currentPage * pagesize)
      "
      border
      stripe
    >
      <el-table-column label="#" type="index"></el-table-column>
      <el-table-column label="权限名称" prop="authName"></el-table-column>
    </el-table>

    <!--分页区域-->
    <el-pagination
      @size-change="size_change"
      @current-change="current_change"
      :current-page="currentPage"
      :page-sizes="[10, 20, 30]"
      :page-size="pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="rightsList.length"
    >
    </el-pagination>
  </el-card>
</template>
<script>
export default {
  data() {
    return {
      rightsList: [], //列表数据

      total: 0, //总条目数
      pagesize: 10, //每页显示条目个数
      currentPage: 1, //当前页数
    };
  },
  methods: {
    //监听 pagesize 改变的事件
    size_change(newSize) {
      this.pagesize = newSize;
    },
    //监听 页码值 改变的事件
    current_change(newPage) {
      this.currentPage = newPage;
    },
  },
};
</script>
<style></style>