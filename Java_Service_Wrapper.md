# 准备工作 #

[安装svn](svn_setup.md)。

[安装ant](ant_setup.md)。

设置环境变量\_JAVA\_HOME

# 下载源代码 #

命令行输入：

```
svn checkout http://simplelife.googlecode.com/svn/trunk/sample.wrapper
```

# 构建和执行 #

命令行，进入sample.wrapper目录。

输入：

```
ant
```

将生成dist目录，在dist目录下，运行：

```
wrapper wrapper.conf
```

这就是使用wrapper启动服务器的简单示例。

# 代码介绍 #

src/sample/wrapper/SampleServer.java：模拟一个服务器程序，取消代码中的异常注释，可以演示wrapper重启的功能。

build.xml和build.properties：ant脚本文件。

res目录中是配置文件和wrapper工具。

dist/wrapper.conf：wrapper的配置文件。