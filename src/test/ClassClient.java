package test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClassClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.67",9797);
		System.out.println("클라이언트 프로그램");
		
		OutputStream os=socket.getOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(os);
		
		ClassInfo member=new ClassInfo();
		member.setId("16505027");
		member.setName("jang");
		member.setKor(10);
		member.setEng(20);
		member.setMath(50);
		
		oos.writeObject(member);
		oos.flush();
		
		oos.close();
		os.close();
		socket.close();
	}
}
