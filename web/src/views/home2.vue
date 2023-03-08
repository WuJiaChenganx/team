<template>
  <header class="bg-dark sticky-top" th:fragment="header">
    <div class="container">
      <!-- 导航 -->
      <!-- navbar-expand-lg：屏幕>992px时水平铺开，否则垂直堆叠 -->
      <!-- 导航栏文字 navbar-dark：白字 -->

      <nav class="navbar navbar-expand-lg navbar-dark">
        <!-- logo -->
        <a class="navbar-brand" href="#">首页</a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <!-- 功能 -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item ml-3 btn-group-vertical">
              <a class="nav-link" th:href="@{/index}">首页</a>
            </li>
            <li class="nav-item ml-3 btn-group-vertical">
              <a class="nav-link position-relative" href="site/letter.html"
                >消息<span class="badge badge-danger">12</span></a
              >
            </li>
            <li class="nav-item ml-3 btn-group-vertical">
              <a class="nav-link" th:href="@{/register}">注册</a>
            </li>
            <li class="nav-item ml-3 btn-group-vertical">
              <a class="nav-link" href="site/login.html">登录</a>
            </li>
            <li class="nav-item ml-3 btn-group-vertical dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                id="navbarDropdown"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <img
                  src="http://images.nowcoder.com/head/1t.png"
                  class="rounded-circle"
                  style="width: 30px"
                />
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item text-center" href="site/profile.html"
                  >个人主页</a
                >
                <a class="dropdown-item text-center" href="site/setting.html"
                  >账号设置</a
                >
                <a class="dropdown-item text-center" href="site/login.html"
                  >退出登录</a
                >
                <div class="dropdown-divider"></div>
                <span class="dropdown-item text-center text-secondary"
                  >nowcoder</span
                >
              </div>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </header>
</template>
