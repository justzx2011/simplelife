# 简介 #

实现简单的用户信息管理功能（增/删/改/查）。

演示Ant的基本使用。

通过Ant构建，生成文档，打包和部署。

# 下载和使用 #

## 准备工作 ##

安装jdk，并设置JAVA\_HOME

安装subversion, 下载地址: http://subversion.tigris.org/files/documents/15/39559/svn-1.4.5-setup.exe

检查subversion是否安装成功：

```
svn --version
```

安装Ant，下载地址：http://ant.apache.org/

配置Ant，在环境变量中加入ant的bin目录

检查Ant是否安装成功：

```
ant -version
```

## 下载源代码 ##

打开命令行, 进入某个目录(源代码将下载到该目录下)

输入如下命令:
```
svn checkout http://simplelife.googlecode.com/svn/trunk/sample.ant
```

## 编译与构建 ##

命令行进入sample.ant目录

输入命令，列出所有可执行任务：
```
ant -projecthelp
```

应该列出如下提示：
```
Buildfile: build.xml

Main targets:

 archive   打包java程序
 clean     清理中间数据
 compile   编译java程序
 deploy    部署web项目
 init      初始化工作
 javadocs  生成javadoc
 undeploy  卸载web项目
 war       生成war文件
Default target: archive
```

输入以下命令对java文件打包：
```
ant
```

或者：
```
ant archive
```

清理中间数据，清除build和dist目录：
```
ant clean
```

其他暂略。