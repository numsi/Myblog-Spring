package com.test.utils;

import java.util.List;

/**
 * @author numsi
 * @date 2020/5/2 21:57
 */
public class ListUtis {
    public static boolean isNotNullEmpty(List<?> list){
        if(list!=null&&list.size()>0&&list.get(0)!=null)
            return true;
        return false;
    }
}
