package ccc;

import java.util.List;

public class Test {
    /**
     * 根据类名取得类实例
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param className
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public static <T> T getInstance(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<T> clazz = (Class<T>) Class.forName(className);
        return clazz.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<String> list = getInstance("java.util.ArrayList");
        list.add("abc");
        list.add("def");

        for (String v : list) {
            System.out.println(v);
        }
    }
}
