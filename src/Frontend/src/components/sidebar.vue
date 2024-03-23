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
    @import '../assets/base.css';

    .leftbar{
        width: 10%;
        height: 100vh;
        background: #454545;
    }

    .list ul{
        list-style: none;
        display: flex;
        flex-direction: column;
    }

    .list ul li{
        padding: 30px 0px 30px 10px;
        color: #fff;
        cursor: pointer;
        border-bottom: rgb(202, 192, 192) 2px solid;
        border-right: rgb(202, 192, 192) 2px solid;
        border-radius: 0px 0px 10px 0px ;
        border-top: none;
        border-left: none;
    }

     .list ul li a{
        text-decoration: none;
        color: #fff;
    }

    .list ul li:hover{
        background: #333;
        transition: all 0.3s;
    }
</style>