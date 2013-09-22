package text.animations;

public class Speaker {
	private int pause;
	
	public Speaker(int pause) {
		this.setPause(pause);
	}
	
	public int getPause() {
		return this.pause;
	}
	
	public void setPause(int pause) {
		this.pause = pause;
	}
	
	public void sayNew(String line) {
		for (int i = 0; i < line.length(); i++) {
			int nextChar = findPause(line.substring(i));
			if (nextChar == 0) { sayChar(line.charAt(i)); }
			else if (nextChar == -1) { System.out.print(line.charAt(i)); }
			else {
				System.out.print(line.charAt(i));
				sleepFor(Integer.parseInt(line.substring(i+2, i + 1 + nextChar)));
				i = i + 1 + nextChar;
			}
		}
	}

	private int findPause(String substr) {
		if (substr.length() < 2) { return -1; }
		if (substr.charAt(1) == '^') {
			return numOfBetweenChars(substr.substring(2));
		}
		else { return 0; } // regular char
	}
	
	private int numOfBetweenChars(String str) {
		return str.indexOf('^')+1;
	}
	
	private void sayChar(char c) {
		System.out.print(c);
		sleepFor(this.pause);
	}
	
	
	public void sleepFor(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}