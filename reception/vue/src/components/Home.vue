<template>
    <div id="home">
      <div class="header">
        <div class="top-toolbar"></div>
        <div class="head"></div>
      </div>
      <div class="home-hero-container">
        <div class="home-hero">

        </div>
      </div>
      <div class="page-main"></div>
      <div>
        <div class="site-footer"></div>
        <div class="site-info"></div>
      </div>
    </div>
</template>

<script>
  export default {
    name: 'Home'
  }
</script>

<style scoped>

  #home {
    width: 1351px;
    height: 7436px;
  }

  .header {
    width: 1351px;
    height: 140px;
  }

  .top-toolbar {
    width: 1351px;
    height: 40px;
    background-color: gray;
  }

  .head {
    width: 1351px;
    height: 100px;
    background-color: orange;
  }
  .home-hero-container {
    width: 1226px;
    height: 670px;
    margin: 0 auto;
    background-color: chartreuse;
  }
  .home-hero {
    width: 1226px;
    height: 644px;
    background-color: pink;
  }
  .page-main {
    width: 1351px;
    height: 5888px;
    background-color: aquamarine;
  }
  .site-footer {
    width: 1351px;
    height: 472px;
    background-color: olivedrab;
  }

  .site-info {
    width: 1351px;
    height: 266px;
    background-color: mediumseagreen;
  }

</style>
