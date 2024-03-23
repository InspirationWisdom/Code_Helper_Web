<script setup></script>

<template>
     <div class="leftbar">
            <div class="list">
                <ul>
                    <li><a href="/home">About</a></li>
                    <li><a href="/python">Python</a></li>
                    <li><a href="/html">Web Frontend</a></li>
                </ul>
            </div>
        </div>
</template>

<style scope>
    *{
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        box-sizing: border-box;
    }

    .leftbar{
        width: 10%;
        height: 100vh;
        border-right: #333 2px solid;
        background: #454545;
        margin: 10px;
    }

    .list ul{
        list-style: none;
    }

    .list ul li{
        padding: 30px 0px 30px 10px;
        color: #fff;
        cursor: pointer;
        border-bottom: #333 2px solid;
    }

     .list ul li a{
        text-decoration: none;
        color: #fff;
    }

    .list ul li:hover{
        background: #333;
 }
</style>