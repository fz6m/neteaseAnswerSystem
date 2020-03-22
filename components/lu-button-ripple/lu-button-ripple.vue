<template>
	<view :id="'buttonRipple'+buttonRippleId" class="lu-button-ripple"
		@tap="_tap">
		<view class="button-content"><slot></slot></view> 
		<view class="ripple-cell"
			v-for="item in rippleList"
			:key="item.rippleId"
			:id="item.rippleId"
			:style="{ width: item.width + 'px', height: item.width + 'px', left: item.left + 'px', top: item.top + 'px','backgroundColor':rippleBackgroundColor,'opacity':rippleOpacity}"
			:class="[item.startAnimate ?'ripple-animation' : '']"
		></view>
	</view>
</template>

<script>
export default {
	name: 'lu-button-ripple',
	props:{
		buttonRippleId:{
			type:[String,Number],
		},
		rippleBackgroundColor:{
			type:String,
			default:"#999"
		},
		rippleOpacity:{
			type:Number,
			default:1
		}
	},
	data() {
		return {
			rippleList: [],
			rippleId: 0,
		};
	},
	methods: {
		_tap(e) {
			this._queryMultipleNodes("#buttonRipple"+this.buttonRippleId).then(res => {
				const button = res[0],
					viewPort = res[1];
				const boxWidth = parseInt(button.width); // button的宽度
				const boxHeight = parseInt(button.height); // button的长度
				const rippleWidth = boxWidth > boxHeight ? boxWidth : boxHeight;
				const rippleX = parseInt(e.touches[0].clientX)- button.left - rippleWidth / 2;
				const rippleY = parseInt(e.touches[0].clientY) - button.top - rippleWidth / 2;
				this.rippleList.push({
					rippleId: `rippleCell-${this.buttonRippleId}-${this.rippleId++}`,
					width: rippleWidth,
					left: rippleX,
					top: rippleY,
					startAnimate: true
				});
			});
			if (this.timer) {
				clearTimeout(this.timer);
				this.timer = setTimeout(this._deleteRipple, 300);
			} else {
				this.timer = setTimeout(this._deleteRipple, 300);
			}
			this.$emit("rippleTap",this.buttonRippleId);
		},
		_queryMultipleNodes(e) {
            return new Promise((resolve, reject) => {
                let view = uni.createSelectorQuery().in(this);
                view.select(e).boundingClientRect();
                view.selectViewport().scrollOffset();
                view.exec(function (res) {
                    resolve(res);
                });
            })
        },
		_deleteRipple() {
			this.rippleList = [];
			clearTimeout(this.timer);
			this.timer = null;
		}
	}
};
</script>

<style lang="scss">
/* #ifndef H5 */

lu-button-ripple {
	position: absolute;
	width: 100%;
	height:100%;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	overflow: hidden;
	z-index: 0;
	display: flex;
	flex-flow: row wrap;
	justify-content: center;
	align-items: center;
}
/* #endif */
.lu-button-ripple{
	position: absolute;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	overflow: hidden;
	z-index: 0;
	display: flex;
	flex-flow: row wrap;
	justify-content: center;
	align-items: center;
	.button-content{
		display: flex;
		flex-flow: row wrap;
		justify-content: center;
		align-items: center;
		z-index: 1;
	}
	.ripple-cell {
		border-radius: 100%;
		background-color: rgba(#999,0.5);
		left: 0px;
		top: 0px;
		opacity: 1;
		transform: scale(1);
		width: 10px;
		height: 10px;
		position: absolute;
		z-index: 0;
	}
	.ripple-animation {
		animation: ripple 0.25s linear;
		animation-fill-mode: forwards;
	}
}



@keyframes ripple {
	0% {
		transform: scale(0);
	}
	50% {
		transform: scale(0.5);
	}
	100% {
		transform: scale(1);
		opacity: 0;
	}
}

</style>
