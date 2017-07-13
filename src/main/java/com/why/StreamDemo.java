package com.why;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式操作
 * 根据操作结果：中间操作和最终操作
 * 根据并发性区分：串行和并行操作
 * Created by why on 13/07/2017.
 */
public class StreamDemo {

    static List<PersonInfo> personInfoList = new ArrayList<PersonInfo>(){
        {
            add(new PersonInfo("na", 20));
            add(new PersonInfo("mm", 45));
        }
    };

    public static void main(String[] args) {


        personInfoList.stream().filter((personInfo -> personInfo.getAge() > 20)).forEach(personInfo -> System.out.println(personInfo.getAge()));


    }
}
