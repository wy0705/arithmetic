package ccc;

import java.lang.reflect.Field;

public class Test3 {
    /**
     * 修改字符串内部的值
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param str
     * @param value
     */
    private static void changeStrValue(String str, char[] value) {
        try {
            Field f = str.getClass().getDeclaredField("value");
            f.setAccessible(true);
            f.set(str, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        changeStrValue("abc", new char[]{'d','e','f'});

        // 这里的"abc"字符串和上面调用changeStrValue的参数"abc"会指向同一块内存
        String abc = "abc";
        System.out.println("abc");
        System.out.println(abc);
        System.out.println("abc".equals(abc));
    }

}
