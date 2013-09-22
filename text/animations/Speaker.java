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
	
	public void sayOld(String line) {
		sayWithSpecifiedPauses(line);
	}
	
	private void sayChar(char c) {
		System.out.print(c);
		sleepFor(this.pause);
	}
	
	private int findPause(String substr) {
		if (substr.length() < 2) { return -1; }
		if (substr.charAt(1) == '^') {
			return numOfBetweenChars(substr.substring(2));
		}
		else { return 0; } // regular char
	}
	
	private void sayWithSpecifiedPauses(String line) {
		for (int i=0; i<line.length(); i++) {
			System.out.print(line.charAt(i)); // print char
			int nextChar = checkNextChar(line, i); // do tests on next char
			if (nextChar == 2) { continue; } // no pause on last char
			if (nextChar == 1) { // if delimiter next
				int num_between = numOfBetweenChars(line.substring(i+2)); // send substring starting with first number
				String cust_sleep_s = line.substring(i+2,i+num_between+1);
				int cust_sleep = Integer.parseInt(cust_sleep_s);
				sleepFor(cust_sleep);
				i = i + num_between + 1;
			}
			else { sleepFor(this.pause); }
		}
	}
	
	private int checkNextChar(String line, int i) {
		if (i == line.length()-1) { // if is last char
			return 2;
		}
		else if (line.charAt(i+1) == '^') { // if delimiter found
			return 1;
		}
		return 0; // regular char
	}
	
	
	public void sleepFor(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int numOfBetweenChars(String str) {
		return str.indexOf('^')+1;
	}
}