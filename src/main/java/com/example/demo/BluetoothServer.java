package com.example.demo;

import javax.bluetooth.*;
import javax.microedition.io.*;

public class BluetoothServer {
    public static void main(String[] args) {
        try {
            LocalDevice localDevice = LocalDevice.getLocalDevice();
            System.out.println("Bluetooth server started on: " + localDevice.getBluetoothAddress());

            UUID uuid = new UUID("0000110100001000800000805F9B34FB", false);
            String name = "BluetoothServer";
            String url = "btspp://localhost:" + uuid + ";name=" + name;

            StreamConnectionNotifier server = (StreamConnectionNotifier) Connector.open(url);

            System.out.println("Waiting for connection...");
            StreamConnection connection = server.acceptAndOpen();
            System.out.println("Client connected.");

            // Đọc và xử lý dữ liệu từ client ở đây

            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
