package test.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: jiawenlong
 * Date: 16-7-29
 * Time: 下午5:44
 */
public class Test {


    private static final int SC_OK = 200; // 成功

    private static final int SC_NOT_MODIFIED = 304;// 没有修改

    private static final int SC_NOT_FOUND = 404;// 请求url不存在

    private static final int SC_SERVICE_UNAVAILABLE = 503;// 服务不可用

    private final static  String HTTP_PREFIX = "http://";  //http请求前缀

    private final AtomicInteger domainNamePos = new AtomicInteger(0);//用来对机器进行逐个的访问

    private int retryCount = 3;//重试次数

    public static void main(String[] args) {
        System.out.println(10000>>124);
//        new Test().action();
    }

    private Object action() {

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = null;

        try {
            postMethod = new PostMethod("//www.baidu.com");
            HttpMethodParams params = new HttpMethodParams();
            params.setSoTimeout(5000);
            postMethod.setParams(params);
            int httpStatus = httpClient.executeMethod(postMethod);
            switch (httpStatus) {
                case SC_OK: {
                    return postMethod;
                }
                case SC_SERVICE_UNAVAILABLE: {
                    break;
                }
                case SC_NOT_FOUND: {
                    break;
                }
                case SC_NOT_MODIFIED: {
                    break;
                }
                default:
                    break;
            }
        } catch (Exception e) {
        }finally{
            if(postMethod != null){
                try{
                    postMethod.releaseConnection();
                }catch(Exception e){
                }
            }
        }
        return null;
    }
}
