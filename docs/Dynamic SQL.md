if 
choose, when, otherwise
trim, where, set

trim： 

	A. perfix: 加前缀
	B. perfixOverrides：去掉前缀
	C. suffix： 加后缀
	D. duffixOverrides：去掉后缀

两个参数：

	不只是方法传过来的参数可以被使用
	mybatis 默认还有两个内置参数
	_parameter 代表整个参数
	单个参数：_parameter就是整个参数
	多个参数：参数就会被封装为一个map；_parameter就代表这个参数Map
	
	_databaseId: 如果配置了databaseIdProvide标签
	_databaseId代表数据库的别名

bind 标签

	bind： 可以从OGNL表达式的值绑定到一个变量，方便后面引用这个变量的值；
	如： 
	<bind name="_name" value="'%' + name + '%'"/>
	#{_name}




	
	
	
	