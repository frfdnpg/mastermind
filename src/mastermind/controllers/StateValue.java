package mastermind.controllers;

enum StateValue {
	INITIAL,
	IN_GAME,
	FINAL,
	EXIT;
	
	private Controller controller;
	
	private StateValue() {
		this.controller = null;
	}
	
	void set(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return this.controller;
	}
	
}
