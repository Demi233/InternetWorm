# 基于Jsoup的爬取网站图书信息的网络爬虫
    1、该系统是爬取网站上的图书信息，然后展示到网页上供用户操作，可以便捷的了解到用户的喜好和购买方向。
    2、该系统运用了Java、Jsoup等技术进行对网站上数据的主题爬取操作，可以定向地爬取用户所需的图书信息，过滤掉无用的信息。
    3、将爬取到的数据信息存储到MySQL数据库中。
    4、将存储到数据库的数据展示到网页上便于用户的查看、进行简单的操作等等。
# Jsoup 技术介绍
    Jsoup是一个Java库即用来处理HTML。它提供了一个极其方便的API，用于提取数据和操作数据，使用的是CSS、DOM和jquery类似的方法。
    Jsoup主要的功能如下：
      1、提取和解析HTML。
      2、使用DOM遍历或CSS选择器查找和提取数据。
      3、操作文本、属性和HTML元素。
      4、清洁用户提交的内容与安全的白名单，以防止XSS攻击。
      5、输出HTML整洁
# 功能
    系统主要分为八个功能模块：登录模块、根据关键词爬取图书数据并存储到数据库、获取数据库信息并展示到网页上、查询图书的详细信息、删除数据操作、模糊查询操作、刷新操作、退出系统。
# 实现
    1、主页模块如下图所示：
   ![Image text](https://github.com/Demi233/InternetWorm/raw/master/crawlerBook/src/main/webapp/images/indexImg.png)
   
    2、一本书的详情模块如下图所示：
   ![Image text](https://github.com/Demi233/InternetWorm/raw/master/crawlerBook/src/main/webapp/images/bookImg.png)
   
    3、该系统爬取的信息存储到数据库如下图所示：
   ![Image text](https://github.com/Demi233/InternetWorm/raw/master/crawlerBook/src/main/webapp/images/sqlImg.png)
# 遇到的问题
    大部分设计是可以实现的，拥有较好的页面显示和排版。但是，该系统中也存在着一些不足，比如多线程的进行爬虫等。
    自学的一个demo，望各路大神指点哇！谢谢阅读😜。
