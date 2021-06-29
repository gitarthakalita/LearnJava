// URL : https://medium.com/martinomburajr/java-create-your-own-hello-world-server-2ca33b6957e

package com.gitarthakalita.learnjava.HttpServer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;


public class HttpServer {
    public static void main(String[] args) {
        connectToServer();
    }
    public static void connectToServer(){

        try(ServerSocket serverSocket = new ServerSocket(9001)){
            Socket connectionSocket = serverSocket.accept();

            InputStream intputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(intputToServer, StandardCharsets.UTF_8);
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, StandardCharsets.UTF_8), true);

            serverPrintOut.println("Hello World! Enter peace to exit.");

            boolean done = false;

            while (!done && scanner.hasNextLine()){
                String line = scanner.nextLine();
                serverPrintOut.println("Echo from World Server: " + line);

                if (line.toLowerCase(Locale.ROOT).trim().equals("peace")){
                    done = true;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
