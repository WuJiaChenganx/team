<template>
  <!-- 下载附件模板 -->
  <div style="margin-top: 20px">
    <a
      class="el-button el-button--primary el-button--mini"
      style="text-decoration: none"
      :href="url"
      download="附件下载"
      id="downloadBtn"
      target="_blank"
      >模板下载</a
    >
  </div>
</template>

<script>
export default {
  data() {
    return {
      url: undefined,
    };
  },
  created() {
    this.getLocalUrl();
  },
  methods: {
    getLocalUrl() {
      // 根据远程url创建本地url
      const url =
        "https://file2.clipworks.com/4c217acc09226795a7ebb8461ddf548f/20220726/469c1056-749d-4c47-819e-35f91c70e163";
      const xhr = new XMLHttpRequest();
      xhr.open("GET", url);
      xhr.responseType = "blob";
      xhr.onload = () => {
        this.url = URL.createObjectURL(xhr.response);
      };
      xhr.onerror = (e) => {
        console.log("err", e);
      };
      xhr.send();
    },
  },
};
</script>
