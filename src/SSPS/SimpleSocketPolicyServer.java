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
                            client.setSoTimeout(10000); //clean failed connections
                            client.getOutputStream().write(SimpleSocketPolicyServer.POLICY_XML.getBytes());
                            client.getOutputStream().write(0x00); //write required endbit
                            client.getOutputStream().flush();
                            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            //reading two lines emties flashs buffer and magically it works!
                            // in.readLine();
                            // in.readLine();
                            
                            System.out.println("from client(" + client.getInetAddress() + ") :");
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            
                            // client.close();
                        } catch (IOException e) {e.printStackTrace();}
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