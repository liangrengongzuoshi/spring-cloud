## spring cloud


###### eureka
```
// 服务治理组件，包含服务注册与发现

```

###### ribbon
```
// 基于http和tcp的客户端负载均衡的服务调用组件

```

###### feign
```
// 基于Ribbon和Hystrix的声明式服务调用组件

```

###### hystric
```
// 容错管理组件，实现了熔断器

```

###### zuul
```
// 网关组件，提供智能路由、访问过滤等功能

```

###### spring cloud config
```
// 配置管理工具，实现应用配置的外部化存储，支持客户端配置信息刷新、加密/解密配置内容等。

```
###### Spring Cloud Sleuth 
```
// 主要功能就是在分布式系统中提供追踪解决方案，并且兼容支持了 zipkin，只需要在pom文件中引入相应的依赖即可。
Span：基本工作单元，发送一个远程调度任务 就会产生一个Span，Span是一个64位ID唯一标识的，Trace是用另一个64位ID唯一标识的，Span还有其他数据信息，比如摘要、时间戳事件、Span的ID、以及进度ID。
Trace：一系列Span组成的一个树状结构。请求一个微服务系统的API接口，这个API接口，需要调用多个微服务，调用每个微服务都会产生一个新的Span，所有由这个请求产生的Span组成了这个Trace。
Annotation：用来及时记录一个事件的，一些核心注解用来定义一个请求的开始和结束 。这些注解包括以下：
cs - Client Sent -客户端发送一个请求，这个注解描述了这个Span的开始
sr - Server Received -服务端获得请求并准备开始处理它，如果将其sr减去cs时间戳便可得到网络传输的时间。
ss - Server Sent （服务端发送响应）–该注解表明请求处理的完成(当请求返回客户端)，如果ss的时间戳减去sr时间戳，就可以得到服务器请求的时间。
cr - Client Received （客户端接收响应）-此时Span的结束，如果cr的时间戳减去cs时间戳便可以得到整个请求所消耗的时间。

curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
java -jar zipkin.jar --zipkin.collector.rabbitmq.addresses=127.0.0.1

```
