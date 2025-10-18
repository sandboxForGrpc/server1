import axios from 'axios'

export const http = axios.create({
  baseURL: '',          // 同一オリジンなら空でOK（/api配下をそのまま叩く）
  timeout: 30_000,
})