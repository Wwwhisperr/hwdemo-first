const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{//代理服务器解决跨域问题
    port:8082,//指定前端服务器端口为8081
    proxy:{//代理--里面是代理
      '/api':{
        target:"http://localhost:8089/",//目标地址
        changeOrigin:true,//跨域关键字
        pathRewrite:{'/api':''}//路径重写
      }
    }
  }
})
