<template >
  <div id="app" >
    <table border="1" >
      <tr border="1">
        <th>工号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>职位</th>
        <th>工资</th>
      </tr>

      <tr  v-for="(obj,index) in objs" :key="index" border="2">
        <!--多选框绑定数组checkArr  -->
        <td>{{obj.num}}</td>
        <td>{{obj.uname}}</td>
        <td>{{obj.gender}}</td>
        <td>{{obj.age}}</td>
        <td>{{obj.job}}</td>
        <td>{{obj.salary}}</td>
      </tr>
    </table>
    <span><router-link to="add">继续添加人员</router-link></span>
  </div>

</template>

<script>
export default {
  name: "ListPage",
  data(){
    return{
      objs:[]
    }
  },
  methods:{
    turn:function (){
      this.$route.push({path:"add"});
    }
  },
  created() {
    this.params=this.$route.params;
    let that=this;
    let url="/api/list.do"
    let params=this.params;
    this.$axios.post(url,params)
        .then(function (res){
          if(res.data.result=="ok"){
            that.objs=res.data.data;
          }else{
            console.log("后台没数据")
          }
        }).catch(function (res){
          console.log(res);
    })

  }
}
</script>

<style scoped>
div{
  margin: 100px;
}
table{
  border: 5px solid saddlebrown;
  text-align: center;
  margin: 50px;
}
tr:hover td{
  background-color: #e5e5e5;
}
td{
  padding: 10px;
}
span{
  margin: 100px;
  background-color: #e5e5e5;
  border-radius: 10px;
  padding: 10px;
}
</style>