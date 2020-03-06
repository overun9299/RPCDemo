package soap;

import soap.common.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class RemoteHandle implements InvocationHandler {

    /**  */
    private String host;
    /**  */
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public RemoteHandle(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        Socket socket = new Socket(host , port);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(rpcRequest);
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object o = objectInputStream.readObject();

        objectOutputStream.close();
        objectInputStream.close();
        return o;
    }
}
