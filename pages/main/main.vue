<template>
	<view class="max" >
		<Modal v-model="show" title='提示' text='要开始答题吗' @cancel='cancel' @confirm='confirm'/>
		<mpopup  ref="mpopup" :isdistance="false"></mpopup> 
		<view class="plus" v-show="legitimate">
		<view class="bk" >
			<text class='title'>答题({{info.number}}/{{info.max}})</text>
			<view class="line"></view>
			<view class="prompt">
				<view class="prompt-1">
				<text class="msg">加油哦～维护云村和平就靠你了！</text>
				<text class="msg" style="color: #0C73C2;">《警员手册》</text>
				</view>
				<view class="prompt-2">
					<img src="../../static/check.png"></img>
				</view>
			</view>
			<view class="line"></view>
			<view class="core">
				<text class="core-1" v-show="info.attitude">
					建议操作：
					<text class="attitudeDelete" v-show="info.attitudeDelete">删除</text>
					<text v-show='info.attitudeDelete'>（</text>
					{{info.suggest}}
					<text v-show='info.attitudeDelete'>）</text>
				</text>
				<text class="core-1" v-show="!info.attitude">
					原因：热门资源评论
				</text>
				<view class="line"></view>
				<view class="core-2">
					<view class="core-2-1">
						<svg class='svg-1' viewBox="0 0 42 42"><circle fill="none" stroke="#999" stroke-width="2" cx="21" cy="21" r="20"></circle><path fill="#999" d="m28.948 22.777l-9.832 6.617c-.916.617-2.159.374-2.776-.542-.221-.33-.34-.719-.34-1.117v-13.235c0-1.104.896-2 2-2 .398 0 .787.119 1.117.341l9.832 6.618c.917.617 1.159 1.86.542 2.776-.145.214-.329.398-.543.542"></path></svg>
						<text class="song">
							单曲「{{info.name}}」- {{info.singer}}
						</text>
					</view>
					<text class="core-2-2">
						<text v-show='info.reply'>回复： {{info.replyContent}}</text>
						<text v-show="!info.reply">{{info.content}}</text>
					</text>
					<view v-show='info.reply' class="core-2-2-1">
						<view class="core-2-2-1-text">{{info.content}}</view>
					</view>
					<text class="core-2-3">
						{{info.awesome}} 赞
					</text>
				</view>
			</view>
			<view class="line"></view>
		</view>
		<view class="bt" v-show='info.attitude'>
			<view class="bt-1" @click="send(info.id, 1)">
				<svg class="svg-2" viewBox="0 0 46 46"><g fill="#333"><path d="m23 46c-12.703 0-23-10.297-23-23 0-12.703 10.297-23 23-23 12.703 0 23 10.297 23 23 0 12.703-10.297 23-23 23m0-2c11.598 0 21-9.402 21-21 0-11.598-9.402-21-21-21-11.598 0-21 9.402-21 21 0 11.598 9.402 21 21 21"></path><path d="m19.808 31.778l15.556-15.557c.391-.39 1.024-.39 1.415 0 .391.391.391 1.024 0 1.415l-16.264 16.263c-.195.195-.451.293-.707.293s-.512-.098-.707-.293l-7.778-7.778c-.391-.391-.391-1.023 0-1.414.391-.391 1.024-.391 1.414 0l7.07 7.07"></path></g></svg>
				<text class='bt-1-1'>同意</text>
			</view>
			<span class="line" style="display: block;width: 1px;height: 50%;background-color: #ccc;"></span>
			<view class="bt-1" @click="send(info.id, 2)">
				<svg class="svg-2"  viewBox="0 0 46 46"><g fill="#333"><path d="m23 46c-12.703 0-23-10.297-23-23 0-12.703 10.297-23 23-23 12.703 0 23 10.297 23 23 0 12.703-10.297 23-23 23m0-2c11.598 0 21-9.402 21-21 0-11.598-9.402-21-21-21-11.598 0-21 9.402-21 21 0 11.598 9.402 21 21 21"></path><path d="m21.586 23l-8.485 8.485c-.391.391-.391 1.023 0 1.414s1.023.391 1.414 0l8.485-8.485 8.485 8.485c.391.391 1.023.391 1.414 0s.391-1.023 0-1.414l-8.485-8.485 8.485-8.485c.391-.391.391-1.023 0-1.414s-1.023-.391-1.414 0l-8.485 8.485-8.485-8.485c-.391-.391-1.023-.391-1.414 0-.391.391-.391 1.023 0 1.414l8.485 8.485"></path></g></svg>
				<text class='bt-1-1'>否决</text>
			</view>
		</view>
		<view class="line"></view>
		<view class="bt" v-show='!info.attitude'>
			<view class="bt-2" @click="send(info.id, 1)">
				<svg class="svg-2" viewBox="0 0 40 48"><g fill="#333"><path d="m16.589 31.23c.479.275.642.889.366 1.366l-8 13.855c-.276.479-.887.643-1.366.367-.479-.277-.642-.889-.366-1.367l8-13.854c.276-.478.887-.642 1.366-.367"></path><path d="m30.75 26.708l-17.322-10 8.5-14.723c.535-.921 1.812-1.265 2.733-.731l13.854 8c.955.551 1.284 1.776.733 2.731l-8.498 14.724m-14.589-10.733l13.858 8 7.5-12.99-13.856-8-7.502 12.99"></path><path d="m31.18 41.965l-31.18-18 .5-.866c2.807-4.861 8.08-7.763 14.12-7.763l.443.003 16.05 9.27.134.226c3.108 5.265 3.269 11.344.428 16.266l-.5.864m-28.412-18.713l27.646 15.961c1.94-4.049 1.677-8.872-.755-13.14l-15.14-8.741c-4.906.03-9.221 2.219-11.754 5.916"></path></g></svg>
				<text class='bt-1-1'>维持原样</text>
			</view>
			<span class="line" style="display: block;width: 1px;height: 50%;background-color: #ccc;"></span>
			<view class="bt-2" @click="send(info.id, 2)">
				<svg class="svg-2" viewBox="0 0 46 44"><path fill="none" stroke="#333" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" d="M23.05 35.619 9.485 42.75 12.08 27.645 1.101 16.947 16.268 14.743 23.05 1 29.834 14.743 45 16.947 34.02 27.645 36.616 42.75z"></path></svg>
				<text class='bt-1-1'>优质评论</text>
			</view>
			<span class="line" style="display: block;width: 1px;height: 50%;background-color: #ccc;"></span>
			<view class="bt-2" @click="deleteFUN()" v-show="info.delete">
				<svg class="svg-2" viewBox="0 0 44 46"><g fill="#c83b31"><path d="m1 8h42c.553 0 1 .448 1 1 0 .552-.447 1-1 1h-42c-.552 0-1-.448-1-1 0-.552.448-1 1-1"></path><path d="m15 15c.552 0 1 .448 1 1v22c0 .553-.448 1-1 1-.552 0-1-.447-1-1v-22c0-.552.448-1 1-1"></path><path d="m22 15c.553 0 1 .448 1 1v22c0 .553-.447 1-1 1-.552 0-1-.447-1-1v-22c0-.552.448-1 1-1"></path><path d="m29 15c.553 0 1 .448 1 1v22c0 .553-.447 1-1 1-.553 0-1-.447-1-1v-22c0-.552.447-1 1-1"></path><path d="m6 8h32v31c0 3.314-2.688 6-6 6h-20c-3.313 0-6-2.686-6-6v-31m2 0v31c0 2.209 1.791 4 4 4h20c2.209 0 4-1.791 4-4v-31h-28"></path><path d="m33 10h-22v-4c0-3.314 2.687-6 6-6h10c3.313 0 6 2.686 6 6v4m-2-2v-2c0-2.209-1.791-4-4-4h-10c-2.209 0-4 1.791-4 4v2h18"></path></g></svg>
				<text class='bt-1-1'>删除</text>
			</view>
			<view class="bt-2" @click="send(info.id, 3)" v-show="!info.delete">
				<svg class="svg-2" viewBox="0 0 46 46"><g fill="#333"><path d="m23 46c-12.703 0-23-10.297-23-23 0-12.703 10.297-23 23-23 12.703 0 23 10.297 23 23 0 12.703-10.297 23-23 23m0-2c11.598 0 21-9.402 21-21 0-11.598-9.402-21-21-21-11.598 0-21 9.402-21 21 0 11.598 9.402 21 21 21"></path><path d="m10 22h26c.553 0 1 .448 1 1 0 .553-.447 1-1 1h-26c-.552 0-1-.447-1-1 0-.552.448-1 1-1"></path></g></svg>
				<text class='bt-1-1'>取消热评</text>
			</view>
			
		</view>
		
		<vus-layer v-show="deleteMark">
			<!--slot(插槽)-->
			<view slot="drawer" class="deleteMain">
				<text class="deleteTitle">删除原因</text>
				<view class="deleteReason">
					<view class="deleteReason-1">
						<view class="item" @click="send(info.id, 11)"><span class="txt">政治敏感</span></view>
						<view class="item" @click="send(info.id, 12)"><span class="txt">营销广告</span></view>
						<view class="item" @click="send(info.id, 13)"><span class="txt">打卡盖楼</span></view>
						<view class="item" @click="send(info.id, 14)"><span class="txt">求赞求粉</span></view>
					</view>
					<view class="deleteReason-1">
						<view class="item" @click="send(info.id, 15)"><span class="txt">色情暴力</span></view>
						<view class="item" @click="send(info.id, 16)"><span class="txt">无意义内容</span></view>
						<view class="item" @click="send(info.id, 17)"><span class="txt">引战撕逼</span></view>
						<view class="item" @click="send(info.id, 18)"><span class="txt">段子及回复</span></view>
					</view>
				</view>
			</view>
		</vus-layer>

		
		</view>
		</view>
