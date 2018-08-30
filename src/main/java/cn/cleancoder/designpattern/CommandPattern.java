package cn.cleancoder.designpattern;

/**
 * Command Pattern: definition:Encapsulate method invocation
 * 
 * decouples the client and the receiver which really do all the things
 * 
 * @author ice
 *
 */
public class CommandPattern {
	
	/**
	 * Client
	 * @param args
	 */
	public static void main(String[] args) {
		//Invoker
		SimpleRemoteControl remote = new SimpleRemoteControl();
		//The receiver which do the concrete job
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		remote.setCommand(lightOn);
		//invoke
		remote.buttonWasPressed();
	}

}

interface Command {
	public void execute();
}


/**
 * 
 * @author ice
 *
 */
class NoCommand implements Command {
	public void execute() {
	}
}

class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}

class SimpleRemoteControl {
	Command slot;

	public SimpleRemoteControl() {
		//usage of the Null Object
		slot = new NoCommand();
	}

	public void setCommand(Command command) {
		slot = command;
	}

	//invocation
	public void buttonWasPressed() {
		//Command object is passsed through
		slot.execute();
	}
}

class LightOffCommand implements Command {
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
}

class StereoOnWithCDCommand implements Command {
	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}
}


