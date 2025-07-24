import {defineStore} from "pinia";

export const useSearchStore = defineStore('search', {
    state: () => ({
        keyword: ''
    }),
    actions: {
        setKeyword(value: string) {
            this.keyword = value

        }
    }
})