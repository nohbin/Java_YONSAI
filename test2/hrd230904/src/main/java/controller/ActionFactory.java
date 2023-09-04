package controller;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {};
	
	public static ActionFactory getInstance () {
		return instance;
	}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("tutorlist")) {
			ac = new TutorList();
		}else if(command.equals("insert")) {
			ac = new InsertClass();
		}else if(command.equals("insert.do")) {
			ac = new InsertDo();
		}else if(command.equals("memberlist")) {
			ac = new MemberList();
		}else if(command.equals("tutorresult")) {
			ac = new TutorResult();
		}
		
		return ac;
	}
	
}
