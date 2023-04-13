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
        <div>
          <a
            target="_blank"
            href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010602013006"
            style="display: inline-block"
          >
            <img
              src="../../assets/images/footer/badge.png"
              style="float: left"
            />
            <p
              style="
                float: left;
                height: 20px;
                line-height: 20px;
                margin: 0px 0px 0px 5px;
              "
            >
              浙公网安备 33010602013006号
            </p>
          </a>
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
