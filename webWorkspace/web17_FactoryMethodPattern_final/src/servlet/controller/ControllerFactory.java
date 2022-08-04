package servlet.controller;


/*
 * 
 */
public class ControllerFactory {
	
	static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		System.out.println("ControllerFactory 싱글톤 생성....");
	}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find")) {
			controller = new FindController();
			System.out.println("FindController Creating...ok");
		}else if(command.equals("register")) {
			controller = new RegisterController();
			System.out.println("ReigsterController Creaating...ok");
		}else if(command.equals("login")) {
			controller = new LoginController();
			System.out.println("LoGINrController Creaating...ok");
		}else if(command.equals("showAll")) {
			controller = new ShowAllController();
			System.out.println("showAllController Creaating...ok");
		}else if(command.equals("update")) {
			controller = new UpdateController();
			System.out.println("UpdateController Creaating...ok");
		}else if(command.equals("logout")) {
			controller = new LogoutController();
			System.out.println("ReigsterController Creaating...ok");
		}else if(command.equals("register")) {
			controller = new RegisterController();
			System.out.println("ReigsterController Creaating...ok");
		}
		
		return controller;
	}
	
}
