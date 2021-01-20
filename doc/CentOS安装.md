安装完Linux操作系统后，跟Window系统安装完一样，需要打补丁，升级软件，安装常用软件等。

用yum安装一个下载工具wget
常规命令：````yum install bash-completion wget net-tools -y````

或者：

（1）````curl -s -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo````

第一条是阿里云开源镜像站提供的官方yum源。

（2）````curl -s -o /etc/yum.repos.d/epel.repo http://mirrors.aliyun.com/repo/epel-7.repo````

第二条是epel源，里面包含一些yum源没有的软件，这里选择这一条命令执行。

更新软件到最新
命令：````yum update -y````

Centos6和7要安装的常用企业运维基础工具包
命令：
````
yum install tree nmap dos2unix lrzsz nc lsof wget tcpdump htop iftop iotop sysstat nethogs -y
````
tree：tree以树形结构显示文件和目录

nmap：nmap扫描端口的工具

dos2unix 转换脚本格式的工具

lrzsz 包含上传（rz）下载（sz）文件工具

nc 文件传输、端口检查

lsof 反查端口进程，以及服务开发文件工具

wget 下载软件包工具

tcpdump 抓包、监听等重要排错工具

htop 系统进程相关信息查看工具

iftop 查看主机网卡带宽工具

iotop 

sysstat 含有sar，iostat等重要系统性能查看工具

nethogs 显示进程的网络流量

Centos7需要安装的常用企业运维基础工具包
命令：

````yum install psmisc net-tools bash-completion vim-enhanced -y````

psmisc：含有killall、pstree等命令

net-tools：含有netstat、ifconfig、route、arp等命令

bash-completion：tab补全功能工具包

vim-enhanced：vim编辑器工具包


安装组包
查看安装情况命令：

（1）yum groups mark convert

（2）yum grouplist 

两条前后执行后，查看所有组包的名称，包括已安装的和未安装的。

安装命令：yum groupinstall "System Management" -y

发现安装提示没有可以安装或者更新的包，这个问题的出现，根据网上博客，分析出可能跟第一次安装网络下载包wget选择使用常规下载，没有使用epel源下载，如果采用epel源安装可能能避免这种情况发生。为了解决这个问题手动再安装下epel。

命令：sudo yum install epel-release