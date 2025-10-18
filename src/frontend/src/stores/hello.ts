// demo/frontend/src/stores/hello.ts
import { defineStore } from 'pinia'
import { api } from '../lib/api'

export const useHelloStore = defineStore('hello', {
  state: () => ({
    message: '' as string,
    loading: false as boolean,
    error: '' as string
  }),
  actions: {
    async fetchHello() {
      this.loading = true
      this.error = ''
      try {
        const res = await api.get<string>('/hello')
        this.message = res.data
      } catch (e: any) {
        this.error = e?.message ?? 'failed'
      } finally {
        this.loading = false
      }
    },
  },
})
