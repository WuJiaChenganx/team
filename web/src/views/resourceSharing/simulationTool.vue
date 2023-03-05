<template>
  <!-- 仿真工具 -->
  <div>
    <simulationTool></simulationTool>
  </div>
</template>
        
  <script>
import simulationTool from "../../components/resourceSharing/simulationTool.vue";
export default {
  data: function () {
    return {};
  },
  created: function () {},
  components: {
    // 注册组件
    simulationTool,
  },
};
</script>
<style></style>