
const aliasFun = function alias(declare, delete_, id) {
	if(declare) {
		if(id == 1) {
			return '同意'
		}
		else {
			return '否决'
		}
	}
	else {
		if(!delete_) {
			switch(id) {
				case 1: return '维持'
						break;
				case 2: return '优质评论'
						break;
				case 3: return '取消热评'
						break;
			}
		}
		else {
			switch(id) {
				case 1: return '维持'
						break;
				case 2: return '优质评论'
						break;
				case 11: return '政治敏感'
						break;
				case 12: return '营销广告'
						break;
				case 13: return '打卡盖楼'
						break;
				case 14: return '求赞求粉'
						break;
				case 15: return '色情暴力'
						break;
				case 16: return '无意义内容'
						break;
				case 17: return '引战撕逼'
						break;
				case 18: return '段子及回复'
						break;
			}
		}
	}
	
}

export default aliasFun