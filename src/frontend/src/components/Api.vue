<template>
  <div style="padding: 16px">
    <h1>API Demo</h1>
    <button @click="hello.fetchHello()" :disabled="hello.loading">
      {{ hello.loading ? "Loading..." : "Hello World を取得" }}
    </button>
    <br />
    <button
      @click="
        // hello.fetchHello();
        console.log(hello.message)
      "
    >
      ボタンを押した時に、console.log(userStore.name); でログを出す
    </button>
    <p v-if="hello.message" style="margin-top: 12px">
      API結果: {{ hello.message }}
    </p>
    <p v-if="hello.error" style="margin-top: 12px; color: crimson">
      Error: {{ hello.error }}
    </p>
  </div>
</template>

<script setup lang="ts">
import { useHelloStore } from "../stores/hello";
const hello = useHelloStore();
</script>
