package test.getcallerclass;

import sun.reflect.Reflection;

/**
 * User: jiawenlong
 * Date: 16-8-4
 * Time: 上午11:21
 */
public class ClassLevel {
    public void currentClass(){
        System.out.println(Reflection.getCallerClass(-222).getName());
        System.out.println(Reflection.getCallerClass(0).getName());
        System.out.println(Reflection.getCallerClass(1).getName());
        System.out.println(Reflection.getCallerClass(2).getName());
        System.out.println(Reflection.getCallerClass(3).getName());
        // Exception in thread "main" java.lang.NullPointerException
//        System.out.println(Reflection.getCallerClass(4).getName());
    }
}
