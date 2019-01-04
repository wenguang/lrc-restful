
- 第一种在该类上添加@Provider，使用JAX-RS的自动发现机制，
- 第二种方式在服务器端使用ResourceConfig提供的register方法注册即可

(JAX-RS拦截器也是单向的了)
javax.ws.rs.ext.ReaderInterceptor
javax.ws.rs.ext.WriterInterceptor

(很像springAOP的拦截器)

....待续：[Jersey 开发RESTful（十五） Jersey的拦截器](https://www.jianshu.com/p/6730dd240269)



