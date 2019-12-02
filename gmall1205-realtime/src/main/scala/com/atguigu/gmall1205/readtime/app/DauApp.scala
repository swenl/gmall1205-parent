package com.atguigu.gmall1205.readtime.app

import com.atguigu.gmall1205.common.constant.GmallConstant
import com.atguigu.gmall1205.readtime.util.MyKafkaUtil
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Description：xxxx<br/>
  * Copyright (c) ，2019 ， Wenlongshiii <br/>
  * This program is protected by copyright laws. <br/>
  * Date： 2019年12月01日  
  *
  * @author 史文龙
  * @version : 1.0
  */
object DauApp {
   def main(args: Array[String]): Unit = {
      val sparkConf: SparkConf = new SparkConf().setAppName("dau_app").setMaster("local[*]")

      val ssc = new StreamingContext(sparkConf,Seconds(5))

      //消费Kafka中消息
      val inputDstream: InputDStream[ConsumerRecord[String, String]] = MyKafkaUtil.getKafkaStream(GmallConstant.KAFKA_TOPIC_STARTUP,ssc)

      inputDstream.foreachRDD(rdd =>
         println(rdd.map(_.value()).collect().mkString("\n"))
      )

      ssc.start()

      ssc.awaitTermination()
   }




}
