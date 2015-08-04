# 介绍 #

以下编写了一个linux服务器创建过程。

使用的是ubuntu7.0.4，当前推出7.1.0版本，估计安装配置过程没有区别（有时间再做测试）。

这个版本非常简单，只包含基本功能，供java开发人员使用和调试：

  * linux基本功能；

  * samba，用于为windows系统共享目录；

  * java 1.6

  * tomcat 5.5，系统启动时自动启动

# 详细过程 #

## 下载和基本安装 ##

> 下载ubuntu Server版本，链接是：http://mirror.rootguide.org/ubuntu-releases/gutsy/ubuntu-7.10-server-i386.iso

基本安装，略

## 更新source.list ##

```
sudo apt-get update
```

## 安装基本功能 ##

```
sudo apt-get -y install autoconf libtool g++ make rcconf
```

## 启用和屏蔽root帐号 ##

启用和屏蔽root帐号，系统默认是屏蔽root帐号的，测试时为方便使用临时开放。

启用root帐号：
```
sudo passwd root
```

屏蔽root帐号：
```
sudo passwd -l root
```

切换到root帐号：
```
sudo -s -H
```

## SSH的安装 ##

服务器端：

```
sudo apt-get install ssh
```

客户端，下载Secure Shell Client，免费软件，http://www.onlinedown.net/soft/20089.htm

## 配置网络 ##

暂略

## samba的安装和配置 ##

安装：
```
sudo apt-get install samba 
sudo apt-get install smbfs
```

编辑配置文件：
```
sudo gedit /etc/samba/smb.conf
```

替代这一行:

```
; security = user
```

为
```
security = user 
username map = /etc/samba/smbusers
```

将下面内容复制到该文件的尾部
```
[Share] 
comment = Shared Folder with username and password 
path = /home/zhangsan/share
public = yes 
#writable = yes
valid users = zhangsan
create mask = 0700 
directory mask = 0700 
force user = zhangsan
force group = zhangsan
available = yes 
browseable = yes
```

创建用户：
```
sudo smbpasswd -a zhangsan
```

重启samba：
```
sudo smbd restart
```

## Java环境的安装和配置 ##

安装：
```
sudo apt-get install sun-java6-jdk
```

设置JAVA\_HOME：

```
sudo vim /etc/profile
```

在文件结尾加入：
```
export JAVA_HOME=/usr/lib/jvm/java-6-sun-1.6.0.00
```

## 安装tomcat ##

安装：
```
sudo apt-get install tomcat5.5-webapps tomcat5.5-admin
```

默认访问端口为8180.

配置JAVA\_HOME，修改/etc/init.d/tomcat5.5:

```
export JAVA_HOME=/usr/lib/jvm/java-6-sun-1.6.0.00
```