<template>
    <div class="vue-template">
        <form @submit.prevent="submit">
            <h3>LOGIN</h3>
            <div class="form-group">
                <label>U S E R - ID</label>
                <input type="text" class="form-control form-control-lg " v-model="userId" />
            </div>

            <div class="form-group">
                <label>P A S S W O R D</label>
                <input type="password" class="form-control form-control-lg" v-model="userPw"  />
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block">L O G I N</button>
        </form>
    </div>
</template>

<script>
export default {
    name: 'LoginForm',
    data () {
        return {
            userId: '',
            userPw: ''
        }
    },
    methods: {
        submit () {
            console.log('LoginForm submit()')
            const { userId, userPw } = this
            this.$emit('submit', { userId, userPw })
        }
    }
}
</script>
