# gy.upms
-------------------------------------------------
## master 使用dubbo
- 一套以spring boot为基础开发的权限api 数据库采用mysql 
- upms为基础服务 后续服务需向该服务请求 验证授权
- 服务验证基础数据库配置 每个服务启动时获取自己标识 向本服务请求
- 用户验证基于数据库配置 用户登录成功写入服务本地缓存并写入redis 
## spring-cloud 使用spring-cloud
- 基础cloud框架搭建

******************************************************
## web 是iview-admin 
- 只是初步考虑前端开发 没有实际功能
