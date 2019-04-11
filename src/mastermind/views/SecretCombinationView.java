package mastermind.views;

import mastermind.utils.WithConsoleView;
import mastermind.views.menus.Message;

class SecretCombinationView extends WithConsoleView {
	
	SecretCombinationView() {
		super();
	}
	
	void writeln(int length) {
		for (int i = 0; i < length; i++) {
			this.console.write(Message.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
