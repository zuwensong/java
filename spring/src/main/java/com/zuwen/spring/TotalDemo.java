package com.zuwen.spring;

/**
 * 什么是Spring Boot
 *  Spring Boot是为Spring服务的，用来简化新Spring应用的搭建和开发过程。
 *  好处：
 *      1.无xml配置，自动创配，配置简单
 *      2.独立运行，易上手，提升开发效率
 *  Spring Boot两个核心配置文件
 *      1.bootstrap.yml
 *      2.application.yml
 *  Spring Boot实现热部署的两种方式
 *      1.使用devtools
 *      2.idea编辑器，勾选自动编译或者手动重新编译
 *
 * 什么是Spring Cloud
 *  Spring Cloud是利用了Spring Boot的开发便捷性，简化了分布式系统的开发，像服务注册中心、配置中心、负载均衡、断路器等等都可以使用Spring Boot开发来实现一键启动和部署。
 *
 * Spring Cloud中的断路器的作用是什么
 *  断路器主要是用来防止因为服务单元出现故障，导致调用方长时间等待从而导致系统瘫痪，Spring Cloud中一般是使用Hystrix。
 *
 * Spring Cloud中的核心组件
 *  1.Eureka
 *  2.Feign
 *  3.Ribbon
 *  4.Hystrix
 *  5.Zuul
 *
 * 分布式事务解决方案
 *  1.TCC【try-confirm-cancel 同步】补偿事务；针对每个操作都要注册一个与其对应的确认和补偿（撤销操作）,TCC事务需要接入TCC框架来监听各个服务的处理情况
 *      TRY: 调用各个服务的try逻辑，一般都是用来冻结相关数据，保证本地预留资源合理
 *      CONFIRM: try调用成功后，调用各个服务的confirm方法处理事务
 *      CANCEL: try中有一个或者多个调用失败时，调用各个服务的cancel进行回滚操作
 *    TCC缺点：将一套业务操作拆分成三个接口，代码的入侵性太强
 *
 *  2.2PC【two phase confirm】两阶段提交【适用于强一致性的场景】
 *      整体思路：引入一个协调者服务，用来对所有的参与者进行事务的整体提交，事务开始时，协调者向所有参与者发送事务预处理请求，并等待参与者的响应，参与者进行本地事务处理，但是不提交，当
 *      协调者收到所有参与者yes响应的时候，会通知参与者进行事务提交，如果有一个或者多个参与者响应no时，会通知参与者回滚事务。
 *    2PC的缺点：
 *      1.性能问题：因为在2PC期间，所有的参与者和协调者的资源都是锁定状态的，等事务完全执行完后才会释放资源，整个过程比较长，对性能影响较大，不适用于高并发场景
 *      2.节点故障问题：协调者和参与者如果发生节点故障，会影响整个流程。协调者发生故障可以使用高可用协调者方案，参与者发生故障可以考虑设置超时时间，超过时间未响应给协调者，则回滚整个事务
 *
 *  3.3PC【three phae confirm】三阶段提交
 *      在2PC的基础上添加了超时机制，并且将2PC中的第一阶段分成两步，第一步：参与者收到协调者通知后进行获取数据库锁，如果成功返回YES，第二步：和2PC第一步一样执行本地事务不提交，但是此时加入了
 *      超时机制，协调者和参与者都加入超时机制【2PC中只有协调者加入超时机制】
 *
 *  4.可靠消息最终一致性方案MQ【异步】主要的核心思想是确保生产方业务动作和消息动作的一致性
 *      整体思路：建立一个可靠消息服务，生产者先发送消息到可靠消息服务中，该服务将消息持久化到本地并标记位待确认，然后告知生产者保存成功
 *      生产者收到后，执行本地数据库操作，完成后通知可靠消息服务进行【确认/删除】，该服务根据类型不同将消息改为【已发送并发送MQ到消息队列/删除该消息】，
 *      消费者消费消息，执行本地数据库，成功后返回一个ACK标识给MQ，MQ通知可靠消息服务修改消息状态为已完成
 *
 *      可靠消息服务中一般会写一个定时任务去定时的检查消息的状态是否超时，如果是根据具体的状态通知生产者或者消费者等。
 *
 * Spring
 *  Spring中设计到的设计模式
 *      1.单例模式： Spring中所有的Bean默认都是单例的，查看源码AbstractBeanFactory中发现采用的是双重检查锁的单例模式
 *      2.原型模式：也叫做克隆模式，创建Bean的时候通过制定scope=prototype可以设置创建Bean的方式为原型模式，每次调用Bean的时候都会克隆一个对象出来
 *      3.模板模式：父类定义好一些流程，然后将其中一些实现交给子类，例如Spring中的JdbcTemplate就是将拼接SQL和执行SQL的过程交给客户端实现，而加载驱动、建立连接、关闭链接等操作固定在模板中实现
 *      4.观察者模式：就是对象间的一对多关系，当一个对象状态发生改变，依赖它的多个对象都会收到通知并更新，比如Spring中的Listener
 *      5.工厂模式：通过工厂类根据传递进来的参数决定生产哪个对象，例如Spring中的BeanFactory中的getBean
 *      6.代理模式：Spring AOP
 *      7.策略模式：用于解决一个问题的一个算法集合，用户可以选择其中一个算法去解决问题，可以方便的更换或者添加算法，由客户端决定调用哪个算法
 */
public class TotalDemo {
}