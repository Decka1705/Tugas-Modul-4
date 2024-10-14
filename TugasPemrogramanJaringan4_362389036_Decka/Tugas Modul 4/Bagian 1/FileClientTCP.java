import java.io.*;
import java.net.*;

public class FileClientTCP {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Koneksi ke server");
        
        // Mengirim informasi ke server bahwa file dikirim
        socket.getOutputStream().write("File dikirim".getBytes());
        
        // Mengirim file ke server
        FileInputStream fileInputStream = new FileInputStream("file.txt");
        OutputStream output = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = fileInputStream.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
        fileInputStream.close();
        output.close();
        System.out.println("File sudah dikirim ke server Asli");
        
        socket.close();
    }
}