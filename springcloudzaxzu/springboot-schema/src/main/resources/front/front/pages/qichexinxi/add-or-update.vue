<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">车牌号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#939393","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.chepaihao" v-model="ruleForm.chepaihao" placeholder="车牌号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">品牌</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="pinpaiChange" :value="pinpaiIndex"  :range="pinpaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#939393"}' class="uni-input">{{ruleForm.pinpai?ruleForm.pinpai:"请选择品牌"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">汽车类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#939393","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.qicheleixing" v-model="ruleForm.qicheleixing" placeholder="汽车类型"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">颜色</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="yanseChange" :value="yanseIndex"  :range="yanseOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#939393"}' class="uni-input">{{ruleForm.yanse?ruleForm.yanse:"请选择颜色"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">换挡方式</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="huandangfangshiChange" :value="huandangfangshiIndex"  :range="huandangfangshiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#939393"}' class="uni-input">{{ruleForm.huandangfangshi?ruleForm.huandangfangshi:"请选择换挡方式"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="fengmianTap">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.fengmian" :src="baseUrl+ruleForm.fengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">状态</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="zhuangtaiChange" :value="zhuangtaiIndex"  :range="zhuangtaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#939393"}' class="uni-input">{{ruleForm.zhuangtai?ruleForm.zhuangtai:"请选择状态"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">租金</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#939393","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zujin" v-model="ruleForm.zujin" placeholder="租金"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">车辆排量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#939393","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheliangpailiang" v-model="ruleForm.cheliangpailiang" placeholder="车辆排量"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">载重</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#939393","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zaizhong" v-model="ruleForm.zaizhong" placeholder="载重"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","background":"#E6EBFF","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"220rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"center"}' class="title">登记日期</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.dengjiriqi" @change="dengjiriqiChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#939393"}' class="uni-input">{{ruleForm.dengjiriqi?ruleForm.dengjiriqi:"请选择登记日期"}}</view>
				</picker>
			</view>
			
			<!-- 否 -->
 

			
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 70rpx","color":"#333","background":"#e6ebff","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"500"}' class="title">车辆详情</view>
                <xia-editor ref="editor" :style='{"minHeight":"300rpx","border":"2rpx solid #efefef","width":"100%","padding":"10rpx 20rpx","height":"auto"}' v-model="ruleForm.cheliangxiangqing" placeholder="车辆详情" @editorChange="cheliangxiangqingChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","alignItems":"center","flexDirection":"column","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"10rpx 0","color":"rgb(255, 255, 255)","borderRadius":"20rpx","background":"#1C3AEA","width":"90%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				chepaihao: '',
				pinpai: '',
				qicheleixing: '',
				yanse: '',
				huandangfangshi: '',
				fengmian: '',
				zhuangtai: '',
				zujin: '',
				cheliangpailiang: '',
				zaizhong: '',
				dengjiriqi: '',
				cheliangxiangqing: '',
				},
				pinpaiOptions: [],
				pinpaiIndex: 0,
				yanseOptions: [],
				yanseIndex: 0,
				huandangfangshiOptions: [],
				huandangfangshiIndex: 0,
				zhuangtaiOptions: [],
				zhuangtaiIndex: 0,
				// 登陆用户信息
				user: {},
                ro:{
                   chepaihao : false,
                   pinpai : false,
                   qicheleixing : false,
                   yanse : false,
                   huandangfangshi : false,
                   fengmian : false,
                   zhuangtai : false,
                   zujin : false,
                   cheliangpailiang : false,
                   zaizhong : false,
                   dengjiriqi : false,
                   cheliangxiangqing : false,
                   clicktime : false,
                   clicknum : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
            this.ruleForm.dengjiriqi = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下拉框
			res = await this.$api.option(`cheliangpinpai`,`pinpai`,{});
			this.pinpaiOptions = res.data;
            this.pinpaiOptions.unshift("请选择品牌");
			// 下拉框
			res = await this.$api.option(`cheliangyanse`,`yanse`,{});
			this.yanseOptions = res.data;
            this.yanseOptions.unshift("请选择颜色");
			// 自定义下拉框值
			this.huandangfangshiOptions = "手动挡,自动挡".split(',')
			// 自定义下拉框值
			this.zhuangtaiOptions = "已租赁,未租赁".split(',')

			// 如果有登陆，获取登陆后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`qichexinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='chepaihao'){
					this.ruleForm.chepaihao = obj[o];
					this.ro.chepaihao = true;
					continue;
					}
					if(o=='pinpai'){
					this.ruleForm.pinpai = obj[o];
					this.ro.pinpai = true;
					continue;
					}
					if(o=='qicheleixing'){
					this.ruleForm.qicheleixing = obj[o];
					this.ro.qicheleixing = true;
					continue;
					}
					if(o=='yanse'){
					this.ruleForm.yanse = obj[o];
					this.ro.yanse = true;
					continue;
					}
					if(o=='huandangfangshi'){
					this.ruleForm.huandangfangshi = obj[o];
					this.ro.huandangfangshi = true;
					continue;
					}
					if(o=='fengmian'){
					this.ruleForm.fengmian = obj[o].split(",")[0];
					this.ro.fengmian = true;
					continue;
					}
					if(o=='zhuangtai'){
					this.ruleForm.zhuangtai = obj[o];
					this.ro.zhuangtai = true;
					continue;
					}
					if(o=='zujin'){
					this.ruleForm.zujin = obj[o];
					this.ro.zujin = true;
					continue;
					}
					if(o=='cheliangpailiang'){
					this.ruleForm.cheliangpailiang = obj[o];
					this.ro.cheliangpailiang = true;
					continue;
					}
					if(o=='zaizhong'){
					this.ruleForm.zaizhong = obj[o];
					this.ro.zaizhong = true;
					continue;
					}
					if(o=='dengjiriqi'){
					this.ruleForm.dengjiriqi = obj[o];
					this.ro.dengjiriqi = true;
					continue;
					}
					if(o=='cheliangxiangqing'){
					this.ruleForm.cheliangxiangqing = obj[o];
					this.ro.cheliangxiangqing = true;
					continue;
					}
					if(o=='clicktime'){
					this.ruleForm.clicktime = obj[o];
					this.ro.clicktime = true;
					continue;
					}
					if(o=='clicknum'){
					this.ruleForm.clicknum = obj[o];
					this.ro.clicknum = true;
					continue;
					}
				}
			}
			this.styleChange()
		},
		methods: {
            cheliangxiangqingChange(e) {
                this.ruleForm.cheliangxiangqing = e
            },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数

			dengjiriqiChange(e) {
				this.ruleForm.dengjiriqi = e.target.value;
				this.$forceUpdate();
			},

			// 日长控件选择日期时间
			clicktimeConfirm(val) {
				console.log(val)
				this.ruleForm.clicktime = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			pinpaiChange(e) {
				this.pinpaiIndex = e.target.value
				this.ruleForm.pinpai = this.pinpaiOptions[this.pinpaiIndex]
			},
			// 下拉变化
			yanseChange(e) {
				this.yanseIndex = e.target.value
				this.ruleForm.yanse = this.yanseOptions[this.yanseIndex]
			},
			// 下拉变化
			huandangfangshiChange(e) {
				this.huandangfangshiIndex = e.target.value
				this.ruleForm.huandangfangshi = this.huandangfangshiOptions[this.huandangfangshiIndex]
			},
			// 下拉变化
			zhuangtaiChange(e) {
				this.zhuangtaiIndex = e.target.value
				this.ruleForm.zhuangtai = this.zhuangtaiOptions[this.zhuangtaiIndex]
			},

			fengmianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.fengmian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {





























//跨表计算判断
				var obj;
				if((!this.ruleForm.chepaihao)){
					this.$utils.msg(`车牌号不能为空`);
					return
				}
				if((!this.ruleForm.pinpai)){
					this.$utils.msg(`品牌不能为空`);
					return
				}
				if(this.ruleForm.zujin&&(!this.$validate.isNumber(this.ruleForm.zujin))){
					this.$utils.msg(`租金应输入数字`);
					return
				}
				if(this.ruleForm.zaizhong&&(!this.$validate.isIntNumer(this.ruleForm.zaizhong))){
					this.$utils.msg(`载重应输入整数`);
					return
				}
				if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('userid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`qichexinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`qichexinxi`, this.ruleForm);
						}else{
							await this.$api.add(`qichexinxi`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`qichexinxi`, this.ruleForm);
					}else{
						await this.$api.add(`qichexinxi`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
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
