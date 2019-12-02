<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="欢迎登录" :bordered="false">
        <div class="form-con">					
          <login-form @on-success-valid="handleSubmit"></login-form>
					<p class="login-tip">{{errorMessage}}</p>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
import LoginForm from '_c/login-form'
import { mapActions } from 'vuex'
export default {
	data: function() {
		return {
					errorMessage: ''
		}
	},
  components: {
    LoginForm
  },
  methods: {
    ...mapActions([
      'handleLogin',
      'getUserPermission'
    ]),
    handleSubmit ({ userName, password }) {
			const _this = this;
      this.handleLogin({ userName, password }).then(res => {
				if(res && res.result != 0){
					_this.errorMessage = res.message;
				}else{
					this.getUserPermission().then(res => {
					  this.$router.push({
					    name: this.$config.homeName
					  })
					})
				}
      })
    }
  }
}
</script>

<style>

</style>
