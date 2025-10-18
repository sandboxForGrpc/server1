// src/stores/upload.ts
import { defineStore } from 'pinia'
import { ref } from 'vue'
import { http } from '../lib/http'

export const useUploadStore = defineStore('upload', () => {
  const file = ref<File | null>(null)
  const uploading = ref(false)
  const progress = ref(0)        // 0-100
  const message = ref<string>('')
  const error = ref<string>('')

  function setFile(f: File | null) {
    file.value = f
    message.value = ''
    error.value = ''
    progress.value = 0
  }

  function reset() {
    setFile(null)
    uploading.value = false
  }

  // 必要に応じてバリデーションを調整
  function validate(f: File) {
    if (!f.type.startsWith('text/')) {
      throw new Error('テキストファイル（.txt 等）を選択してください')
    }
    const maxBytes = 2 * 1024 * 1024 // 2MB
    if (f.size > maxBytes) {
      throw new Error('ファイルサイズが大きすぎます（最大 2MB）')
    }
  }

  async function upload() {
    if (!file.value) {
      error.value = 'ファイル未選択'
      return
    }
    try {
      validate(file.value)
    } catch (e: any) {
      error.value = e.message ?? '不正なファイルです'
      return
    }

    const form = new FormData()
    form.append('file', file.value)

    uploading.value = true
    progress.value = 0
    message.value = ''
    error.value = ''

    try {
      const res = await http.post('/api/upload', form, {
        headers: { 'Content-Type': 'multipart/form-data' },
        onUploadProgress(e) {
          if (e.total) progress.value = Math.round((e.loaded / e.total) * 100)
        },
        // withCredentials: true, // クロスオリジンでCookieが必要なら
      })
      message.value = String(res.data ?? 'アップロード完了')
    } catch (e: any) {
      error.value = e?.response?.data ?? e?.message ?? 'アップロードに失敗しました'
    } finally {
      uploading.value = false
    }
  }

  return { file, uploading, progress, message, error, setFile, reset, upload }
})
