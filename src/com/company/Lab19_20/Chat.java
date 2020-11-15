package com.company.Lab19_20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите имя пользователя: ");
        String localAdress = "127.0.0.1";
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        DatagramSocket socket = new DatagramSocket();
        byte[] username = name.getBytes();
        DatagramPacket packet = new DatagramPacket(username, 0, username.length, InetAddress.getByName(localAdress), 3548);
        socket.send(packet);

        Thread Receive = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    byte[] data = new byte[2048];
                    DatagramPacket packetToReceive = new DatagramPacket(
                            data,
                            0, data.length
                    );
                    try {
                        socket.receive(packetToReceive);
                        System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Receive.start();
        Thread Send = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String text = sc.nextLine();
                    String message = name + ": " + text;
                    byte[] data = message.getBytes();
                    try {
                        DatagramPacket packetToSend = new DatagramPacket(
                                data,
                                0, data.length,
                                InetAddress.getByName(localAdress), 3548
                        );
                        socket.send(packetToSend);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Send.start();
    }
}
