<template>
<view class="content">
	<view :style='{"width":"100%","background":"#EAF2FF","height":"100%"}'>
		<swiper :style='{"width":"94%","margin":"20rpx 3%","overflow":"hidden","borderRadius":"20rpx","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='3000' :vertical='false'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>


		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"#f7f7f7","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"23%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#fff","borderRadius":"100%","textAlign":"center","background":"#3A4C94","display":"block","width":"80rpx","lineHeight":"80rpx","fontSize":"40rpx","height":"80rpx"}'></view>
                                <view :style='{"padding":"0","margin":"20rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		
		<!-- 系统简介 -->
		<view :style='{"padding":"0 24rpx","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#6797FF","display":"flex","width":"100%","height":"auto"}'>
		  <view :style='{"width":"100%","lineHeight":"1.5","fontSize":"48rpx","color":"#fff","textAlign":"center"}'>{{systemIntroductionDetail.title}}</view>
		  <view :style='{"width":"100%","margin":"0 0 20rpx","lineHeight":"1.5","fontSize":"32rpx","color":"#fff","textAlign":"center"}'>{{systemIntroductionDetail.subtitle}}</view>
		  <view :style='{"width":"100%","flexWrap":"wrap","display":"flex","height":"auto"}'>
		    <img :style='{"width":"100%","margin":"0","objectFit":"cover","flex":1,"display":"block","height":"200rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":"0","display":"block","height":"0"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":"0","display":"block","height":"0"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
		  </view>
		  <view :style='{"width":"100%","padding":"0","margin":"0 0 20rpx 0","lineHeight":"2","fontSize":"28rpx","color":"#fff"}' v-html="systemIntroductionDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		</view>

		<!-- 商品推荐 -->
		<view class="listBox recommend">
			<view v-if="false && 1 == 1" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"width":"100%","padding":"0 24rpx","margin":"0"}'>
				<view :style='{"fontSize":"40rpx","lineHeight":"88rpx","color":"#1C3AEA","fontWeight":"600"}'>汽车信息推荐</view>
			</view>
			
			<view v-if="false && 1 == 2" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			
			<!-- 样式2 -->
			<view class="list-box style2" :style='{"padding":"24rpx","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view @tap="onDetailTap('qichexinxi',product.id)" v-for="(product,index) in qichexinxilist" :key="index" class="list-item" :style='{"width":"31%","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"0 0 20rpx","backgroundColor":"#fff","height":"auto"}'>
					<view :style='{"padding":"6rpx 20rpx","color":"#fff","textAlign":"center","background":"#1C3AEA","width":"100%","lineHeight":"1.5","fontSize":"28rpx"}' class="list-item-title ">{{product.chepaihao}}</view>
					<view :style='{"padding":"6rpx 20rpx","color":"#fff","textAlign":"center","background":"#1C3AEA","width":"100%","lineHeight":"1.5","fontSize":"28rpx"}' class="list-item-title ">品牌:{{product.pinpai}}</view>
					<image :style='{"padding":"0","margin":"10rpx","objectFit":"cover","borderRadius":"50%","display":"block","width":"200rpx","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
					<image :style='{"padding":"0","margin":"10rpx","objectFit":"cover","borderRadius":"50%","display":"block","width":"200rpx","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
					<view :style='{"padding":"6rpx 20rpx","color":"#fff","textAlign":"center","background":"#1C3AEA","width":"100%","lineHeight":"1.5","fontSize":"28rpx"}' class="list-item-title ">状态:{{product.zhuangtai}}</view>
				</view>
			</view>
			
			
			  
			
			
			  
			
			  
			<view v-if="false && 1 == 3" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		

		<!-- 商品列表 -->
																																																				<!-- 商品列表 -->
		
		
		<!-- 新闻资讯 -->
																																										<view class="listBox news">
			<view v-if="false && 1 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"width":"100%","padding":"0 40rpx","margin":"0","justifyContent":"space-between","fontWeight":"600","display":"flex"}'>
				<view :style='{"color":"#1C3AEA","fontSize":"40rpx","lineHeight":"88rpx"}'>公告信息</view>
				<text :style='{"color":"#1C3AEA","fontSize":"32rpx","lineHeight":"88rpx"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						
		  <!-- 样式4 -->
		  		  
		  <!-- 样式5 -->
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  <view class="news-box5" :style='{"padding":"24rpx","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"border":"2rpx solid #1C3AEA","width":"47%","margin":"0 10rpx 20rpx","backgroundColor":"#fff","height":"auto"}'>
			  <view :style='{"padding":"4rpx 20rpx","overflow":"hidden","color":"#fff","background":"#1C3AEA","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","height":"52rpx"}' class="title ">{{item.title}}</view>
			  <view :style='{"padding":"4rpx 20rpx","margin":"4rpx 0","overflow":"hidden","color":"#B0B0B0","width":"100%","lineHeight":"40rpx","fontSize":"28rpx","height":"80rpx"}' class="category ">{{item.introduction}}</view>
			  <view :style='{"width":"100%","padding":"4rpx 20rpx","lineHeight":"1.2","fontSize":"28rpx","color":"#999","textAlign":"right"}' class="time ">{{item.addtime.split(" ")[0]}}</view>
			</view>
		  </view>
		  		  
		  <!-- 样式9 -->
		  			
			<view v-if="false && 1 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
														<!-- 新闻资讯 -->
				
		<!-- 关于我们 -->
		<view :style='{"padding":"10rpx 24rpx","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"0 2.5% 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"95%","height":"auto"}'>
		  <view :style='{"width":"100%","lineHeight":"1.5","fontSize":"48rpx","color":"#1c3aea","textAlign":"center","fontWeight":"600"}'>{{aboutUsDetail.title}}</view>
		  <view :style='{"width":"100%","margin":"0 0 20rpx","lineHeight":"1.5","fontSize":"32rpx","color":"#999","textAlign":"center"}'>{{aboutUsDetail.subtitle}}</view>
		  <view :style='{"width":"100%","padding":"0 10rpx","flexWrap":"wrap","display":"flex","height":"auto"}'>
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"240rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
		  </view>
		  <view :style='{"width":"100%","padding":"0 20rpx","margin":"0 0 20rpx 0","lineHeight":"2","fontSize":"28rpx","color":"rgb(102, 102, 102)"}' v-html="aboutUsDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
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
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				qichexinxilist: [],
				news: [],
			}
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
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
            let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
            this.getAboutUs();
            this.getSystemIntroduction();
			// 公告信息
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list

			// 推荐信息
			res = await this.$api.recommend('qichexinxi', {                                              
                page: 1,
                limit: 6
            });
			this.qichexinxilist = res.data.list

		},

		methods: {

			//轮播图跳转
			onSwiperTap(e) {

			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
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
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
