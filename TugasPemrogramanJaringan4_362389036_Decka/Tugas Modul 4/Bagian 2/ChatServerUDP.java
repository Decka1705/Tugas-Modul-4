import java.io.*;
import java.net.*;

public class ChatServerUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(1234);
        System.out.println("Server berjalan pada port 1234");
        
        while (true) {
            // Menerima pesan dari klien
            DatagramPacket packet = new DatagramPacket(new byte[1024], serverSocket);
            serverSocket.receive(packet);
            String message = new String(packet.getData(), "UTF-8");
            System.out.println("Pesan diterima: " + message);
            
            // Menyebarkan pesan ke semua klien yang terhubung
            for (DatagramPacket clientPacket : clients) {
                if (clientPacket!= null) {
                    clientPacket.setData(message.getBytes());
                    clientPacket.setPort(packet.getPort());
                    clientPacket.setAddress(packet.getAddress());
                    clientPacket.send();
                }
            }
        }
    }
}