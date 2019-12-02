package com.atguigu.gmall1205.readtime.util

import java.io.InputStreamReader
import java.util.Properties

/**
  * Description：xxxx<br/>
  * Copyright (c) ，2019 ， Wenlongshiii <br/>
  * This program is protected by copyright laws. <br/>
  * Date： 2019年12月01日  
  *
  * @author 史文龙
  * @version : 1.0
  */
object PropertiesUtil {
  def main(args: Array[String]): Unit = {
    val properties: Properties = PropertiesUtil.load("config.properties")

    println(properties.getProperty("kafka.broker.list"))
  }

  def load(propertieName:String): Properties ={
    val prop=new Properties();
    prop.load(new InputStreamReader(Thread.currentThread().getContextClassLoader.getResourceAsStream(propertieName) , "UTF-8"))
    prop
  }

}
