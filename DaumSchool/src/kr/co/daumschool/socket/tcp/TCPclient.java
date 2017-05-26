package kr.co.daumschool.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class TCPclient {
	InputStream is;
	OutputStream os;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Scanner sc;
	String rMsg;


	public void start(){

		try{
			while(true){
				socket = new Socket("localhost", 6007);
				sendMessage(socket);
				receiveMessage(socket);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	private void receiveMessage(Socket socket) {
		try{
			is=socket.getInputStream();
			ois=new ObjectInputStream(is);
			rMsg = (String) ois.readObject();
			System.out.println(rMsg);
		
			if(rMsg.substring(15).equals("close")){
				try {
					System.out.println("Á¾·á");
					socket.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	private void sendMessage(Socket socket) {
		try{
			os=socket.getOutputStream();
			oos=new ObjectOutputStream(os);
			sc = new Scanner(System.in);
			String sMsg = sc.next();
			oos.writeObject(sMsg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TCPclient tc = new TCPclient();
		tc.start();

	}

}
