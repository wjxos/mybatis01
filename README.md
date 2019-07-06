## mybatis的配置文件
1. properties 配置
   resource 属性

2. seting 配置

   mapUnderscoreToCamelCase： 是否开启自动驼峰命名规则（camel case）映射，即从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射。 默认false
   
3. typeAliases 类型别名: 只能为单个的类起别名
   package可以为整个包下的所有java类起别名， 如果包下面的自包中还有跟父包相同名称的java类 ， 可以使用@Alisa 给指定的java 类起别名
    
   