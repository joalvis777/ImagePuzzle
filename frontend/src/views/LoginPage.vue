<template>
    <div align="center">
        <login-form @submit="onSubmit"/>
    </div>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import axios from 'axios'
import { mapActions } from 'vuex'

export default {
    name: 'LoginPage',
    components: {
        LoginForm
    },
    methods: {
        ...mapActions(['saveId']),
        onSubmit (payload) {
        console.log('id : ' + payload.userId)
        console.log('pw : ' + payload.userPw)

        axios.post('http://localhost:7777/login',
            payload)
            .then(res => {
                if(res.status === 200) {
                    console.log(res)
                    alert('LOGIN SUCCESS')
                    this.$router.push({
                        name: 'Home'
                    })
                    console.log('id = ' + res.data.userId)
                    this.saveId(res.data.userId)
                } else {
                    alert('LOGIN FAILED')
                }
            })
            .catch(err => {
                console.log(err)
                alert('LOGIN FAIL')
            })
        },
        ...mapActions([ 'login' ])
    }
}
</script>