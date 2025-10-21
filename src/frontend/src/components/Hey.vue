<template>
  <div style="padding: 16px">
    <h1>API Demo</h1>
    <button @click="hey.fetchHey()" :disabled="hey.loading">
      {{ hey.loading ? "Loading..." : "Hey World を取得" }}
    </button>
    <br />
    <button
      @click="
        // hey.fetchHey();
        console.log(hey.message)
      "
    >
      ボタンを押した時に、console.log(userStore.name); でログを出す
    </button>
    <p v-if="hey.message" style="margin-top: 12px">
      API結果: {{ hey.message }}
    </p>
    <p v-if="hey.error" style="margin-top: 12px; color: crimson">
      Error: {{ hey.error }}
    </p>
  </div>
</template>

<script setup lang="ts">
import { useHeyStore } from "../stores/hey";
const hey = useHeyStore();
</script>
