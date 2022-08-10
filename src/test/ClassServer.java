package test;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClassServer {

	public static void main(String[] args) {
		try {
			ServerSocket server =new ServerSocket(9797);
			System.out.println("서버 접속 대기중 ");
			Socket client=server.accept();
			System.out.println("클라이언트 접속");
			
			InputStream is=client.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			
			ClassInfo member= (ClassInfo)ois.readObject();
			String id	=member.getId();	
			String name=member.getName();		
			int kor=member.getKor();
			int eng=member.getEng();		
			int math=member.getMath();	
			System.out.println("ID : "+id+"\nName : "+name+"\nkor점수 : "
			+kor+"\neng점수 : "+eng+"\nmath점수 : "+math);
			
			//ClassMemberDAO.getInstance().insert(member);
			
			ois.close();
			is.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
