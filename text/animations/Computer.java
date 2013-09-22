package text.animations;
import java.lang.Math;

public class Computer extends Speaker {
	private int mode = 0;

	
	public Computer(int pause, int mode) {
		super(pause);
		this.setMode(mode);
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public void type(String line) {
		if (this.mode == 0) { typeCharRandom(line); }
		if (this.mode == 1) { typeFullLineRandom(line); }
	}
	
	private void typeCharRandom(String line) {
		// Prints a random character on the end of the current line, then
		// re-prints the entire line plus the next character.
		System.out.print(((Math.random() * 9) + 1));
		sleepFor(this.getPause()); // pause with cursor on end
		System.out.print("\r" + line);
	}
	
	private void typeFullLineRandom(String line) {
		System.out.println("w/e");
	}
}