</template>

<script>
	import luButtonRipple from '@/components/lu-button-ripple/lu-button-ripple.vue';
	import {url} from '../../config/index.js'
	import mpopup from '../../components/xuan-popup/xuan-popup.vue'
	import Modal from '@/components/x-modal/x-modal'
	export default {
		components: { luButtonRipple, mpopup, Modal},
		data() {
			return {
				deleteMark:false,
				token: '',
				legitimate: false,
				show:false,
				info: {
					id:0,
					suggest:'',
					name:'',
					singer:'',
					content:'',
					awesome:0,
					number:0,
					attitude:false,
					attitudeDelete:true,
					delete:false,
					max:0,
					reply:true,
					replyContent:''
				}
			}
		},
		onLoad() {
			uni.getStorage({
				key: 'token',
				success: (res) => {
					const token = res.data
					uni.request({
						url: url + '/token',
						method: 'GET',
						data: {token:token},
						success: (res) => {
							const resp = res.data
							if(resp.code == 400){
								uni.redirectTo({
									url: '../index/index'
								})
							}
							this.token = token
							if(resp.code == 200){
							
							this.show = true
							
						}
						if(resp.code == 2000){
							const sendData = {
								token: this.token,
								id:0,
								answer:0
							}
							uni.request({
								url: url + '/answer',
								method:'POST',
								header: {'content-type': 'application/x-www-form-urlencoded'},
								data: sendData,
								success:(res) => {
									if(res.data.code == 200) {
										this.info = res.data.info
										this.legitimate = true
									}
									else {
										this.keySet('error')
										uni.redirectTo({
											url: '../index/index'
										})
										}
										}
										})
									}
								}
								})
							
						}
						
					})
				},
		methods: {
			keySet(e) {
				uni.setStorage({
					key:'info',
					data:e
				})
			},
			confirm() {
				const sendData = {
					token: this.token,
					id:0,
					answer:0
				}
				uni.request({
					url: url + '/answer',
					method:'POST',
					header: {'content-type': 'application/x-www-form-urlencoded'},
					data: sendData,
					success:(res) => {
						if(res.data.code == 200) {
							this.info = res.data.info
							this.legitimate = true
						}
						else {
							this.keySet('error')
							uni.redirectTo({
								url: '../index/index'
							})
						}
					},
					})
			},
			cancel() {
				uni.redirectTo({
					url: '../index/index'
				})
			},
				
			deleteFUN() {
				this.deleteMark = true
				this.vusui.drawer('bottom') //下弹出
			},
			send(id, answer) {
				const sendData = {
					token: this.token,
					id,
					answer
				}
				uni.request({
					url: url + '/answer',
					method:'POST',
					header: {'content-type': 'application/x-www-form-urlencoded'},
					data: sendData,
					success: (res) => {
						const resp = res.data
						if(resp.code == 200) {
							if(resp.end) {
								this.keySet('over')
								uni.redirectTo({
									url: '../index/index'
								})
								}
							this.info = resp.info
							this.deleteMark = false
							this.$refs.mpopup.open({
							                type:'success',
							                content:'提交成功',
							                timeout:1000
							            });
						}
						else {
								this.keySet('error')
								uni.redirectTo({
									url: '../index/index'
								})
						}
					}
				})
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
	.attitudeDelete {
		color: #D33A31;
	}
	.deleteReason-1 {
		margin: 0px 7px;
		display: flex;
		flex-direction: column;
		width: 50%;
		align-items: center;
	}
	.txt {
		font-size: 15px;
		color: #333333;
		text-align: center;
		cursor: pointer;
	}
	.item {
		padding: 5px;
		margin-bottom: 10px;
		width: 100%;
		border-width: 1px;
		border-radius: 35px;
		border-style:solid;
		border-color: #c9caca;
	}
	.deleteReason {
		display: flex;
	}
	.deleteMain {
		display: flex;
		flex-direction: column;
		height: 100%;
	}
	.deleteTitle {
		padding: 15px 0px;
		color: #333333;
		font-size: 15px;
		text-align: center;
	}
	.bt-1-1 {
		margin-top: 3px;
		color: #666666;
		font-size: 12px;
	}
	.svg-2 {
		width: 25px;
		height: 25px;
	}
	.bt-1 {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		width: 50%;
	}
	.bt-2 {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		width: 33%;
	}
	.plus {
		position: absolute;
		display: flex;
		flex-direction: column;
		width: 100%;
		height: 100%;
	}
	.bt {
		display: flex;
		flex-direction: row;
		align-items: center;
		width: 100%;
		height: 13%;
	}
	.bottom-1 {
		width: 50%;
		color: #666666;
		font-size: 20px;
	}
	.bottom {
		display: flex;
		flex-direction: row;
		background-color: #FFFFFF;
		width: 100%;
		height: 50%;
	}
	.core-2-3 {
		margin-top: 25px;
		text-align: right;
		font-size: 13px;
		color: #999999;
		margin-right: 20px;
	}
	.core-2-2 {
		word-break:break-all;
		line-height: 25px;
		margin-top: 8px;
		margin-left: 20px;
		margin-right: 20px;
		color: #333333;
		font-size: 15px;
		text-align: left;
	}
	.core-2-2-1 {
		border-style: solid;
		border-color: rgb(102,102,102,.1);
		border-width: 1px;
		word-break:break-all;
		line-height: 20px;
		margin-top: 8px;
		margin-left: 20px;
		margin-right: 20px;
		color: #666666;
		font-size: 13px;
		text-align: left;
	}
	.core-2-2-1-text {
		margin: 5px 10px;
	}
	.song {
		width: 100%;
		margin: 0px 20px;
		color: #888888;
		font-size: 13px;
	}
	.svg-1 {
		width: 20px;
		height: 20px;
	}
	.core-2-1 {
		display: flex;
		flex-direction: row;

		align-items: flex-start;
		margin-top: 20px;
		margin-left: 20px;
		text-align: left;
	}
	.prompt {
		display: flex;
		flex-direction: row;
		justify-content: flex-start;
		width: 100%;
		height: 65px;
	}
	.prompt-1 {
		display: flex;
		justify-content: flex-start;
		flex-direction: column;
		width: 70%;
		background-color: #FFFFFF;
	}
	.prompt-2 {
		width: 30%;
		background-color: #FFFFFF;
	}
	img {
		width: auto;  
		height: auto; 
		max-width: 100%;  
		max-height: 100%;
	}
	.msg {
		margin-left: 20px;
		margin-top: 7px;
		height: 50%;
		color: #888888;
		font-size: 13px;
		text-align: left;
	}
	
	.line {
		height: 1px;
		width: 100%;
		background-color: #E5E5E5;
	}
	
	.bk {
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
		background-color: #F6F7F8;
		height: 87%;
	}
	.title {
		height: 30px;
		padding-top: 10px;
		font-size: 15px;
		background-color: #FFFFFF;
		width: 100%;
	}
	.core {
		padding-bottom: 20px;
		margin-top: 10px;
		display: flex;
		flex-direction: column;
		width: 100%;
		background-color: #FFFFFF;
	}
	.core-1 {
		display: flex;
		flex-direction: column;
		justify-content: center;
		margin-top: 12px;
		padding-left: 20px;
		margin-bottom: 12px;
		text-align: left;
		height: 30px;
		font-size: 15px;
	}
	.core-2 {
		display: flex;
		flex-direction: column;
	}
</style>
