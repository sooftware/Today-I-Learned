package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSenderTh extends Thread{
	public ClientSenderTh() {
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket("10.20.7.75", 5550);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");
					out.flush();
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				scanner.close();
				if(socket != null) socket.close();
			}catch(IOException e) {
				System.out.println("������ ä�� �� ������ �߻��Ͽ����ϴ�. ");
			}
		}
	}
}