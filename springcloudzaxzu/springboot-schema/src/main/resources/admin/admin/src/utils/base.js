const base = {
    get() {
        return {
            url : "http://localhost:8080/springcloudzaxzu/",
            name: "springcloudzaxzu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springcloudzaxzu/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信微服务架构的汽车租赁系统的设计与实现"
        } 
    }
}
export default base
