<template>
<div id="box">
  <h2>员工信息添加</h2>
  <form method="get" >

    工号：<input type="text" v-model="num"  placeholder="请输入工号" ><span>{{numerr}}</span><br/>
    姓名：<input type="text" v-model="uname" placeholder="请输入姓名"><span>{{unameerr}}</span><br/>
    性别：<input type="text" v-model="gender" placeholder="请输入性别"><span>{{gendererr}}</span><br/>
    年龄：<input type="text" v-model="age" placeholder="请输入年龄"><span>{{ageerr}}</span><br/>
    职位：<input type="text" v-model="job" placeholder="请输入职位"><span>{{joberr}}</span><br/>
    工资：<input type="text" v-model="salary" placeholder="请输入工资"><span>{{salaryerr}}</span><br/>
    <input type="button" value="提交" @click="btn">
  </form>
</div>
</template>

<script>
export default {
  name: "AddPage",

  data() {
    return {
        num:"",
        uname:"",
        gender:"",
        age:"",
        job:"",
        salary:"",
        numerr:"",
      unameerr:"",
      gendererr:"",
      ageerr:"",
      joberr:"",
      salaryerr:""
    }
  },
  updated() {
    //工号的验证
    if(this.num.length<4 || this.num.length>7){
      this.numerr="*请输入4-7个数字"
    }else{
      this.numerr=""
    }
    //姓名验证
    if(this.uname.length>4 ||this.uname.length<1){
      this.unameerr="*请输入1-4个字的名字"
    }else{
      this.unameerr=""
    }
    //性别验证
    if(this.gender!="男"&&this.gender!="女"){
      this.gendererr="*请输入男或者女"
    }else {
      this.gendererr=""
    }
    //年龄验证
    if(this.age<18 || this.age>70){
      this.ageerr="*请输入18-70的岁数"
    }else{
      this.ageerr=""
    }
    //职位验证
    if(this.job.length<1 || this.job.length>7){
      this.joberr="*请输入正确的职位（1-7个字）"
    }else {
      this.joberr=""
    }
    //工资验证
    if(this.salary<1000 || this.salary>35000){
      this.salaryerr="*工资不得低于1000或者高于350000"
    }else {
      this.salaryerr=""
    }


  },
  methods:{
    btn(){
      let that=this;
      let url="/api/add.do";
      let params={"num":this.num,"uname":this.uname,"gender":this.gender,"age":this.age,"job":this.job,"salary":this.salary};
      this.$axios.post(url,params).then(function (res){
        console.log(params.uname);
        if(res.data.result=="ok"){
          that.$router.push({name:'list',params:params});
        }else{
          this.records=[];
        }
      }).catch(function (res){
        alert(res);
      });

    }
  }
}

</script>

<style scoped>
#box{
  width: 500px;
  background-color: #e5e5e5;
  margin: 100px auto;
  padding: 20px;
}
input{
  margin: 10px;
  border: 1px solid gray;
  color: darkblue;
}
span{
  color: red;
}
</style>