<template>
    <div align="center">
        <admin-setup-form @submit="onSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import AdminSetupForm from '@/components/AdminSetupForm.vue'
export default {
    name: 'AdminSetupPage',
    components: {
        AdminSetupForm
    },
    methods: {
        onSubmit (payload) {
            console.log('payload: ' + payload.userId +
                ', ' + payload.userPw +
                ', ' + payload.userName)
            const { userId, userPw, userName } = payload
            axios.post('http://localhost:7777/users/setup',
                { userId, userPw, userName })
                .then(res => {
                    alert('Register Success' + res)
                    this.$router.push({
                        name: 'Home'
                    })
                })
                .catch(err => {
                    alert(err.response.data)
                })
            },

        }
    }
</script>