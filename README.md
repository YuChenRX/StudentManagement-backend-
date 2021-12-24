# StudentManagement-backend
后端 使用Spring SpringMVC SpringBoot SpringSecurity SpringJPA 目前只是搭了个框架。。。

# BUG 记录
Spring security 的 版本和SpringBoot版本有依赖关系（指序列化和反序列化的时候），切换版本的时候需要注意将**数据库中已经序列化的数据**进行清理操作，不然下次使用该数据的时候会出现反序列化失败的错误
