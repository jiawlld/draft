package test.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * http://www.infoq.com/cn/articles/A-Post-Apocalyptic-sun.misc.Unsafe-World
 * User: jiawenlong
 * Date: 16-8-3
 * Time: 下午5:19
 */
public class Test {
    private static final Unsafe unsafe = getUnsafeInstance();

    public static void main(String[] args) throws InstantiationException, ClassNotFoundException, IllegalAccessException {

//        会有异常。unsafe里的代码安全校验会报错 http://www.cnblogs.com/focusj/archive/2012/02/20/2359119.html
//        Obj obj = (Obj) Unsafe.getUnsafe().allocateInstance(Obj.class);
//        System.out.println(obj.getA());
//        System.out.println(obj.getB());

        //绕过构造函数
        Obj obj = (Obj) unsafe.allocateInstance(Obj.class);
        System.out.println(obj.getA());
        System.out.println(obj.getB());

        //调用默认的无参构造函数
        obj = (Obj) Class.forName("test.unsafe.Obj").newInstance();
        System.out.println(obj.getA());
        System.out.println(obj.getB());
    }

    private static Unsafe getUnsafeInstance()  {
        Field theUnsafeInstance = null;
        try {
            theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        theUnsafeInstance.setAccessible(true);
        try {
            return (Unsafe) theUnsafeInstance.get(Unsafe.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
