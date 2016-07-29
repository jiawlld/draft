package test.proxy.cglib;

/**
 * User: jiawenlong
 * Date: 16-7-28
 * Time: 下午5:24
 */
public class Test {
    public static void main(String[] args) {

        //代理类
        C c = (C) CglibFactory.getInstance(new C());
        c.print("jiawl");

        C1 c1 = (C1) CglibFactory.getInstance(new C1());
        c1.print1("jiawl");

        //代理接口-实例类都代理了，接口就没啥必要了。。
        I i = (I) CglibFactory.getInstance(new C());
        i.print("jiawl-i");

        I1 i1 = (I1) CglibFactory.getInstance(new C1());
        i1.print1("jiawl-i1");
    }
}
