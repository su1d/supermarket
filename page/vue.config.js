// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.exports = {
  // transpileDependencies: true,
  devServer: {
    /* 自动打开浏览器 */
    open: true,
    /* 设置为0.0.0.0则所有的地址均能访问 */
    host: '0.0.0.0',
    port: 8081,
    /* 使用代理 */
    proxy: {
      '/api/*': {
        /* 目标代理服务器地址 */
        target: 'http://localhost:10052',
        /* 允许跨域 */
        changeOrigin: true,
        pathRewrite:{
          '^/api': ''  /* 重写路径，去掉'/api' */
        }
      },
    },
  },
}
