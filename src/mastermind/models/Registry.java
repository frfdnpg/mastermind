package mastermind.models;

import java.util.ArrayList;

public class Registry {
	
	private ArrayList<Memento> mementoList;
	
	private Game game;
	
	private int firstPrevious;
	
	Registry(Game game) {
		this.game = game;
		this.mementoList = new ArrayList<Memento>();
		this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
	}

	void registry() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementoList.remove(0);
		}
		this.firstPrevious = 0;
		this.mementoList.add(this.firstPrevious, this.game.createMemento());
		System.out.println(this.toString());
	}

	void undo(Game game) {
		this.firstPrevious++;
		game.set(this.mementoList.get(this.firstPrevious));
		System.out.println(this.toString());
	}

	void redo(Game game) {
		this.firstPrevious--;
		game.set(this.mementoList.get(this.firstPrevious));
		System.out.println(this.toString());
	}

	boolean undoable() {
		return this.firstPrevious < this.mementoList.size() - 1;
	}

	boolean redoable() {
		return this.firstPrevious >= 1;
	}

	public void reset() {
		this.mementoList = new ArrayList<Memento>();
		this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
	}
	
	public String toString() {
		String string = "firstPrevious: "+this.firstPrevious+", ";
		for (Memento memento: this.mementoList) {
			string += memento.toString()+"\n";
		}
		return string;
	}

}
