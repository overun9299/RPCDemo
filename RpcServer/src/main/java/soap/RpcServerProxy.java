package soap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class RpcServerProxy {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object server , int port) {
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            /** 接受一个请求 */
            Socket accept = serverSocket.accept();
            executorService.execute(new ProcessorHandler(accept , server));

        } catch (Exception e) {

        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
