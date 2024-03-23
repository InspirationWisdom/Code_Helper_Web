<script setup>
  import leftbar from './components/sidebar.vue'

  function run(){
    let htmlCode = document.getElementById('html-code').value;
    let cssCode = document.getElementById('css-code').value;
    let jsCode = document.getElementById('js-code').value;
    let outPut = document.getElementById('output');

    outPut.contentDocument.body.innerHTML = htmlCode + "<style>" + cssCode + "</style>";
    outPut.contentWindow.eval(jsCode);
  } 
</script>

<template>
  <div class="container">
    <leftbar/>
    <div class="left">
      <label for="html-code">HTML</label>
      <textarea id="html-code" v-on:keyup="run()"></textarea>

      <label for="css-code">CSS</label>
      <textarea id="css-code" v-on:keyup="run()"></textarea>

      <label for="js-code">JavaScript</label>
      <textarea id="js-code" v-on:keyup="run()"></textarea>
    </div>
    <div class="right">
      <label for="output">Output</label>
      <iframe id="output" srcdoc=""></iframe>
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

  .left, .right{
    flex-basis: 50%;
    padding: 10px;
  }

  textarea{
    width: 100%;
    height: 28%;
    background: #1f1f1f;
    color: #fff;
    font-family: Consolas, monospace;
    padding: 10px 20px;
    border: 0;
    outline: 0;
    font-size: 18px;

  }

  iframe{
    width: 100%;
    height: 95%;
    background: #fff;
    border: 0;
    outline: 0;
  }

  label{
    display: flex;
    align-items: center;
    background: #000;
    height: 30px;
    padding-left: 10px;
  }

</style>
