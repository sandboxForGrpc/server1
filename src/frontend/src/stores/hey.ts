// demo/frontend/src/stores/hello.ts
import { defineStore } from 'pinia'
import { api } from '../lib/api'

export const useHeyStore = defineStore('hey', {
  state: () => ({
    message: '' as string,
    loading: false as boolean,
    error: '' as string
  }),
  actions: {
    async fetchHey() {
      this.loading = true
      this.error = ''
      try {
        const res = await api.get<string>('/hey')
        this.message = res.data
      } catch (e: any) {
        this.error = e?.message ?? 'failed'
      } finally {
        this.loading = false
      }
    },
  },
  persist: true,// localStorage に保存
})
