# 使用JavaDB的简单例子 #

## 安装svn ##

  * 安装subversion, 下载地址: http://subversion.tigris.org/files/documents/15/39559/svn-1.4.5-setup.exe

  * 检查安装是否成功，在命令行中输入：
```
svn --version
```

## 导出源代码 ##

在命令行中，进入指定存放下载代码的目录，然后输入：

```
svn export http://simplelife.googlecode.com/svn/trunk/sample.javadb
```

成功后，应该在当前目录下有一个sample.javadb目录，在sample.javadb目录下有一个src目录，源代码就存放在这个目录中。

## 源代码导入到eclipse项目 ##

本文使用eclipse 3.3.1。

要求使用JDK 1.6.0以上版本。

过程如下：

  * 创建java项目

  * 为该项目增加junit4的类库支持，选择build path ……

  * 创建javadb用户库，将C:\Program Files\Sun\JavaDB\lib中的derby.jar加入到该用户库

  * 为该项目增加javadb的类库支持

  * 将从svn下载的源代码复制到java项目的src目录下

## 学习源代码 ##

建议先运行com.googlecode.simplelife.sample.javadb.UserDaoTest，然后以该测试类为线索，结合javadb文档，在
C:\Program Files\Sun\JavaDB\docs目录下，学习理解源代码。