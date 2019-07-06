## mybatis 的实现方式
1. 从 SqlSessionFactory 中获取 SqlSession,通过 SqlSession 实例来直接执行已映射的 SQL 语句
2. 使用完全限定名调用 Java 对象的方法类似。这样，该命名就可以直接映射到在命名空间中同名的 Mapper 类，并将已映射的 select 语句中的名字、参数和返回类型匹配成方法。

优势:首先它不依赖于字符串字面值，会更安全一点； 其次，如果你的 IDE 有代码补全功能，那么代码补全可以帮你快速选择已映射的 SQL 语句。