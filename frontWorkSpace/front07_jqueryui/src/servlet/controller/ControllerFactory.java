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
		
		
		return controller;
	}
	
}
