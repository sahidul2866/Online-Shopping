package sample;

import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
class Decider{
    int remain=20;
    boolean adminWorking = false;
    public int Remaining(String name){
        try {
            File f = new File("/home/sahidul/Desktop/Online Shopping/src/sample/"+ name + ".txt");
            f.createNewFile();
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str;
            if ((str = br.readLine()) != null) {
                remain = 20+Integer.parseInt(str);
                }
            fr.close();
            }
        catch (Exception e){
            e.printStackTrace();
        }
        return remain;

    }

    synchronized boolean get(String name) {
        while (adminWorking)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (remain > 0) {
            System.out.println(Remaining(name));
            notifyAll();
            return true;
        }
        else {
            notifyAll();
            return false;
        }

    }
    synchronized void put(String name,int quantity){
        adminWorking=true;
        notifyAll();
        //we are not handling the admin part
        adminWorking=false;

    }
}
class ClientHandler extends Thread {
    Socket clientSocket;
    Decider decider;

    public ClientHandler(Socket clientSocket,Decider decider) {
        this.clientSocket = clientSocket;
        this.decider = decider;
    }

    @Override
    public void run() {

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            String input = in.readLine();
            System.out.println(input);
            if(decider.remain>0)
                out.println("ok");
            else out.println("no");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Server {
    public static void main(String[] args) {
        try {
            Decider decider = new Decider();
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is waiting for client request");
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Client request");

            while(true) {
                ClientHandler clientHandler = new ClientHandler(clientSocket,decider);

                clientHandler.start();
                clientHandler.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


