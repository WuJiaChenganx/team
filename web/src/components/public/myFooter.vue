<template>
  <div>
    <footer class="footer">
      <div class="container">
        <div>版权所有 &copy;{{ CopyrightYear }} 群智感知与协同研究</div>
        <div>
          <a href="https://beian.miit.gov.cn/" target="_blank"
            >浙ICP备2023007286号-1</a
          >
        </div>
      </div>
    </footer>
  </div>
</template>
<script>
export default {
  data() {
    return {
      CopyrightYear: new Date().getFullYear(),
    };
  },
};
</script>
<style>
.footer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  min-height: 15rem;
  background: #1d609c url(../../assets/images/background/zryy-footer-bg.png)
    no-repeat center center;
  background-size: cover !important;
  text-align: center;
}

.container {
  display: inline-block;
  font-size: 16px;
  color: #e9f5ff;
  line-height: 26px;
}
a {
  text-decoration: none;
  color: #e9f5ff;
}
a:hover {
  text-decoration: underline;
}
</style>
