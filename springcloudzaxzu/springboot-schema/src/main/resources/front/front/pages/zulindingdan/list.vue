<template>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view :style='{"width":"100%","padding":"0","position":"relative","background":"#EAF2FF","height":"auto"}'>
			<view class="cu-bar bg-white search" style="width:100%" :style="[{top:CustomBar + 'px'}]">
				<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
					<view><image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image></view>
				</picker>
					<view v-if="queryIndex==0" class="search-form round">
						<text class="cuIcon-search"></text>
						<input v-model="searchForm.xingming" type="text" placeholder="姓名" ></input>
					</view>
				<view class="action">
					<button @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			</view>
			<view :style='{"width":"100%","background":"#fff","height":"auto"}'>

			
			
			
			
			<!-- 样式5 -->
			<view class="list-box6" :style='{"padding":"24rpx","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<block v-for="(list,indexOut) in lists" :key="indexOut">
				<block v-for="(product,index) in list" :key="index">
				<view @tap="onDetailTap(product)" v-if="index%6==0" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"0 0 20rpx","backgroundColor":"#fff","overflow":"hidden","borderRadius":"30rpx","width":"48%","height":"auto"}'>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-if="preHttp(product.fengmian)" :src="product.fengmian"></image>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
				  <view :style='{"padding":"4rpx 20rpx","margin":"10rpx 0 0 0","overflow":"hidden","color":"#333","width":"100%","lineHeight":"40rpx","fontSize":"28rpx","height":"100rpx"}' class="title">{{product.chepaihao}}</view>
				  <view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"6rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','修改')) || (!userid && isAuthFront('zulindingdan','修改'))" @click.stop="onUpdateTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
				  	</view>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','删除')) || (!userid && isAuthFront('zulindingdan','删除'))" @click.stop="onDeleteTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
				  	</view>
				  </view>
				</view>
				<view @tap="onDetailTap(product)" v-if="index%6==1" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"0 0 20rpx","backgroundColor":"#fff","overflow":"hidden","borderRadius":"30rpx","width":"48%","height":"auto"}'>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-if="preHttp(product.fengmian)" :src="product.fengmian"></image>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
				  <view :style='{"padding":"4rpx 20rpx","margin":"10rpx 0 0 0","overflow":"hidden","color":"#333","width":"100%","lineHeight":"40rpx","fontSize":"28rpx","height":"100rpx"}' class="title">{{product.chepaihao}}</view>
				  <view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"6rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','修改')) || (!userid && isAuthFront('zulindingdan','修改'))" @click.stop="onUpdateTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
				  	</view>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','删除')) || (!userid && isAuthFront('zulindingdan','删除'))" @click.stop="onDeleteTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
				  	</view>
				  </view>
				</view>
				<view @tap="onDetailTap(product)" v-if="index%6==2" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"0 0 20rpx","backgroundColor":"#fff","overflow":"hidden","borderRadius":"30rpx","width":"48%","height":"auto"}'>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-if="preHttp(product.fengmian)" :src="product.fengmian"></image>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
				  <view :style='{"padding":"4rpx 20rpx","margin":"10rpx 0 0 0","overflow":"hidden","color":"#333","width":"100%","lineHeight":"40rpx","fontSize":"28rpx","height":"100rpx"}' class="title">{{product.chepaihao}}</view>
				  <view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"6rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','修改')) || (!userid && isAuthFront('zulindingdan','修改'))" @click.stop="onUpdateTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
				  	</view>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','删除')) || (!userid && isAuthFront('zulindingdan','删除'))" @click.stop="onDeleteTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
				  	</view>
				  </view>
				</view>
				<view @tap="onDetailTap(product)" v-if="index%6==3" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"0 0 20rpx","backgroundColor":"#fff","overflow":"hidden","borderRadius":"30rpx","width":"48%","height":"auto"}'>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-if="preHttp(product.fengmian)" :src="product.fengmian"></image>
				  <image :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"block","height":"220rpx"}' mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
				  <view :style='{"padding":"4rpx 20rpx","overflow":"hidden","color":"#333","width":"100%","lineHeight":"40rpx","fontSize":"28rpx","height":"100rpx"}' class="title">{{product.chepaihao}}</view>
				  <view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"6rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','修改')) || (!userid && isAuthFront('zulindingdan','修改'))" @click.stop="onUpdateTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
				  	</view>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','删除')) || (!userid && isAuthFront('zulindingdan','删除'))" @click.stop="onDeleteTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
				  	</view>
				  </view>
				</view>
				
				<view @tap="onDetailTap(product)" v-if="index%6==4" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"10rpx 20rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
				  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"200rpx"}' mode="aspectFill" v-if="preHttp(product.fengmian)" :src="product.fengmian"></image>
				  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"200rpx"}' mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
				  <view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","overflow":"hidden","position":"relative","height":"200rpx"}'>
					<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","color":"#333","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="title">{{product.chepaihao}}</view>
				  </view>
				  <view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"6rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','修改')) || (!userid && isAuthFront('zulindingdan','修改'))" @click.stop="onUpdateTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
				  	</view>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','删除')) || (!userid && isAuthFront('zulindingdan','删除'))" @click.stop="onDeleteTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
				  	</view>
				  </view>
				</view>
				<view @tap="onDetailTap(product)" v-if="index%6==5" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"10rpx 20rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
				  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"200rpx"}' mode="aspectFill" v-if="preHttp(product.fengmian)" :src="product.fengmian"></image>
				  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"200rpx"}' mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
				  <view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","overflow":"hidden","position":"relative","height":"200rpx"}'>
					<view :style='{"padding":"0 20rpx","margin":"0","color":"#333","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="title">{{product.chepaihao}}</view>
				  </view>
				  <view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"6rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','修改')) || (!userid && isAuthFront('zulindingdan','修改'))" @click.stop="onUpdateTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
				  	</view>
				  	<view :style='{"display":"flex"}' v-if="(userid && isAuth('zulindingdan','删除')) || (!userid && isAuthFront('zulindingdan','删除'))" @click.stop="onDeleteTap(product.id)">
				  		<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
				  		<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
				  	</view>
				  </view>
				</view>
				</block>
				</block>
			</view>
			

			</view>
			
			
			
		</view>

		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"rgb(255, 170, 51)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('zulindingdan','新增')" class="add-btn" @click="onAddTap()">新增</button>
		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"rgb(255, 170, 51)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('zulindingdan','新增')" class="add-btn" @click="onAddTap()">新增</button>
	</view>
</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"姓名",
					},
				],
				queryIndex: 0,
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0'
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
                                return (0.5-Math.random());
                        });
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.xingming="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}


				if(this.searchForm.xingming){
					params['xingming'] = '%' + this.searchForm.xingming + '%'
				}



                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`zulindingdan`, params);
                } else {
                    params['sfsh'] = '是';
                    res = await this.$api.list(`zulindingdan`, params);
                }
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 修改
			onUpdateTap(id){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('zulindingdan', JSON.stringify([id]));
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.mescroll.resetUpScroll()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
                    sfsh :'是',
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				if(this.searchForm.xingming){
					searchForm['xingming'] = '%' + this.searchForm.xingming + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`zulindingdan`, searchForm);
                } else {
                    res = await this.$api.list(`zulindingdan`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.category-one .tab {
		cursor: pointer;
		border-radius: 20rpx;
		padding: 0 20rpx;
		margin: 0 10rpx;
		color: #fff;
		background: #999;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 80rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		border-radius: 20rpx;
		padding: 0 20rpx;
		color: #000;
		background: #BEDBF1;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 80rpx;
	}
	
	.category-two .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: blue;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-two .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: burlywood;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
</style>
