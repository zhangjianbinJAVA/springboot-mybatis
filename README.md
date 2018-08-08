## 通过拦截器切换数据源
#### 查询 ds1 的数据库
post: 127.0.0.1:8909/db/mysql?db=ds1     
body: select * from person   

#### 查询 ds2 的数据库
post: 127.0.0.1:8909/db/mysql?db=ds2 
body: select * from person

## 通过注解切换数据源
#### 查询 ds1 的数据库
get: 127.0.0.1:8909/all-one  

#### 查询 ds2 的数据库
get: 127.0.0.1:8909/all-two 
