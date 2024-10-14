import java.io.*;
import java.net.*;

public class ChatClientUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        socket.connect(new InetSocketAddress("localhost", 1234));
        System.out.println("Koneksi ke server");
        
        // Mengirim pesan ke server
        String message = "Halo, server!";
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, socket);
        socket.send(packet);
        System.out.println("Pesan dikirim ke server");
        
        socket.close();
    }
}