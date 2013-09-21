package text.animations;

public class Main {
	public static void main (String args[]) {
		Speaker person1 = new Speaker(30);
		Speaker person2 = new Speaker(100);
		person1.say("Yooooo!^1000^ What^400^ is^400^ UP,^200^ my friend?!");
		System.out.println();
		person2.say("Yooooo!^1000^ What^400^ is^400^ UP,^200^ my friend?!");
		System.out.println();
	}
}