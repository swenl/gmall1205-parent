package atguigu.gmall1205.mock.util;

import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description：xxxx<br/>
 * Copyright (c) ，2019 ， Wenlongshiii <br/>
 * This program is protected by copyright laws. <br/>
 * Date： 2019年11月28日
 *
 * @author 史文龙
 * @version : 1.0
 */




public class LogUploader {




    public static void sendLogStream(String log){
        try{
            //不同的日志类型对应不同的URL

            URL url  =new URL("http://hadoop102/log");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为post
            conn.setRequestMethod("POST");

            //时间头用来供server进行时钟校对的
            conn.setRequestProperty("clientTime",System.currentTimeMillis() + "");
            //允许上传数据
            conn.setDoOutput(true);
            //设置请求的头信息,设置内容类型为JSON
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            System.out.println("upload" + log);

            //输出流
            OutputStream out = conn.getOutputStream();
            out.write(("log="+log).getBytes());
            out.flush();
            out.close();
            int code = conn.getResponseCode();
            System.out.println(code);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}



