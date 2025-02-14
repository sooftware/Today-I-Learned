package server;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 채팅 프로그램 서버 Main 클래스 (UDP)
 *  2014707073 전자통신공학과 김수환
 */

public class ServerMain  implements ServerInterface{
	public static void main(String[] args) {
		SharedArea sArea = new SharedArea();
		UdpServerSender sSender = new UdpServerSender();
		UdpServerReceive sReceive = new UdpServerReceive();
		AdminCommand aCommand = new AdminCommand();
		
		/* 같은 SharedArea 객체를 공유하게 함 */
		sSender.setsArea(sArea);
		sReceive.setsArea(sArea);
		aCommand.setsArea(sArea);
		sArea.ck.setsArea(sArea);
		aCommand.setSender(sSender);
		aCommand.setReceiver(sReceive);
		/* 같은 SharedArea 객체를 공유하게 함 */
		
		try {
			/* Server Thread Start! */
			sSender.start();
			sReceive.start();
			aCommand.start();
			/* Server Thread Start! */
			
			/* Thread Return Together */
			sSender.join();
			sReceive.join();
			aCommand.join();
			/* Thread Return Together */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
}