package Socket;

/**
 * Created by Cass on 2016/6/20.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket ;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(is));
            PrintStream ps = new PrintStream(os);
            while(true){
                String temp = br.readLine();//读取客户端输入的消息
                ps.println("服务器端消息:" + temp);//服务器端简单处理一下。
                if(temp.equals("bye")){
                    //如果客户端输入bye,推出循环结束。
                    break;
                }
            }
            ps.close();
            br.close();
            socket.close();
        }catch(Exception rr){
            rr.printStackTrace();
        }
    }
}