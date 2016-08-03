package test.unsafe;

/**
 * User: jiawenlong
 * Date: 16-8-3
 * Time: 下午5:18
 */
public class Obj {
    private String a;
    private int b = 10;

    public Obj(){
        a = "jiawl";
        b = 1;
    }

    public Obj(String str){
        a = str;
        b = 1;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
