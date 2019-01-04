
(对比：servlet的过滤器是双向的，即可对请求进行过滤，也可对响应进行过滤)

javax.ws.rs.container.ContainerRequestFilter：针对请求的过滤器；
javax.ws.rs.container.ContainerResponseFilter：针对响应的过滤器；

ContainerRequestContext和ContainerResponseContext作为过滤器的filter方法的参数提供上下文环境参数，如请求URI，请求方法，请求实体，请求头等等。

注意：ContainerRequestContext在请求过滤器中是“可变的”，但其在响应过滤器就是“不可变的”

可以在ResourceConfig的子类的构造函数利用其方法register来注册过滤器