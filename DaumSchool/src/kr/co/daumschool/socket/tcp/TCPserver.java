package kr.co.daumschool.socket.tcp;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPserver extends Thread{

	private InputStream is;
	private OutputStream os;
	private ServerSocket serverSocket;
	private ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket socket;	

	@Override
	public void run() {
		try{
			serverSocket = new ServerSocket(6007);
			while(true){
				System.out.println("��û���");
				socket = serverSocket.accept();
				System.out.println("������ Ŭ���̾�Ʈ:"+socket.getInetAddress());

				is = socket.getInputStream();
				os = socket.getOutputStream();
				ois = new ObjectInputStream(is);
				oos = new ObjectOutputStream(os);


				String msg = (String) ois.readObject();
				System.out.println("Ŭ���̾�Ʈ���� ���� �޽���:"+msg);
				String retMsg="�����κ��� �ǵ��ƿ� �޽���:"+msg;
				oos.writeObject(retMsg);

				if(msg.equals("close")){
					oos.writeObject(retMsg);
					socket.close();
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("����");
		}
		

	}


	public static void main(String[] args) {

		TCPserver ts = new TCPserver();
		ts.start();
	}

}

