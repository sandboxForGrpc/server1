// demo/frontend/src/lib/api.ts
import axios from 'axios'
export const api = axios.create({ baseURL: '/api', timeout: 10000 })
