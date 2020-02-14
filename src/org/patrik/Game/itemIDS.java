package org.patrik.Game;

public class itemIDS {
	
	public int getID(String item) {
		if (item.equals("Apple")) {
			return 1;
		} else if (item.equals("Log")) {
			return 2;
		} else {
			return 0;
		}
	}
}