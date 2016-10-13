#spring-springmvc-mybatis
##手把手教你如何搭建一个Spring SpringMVC Mybatis项目

----
###一、搭建一个Maven项目，在pom导入相关的依赖包，具体可以查看本项目的pom文件，该pom文件配置好的依赖包全是项目框架的核心依赖包。
###二、web.xml的核心配置：（以本项目为例）
#####1、spring的相关配置：
    <!-- Spring的必须配置  ContextLoaderListener容器-->
    <listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</liste
        ner-class>
	</listener>
	<!-- 读取spring配置文件 -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:conf/spring.xml;
			classpath:conf/spring-mybatis.xml
		</param-value>
	</context-param>
#####2、springmvc的相关配置：
    <!-- springMVC核心配置 -->
    <servlet>
		<servlet-name>spring</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:conf/spring-mvc.xml</param-value>
		</init-param>
		<load-on-startup>2</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>spring</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
###三、Spring、SpringMVC、Mybatis三个框架对应的xml配置文件分别对应为spring.xml(spring)、spring-mybatis.xml 和 spring-mvc.xml(springmvc)、mybatis-config.xml(mybatis)，至于为什么要分成这几个文件呢，因为这样分的话可以让配置文件条理相对清晰，spring对应的spring.xml配置文件主要管理service层，如spring的配置文件：

    <!-- 扫描文件（自动将servicec层注入） -->
    <context:component-scan base-package="cn.springmvc.service" />

###这样可以让spring.xml去管理好service层。相应的spring-mybatis可以管理好model层，spring-mvc可以管理好controller层。
###三、 须注意的一点是，使用Mybatis开发的dao层和hibernate不一样，使用Mybatis的dao层是接口，而具体的操作在对应的Mapper文件中。
-----
##ps:想要了解的更加清楚的可以查看项目源码。