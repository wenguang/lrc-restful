
(说在前面：怎么也找不到jersey.config.server.provider.packages定义在哪儿，倒是可以试试用servlet的getInitParameterNames来获取初始化参数名)

web.xml中配置jersey
```
    <servlet>
        <servlet-name>jerseyServletContainer</servlet-name>
        <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
        <init-param>
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>jersey.start.service</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>jerseyServletContainer</servlet-name>
        <url-pattern>/api/*</url-pattern>
    </servlet-mapping>
```

org.glassfish.jersey.servlet.ServletContainer是整个jersey核心控制器，
它继承自HttpServlet，jersey.config.server.provider.packages是其中一个init-param,
它用于扫描jersey中REST服务类所在的包（可以简单理解为SpringMVC中的component-scan）

网上还提到另一个init-param：javax.ws.rs.Application，也可达到相似的效果，那它们有什么不同呢？阅读以下文章了解更多：

[which init-param to use: jersey.config.server.provider.packages or javax.ws.rs.Application?](https://stackoverflow.com/questions/22994690/which-init-param-to-use-jersey-config-server-provider-packages-or-javax-ws-rs-a)

[Custom ResourceConfig 自定义资源配置](https://waylau.gitbooks.io/rest-in-action/content/docs/Custom%20ResourceConfig.html)

[REST 服务类型](https://www.jianshu.com/p/ae316fa2dcd0)

[JAX-RS 2.0 中 REST 的四种服务类型](https://segmentfault.com/a/1190000002489170)

