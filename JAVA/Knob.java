import java.util.ArrayList;
import java.util.Scanner;

class Knob {
	//Data Attributes
	boolean isOn;
	String currPos;
	String targetPos;
	ArrayList<String> position = new ArrayList<String>() {
		add("up");
		add("right");
		add("down");
		add("left");
	}
	

	//Constructor
	public Knob(boolean state, String newCurrPos, String newTargetPos) {
		this.isOn = state;
		this.currPos = newCurrPos;
		this.targetPos = newTargetPos;
	}
	//Determine whether the device is on or off after num moves
	public boolean deviceIsOn() {
		if (this.isOn == "off") {
			this.isOn = "on";
		} else {
			this.isOn = "off";
		}
		return this.isOn;	
	}
	//Compute the least moves to turn the knob
	public int changePos() {
		count = 0;
		if (this.currPos == this.targetPos) {
			count = position.length;
		} else {
			while (this.currPos != this.targetPos) {
				this.currPos = this.moveClockwise(this.currPos);
				this.deviceIsOn()
				count += 1
			}
		}
		return count;
	}
}

class TurnKnobs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int knob_num = scan.nextInt();
	}
}