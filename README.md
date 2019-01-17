# spring-cloud
* 微服务的概念
  - 把传统的一站式应用拆分开，使其去耦合，类似于进程，能够单独启动或者注销，拥有自己单独的数据库
  - 微服务技术栈包含了：(针对每一项，springcloud对每一个技术栈都有自己的技术落地实现)
    * 服务的注册与发现（zookeeper、eureka）；
    * 服务之间的调用（rest、rpc）;
    * 服务的熔断（hystrix）;
    * 负载均衡（nginx 、ribbon）；
    * 消息队列（kafka，activeMq）；
    * 服务配置中心管理（springcloud-config）；
    * 服务路由（zuul）；
    * 服务部署（docker）；
    * 事件消息总线（springcloudBus）；
  - springcloud是分布式微服务下一站式的解决方案；
* springcloud与springboot的区别
  - springboot是快速开发单个应用服务，springcloud是对于全局的服务治理框架
  - springboot是可以单独存在的，但springcloud的开发是依赖于springboot
* dubbo与springcloud的对比
  - 目前比较流行的技术是dubbo的分布式治理，但为什么还会出现springcloud？
  - 除了服务的注册于发现以及服务的监控，其他维度技术的实现在dubbo中都没有体现；
  - springcloud采用了rest风格的通讯方式，丢弃了之前rpc类似于二进制的通讯方式；
  - dubbo的定义：只是一个rpc框架；
  - 总结：使用springcloud你不必担心如果需要其他技术栈实现使用时的问题，类似于电脑的组装，springcloud是一体机，正宗的牌子，但dubbo类似于组装机，也许有那天你会因为开发不出一个合适的CPU而烦恼；
* springcloud的初始搭建
  - 首先创建一个父工程，其中包含了一个公共接口的子工程和一个服务提供者还有另外一个服务消费者；
  - 使用springboot搭建出一个普通的ssm工程；
  - 服务消费者使用restTemplate调用服务提供者提供的服务；
  - 测试：服务消费者可以消费提供的服务；
* Eureka介绍
  - 是用来实现服务的注册与发现；
  - 分为服务端与客户端，客户端连接到服务端，并维持心跳(30s)，通过管理服务中心即可管理各个微服务；
  - 服务提供者把服务注册在euraka中，消费者从Eureka中拉取注册服务列表，从而消费服务；
  - 如果某一时刻，某个服务不能使用，Eureka不会立即清理，依然保存对该服务的信息维护；
  - 通常情况下，会对Eureka做集群处理，保证注册中心的稳定；
* Ribbon介绍
  - 负载均衡，把用户的请求分摊在多个服务器上，从而达到服务的高可用；
  - springcloud负载均衡算法可以自定义；
  - 在获得restTemplate时，加上@loadBalance注解；
  - 上述的Eureka与ribbon整合后不必关心服务的IP与端口；
* Feign介绍
  - 之前的服务是采用ribbon+restTemplate来访问的，现在是通过接口的方式进行调用；
  - 首先在API中声明@FeignClient，属性value值中指明具体的服务名称；
  - 之后再controller中调用是，直接注入此service，即可完成服务的调用，达到和ribbon同样的效果；


* Hystrix介绍
  - 用于处理分布式系统延迟和容错的开源库，保证在一个或者几个依赖出现问题的时候，不会导致服务整体出现级联故障，提高了分布式系统的弹性；
  - 原理是当某一个服务单元出现故障时，向调用方返回一个预期的备选响应，而不是长时间的等待或者抛出异常，不会导致资源被长时间的占用，避免服务的雪崩，提高服务的弹性；
  - 服务熔断：
    - 应对雪崩效应的一种微服务链路保护机制，当某个微服务不可用或者等待时间过长时，迅速返回准备好的错误信息，当节点正常时，恢复调用链路；
    - @HystrixCommand(fallbackMethod = "findByIdException")    表示在此方法存在异常时，可以去找fallbackMethod 中的方法去处理异常错误；
  - 服务降级：
    - 整体资源不够，先把某些服务关掉，等资源充足时，再恢复回来，针对客户端；
    - 根据已经有的DeptService接口新建一个实现了FallbackFactory接口的类DeptServiceFallbackFactory，注意加上@Component注解；
  - HystrixDashBoard : 提供实时的调用监控图形展示；

* Zuul路由网关

  - 主要作用是对于请求的**路由**和**过滤**；

  - 其中的路由功能可以把请求转移到具体的微服务实例上；

  - Zuul与Eureka整合，把Zuul注册进入Eureka，Zuul从注册中心获取微服务的消息，从而实现调用微服务的功能；

  - 步骤：（可以做到真实服务名称的影藏和公共前缀的配置）

    1.开启Zuul的注解   @EnableZuulProxy

    2.修改yml，端口，路由规则，Eureka注册中心地址注册；

* Config分布式配置中心

  - 为微服务提供集中化的外部配置管理，针对每一个微服务；
  - 分为服务端与客户端，服务单负责从远程拉取配置信息，客户端负责通过配置中心管理应用资源；
  - 动态切换环境，配置在变化时，服务不需要重启即可切换；
