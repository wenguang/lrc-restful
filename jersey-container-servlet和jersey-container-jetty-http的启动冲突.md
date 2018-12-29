```
    <dependency>
        <groupId>org.glassfish.jersey.containers</groupId>
        <artifactId>jersey-container-servlet</artifactId>
        <version>2.25.1</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.containers</groupId>
        <artifactId>jersey-container-jetty-http</artifactId>
        <version>2.21</version>
    </dependency>
```

maven下载依赖没问题，但把它们放一块只有用jetty-http启动正常，作container-servlet方式启动就有报异常
```
十二月 29, 2018 8:48:02 下午 org.apache.coyote.AbstractProtocol init
信息: Initializing ProtocolHandler ["http-bio-8087"]
十二月 29, 2018 8:48:02 下午 org.apache.catalina.core.StandardService startInternal
信息: Starting service Tomcat
十二月 29, 2018 8:48:02 下午 org.apache.catalina.core.StandardEngine startInternal
信息: Starting Servlet Engine: Apache Tomcat/7.0.47
十二月 29, 2018 8:48:02 下午 org.apache.catalina.core.ContainerBase startInternal
严重: A child container failed during start
java.util.concurrent.ExecutionException: org.apache.catalina.LifecycleException: Failed to start component [StandardEngine[Tomcat].StandardHost[localhost].StandardContext[]]
    at java.util.concurrent.FutureTask.report(FutureTask.java:122)
    at java.util.concurrent.FutureTask.get(FutureTask.java:192)
    at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:1123)
    at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:800)
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
    at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1559)
    at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1549)
    at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)
Caused by: org.apache.catalina.LifecycleException: Failed to start component [StandardEngine[Tomcat].StandardHost[localhost].StandardContext[]]
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:154)
    ... 6 more
Caused by: java.lang.ClassCastException: org.glassfish.jersey.servlet.init.JerseyServletContainerInitializer cannot be cast to javax.servlet.ServletContainerInitializer
    at org.apache.catalina.startup.ContextConfig.getServletContainerInitializer(ContextConfig.java:1670)
    at org.apache.catalina.startup.ContextConfig.getServletContainerInitializers(ContextConfig.java:1652)
    at org.apache.catalina.startup.ContextConfig.processServletContainerInitializers(ContextConfig.java:1562)
    at org.apache.catalina.startup.ContextConfig.webConfig(ContextConfig.java:1270)
    at org.apache.catalina.startup.ContextConfig.configureStart(ContextConfig.java:878)
    at org.apache.catalina.startup.ContextConfig.lifecycleEvent(ContextConfig.java:376)
    at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:119)
    at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)
    at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5322)
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
    ... 6 more

十二月 29, 2018 8:48:02 下午 org.apache.catalina.core.ContainerBase startInternal
严重: A child container failed during start
java.util.concurrent.ExecutionException: org.apache.catalina.LifecycleException: Failed to start component [StandardEngine[Tomcat].StandardHost[localhost]]
    at java.util.concurrent.FutureTask.report(FutureTask.java:122)
    at java.util.concurrent.FutureTask.get(FutureTask.java:192)
    at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:1123)
    at org.apache.catalina.core.StandardEngine.startInternal(StandardEngine.java:302)
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
    at org.apache.catalina.core.StandardService.startInternal(StandardService.java:443)
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
    at org.apache.catalina.core.StandardServer.startInternal(StandardServer.java:732)
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
    at org.apache.catalina.startup.Tomcat.start(Tomcat.java:341)
    at org.apache.tomcat.maven.plugin.tomcat7.run.AbstractRunMojo.startContainer(AbstractRunMojo.java:1238)
    at org.apache.tomcat.maven.plugin.tomcat7.run.AbstractRunMojo.execute(AbstractRunMojo.java:592)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
    at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
    at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
    at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
    at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
    at org.codehaus.classworlds.Launcher.main(Launcher.java:47)
Caused by: org.apache.catalina.LifecycleException: Failed to start component [StandardEngine[Tomcat].StandardHost[localhost]]
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:154)
    at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1559)
    at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1549)
    at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at java.lang.Thread.run(Thread.java:748)
Caused by: org.apache.catalina.LifecycleException: A child container failed during start
    at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:1131)
    at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:800)
    at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
    ... 6 more
```

原因有待研究，暂时用两个module把两种启动方式分开