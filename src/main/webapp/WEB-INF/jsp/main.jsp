<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
   margin-top: 50px;
}

.row {
   margin: 0px auto;
   width: 960px;
}

p {
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
</style>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container" id="musicApp">
		<div class="row">
			<div class="col-md-3" v-for="vo in list">
				    <div class="thumbnail">
				      <a href="#">
				        <img :src="vo.poster" alt="Lights" style="width:24opx;height:150px">
				        <div class="caption">
				          <p>{{vo.title}}</p>
				        </div>
				      </a>
				    </div>
				  </div>
		</div>	
	</div>
</body>
<script>
	let musicApp=Vue.createApp({
		data(){
			return{
				list:[],
				curPage:0,
				startPage:0,
				endPage:0,
				totalPage:0
			}
		},
		mounted(){
			this.dataRecv()
		},
		methods:{
			dataRecv(){
				axios.get('http://localhost/list_vue',{
					params:{
						page:this.curPage
					}
				}).then(res=>{
					this.list = res.data.list
					this.startPage = res.data.startPage
					this.curPage = res.data.curPage
					this.endPage = res.data.endPage
					this.totalPage = res.data.totalPage
				})
			},
			pageChange(i){
				this.curPage = i
				this.dataRecv()
			}
		}
	})
	musicApp.mount(".container")
</script>
</html>