package org.patrik.Game;

import org.lwjgl.input.Keyboard;

public class Input {
	
	public static boolean Keyboard(int key) {
		boolean returnValue = false;
		if (Keyboard.isKeyDown(key)) {
			returnValue = true;
		}
		return returnValue;
	}
	
	public static boolean KeyEvent(int key) {
		boolean returnValue = false;
		while(Keyboard.next()) {
			if (Keyboard.isKeyDown(key)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	public static boolean Mouse(int button) {
		boolean returnValue = false;
		if (org.lwjgl.input.Mouse.isButtonDown(button)) {
			returnValue = true;
		}
		
		return returnValue;
	}
}