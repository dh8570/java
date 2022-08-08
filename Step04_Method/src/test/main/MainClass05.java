package test.main;

import test.pack.*;

public class MainClass05 {
	public static void main(String[] args) {
		Messenger.sendMessage("aa");
		Messenger.getMessage();
		Messenger.useRadio(new Radio());
	}
}
