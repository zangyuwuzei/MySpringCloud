**项目说明**
==================================

- 个人学习用,希望用此搭建基于springCloud的完整结构
- 同时搭载想实现的 [^小功能]
-



 **技术选型：**

- 核心框架：Spring Boot 2.1
- 安全框架：Apache Shiro 1.4
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.5
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x

<br>

 **软件需求**

- JDK1.8
- MySQL5.5+
- Maven3.0+

<br>

```
graph LR
start[开始] --> input[输入A,B,C]
input --> conditionA{A是否大于B}
conditionA -- YES --> conditionC{A是否大于C}
conditionA -- NO --> conditionB{B是否大于C}
conditionC -- YES --> printA[输出A]
conditionC -- NO --> printC[输出C]
conditionB -- YES --> printB[输出B]
conditionB -- NO --> printC[输出C]
printA --> stop[结束]
printC --> stop
printB --> stop
```

```
st=>start: Start|past:>http://www.google.com[blank]
e=>end: End:>http://www.google.com
op1=>operation: My Operation|past
op2=>operation: Stuff|current
sub1=>subroutine: My Subroutine|invalid
cond=>condition: Yes
or No?|approved:>http://www.baidu.com
c2=>condition: Good idea|rejected
io=>inputoutput: catch something...|request
st->op1(right)->cond
cond(yes, right)->c2
cond(no)->sub1(left)->op1
c2(yes)->io->e
c2(no)->op2->e
```　

