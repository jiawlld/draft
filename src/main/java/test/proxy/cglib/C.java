package test.proxy.cglib;

/**
 * User: jiawenlong
 * Date: 16-7-28
 * Time: 下午2:25
 */
public class C implements I {

    @Override
    public void print(String str) {
        System.out.println("C:" + str);
    }

    @Override
    public String returnVal(String str) {
        return str;
    }
}