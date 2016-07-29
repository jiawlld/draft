package test.proxy.jdk;

/**
 * User: jiawenlong
 * Date: 16-7-28
 * Time: 下午2:25
 */
public class C1 implements I, I1{

    @Override
    public void print(String str) {
        System.out.println("C:" + str);
    }

    @Override
    public String returnVal(String str) {
        return str;
    }

    @Override
    public void print1(String str) {
        System.out.println("C1:" + str);
    }
}