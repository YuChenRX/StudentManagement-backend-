# StudentManagement-backend
后端 使用Spring SpringMVC SpringBoot SpringSecurity SpringJPA 目前只是搭了个框架。。。

# BUG 记录
Spring security 的 版本和SpringBoot版本有依赖关系（指序列化和反序列化的时候），切换版本的时候需要注意将**数据库中已经序列化的数据**进行清理操作，不然下次使用该数据的时候会出现反序列化失败的错误

麻了，我裂开，明明该开的接口都开了，oauth2也开放了，一访问就让我登录。。。我。。

两天了！两天了！你知道我这两天这么过的吗？解决不了啊啊啊该死的Spring Security 

5 天了！ 5天了！ 这是个啥玩意啊！

麻了,别人的电脑都能跑,就我会出现跨域问题,先写后端接口吧,至少我的postwoman珂以访问接口(迫真
