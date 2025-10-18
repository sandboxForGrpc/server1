import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueJsx()],
  server: {
    port: 5173,
    proxy: {
      // ここが重要：/api を 8080 へ
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
        // 付けても付けなくてもOK（今回は不要）
        // rewrite: (path) => path,
      },
    },
  },
})