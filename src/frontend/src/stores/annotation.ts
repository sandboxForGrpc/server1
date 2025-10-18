import { defineStore } from "pinia";
import axios from "axios";

export const useAnnotationStore = defineStore("annotation", {
  state: () => ({
    loading: false as boolean,
    message: "" as string,
    config: {} as Record<string, string>,
    error: "" as string,
  }),
  actions: {
    async fetchAnnotation(name: string) {
      this.loading = true;
      this.message = "";
      this.error = "";
      try {
        const res = await axios.get("/api/greet", { params: { name } });
        this.message = typeof res.data === "string" ? res.data : JSON.stringify(res.data);
      } catch (e: any) {
        this.error =
          e?.response?.data?.message ||
          e?.message ||
          "API呼び出しに失敗しました";
      } finally {
        this.loading = false;
      }
    },
    async fetchConfig() {
      this.loading = true;
      this.message = "";
      this.error = "";
      try {
        const res = await axios.get("/api/config/management");
        this.config = res.data;
      } catch (e: any) {
        this.error =
          e?.response?.data?.message ||
          e?.message ||
          "API呼び出しに失敗しました";
      } finally {
        this.loading = false;
      }
    },
  },
});
