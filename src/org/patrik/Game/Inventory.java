package org.patrik.Game;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import static org.lwjgl.opengl.GL11.*;

public class Inventory {
	
	private static boolean printFullInv = false;
	private static int printfullinv = 0;
	public static int invSlotAmount0 = 0; // the amount of inventory-slot 1
	public static int invSlotAmount1 = 0; // the amount of inventory-slot 2
	public static int invSlotAmount2 = 0; // the amount of inventory-slot 3
	public static int invSlotAmount3 = 0; // the amount of inventory-slot 4
	public static int invSlotAmount4 = 0; // the amount of inventory-slot 5
	public static int invSlotAmount5 = 0; // the amount of inventory-slot 6
	public static int invSlotAmount6 = 0; // the amount of inventory-slot 7
	public static int invSlotAmount7 = 0; // the amount of inventory-slot 8
	public static int invSlotAmount8 = 0; // the amount of inventory-slot 9
	public static int invSlotAmount9 = 0; // the amount of inventory-slot 10
	
	public static String invSlotItem0 = null;
	public static String invSlotItem1 = null;
	public static String invSlotItem2 = null;
	public static String invSlotItem3 = null;
	public static String invSlotItem4 = null;
	public static String invSlotItem5 = null;
	public static String invSlotItem6 = null;
	public static String invSlotItem7 = null;
	public static String invSlotItem8 = null;
	public static String invSlotItem9 = null;
	public static String invSlotItem10 = null;
	
	public static Vector2f invSlotPos0 = null;
	public static Vector2f invSlotPos1 = null;
	public static Vector2f invSlotPos2 = null;
	public static Vector2f invSlotPos3 = null;
	public static Vector2f invSlotPos4 = null;
	public static Vector2f invSlotPos5 = null;
	public static Vector2f invSlotPos6 = null;
	public static Vector2f invSlotPos7 = null;
	public static Vector2f invSlotPos8 = null;
	public static Vector2f invSlotPos9 = null;
	
	public Inventory(int x, int y) {
		invSlotPos0 = new Vector2f(x, y);
		
		invSlotPos1 = new Vector2f(x + 90, y);
		
		invSlotPos2 = new Vector2f(x + 180, y);
		
		invSlotPos3 = new Vector2f(x + 270, y);
		
		invSlotPos4 = new Vector2f(x + 360, y);
		
		invSlotPos5 = new Vector2f(x + 450, y);
		
		invSlotPos6 = new Vector2f(x + 540, y);
		
		invSlotPos7 = new Vector2f(x + 630, y);
		
		invSlotPos8 = new Vector2f(x + 720, y);
		
		invSlotPos9 = new Vector2f(x + 810, y);
	}
	
	public static void addItem(String item, int amount) {
		
		
		if(invSlotItem0 == item && invSlotAmount0 <= 64 && (64 -invSlotAmount0) > amount) {
			invSlotAmount0 += amount;
		} else if(invSlotItem1 == item && invSlotAmount1 <= 64 && (64 -invSlotAmount1) > amount) {
			invSlotAmount1 += amount;
		} else if(invSlotItem2 == item && invSlotAmount2 <= 64 && (64 -invSlotAmount2) > amount) {
			invSlotAmount2 += amount;
		} else if(invSlotItem3 == item && invSlotAmount3 <= 64 && (64 -invSlotAmount3) > amount) {
			invSlotAmount3 += amount;
		} else if(invSlotItem4 == item && invSlotAmount4 <= 64 && (64 -invSlotAmount4) > amount) {
			invSlotAmount4 += amount;
		} else if(invSlotItem5 == item && invSlotAmount5 <= 64 && (64 -invSlotAmount5) > amount) {
			invSlotAmount5 += amount;
		} else if(invSlotItem6 == item && invSlotAmount6 <= 64 && (64 -invSlotAmount6) > amount) {
			invSlotAmount6 += amount;
		} else if(invSlotItem7 == item && invSlotAmount7 <= 64 && (64 -invSlotAmount7) > amount) {
			invSlotAmount7 += amount;
		} else if(invSlotItem8 == item && invSlotAmount8 <= 64 && (64 -invSlotAmount8) > amount) {
			invSlotAmount8 += amount;
		} else if(invSlotItem9 == item && invSlotAmount9 <= 64 && (64 -invSlotAmount9) > amount) {
			invSlotAmount9 += amount;
		}
		
		else if (invSlotItem0 == null && invSlotAmount0 == 0) {
			invSlotItem0 = item;
			invSlotAmount0 = amount;
		} else if (invSlotItem1 == null && invSlotAmount1 == 0) {
			invSlotItem1 = item;
			invSlotAmount1 = amount;
		} else if (invSlotItem2 == null && invSlotAmount2 == 0) {
			invSlotItem2 = item;
			invSlotAmount2 = amount;
		} else if (invSlotItem3 == null && invSlotAmount3 == 0) {
			invSlotItem3 = item;
			invSlotAmount3 = amount;
		} else if (invSlotItem4 == null && invSlotAmount4 == 0) {
			invSlotItem4 = item;
			invSlotAmount4 = amount;
		} else if (invSlotItem5 == null && invSlotAmount5 == 0) {
			invSlotItem5 = item;
			invSlotAmount5 = amount;
		} else if (invSlotItem6 == null && invSlotAmount6 == 0) {
			invSlotItem6 = item;
			invSlotAmount6 = amount;
		} else if (invSlotItem7 == null && invSlotAmount7 == 0) {
			invSlotItem7 = item;
			invSlotAmount7 = amount;
		} else if (invSlotItem8 == null && invSlotAmount8 == 0) {
			invSlotItem8 = item;
			invSlotAmount8 = amount;
		} else if (invSlotItem9 == null && invSlotAmount9 == 0) {
			invSlotItem9 = item;
			invSlotAmount9 = amount;
		}
		
		else
			printFullInv = true;
	}
	
