除在web.xml配置org.glassfish.jersey.servlet.servletContainer, 用jersey.config.server.provider.packages指定服务包（或叫资源包），用jetty插件启动这样方式外，还有一种纯代码的启动方式，步骤：
1、新建类继承自RestConfig，该为jersey提供资源配置（在REST中，提供服务的组件都叫资源），在新建类的初始化中用packages方法注册资源类的包`this.packages("jersey.start.service")`
2、用JettyHttpContainerFactory发布应用即可
```
JettyHttpContainerFactory.createServer(URI.create("http://localhost:8086/"), new RestApplication());
```

注意：web.xml配置方式下，在servlet-mapping中把servletContainer匹配为/api/\*, 而JettyHttpContainerFactory是把应用发布在根路径下的。