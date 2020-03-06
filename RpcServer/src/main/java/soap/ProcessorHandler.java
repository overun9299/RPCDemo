package soap;

import soap.common.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class ProcessorHandler  implements Runnable{

    Socket socket;
    Object server;


    public ProcessorHandler(Socket socket, Object server) {
        this.socket = socket;
        this.server = server;
    }

    public ProcessorHandler() {
    }

    public void run() {
        try {
            System.out.println("开始处理客户端请求");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest o = (RpcRequest)objectInputStream.readObject();
            Object invoke = invoke(o);

            /** 返回结果 */
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(invoke);
            objectOutputStream.flush();

            objectInputStream.close();
            objectOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private Object invoke(RpcRequest rpcRequest) {
        Object[] parameters = rpcRequest.getParameters();
        Class<?>[] tyeps = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            tyeps[i] = parameters[i].getClass();
        }
        try {
            Method method = server.getClass().getMethod(rpcRequest.getMethodName(), tyeps);
            Object invoke = method.invoke(server, parameters);
            return invoke;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
