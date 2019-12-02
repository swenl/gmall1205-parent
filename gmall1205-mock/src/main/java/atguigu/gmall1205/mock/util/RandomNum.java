package atguigu.gmall1205.mock.util;
import java.util.Random;
/**
 * Description：xxxx<br/>
 * Copyright (c) ，2019 ， Wenlongshiii <br/>
 * This program is protected by copyright laws. <br/>
 * Date： 2019年11月28日
 *
 * @author 史文龙
 * @version : 1.0
 */
public class RandomNum {

    public static final  int getRandInt(int fromNum,int toNum){
        return   fromNum+ new Random().nextInt(toNum-fromNum+1);
    }
}

