<template>
  <div class="p-6 font-sans">
    <h1>Vue 3 Lifecycle Playground</h1>
    <a
      href="https://ja.vuejs.org/guide/essentials/lifecycle.html"
      target="_blank"
      class="text-blue-600 underline"
      >公式ドキュメント</a
    >

    <div style="margin-top: 12px; display: flex; gap: 8px; align-items: center">
      <button @click="count++">count++</button>
      <button @click="show = !show">
        {{ show ? "Unmount me" : "Mount me" }}
      </button>
      <span>count: {{ count }}</span>
    </div>

    <Child v-if="show" :count="count" />
  </div>
</template>

<script setup lang="tsx">
import {
  ref,
  defineComponent,
  onBeforeMount,
  onMounted,
  onBeforeUpdate,
  onUpdated,
  onBeforeUnmount,
  onUnmounted,
  onActivated,
  onDeactivated,
} from "vue";

const count = ref(0);
const show = ref(true);

onBeforeMount(() => {
  console.log("PARENT onBeforeMount");
});
onMounted(() => {
  console.log("PARENT onMounted");
});
onBeforeUpdate(() => {
  console.log("PARENT onBeforeUpdate（DOM差分適用の直前）");
});
onUpdated(() => {
  console.log("PARENT onUpdated（DOM差分適用の直後）");
});
onBeforeUnmount(() => {
  console.log("PARENT onBeforeUnmount");
});
onUnmounted(() => {
  console.log("PARENT onUnmounted");
});

// 子コンポーネント：更新・アンマウントを見やすく
const Child = defineComponent({
  name: "Child",
  props: { count: { type: Number, required: true } },
  setup(props) {
    onBeforeMount(() => console.log("CHILD onBeforeMount"));
    onMounted(() => console.log("CHILD onMounted"));
    onBeforeUpdate(() =>
      console.log("CHILD onBeforeUpdate（props/count変化で再描画前）")
    );
    onUpdated(() => console.log("CHILD onUpdated（再描画後）"));
    onBeforeUnmount(() => console.log("CHILD onBeforeUnmount"));
    onUnmounted(() => console.log("CHILD onUnmounted"));

    // KeepAliveを試すときに使う（<KeepAlive>でラップした場合のみ発火）
    onActivated(() => console.log("CHILD onActivated (KeepAlive)"));
    onDeactivated(() => console.log("CHILD onDeactivated (KeepAlive)"));

    return () => (
      <div style="margin-top:8px; padding:8px; border:1px solid #ddd; border-radius:8px;">
        <strong>Child</strong> — received count: {props.count}
      </div>
    );
  },
});
</script>

<style scoped>
button {
  padding: 6px 10px;
  border: 1px solid #cbd5e1;
  background: #fff;
  border-radius: 8px;
  cursor: pointer;
}
button:hover {
  background: #f8fafc;
}
</style>
