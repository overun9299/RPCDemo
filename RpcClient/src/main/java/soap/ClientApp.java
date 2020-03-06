package soap;


import soap.common.RpcRequest;
import soap.common.User;
import soap.common.UserService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class ClientApp {

    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        UserService userService = rpcClientProxy.clientProxy(UserService.class , "127.0.0.1" , 8585);
        User userIfoById = userService.getUserIfoById(3);
        System.out.println(userIfoById);
    }


}
