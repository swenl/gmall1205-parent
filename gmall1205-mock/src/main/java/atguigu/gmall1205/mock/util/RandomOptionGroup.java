package atguigu.gmall1205.mock.util;
import java.util.ArrayList;
import java.util.List;
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
public class RandomOptionGroup<T> {

    int totalWeight=0;

    List<RanOpt> optList=new ArrayList();

    public   RandomOptionGroup(RanOpt<T>... opts) {
        for (RanOpt opt : opts) {
            totalWeight+=opt.getWeight();
            for (int i = 0; i <opt.getWeight() ; i++) {
                optList.add(opt);
            }

        }
    }

    public RanOpt<T> getRandomOpt() {
        int i = new Random().nextInt(totalWeight);
        return optList.get(i);
    }


    public static void main(String[] args) {
        RanOpt[] opts= {new RanOpt("zhang3",20),new RanOpt("li4",30),new RanOpt("wang5",50)};
        RandomOptionGroup randomOptionGroup = new RandomOptionGroup(opts);
        for (int i = 0; i <10 ; i++) {
            System.out.println(randomOptionGroup.getRandomOpt().getValue());
        }

    }





}


