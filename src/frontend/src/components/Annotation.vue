<template>
  <div class="p-6 font-sans space-y-4">
    <h1 class="text-xl font-bold">Annotation Playground</h1>
    <input
      v-model="name"
      type="text"
      placeholder="お名前を入力"
      class="border rounded px-3 py-2 w-64"
      @keyup.enter="handleClick"
    />
    <button
      @click="handleClick"
      :disabled="annotation.loading || !name"
      class="px-4 py-2 rounded bg-black text-white disabled:opacity-50"
    >
      {{ annotation.loading ? "Loading..." : "Annotation test" }}
    </button>
    <br />

    <p v-if="annotation.message" style="margin-top: 12px">
      API結果: {{ annotation.message }}
    </p>
    <br />
    <button @click="annotation.fetchConfig()" :disabled="annotation.loading">
      {{ annotation.loading ? "Loading..." : "環境変数を取得" }}
    </button>
    <br />
    <p v-if="annotation.config" style="margin-top: 12px">
      API結果: {{ annotation.config }}
    </p>
    <p v-if="annotation.error" class="mt-2 text-red-600">
      エラー: {{ annotation.error }}
    </p>
  </div>
  <a
    href="http://localhost:8080/actuator/beans"
    target="_blank"
    class="text-blue-600 underline"
    >Actuator Beans Endpoint</a
  >
</template>

<script setup lang="tsx">
import { ref } from "vue";
import { useAnnotationStore } from "../stores/annotation";
const annotation = useAnnotationStore();

const name = ref("");

const handleClick = () => {
  annotation.fetchAnnotation(name.value);
};
</script>
