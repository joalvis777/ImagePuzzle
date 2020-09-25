<template>
    <div class="vue-template">
        <form @submit.prevent="submit">
            <h3>REGISTER</h3>
            <div class="form-group">
                <label>U S E R - I D</label>
                <input type="text" v-model="userId" class="form-control form-control-lg"/>
            </div>

            <div class="form-group">
                <label>P A S S W O R D</label>
                <input type="password" v-model="userPw" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>N I C K N A M E</label>
                <input type="text" v-model="userName" class="form-control form-control-lg" />
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block">R E G I S T E R</button>
        </form>
    </div>
</template>

<script>

export default {
    name: 'AdminSetupForm',
    data () {
        return {
            userId: '',
            userPw: '',
            userName: ''
        }
    },
    methods: {
        submit () {
            console.log('this: ' + this.userId +
                ', ' + this.userPw +
                ', ' + this.userName)
            const { userId, userPw, userName } = this
            this.$emit('submit', { userId, userPw, userName })
        }
    }
}
</script>