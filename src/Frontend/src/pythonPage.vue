<script setup>
    import leftbar from './components/sidebar.vue'
    import axios from 'axios'
    import banner from './components/banner.vue'

    const run = async () => {
        let pythonCode = document.getElementById('python-code').value;
        let pythonParams = document.getElementById('params').value;
        let outPut = document.getElementById('output');
        if(pythonCode.trim() === ''){
            alert('Please enter some code');
            return;
        }

        await axios.post('http://localhost:8080/executePython', {
            code: pythonCode,
            params: pythonParams
        }).then((response) => {
            outPut.innerHTML = response.data;
        }).catch((error) => {
            outPut.contentDocument.body.innerHTML = error;
        });
    }

    const check = async () => {
        let pythonCode = document.getElementById('python-code').value;
        
    }


</script>

<template>
    <banner/>
    <div class="container">
        <leftbar/>
        <div class="left">
            <label for="python-code">Python</label>
            <textarea id="python-code"></textarea>
            <label for="params">Pamameters</label>
            <textarea id="params"></textarea>
            <div class="button">
                <button v-on:click="check()">Check Code</button>
                <button v-on:click="run()">Run Code</button>
            </div>
        </div>
        <div class="right">
            <label for="output">Output</label>
            <textarea id="output" srcdoc="" readonly wrap="off"></textarea>
        </div>
    </div>
</template>

<style>
    @import './assets/base.css';

    .container{
        background: whitesmoke;
        color: #fff;
        font-family: 'Poppins', sans-serif;
        width: 100%;
        height: 87vh;
        display: flex;
    }

    .left, .right{
        flex-basis: 50%;
        padding: 10px;
    }

    textarea{
        width: 100%;
        height: 65%;
        background: #1f1f1f;
        color: #fff;
        font-family: Consolas, monospace;
        padding: 10px 20px;
        border: 0;
        outline: 0;
        font-size: 18px;
        overflow: auto;
    }

    #params{
        height: 10%;
    }

    #output{
        height: 90%;
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

    .button {
        display: flex;
        flex-direction: row;
        float: right;
    }

    button {
        display: block;
        width: 90px;
        line-height: 40px;
        padding: 0px 5px 0px 5px;
        margin-left: 40px;
        margin-top: 10px;
        border-radius: 15px;
        border: black 2px solid;
        cursor: pointer;
    }

    button:hover {
        background: rgb(202, 192, 192);
        transition: all 0.3s;
    }
</style>