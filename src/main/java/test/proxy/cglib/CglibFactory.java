package test.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: jiawenlong
 * Date: 16-7-28
 * Time: 下午2:40
 */
public class CglibFactory implements MethodInterceptor{

    private static final CglibFactory CGLIB_PROXY_FACTORY = new CglibFactory();
    private static final Map<Class, Object> CACHE = new ConcurrentHashMap<Class, Object>();

    public static Object getInstance(Object obj){
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(obj.getClass());
//        enhancer.setCallback(CGLIB_PROXY_FACTORY);
//        return enhancer.create();

        return new Enhancer().create(obj.getClass(), CGLIB_PROXY_FACTORY);

//        if(CACHE.containsKey(obj.getClass())){
//            return CACHE.get(obj.getClass());
//        } else {
//            Object res = new Enhancer().create(obj.getClass(), CGLIB_PROXY_FACTORY);
//            CACHE.put(obj.getClass(), res);
//            return res;
//        }
    }

    private CglibFactory(){
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib:before");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("Cglib:after");
        return res;
    }
}