	public static void drawInventory() {
		if (printFullInv) {
			GameLogic.uFont.drawString((Display.getDisplayMode().getWidth() / 2 - 135), (Display.getDisplayMode().getHeight() / 2 - 150), "FULL INVENTORY!", Color.white);
			printfullinv++;
		}
		
		if (printfullinv == 100) {
			printFullInv = false;
			printfullinv = 0;
		}
		
		// draw inventory slot 1
		glColor4f(0.5f, 0.5f, 0.5f, 0.5f);
		LoadTextures.inventory_slot.bind();
		
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos0.getX(), invSlotPos0.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos0.getX() + 140, invSlotPos0.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos0.getX() + 140, invSlotPos0.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos0.getX(), invSlotPos0.getY() + 140);
		glEnd();
		
		// draw inventory slot 2
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos1.getX(), invSlotPos1.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos1.getX() + 140, invSlotPos1.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos1.getX() + 140, invSlotPos1.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos1.getX(), invSlotPos1.getY() + 140);
		glEnd();
		
		// draw inventory slot 3
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos2.getX(), invSlotPos2.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos2.getX() + 140, invSlotPos2.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos2.getX() + 140, invSlotPos2.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos2.getX(), invSlotPos2.getY() + 140);
		glEnd();
		
		// draw inventory slot 4
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos3.getX(), invSlotPos3.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos3.getX() + 140, invSlotPos3.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos3.getX() + 140, invSlotPos3.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos3.getX(), invSlotPos3.getY() + 140);
		glEnd();
		
		// draw inventory slot 5
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos4.getX(), invSlotPos4.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos4.getX() + 140, invSlotPos4.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos4.getX() + 140, invSlotPos4.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos4.getX(), invSlotPos4.getY() + 140);
		glEnd();
	
		// draw inventory slot 6
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos5.getX(), invSlotPos5.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos5.getX() + 140, invSlotPos5.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos5.getX() + 140, invSlotPos5.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos5.getX(), invSlotPos5.getY() + 140);
		glEnd();
	
		// draw inventory slot 7
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos6.getX(), invSlotPos6.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos6.getX() + 140, invSlotPos6.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos6.getX() + 140, invSlotPos6.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos6.getX(), invSlotPos6.getY() + 140);
		glEnd();
	
		// draw inventory slot 8
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos7.getX(), invSlotPos7.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos7.getX() + 140, invSlotPos7.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos7.getX() + 140, invSlotPos7.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos7.getX(), invSlotPos7.getY() + 140);
		glEnd();
	
		// draw inventory slot 2
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos8.getX(), invSlotPos8.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos8.getX() + 140, invSlotPos8.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos8.getX() + 140, invSlotPos8.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos8.getX(), invSlotPos8.getY() + 140);
		glEnd();
	
		// draw inventory slot 2
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(invSlotPos9.getX(), invSlotPos9.getY());
			glTexCoord2f(1, 0);
			glVertex2f(invSlotPos9.getX() + 140, invSlotPos9.getY());
			glTexCoord2f(1, 1);
			glVertex2f(invSlotPos9.getX() + 140, invSlotPos9.getY() + 140);
			glTexCoord2f(0, 1);
			glVertex2f(invSlotPos9.getX(), invSlotPos9.getY() + 140);
		glEnd();
		
		glColor4f(1, 1, 1, 1);
	}
}