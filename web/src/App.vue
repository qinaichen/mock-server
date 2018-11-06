<template>
  <div id="app">
    <el-container>
      <el-header style="background-color: #545C64;">
        <el-menu :default-active="activeIndex" router class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545C64" text-color="#FFFFFF" active-text-color="#FFD04B">
          <el-menu-item index="/">所有信息</el-menu-item>
          <el-menu-item index="/code">添加配置</el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '/'
      };
    },
    methods: {
      handleSelect(key, keyPath) {

      }
    },
    mounted(){
      this.activeIndex = this.$route.path;
    }
  }
</script>

<style>
body{
  margin: 0;
  padding: 0;
}
</style>
