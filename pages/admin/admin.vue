<template>
	<view class="content">
	<view class="head-list">
        <xfl-select 
            :list="users"
            :clearable="false"
            :showItemNum="6" 
            :isCanInput="false"  
            :style_Container="'height: 50px; font-size: 16px;'"
            :selectHideType="'hideAll'" 
			@change = 'change'
        >
        </xfl-select>
    </view>
	<view class="speed-progress">
<cmd-progress :success-percent="Math.round(100*(correct/max))"
 :percent="Math.round(100*(correct/max))" :stroke-width="10"></cmd-progress>
	</view>
	<view class="statistics">
		总数：{{max}} | 正确：{{correct}} | 错误：{{error}}
	</view>
	<view v-for="(i,key) in errorList" :key='key' class="info">
		编号 {{i.id}} : 
		<view v-show="i.reply" style="display: flex;flex-direction: column;width: 100%;">
		<text>回复： {{i.replyContent}}</text>
		<text class="reply-1">{{i.content}}</text>
		</view>
		<text v-show="!i.reply">{{i.content}}</text>
		<text>正确：{{alias(i.attitude, i.delete, i.rawAnswer)}}</text>
		<text>错选：{{alias(i.attitude, i.delete, i.answer)}}</text>
	</view>
	</view>
</template>

<script>
	import alias from '@/config/alias.js'
	import { url } from '../../config/index.js'
	import xflSelect from '../../components/xfl-select/xfl-select.vue'; 
	import cmdProgress from "@/components/cmd-progress/cmd-progress.vue"
	export default {
		components: {cmdProgress, xflSelect},
		data() {
			return {
				error:0,
				val:0,
				correct:0,
				max:0,
				errorList:[],
				users:[]
			}
		},
		/* 				list: [       //要展示的数据
						                '苹果',
						                {value: '香蕉', disabled: true},
						                '葡萄',
						                '芒果',
						                '大白菜',
						            ] */
		methods: {
			alias,
			change(e){
				this.val = Number(e.newVal)
				uni.request({
					url: url + '/stata',
					method:'GET',
					data: {id:this.val},
					success: (res) => {
						const resp = res.data
						if(resp.code == 200) {
							this.users = resp.users
							this.errorList = resp.error
							this.correct = resp.correct
							this.max = resp.max
							this.error = this.max - this.correct
						}
						else {
							this.vusui.msg('获取失败')
						}
					}
				})
			}
		},
		onLoad() {
			uni.request({
				url: url + '/stata',
				method:'GET',
				data: {id:this.val},
				success: (res) => {
					const resp = res.data
					if(resp.code == 200) {
						this.users = resp.users
						this.errorList = resp.error
						this.correct = resp.correct
						this.max = resp.max
						this.error = this.max - this.correct
					}
					else {
						this.vusui.msg('获取失败')
					}
				}
			})
		}
	}
</script>

<style scoped>
	.reply-1 {
		border-style: solid;
		border-width: 1px;
		border-color: rgb(102,102,102,.1);
		font-size: 12px;
		margin: 2px;
		padding: 0px 5px;
		color: #666666;
	}
	.content {
		position: absolute;
	}
	.statistics {
		padding: 7px;
		font-size: 15px;
		color: #2C405A;
	}
	.info {
		border-radius: 20px;
		border-width: 2px;
		border-color: #888888;
		border-style: dotted ;
		margin: 10px;
		word-break:break-all;
		display: flex;
		flex-direction: column;
		padding: 10px;
		font-size: 14px;
		line-height: 25px;
		align-items: flex-start;
		width: 80%;
	}
	.head-list {
		width: 80%; 
		margin-top: 30px;
		margin-bottom: 20px;
	}
	.speed-progress {
		width: 80%;
	}
</style>
