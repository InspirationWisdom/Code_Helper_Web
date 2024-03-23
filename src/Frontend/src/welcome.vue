<script setup>
    import leftbar from './components/sidebar.vue'
</script>

<template>
    <div class="container">
        <leftbar/>
        <div class="page">
            <div class="text">
                Welcome to the Code Helper
            </div>
        </div>
    </div>
</template>

<style scoped>
  @import './assets/base.css';

  .container{
    background: #454545;
    color: #fff;
    font-family: 'Poppins', sans-serif;
    width: 100%;
    height: 100vh;
    display: flex;
  }

  .page{
    height: 100vh;
    width: 100%;
    display: flex;
  }

  .text{
    margin: 0 auto;
    font-size: 40px;
    margin-top: 45vh;
  }
</style>