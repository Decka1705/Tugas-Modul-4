import java.io.*;
import java.net.*;
import java.util.*;

public class FileServerTCP {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server berjalan pada port 1234");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Koneksi dari klien diterima");
            
            // Mengirim informasi ke klien bahwa file diterima
            clientSocket.getOutputStream().write("File diterima".getBytes());
            
            // Menerima file dari klien
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            OutputStream output = clientSocket.getOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileInputStream.close();
            output.close();
            System.out.println("File diterima oleh klien");
            
            clientSocket.close();
        }
    }
}