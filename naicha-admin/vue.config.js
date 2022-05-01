const port = process.env.port || process.env.npm_config_port || 8080 // 端口
module.exports = {
    publicPath: '/', //项目的公共路径
    // devServer: {    //开发用的服务器配置
    //     proxy: {
    //         '/api': {
    //             target: 'http://localhost:9002',  //这里是目标服务器地址
    //             changeOrigin: true, //是否改变源地址
    //             ws: true,  //是否支持websocket协议
    //             pathRewrite: {  //路径重写
    //                 '^/api': ''       //这里一定要为空
    //             }
    //         }
    //     }
    // },
    devServer: {
        host: '0.0.0.0',
        port: port,
        open: true,
        proxy: {
        // detail: https://cli.vuejs.org/config/#devserver-proxy
        [process.env.VUE_APP_BASE_API]: {
            target: `http://114.115.148.124:9002`,
            changeOrigin: true,
            pathRewrite: {
            ['^' + process.env.VUE_APP_BASE_API]: ''
            }
        }
        },
        disableHostCheck: true
    },
}
