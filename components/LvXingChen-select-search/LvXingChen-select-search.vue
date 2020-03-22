<template>
	<view style="position: relative;">
		<view class="uni-flex" :class="{unishadow :uniShadow}">
			<view class="uni-search-form uni-circular uni-background">
				<icon type="search" size="18" class="uni-icon-position"/>
				<input type="text" :placeholder="placeholder" v-model="inputVal" @input="onInput"
				 @blur="onBlur"></input>
			</view>
			<view class="uni-action">
				<button 
					:disabled="loading" 
					class="uni-cu-btn uni-bg-gradual-green uni-shadow-blur uni-round" 
					:class="[type === 'primary' ? 'uni-primary' : (type === 'success' ? 'uni-success' : (type === 'warning' ? 'uni-warning' : 'uni-error'))]" 
					hover-class="hover" 
					@click="handleSearch"
				>搜索</button>
			</view>
		</view>
		<view class="uni-combox__selector" v-if="inputIsShow">
			<scroll-view scroll-y="true" class="uni-combox__selector-scroll">
				<view class="uni-combox__selector-empty " v-if="loading">
					<view>加载中··· </view>
				</view>
				<view class="uni-combox__selector-empty " v-if="!loading && dataListLength === 0" @click="closeDielog">
					<view>{{emptyTips}}</view>
				</view>
				<view class="uni-combox__selector-item" v-for="(item,index) in dataList" :key="index" @click="onSelectorClick(index)">
					<text>{{item[showValue]}}</text>
				</view>
			</scroll-view>
		</view>
	</view>
</template>
<script>
	export default {
		name: 'select',
		props: {
			placeholder: {
				type: String,
				default: '请输入信息'
			},
			infoList: {
				type: Array,
				default () {
					return []
				}
			},
			value: {
				type: String,
				default: ''
			},
			showValue: {
				type: String,
				default: 'name'
			},
			emptyTips: {
				type: String,
				default: '暂无数据'
			},
			loading: {
				type: Boolean,
				default: false
			},
			btnStyleColor: {
				type: Object,
				default() {
					return {}
				}
			},
			uniShadow: {
				type: Boolean,
				default: true
			},
			type: {
				type: String,
				default: 'primary'
			}
		},
		data() {
			return {
				inputIsShow: false,
				inputVal: '',
				dataList: []
			}
		},
		computed: {
			dataListLength() {
				return this.dataList.length
			}
		},
		watch: {
			value: {
				handler(newVal) {
					this.inputVal = newVal
				},
				immediate: true
			},
			infoList: {
				handler(newVal) {
					this.dataList = newVal
				},
				immediate: true
			}
		},
		methods: {
			closeDielog() {
				this.inputIsShow = false
			},
			onBlur() {
				setTimeout(() => {
					this.inputIsShow = true
				},50)
			},
			onSelectorClick(index) {
				this.inputVal = this.dataList[index][this.showValue]
				this.inputIsShow = false
				this.$emit('input', this.inputVal)
				this.$emit('change', this.dataList[index])
			},
			onInput() {
				setTimeout(() => {
					this.$emit('input', this.inputVal)
				})
			},
			handleSearch() {
				this.inputIsShow = true
				this.$emit('handleSearch')
				console.log('dom', document)
			}
		}
	}
</script>
<style lang="scss" scoped>
	$selectWidth: 75%; // 下拉选择框宽度
	.uni-primary {
		background-color: $uni-color-primary;
	}
	.uni-success {
		background-color: #67c23a;
	}
	.uni-warning {
		background-color: $uni-color-warning;
	}
	.uni-error {
		background-color: $uni-color-error;
	}
	.hover{
		transition: all .6s;
		transform: scale(0.8,0.8);
	}
	.uni-flex{
		width: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.unishadow{
		padding: 8rpx 0rpx;
		box-shadow: 0rpx 1rpx 5rpx #DDDDDD;
	}
	.uni-search-form{
		position: relative;
		width: 60%;
		margin: 10rpx;
		padding: 10rpx 30rpx 10rpx 80rpx;
		font-size: 30rpx;
		color: #999999;
	}
	.uniRound{
		border-radius: 5px;
	}
	.uni-circular{
		border-radius: 100rpx;
	}
	.uni-icon-position{
		position: absolute;
		top: 50%;
		left: 26rpx;
		transform: translate(0,-50%);
	}
	.uni-background{
		background-color: #F5F5F5;
	}
	/* button */
	.uni-action{
		width:120rpx;
		height: 66rpx; 
	}
	.uni-cu-btn{
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
		color: #FFFFFF;
		font-size: 28rpx;
		border: none;
		// background-color: $uni-color-primary;
	}
	.uni-shadow-blur{
		box-shadow: 0rpx 1rpx 10rpx #C8C7CC;
	}
	.uni-round{
		border-radius: 100rpx;
	}
	.uni-combox__selector {
		position: absolute;
		top: 100rpx;
		left: 40rpx;
		box-sizing: border-box;
		width: $selectWidth;
		background-color: #FFFFFF;
		border-radius: 6px;
		box-shadow: #DDDDDD 4px 4px 8px, #DDDDDD -4px -4px 8px;
		z-index: 2;
	}
	.uni-combox__selector-scroll {
		max-height: 200px;
		box-sizing: border-box;
	}
	.uni-combox__selector::before {
		content: '';
		position: absolute;
		width: 0;
		height: 0;
		border-bottom: solid 6px #FFFFFF;
		border-right: solid 6px transparent;
		border-left: solid 6px transparent;
		left: 50%;
		top: -6px;
		margin-left: -6px;
	}
	.uni-combox__selector-empty{
		text-align: center;
		color: #8F8F94;
		padding: 20rpx 0;
		font-size: 28rpx;
	}
	.uni-combox__selector-item {
		/* #ifdef APP-NVUE */
		display: flex;
		/* #endif */
		font-size: 24rpx;
		margin: 0px 10px;
		padding: 20rpx 10rpx;
		color: #808080;
	}
	.uni-combox__selector-item:hover {
		background-color: #DDDDDD;
	}
	.uni-combox__selector-empty:last-child,
	.uni-combox__selector-item:last-child {
		border-bottom: none;
	}
</style>