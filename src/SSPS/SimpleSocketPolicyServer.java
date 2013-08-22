package SSPS;

import java.io.*;
import java.net.*;

public class SimpleSocketPolicyServer {
	public static final String POLICY_XML =
		"<?xml version=\"1.0\"?><cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"*\" /></cross-domain-policy>";

    public SimpleSocketPolicyServer(){
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(843);
            System.out.println(" === SSPS on port 843 === ");
        } catch (IOException e) {e.printStackTrace();}
        
        while(true){
            try {
                final Socket client = ss.accept();
                System.out.println("a new connection from " + client.getInetAddress());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.setSoTimeout(10000); //clear
                            client.getOutputStream().write(SimpleSocketPolicyServer.POLICY_XML.getBytes());
                            client.getOutputStream().write(0x00);//required endbit
                            client.getOutputStream().flush();
                        } catch (IOException e) {
                        }
                    }
                }).start();
            } catch (Exception e) {}
        }
    }
    
    @SuppressWarnings("unused")
	public static void main(String args[]) {
    	SimpleSocketPolicyServer ssps = new SimpleSocketPolicyServer();
	}
}
