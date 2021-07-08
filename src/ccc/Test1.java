package ccc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
    /**
     * 打印类的属性
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param clazz
     */
    public static void printFields(Class clazz) {
        System.out.println(clazz.getName() + "包含如下属性：");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }
    }

    /**
     * 打印类的方法
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param clazz
     */
    public static void printMethods(Class clazz) {
        System.out.println(clazz.getName() + "包含如下方法：");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        printFields(MyClass.class);
        printMethods(MyClass.class);
    }
}

class MyClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
