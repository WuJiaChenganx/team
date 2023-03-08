<template>
  <div class="home">
    <div>
      <b-navbar
        b-navbar
        toggleable="lg"
        type="light"
        variant="light"
        sticky="“true”"
        fixed="top"
      >
        <b-navbar-brand href="#">首页</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#">Link</b-nav-item>
            <b-nav-item href="#" disabled>Disabled</b-nav-item>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <!-- 菜单下拉栏 -->
            <b-nav-item-dropdown text="我是无敌的" right>
              <!-- Using 'button-content' slot -->
              <b-dropdown-item href="#">Profile</b-dropdown-item>
              <!-- 下拉栏的项目 -->
              <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>
