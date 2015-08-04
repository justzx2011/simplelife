# SimpleLife.Product项目 #

## 简介 ##

实现简单的商品管理(增/删/改/查)功能.

使用Java多项技术, 包含Hibernate3.2/Spring2.0/Struts2.0等.

通过Maven自动构建, 简化开发和部署等.

## 下载和构建 ##

### 准备工作 ###

  1. 安装JDK 1.6.0及以上版本;
  1. 安装subversion, 下载地址: http://subversion.tigris.org/files/documents/15/39559/svn-1.4.5-setup.exe
  1. 安装maven, 下载地址: http://www.apache.org/dyn/closer.cgi/maven/binaries/maven-2.0.7-bin.tar.gz, 解压缩
  1. 检查subversion安装是否成功:
```
svn --version
```
  1. 配置maven, 将maven/bin目录设置到windows环境变量Path中
  1. 检查maven是否安装成功, 在命令行中执行
```
mvn -version
```

### 下载源代码 ###

打开命令行, 进入某个目录(<sub>源代码将下载到该目录下</sub>)

输入如下命令:

```
svn checkout http://simplelife.googlecode.com/svn/trunk/simplelife.product
```

运行结束后, 在该目录下, 会有一个simplelife.product目录, 源代码在simplelife.product/src目录下

### 编译和运行 ###

#### 前提条件 ####

因为下面编译过程会自动从互联网下载依赖的类库, 所以必须联网才能执行下面过程.

#### 编译 ####

在命令行simplelife目录下, 输入:

```
mvn package
```

如果是第一次执行, 下载依赖类库需要很多时间, 以后将使用本地库.

执行后生成target目录, 和src并列.

target目录下的simplelife.product.war可以部署到tomcat等服务器中执行.

#### 运行 ####

可以跳过上面编译, 直接运行web应用, 不需要安装配置数据库和web服务器.

这里会自动安装web应用服务器, 编译系统并执行.

_**执行前请检查8080端口是否可用, 这里需要使用该端口.**_

在命令行simplelife目录下, 输入:

```
mvn jetty:run
```

然后通过浏览器访问: http://localhost:8080/simplelife.product

#### 可能出现的问题和解决办法 ####

如果在执行上述任务中出现以下提示：

```
...

[INFO] Failed to resolve artifact.

Missing:
----------
1) javax.transaction:jta:jar:1.0.1B

  Try downloading the file manually from:
      http://java.sun.com/products/jta

  Then, install it using the command:
      mvn install:install-file -DgroupId=javax.transaction -DartifactId=jta \
          -Dversion=1.0.1B -Dpackaging=jar -Dfile=/path/to/file
Alternatively, if you host your own repository you can deploy the file there:
    mvn deploy:deploy-file -DgroupId=javax.transaction -DartifactId=jta \
          -Dversion=1.0.1B -Dpackaging=jar -Dfile=/path/to/file \
           -Durl=[url] -DrepositoryId=[id]

  Path to dependency:
        1) simplelife.googlecode.com:simplelife.product:war:0.1.0
        2) javax.transaction:jta:jar:1.0.1B

...
```

提示说的很清楚，因为缺少jta包，这个需要手工下载和安装。

简易的办法是：

  * 通过http://java.sun.com/products/jta 网页提示的链接找到1.0.1b版本下载”jta-1\_0\_1B-classes.zip“文件

  * 将下载的文件改名为jta-1.0.1B.jar

  * 找到maven的“.m2”目录，一般在C:\Documents and Settings\你的用户名目录下

  * 找到”.m2“目录下的”repository\javax\transaction\jta\1.0.1B“目录

  * 将改名后的jta-1.0.1B.jar文件复制到上述”repository\javax\transaction\jta\1.0.1B“目录下


## 开发者文档 ##

以上是作为部署者和使用者需要执行的内容.

如果需要理解系统设计和参与开发, 需要

命令行执行:

```
mvn site
```

生成系统文档网站.

访问生成的文档: simplelife.product/target/site/index.html

其中主要内容有:

  1. 问题追踪: 提供问题管理的工具链接, 可提交bug或者希望增加(增强)的功能
  1. 项目授权: 授权协议
  1. 项目团队: 所有对本项目有贡献的人员列表和联系方式等
  1. 项目依赖: 本项目依赖的库的列表
  1. 邮件列表: 是一个BBS/邮件列表, 可以象BBS一样发帖和跟帖, 所有变化又作为邮件发给用户
  1. 源代码库: 提供链接, 在浏览器浏览源代码, 并说明如何通过subversion工具下载源代码
  1. 项目报告: 有关代码的javadoc, 准备将详细设计由javadoc生成, 另外, 有测试的报告.