Dynamic SQL （动态sql）




## mybatis的配置文件
1. properties 配置
   resource 属性

2. seting 配置

   mapUnderscoreToCamelCase： 是否开启自动驼峰命名规则（camel case）映射，即从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射。 默认false
   
3. typeAliases 类型别名: 只能为单个的类起别名

	package可以为整个包下的所有java类起别名， 如果包下面的自包中还有跟父包相同名称的java类 ， 可以使用@Alisa 给指定的java 类起别名
	   
	  ![](https://github.com/wangjianxiongwjx/mybatis01/blob/master/src/main/img/1562387700.jpg)
  
4. typeHanders 类型处理器

	无论是 MyBatis 在预处理语句（PreparedStatement）中设置一个参数时，还是从结果集中取出一个值时， 都会用类型处理器将获取的值以合适的方式转换成 Java 类型。

5. plugins (插件)

	Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
	ParameterHandler (getParameterObject, setParameters)
	ResultSetHandler (handleResultSets, handleOutputParameters)
	StatementHandler (prepare, parameterize, batch, update, query)

6. environments（环境配置）

	事务管理器（transactionManager）
	数据源（dataSource）
 
7. mysql 支持多数据源环境

8. mapper 标签

    resource 本地环境的文件
    url 网略环境下的资源
    class 引用接口 1. 有sql映射文件，映射文件和mapper文件同名， 并且在同一个包下面
    
    
 **注意** ：标签可以没有但是标签的顺序不能打乱
 
  获取自增主键
useGeneratedKey   相当于jdbc statement.getGenerratedKeys()
keyProperty  赋值给制定的字段


## 参数处理

1. 单个参数 不做特殊处理，#{参数名} 去除参数
2. 多个参数：
	 多个参数会被封装成一个map
	key ： param1 ... paramN， 或者参数的索引 
	命名参数：明确指定封装参数时的map和key @param注解
3. 传入POJO 对象

4. mybatis 特殊参数处理 
![](https://github.com/wangjianxiongwjx/mybatis01/blob/master/src/main/img/1562396468.jpg)

5. 参数只获取#{} 和 ${}

	 #{} 预编译的形式放到sql中，防防sql 注入
	 ${} 将值直接拼接sql，原生jdbc 不支持占位符的地方试用 ${}进行取值
	 例如： 分表,排序，按年份分表
	 select * from${}_salary where ....
	 
	 #{}更丰富的用法 
	   规定参数的一个规则
	 javaType， jdbcType， mode（存储过程），resultMap...
	 jdbcType: 通常需要在目中特殊的情况下被设置：
	 在我们数据位null的时候有些数据库可能不能识别mybatis对null的默认处理：例如oracle
	 #{id, jdbcType=NULL}
	 由于全局配置中：jdbcTypeForNull=OTHER
	 <setings>
	     <string name="jdbcTypeForNull" value="NULL">
	 </setings>
	 
mybatis 返回一个Map<Integer, Employee> 键是记录的主键，value是一个对象

	使用@Mapkey("id") 注解 告诉mybatismap的key是主键

resultMap 级联

	1. 级联属性封装结果集 <result columns="did" property="dept.id">
	2. association 指定这个属性的对象类型
	<association property="dept" javaType="com.wjx.Dept"> 
	   <id columns="did" property="id"></id>
	   <result columns="dname" property="dname"></result>
	</association>
	3.分布查询
	  A.association定义关联对象的封装规则
	  B.select：表明当前属性是调用select指定的方法查出的结果
	  C.columns：指定将那一列的值传给这个方法

lazyLoadingEnabled 延迟加载（按需加载）






 





	
  
 


 
 
 
    
    
   