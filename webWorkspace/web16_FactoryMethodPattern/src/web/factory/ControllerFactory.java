package web.factory;

import web.controller.AddController;
import web.controller.Controller;
import web.controller.RemoveController;

/*
 * ControllerFactory
 * 
 * Controller를 만드는 공장
 * 이곳에서
 * RegisterController, UpdateController, RemoveController, LoginController...생성
 * ::
 * Singletone Pattern
 */
public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		System.out.println("creating controllerfactory");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("INSERT")) {
			controller = new AddController();
			System.out.println("AddController Creating...ok");
		}else if(command.equals("DELETE")) {
			controller = new RemoveController();
			System.out.println("RemoveController Creating...ok");
		}else if(command.equals("UPDATE")) {
			controller = new RemoveController();
			System.out.println("UPDATEController Creating...ok");
		}else if(command.equals("LOGIN")) {
			controller = new RemoveController();
			System.out.println("LOGINController Creating...ok");
		}
		return controller;
	}

}
