<template>
	<view class="max">
		<view class="content">
		<mpopup  ref="mpopup" :isdistance="false"></mpopup> 
			<vus-layer></vus-layer>
			<image src="../../static/logo.png" 
			class="logo"></image>
			<input focus=true 
			class="u-input  u-btn-input"
			placeholder="输入警号"
			v-model="policeID"
			/>
			<button class="login" @click="loginFun()">
			出发ヽ(✿ﾟ▽ﾟ)ノ
			</button>

		</view>
	</view>
</template>

<script>
	import { url } from '../../config/index.js'
	import mpopup from '../../components/xuan-popup/xuan-popup.vue'
	export default {
		components: { mpopup},
		data() {
			return {
				policeID:''
			}
		},
		onShow(){
			if(this.$refs.mpopup != undefined)
			{
				this.info()
			}
		},
		methods: {
			info() {
				uni.getStorage({
					key:'info',
					success:(res) => {
						const resp = res.data
						if(resp == 'error') {
							this.$refs.mpopup.open({
							                type:'err',
							                content:'身份信息失效',
							                timeout:2500
							            });
						}
						if(resp == 'over') {
							this.$refs.mpopup.open({
							                type:'success',
							                content:'恭喜，已完成所有题目！',
							                timeout:5000
							            });
						}
					}
				})
				
			},
			loginFun() {
				const policeID = this.policeID
				if (policeID) {
					uni.request({
						url:url + '/login',
						method:'GET',
						data:{id:policeID},
						success: (res) => {
							const resp = res.data
							if(resp.code == 400) {
								this.vusui.msg('用户不存在')
							}
							if(resp.code == 600) {
								this.vusui.msg('已经答过卷啦')
							}
							if(resp.code == 200) {
								uni.setStorage({
									key: 'token',
									data: resp.token
								})
								uni.redirectTo({
									url: '../main/main'
								})
							}
						}
					})
				}
			}
			
		}
	}
</script>

<style scoped>
	html,body{
	  overflow: hidden;
	  height: 100%;
	  width: 100%;
	}
	.login {
		margin-top: 10px;
	    font-size: 13px;
	    text-align: center;
	    box-sizing: border-box;
	    display: block;
	    width: 200px;
	    height: 35px;
	    margin-bottom: 15px;
	    line-height: 35px;
	    border-radius: 40px;
	    background: #d33a31;
	    color: #fff;
	}
	
	.logo {
		width: 400px;
		height: 220px;
	}
	.u-input {
	    height: 30px;
	    line-height: 30px;
	    padding: 0 6px;
	    border: 5px;
	    background-color: #fff;
	    text-align: center;
	    box-sizing: border-box;
	    border-bottom: 1px solid #adadad;
	    border-top: 1px solid #adadad;
	}
	.u-btn-input {
		border-color: #d33a31;
	    width: 200px;
		margin-top: 30px;
	    margin-bottom: 30px;
	    border-radius: 10px;
		font-size: 13px;
	}

	
</style>
