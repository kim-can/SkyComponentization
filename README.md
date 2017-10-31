# SkyComponentization

## 结构图

 ![image](https://github.com/skyJinc/SkyComponentization/blob/master/picture/1.png)

## 模块关系图

![image](https://github.com/skyJinc/SkyComponentization/blob/master/picture/2.png)


## 组件之间资源名
    //设置了resourcePrefix值后，所有的资源名必须以指定的字符串做前缀，否则会报错。
    //但是resourcePrefix这个值只能限定xml里面的资源，并不能限定图片资源，所有图片资源仍然需要手动去修改资源名。
    resourcePrefix "girls_"


## 说明

    1.app壳 - 空壳工程，没有任何的业务代码，也不能有Activity 
	    1.Android应用的打包签名，以及buildTypes和defaultConfig都需要在这里配置
	    2.app壳工程的 AndroidManifest.xml 是我Android应用的根表单 其他组件都会合并到这里
	    3.app壳工程的 build.gradle 是比较特殊的
	    
    2.业务组件  - n个
	    1.业务组件定义根据组件名称声明资源信息
	    2.业务组件中要有两张AndroidManifest.xml 分别对应组件开发模式和集成开发模式
	    3.业务组件有debug文件夹，这个文件夹在集成模式下会从业务组件的代码中排除掉
    3.main组件 - 首页
        1.Main组件集成模式下的AndroidManifest.xml是跟其他业务组件不一样的，Main组件的表单中声明了我们整个Android应用的launch Activity
    4.功能组件
	    1.功能组件的 AndroidManifest.xml 是一张空表，这张表中只有功能组件的包名
	    2.功能组件不管是在集成开发模式下还是组件开发模式下属性始终是：    com.android.library
    5.common公共组件
	    1.具有部分功能组件的属性
	    2.AndroidManifest.xml  声明权限
	    3.build.gradle 声明共用依赖
	    4.res 共用资源也放到这里
    6.混淆问题
        组件化项目的Java代码混淆方案采用在集成模式下集中在app壳工程中混淆，各个业务组件不配置混淆文件