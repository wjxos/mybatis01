## Mybatis 的缓存机制
默认定义了两级缓存
<setting name="cacheEnabled" value="true"> </setting>
** false ： 关闭缓存，关闭的是二级缓存，以及缓存一直可以用 **

** 一级缓存（本地缓存） ** 

	sqlSession 级别的缓存， 一级缓存是一直开启的，
	与数据库同一次会话期间查询到的数据会放到本地缓存中。
	一级缓存失效的情况
	A. sqlSession 不同
	B. sqlSession 相同，查询条件不同
	C. sqlSession 相同，两次查询之间有增删改
    D. sqlSession 相同，手动清除了一级缓存。 使用SQLSession.cleanCheache()方法；
    
** 二级缓存 （全局缓存）基于namespace 级别的缓存， 一个namespace 对应一个耳机缓存** 

	工作机制
	1. 一个会话查询一条数据，这个数据就会被放在一级缓存中；
	2. 如果会话关闭，一级缓存中的数据就会被放在二级混存中；新的会话查询信息，就可以参照二级缓存中的信息
	3. sqlSession == EmployeeMapper ==>Employee
	                 DepartmentMapper ==>Department
	不同namespace查询出来的数据就会放在自己对应的缓存中
	
	使用
	A. <setting name="cacheEnabled" value="true"> </setting>
	B. mapper.xml中使用
	<cache></cache>
		策略
		<cache eviction=""></cache>
		eviction：缓存的回收策略： 默认（LRU）
		   LRU： 最近最少使用：移除最长时间不被使用的对象。
		   FIFO：先进先出：按对象进入缓存的顺序来移除他们。
		   SOFT：软引用:移除基于垃圾回收器的状态和软引用规则的对象。
		   WEAK：弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象
		flushInterval：缓存的刷新间隔
		readOlay： 
			true 只读
			false 非只读 （默认）	   
		size： 缓存默认放多少个元素
		type： 指定自定义缓存的全类名   
	C. 我们的POJO需要实现序列化接口

** 缓存的相关设置和属性** 
	
	1. 默认定义了两级缓存  false ： 关闭缓存，关闭的是二级缓存，以及缓存一直可以用	   
	name="cacheEnabled" value="true"
	2. 每个select标签都有useCache="true"  
		true： 
		false：不适用缓存（一级缓存依然可用，二级缓存不适用）
	3. 每个增删改标签的flushCache="true"
		增删改完成后就会清除缓存
		测试:一级缓存被清除，二级缓存也会被清除
	4. sqlSession.cleanCache()，只清除当前session的一级缓存。
	5. localCacheScpoe（本地缓存作用域）
		session：当前会话的所有数据保存在缓存中；
		statement：可以禁用以及缓存

**Mybatis 缓存图解**
![](https://github.com/wangjianxiongwjx/mybatis01/blob/master/src/main/img/1562407790.jpg)

	   
	   
	   
	   
	   
	   
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





