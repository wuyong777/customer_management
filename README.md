# customer_management

#### 介绍
一个简单的javaweb项目：用户管理系统

#### 软件架构
MVC模式：三层架构
后端技术：Servlet+JavaBean+JSP+EL+JSTL,采用MySQL数据库，用Druid连接池，JdbcTamplate封装JDBC开发
前端技术：HTML+CSS+JS+Bootstrap框架

#### 安装教程
1.  安装ieda，导入项目
2.  安装MySQL，建数据库，建表
3.  调试运行

#### 使用说明
1.  不同版本的数据库要对应的jar包，不然会报错

#### 实现的功能
1. 登录  带验证码功能
2. 添加用户  带表单验证
3. 删除用户  可全选，反选。有安全提示功能
4. 修改用户  带数据回显功能
5. 查询用户  可模糊查询，可复杂组合查询
6. 分页展示  每页显示10条记录