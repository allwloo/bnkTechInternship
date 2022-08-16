package servlet.controller;
/*
 * Componenet를 생성하는 공장
 * 싱글콘으로 작성
 * 서버클라이언트가 보내는 Command값에 따라서 생성되는 Componenet가 달라진다.
 */
public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("ControllerFactory....싱글톤..");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	//Component를 생성하는 기능...정의
	public Controller createController(String command) {
		Controller controller = null; 
		if(command.equals("subject.do")) {
			System.out.println("SubjectController...createController");
			controller = new SubjectController();
		}else if(command.equals("branches.do")) {
			System.out.println("branchesController...createController");
			controller = new BranchesController();
		}

		return controller;
	}

}












