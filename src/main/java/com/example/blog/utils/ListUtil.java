package com.example.blog.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 21:45 2019/3/26
 */
public class ListUtil {

    public static List removeDuplicateWithOrder(List list) {
        List newList = new ArrayList();
        for (Object o : list) {
            if (!newList .contains(o)) newList.add(o);
        }
        return newList;
    }
}
