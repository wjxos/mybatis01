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
 
    
    
   