<template>
  <div>
    <footer class="footer">
      <div class="container">
        <span>版权所有 &copy;{{ CopyrightYear }} 群智感知与协同研究所</span>
        <a href="https://beian.miit.gov.cn/#/Integrated/index" target="_blank"
          >京ICP备05002829号-1</a
        >
        <a
          href="http://www.beian.gov.cn/portal/registerSystemInfo"
          target="_blank"
          >京公网安备1101080060号</a
        >
        <br />
        <span>地址：杭州市西湖区留和路288号</span><br />
        <span>电话：86-10-62601166</span> <span>邮箱：ictoffice@ict.ac.cn</span>
      </div>
    </footer>
  </div>
</template>
<script>
export default {
  name: "myFooter",
  data() {
    return {
      CopyrightYear: new Date().getFullYear(),
    };
  },
};
</script>
<style>
.footer {
  background: #1d609c url(../../assets/images/background/zryy-footer-bg.png)
    no-repeat center center;
  background-size: cover !important;
  padding: 36px 0 33px 0;
  text-align: center;
}
.footer span,
.footer a {
  display: inline-block;
  font-size: 14px;
  color: #e9f5ff;
  line-height: 26px;
}
.footer a {
  margin-left: 10px;
}
.footer a:hover {
  text-decoration: underline;
}
</style>