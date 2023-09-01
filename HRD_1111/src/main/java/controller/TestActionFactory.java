package controller;


public class TestActionFactory {
	
	private static TestActionFactory instance = new TestActionFactory();
	
	private TestActionFactory() {};	
	
	public static TestActionFactory getInstance() {
		return instance;
	}
	
	public TestAction getAction(String command){
		TestAction action = null;
		
		if(command.equals("list")) {
			action = new ListAction();
		}else if (command.equals("insertview")) {
			action = new InsertView();
		}else if(command.equals("insertDo")){
			action = new InsertDo();
		}else if(command.equals("check")) {
			action = new Check();
		}else if(command.equals("count")) {
			action = new Count();
		}
		
		return action;
	}
	
}
