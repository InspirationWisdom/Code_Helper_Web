<script setup>
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
  <body>

    <div class="container">
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
  </body>
</template>

<style scoped>

  *{
    margin: 0;
    padding: 0;
    font-family: 'Poppins', sans-serif;
    box-sizing: border-box;
  }

  body{
    background: #454545;
    color: #fff;
  }

  .container{
    width: 100%;
    height: 100vh;
    padding: 20px;
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
