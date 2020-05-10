module.exports = {
    outputDir: 'target/dist',
    assetsDir: 'static',
    devServer: {
        proxy: 'http://localhost:8080',
        host: '0.0.0.0',
        port: 8081
    },
    chainWebpack: config => {
        config
            .plugin('html')
            .tap(args => {
                args[0].title = 'Quote Examiner'
                return args
            })
    }
}