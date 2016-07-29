package test.proxy.jdk;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Proxy;

/**
 * User: jiawenlong
 * Date: 16-7-28
 * Time: 下午5:19
 */
public class Test {
    public static void main(String[] args) {
        ((I)ProxyFactory.getInstance(new C())).print("jiawl");
        ((I1)ProxyFactory.getInstance(new C1())).print1("jiawl");

        Object obj = ProxyFactory.getInstance(new C());

        System.out.println(obj.getClass().getName());
        System.out.println(obj.getClass().getSuperclass().getName());
        System.out.println(JSONObject.toJSONString(obj.getClass().getInterfaces()));

        System.out.println(obj.getClass().getSuperclass().getName());
    }
}
