package soap;


import soap.common.UserService;
import soap.service.UserServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class ServerApp {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        RpcServerProxy rpcServerProxy = new RpcServerProxy();
        rpcServerProxy.publisher(userService , 8585);
    }



}
