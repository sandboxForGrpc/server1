<template>
  <div style="padding: 16px; max-width: 560px">
    <h1>API Demo</h1>

    <input
      type="file"
      accept=".txt,text/plain"
      @change="onPick"
      :disabled="store.uploading"
    />

    <div v-if="store.file" style="margin-top: 8px; color: #374151">
      選択中:
      <strong>{{ store.file?.name }}</strong>
      <span style="color: #6b7280">
        ({{ (store.file?.size ?? 0).toLocaleString() }} bytes)
      </span>
    </div>

    <button
      style="
        margin-top: 12px;
        padding: 0.5rem 0.9rem;
        border-radius: 10px;
        border: 1px solid #d1d5db;
        background: #f9fafb;
        cursor: pointer;
      "
      :disabled="!store.file || store.uploading"
      @click="store.upload"
    >
      {{ store.uploading ? "アップロード中…" : "アップロード" }}
    </button>

    <div
      v-if="store.uploading"
      style="
        margin-top: 12px;
        height: 10px;
        background: #f3f4f6;
        border-radius: 8px;
        overflow: hidden;
      "
    >
      <div
        :style="{
          width: store.progress + '%',
          height: '100%',
          background: '#3b82f6',
          transition: 'width .15s linear',
        }"
      ></div>
    </div>

    <p v-if="store.message" style="margin-top: 8px; color: #065f46">
      ✅ {{ store.message }}
    </p>
    <p v-if="store.error" style="margin-top: 8px; color: #991b1b">
      ⚠️ {{ store.error }}
    </p>
  </div>
</template>

<script setup lang="ts">
import { useUploadStore } from "../stores/upload";

const store = useUploadStore();

function onPick(e: Event) {
  const input = e.target as HTMLInputElement;
  store.setFile(input.files?.[0] ?? null);
}
</script>
