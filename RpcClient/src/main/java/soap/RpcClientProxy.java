package soap;

import java.lang.reflect.Proxy;
import java.rmi.server.RemoteObjectInvocationHandler;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class RpcClientProxy  {

    public <T> T clientProxy(Class<T> interfaceT , String host , int port) {
        return (T)Proxy.newProxyInstance(interfaceT.getClassLoader() , new Class<?>[]{interfaceT} , new RemoteHandle(host , port));
    }
}
