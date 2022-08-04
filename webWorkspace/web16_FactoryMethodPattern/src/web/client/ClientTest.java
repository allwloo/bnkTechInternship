package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.factory.ControllerFactory;

public class ClientTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>> command값 입력 ");
		
		String command = sc.next();
		
		ControllerFactory factory = ControllerFactory.getInstance();
		
		Controller controller = factory.createController(command);
		
		System.out.println(controller.handle()); // 무조건 마지막은 네비게이션이 된다.
	}

}
