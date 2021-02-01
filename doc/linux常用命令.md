#####1、CPU占用最多的前10个进程： 
````
ps auxw|head -1;ps auxw|sort -rn -k3|head -10 
````
#####2、内存消耗最多的前10个进程:
````
ps auxw|head -1;ps auxw|sort -rn -k4|head -10 
````

#####3、其他排序
````
ps auxw --sort=%cpu
````
