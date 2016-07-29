package test.proxy.jdk;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: jiawenlong
 * Date: 16-7-28
 * Time: 下午2:24
 */
public class ProxyFactory implements InvocationHandler {
    Object object;

    private ProxyFactory(Object object){
        this.object = object;
    }

    public static Object getInstance(Object object){
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),
                object.getClass().getInterfaces(), new ProxyFactory(object));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ProxyHandler.invoke:before");
        Object res = method.invoke(object, args);
        System.out.println("ProxyHandler.invoke:after");
        return res;
    }
}