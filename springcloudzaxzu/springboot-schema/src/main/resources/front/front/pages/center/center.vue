<template>
	<view class="content">
		<view :style='{"minHeight":"100vh","width":"100%","padding":"0 0 100rpx","position":"relative","background":"#EAF2FF","height":"auto"}'>
			<view :style='{"padding":"0 24rpx","margin":"20rpx 3%","backgroundImage":"url(http://codegen.caihongy.cn/20221011/e0374daf5728418aaaf3a9d246b40fd5.png)","display":"flex","width":"94%","backgroundSize":"100% 100%","height":"360rpx"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"width":"calc(100% - 112rpx)","display":"flex","height":"100%"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"88rpx","padding":"0","margin":"40rpx 20rpx 0 0","borderRadius":"100%","height":"88rpx"}' :src="user.touxiang?baseUrl+user.touxiang:'/static/gen/upload.png'"></image>
					<view :style='{"width":"100%","flex":"1","flexDirection":"column","display":"flex","height":"100%"}' class="info">
						<view :style='{"width":"100%","margin":"60rpx 0 20rpx 0","lineHeight":"36rpx","fontSize":"24rpx","color":"#fff"}'>{{user.zhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
				</view>
				<view :style='{"width":"112rpx","alignItems":"center","justifyContent":"center","display":"flex","height":"100%"}' class="setting">
					<view :style='{"border":"0","width":"60rpx","lineHeight":"60rpx","fontSize":"60rpx","color":"#fff","borderRadius":"0"}' class="cuIcon-settings"></view>
				</view>
			</view>
		
		
			<view :style='{"width":"100%","padding":"0 24rpx","flexWrap":"wrap","display":"flex","height":"auto"}' class="list">

				<block v-for="item in menuList" v-bind:key="item.roleName">
					<block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.backMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<view :style='{"padding":"0 10rpx","borderColor":"#ccc","margin":"20rpx 5%","alignItems":"center","borderWidth":"0","background":"#FFFFFF","display":"flex","width":"40%","borderStyle":"solid","height":"140rpx"}' v-if="child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' && child.tableName!='exampaper' && child.tableName!='examquestion' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id)" class="li" hover-class="hover">
								<view v-if="true" :style='{"width":"40rpx","lineHeight":"40rpx","fontSize":"40rpx","color":"#000000"}' :class="child.appFrontIcon"></view>
								<view :style='{"width":"100%","padding":"0 10rpx","fontSize":"26rpx","color":"#333","flex":"1"}' class="text">{{child.menu}}</view>
								<view v-if="false" :style='{"width":"20rpx","lineHeight":"28rpx","fontSize":"20rpx","color":"#999"}' class="cuIcon-right"></view>
							</view>
						</block>
					</block>
				</block>

				<view @tap="onPageTap('../chat/chat')" :style='{"padding":"0 10rpx","borderColor":"#ccc","margin":"20rpx 5%","alignItems":"center","borderWidth":"0","background":"#FFFFFF","display":"flex","width":"40%","borderStyle":"solid","height":"140rpx"}' class="li" hover-class="hover">
					<view v-if="true" :style='{"width":"40rpx","lineHeight":"40rpx","fontSize":"40rpx","color":"#000000"}' class="cuIcon-service"></view>
					<view class="text" :style='{"width":"100%","padding":"0 10rpx","fontSize":"26rpx","color":"#333","flex":"1"}'>在线客服</view>
					<view v-if="false" :style='{"width":"20rpx","lineHeight":"28rpx","fontSize":"20rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>
				<view @tap="onPageTap('../forum-add-or-update/forum-add-or-update')" :style='{"padding":"0 10rpx","borderColor":"#ccc","margin":"20rpx 5%","alignItems":"center","borderWidth":"0","background":"#FFFFFF","display":"flex","width":"40%","borderStyle":"solid","height":"140rpx"}' class="li"
				 hover-class="hover">
					<view v-if="true" :style='{"width":"40rpx","lineHeight":"40rpx","fontSize":"40rpx","color":"#000000"}' class="cuIcon-scan"></view>
					<view class="text" :style='{"width":"100%","padding":"0 10rpx","fontSize":"26rpx","color":"#333","flex":"1"}'>我要发贴</view>
					<view v-if="false" :style='{"width":"20rpx","lineHeight":"28rpx","fontSize":"20rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>
				<view @tap="onPageTap('../forum-my/forum-my')" :style='{"padding":"0 10rpx","borderColor":"#ccc","margin":"20rpx 5%","alignItems":"center","borderWidth":"0","background":"#FFFFFF","display":"flex","width":"40%","borderStyle":"solid","height":"140rpx"}' class="li"
				 hover-class="hover">
					<view v-if="true" :style='{"width":"40rpx","lineHeight":"40rpx","fontSize":"40rpx","color":"#000000"}' class="cuIcon-scan"></view>
					<view class="text" :style='{"width":"100%","padding":"0 10rpx","fontSize":"26rpx","color":"#333","flex":"1"}'>我的发贴</view>
					<view v-if="false" :style='{"width":"20rpx","lineHeight":"28rpx","fontSize":"20rpx","color":"#999"}' class="cuIcon-right"></view>
				</view>

			</view>
		</view>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
        iconArr: [
          'cuIcon-same',
          'cuIcon-deliver',
          'cuIcon-evaluate',
          'cuIcon-shop',
          'cuIcon-ticket',
          'cuIcon-cascades',
          'cuIcon-discover',
          'cuIcon-question',
          'cuIcon-pic',
          'cuIcon-filter',
          'cuIcon-footprint',
          'cuIcon-pulldown',
          'cuIcon-pullup',
          'cuIcon-moreandroid',
          'cuIcon-refund',
          'cuIcon-qrcode',
          'cuIcon-remind',
          'cuIcon-profile',
          'cuIcon-home',
          'cuIcon-message',
          'cuIcon-link',
          'cuIcon-lock',
          'cuIcon-unlock',
          'cuIcon-vip',
          'cuIcon-weibo',
          'cuIcon-activity',
          'cuIcon-friendadd',
          'cuIcon-friendfamous',
          'cuIcon-friend',
          'cuIcon-goods',
          'cuIcon-selection'
        ],
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad(){
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		methods: {
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
</style>
