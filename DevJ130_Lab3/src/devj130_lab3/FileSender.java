
package devj130_lab3;

import java.io.*;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.net.*;


public class FileSender {
    
    public static final int SERVER_PORT = 34567;
    public static final int BUFFER_SIZE = 4096;
    
    public static void main(String[] args) {
        FileSender sender = new FileSender();
        sender.sendFile(new File("D:\\Учёба_Джава\\Лабы_Dev130\\Test.txt"));
    }
    
    public void sendFile(File file){
        try(Socket socket = new Socket("localhost", SERVER_PORT);
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream()){
            FileInputStream fis = new FileInputStream(file);
            byte [] buff = new byte[BUFFER_SIZE];
            int n;
            while((n = fis.read(buff))>-1){
                os.write(buff, 0, n);
                os.flush();
            }
        }
        catch(IOException io){
            System.out.println("Error: "+io.getMessage());}
    }
    
}
