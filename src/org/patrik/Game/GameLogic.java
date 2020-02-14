package org.patrik.Game;

import java.awt.Font;
import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import org.patrik.Game.RPG;
import org.patrik.src.*;
import org.lwjgl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.GameState;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class GameLogic {
	
	protected static EntityLiving Player;
	protected static EntityLiving Ground;
	
	protected static EntityLiving Tree0;
	protected static EntityLiving Tree1;
	protected static EntityLiving Tree2;
	protected static EntityLiving Tree3;
	protected static EntityLiving Tree4;
	
	protected static EntityButton cameraButton;
	
	protected static EntityButton menuButtonPlay;
	
	private static boolean FocusOnPlayer = true;
	
	private static boolean InitializedEntities = false;
	
	private static ArrayList<Entity> entities = new ArrayList<Entity>();
	private static ArrayList<Entity> trees = new ArrayList<Entity>();
	
	private static double PlayerGroundZ = -2000;
	
	protected static float FOV = 30;
	
	private static Player player;
	
	public static UnicodeFont uFont;
	
	private static Vector3f camPos = null;
	
	private static Vector3f oldcamPos = null;
	
	private static Random random = new Random();
	private static Face[] face = new Face[160000];
	
	private static int delta = TheTypicalN00bGame.getDelta();
	
	private static enum GameStates{
		Intro, mainMenu, inGame;
	}
	
	private static GameStates GameState;
	
	protected static void gameLogic() {
		if (!InitializedEntities) {
			// Initialize Entities
			Inventory Inventory = new Inventory(((Display.getDisplayMode().getWidth() / 2) / 2) + 20,Display.getDisplayMode().getHeight() - 77);
			
			Ground = new EntityGround(-1000, -500, PlayerGroundZ, 4000, 4000, 1);
			entities.add(Ground);
			
			Player = new Player(66, 210, PlayerGroundZ, 128, 256, 1);
			Player.setHealth(9);
			Player.setHunger(9);
			entities.add(Player);
			
			cameraButton = new ButtonEntity(Display.getDisplayMode().getWidth()- 64, Display.getDisplayMode().getHeight() - 64, 1,64, 64, 0.5);
			cameraButton.setText(false, null, null);
			cameraButton.setTransparent(true);
			cameraButton.setHasTextures(true);
			
			menuButtonPlay = new ButtonEntity(1920 - 258, 10, 1, 192, 64, 1);
			menuButtonPlay.setText(true, "Play Game!", Color.white);
			menuButtonPlay.setTransparent(false);
			menuButtonPlay.setHasTextures(false);
			
			Tree0 = new AppleTreeEntity(100, 150, PlayerGroundZ, 256, 512, 1);
			trees.add(Tree0);
			Tree1 = new AppleTreeEntity(356, 150, PlayerGroundZ, 256, 512, 1);
			trees.add(Tree1);
			Tree2 = new AppleTreeEntity(620, 150, PlayerGroundZ, 256, 512, 1);
			trees.add(Tree2);
			Tree3 = new AppleTreeEntity(800, 150, PlayerGroundZ, 256, 512, 1);
			trees.add(Tree3);
			Tree4 = new AppleTreeEntity(1100, 150, PlayerGroundZ, 256, 512, 1);
			trees.add(Tree4);
			
			camPos = new Vector3f((float)-Player.getX(), (float)-Player.getY(), 0);
			oldcamPos = new Vector3f(0, 0, 0);
			
			GameState = GameStates.mainMenu;
			
			setUpFonts();
			
			for(int i = 0; i < face.length; i++) {
				face[i] = new Face((random.nextFloat() - 0.5f) * 4000f, (random.nextFloat() - 0.5f) * 4000f, random.nextInt(39999999) - 40000000);
			}
			
			InitializedEntities = true;
		}
		
		switch (GameState) {
		case Intro:
			
			break;
		case mainMenu:
			if (camPos.getX() != oldcamPos.getX()
				|| camPos.getY() != oldcamPos.getY()
				|| camPos.getZ() != oldcamPos.getZ()) {
				glTranslatef(camPos.x, camPos.y, camPos.z);
			}
			
			oldcamPos.setX(camPos.getX());
			oldcamPos.setY(camPos.getY());
			oldcamPos.setZ(camPos.getZ());
			
			float z = camPos.getZ();
			camPos.setZ(z += 450);
			
			break;
		case inGame:
			// Game Logic
			if (camPos.getX() != oldcamPos.getX()
				|| camPos.getY() != oldcamPos.getY()
				|| camPos.getZ() != oldcamPos.getZ()) {
				glTranslatef(camPos.x, camPos.y, camPos.z);
			}
			
			if (Input.Keyboard(Keyboard.KEY_0)) {
				System.out.println(Inventory.invSlotItem0);
				System.out.println(Inventory.invSlotAmount0);
			} else if (Input.Keyboard(Keyboard.KEY_1)) {
				System.out.println(Inventory.invSlotItem1);
				System.out.println(Inventory.invSlotAmount1);
			} else if (Input.Keyboard(Keyboard.KEY_2)) {
				System.out.println(Inventory.invSlotItem2);
				System.out.println(Inventory.invSlotAmount2);
			} else if (Input.Keyboard(Keyboard.KEY_3)) {
				System.out.println(Inventory.invSlotItem3);
				System.out.println(Inventory.invSlotAmount3);
			} else if (Input.Keyboard(Keyboard.KEY_4)) {
				System.out.println(Inventory.invSlotItem4);
				System.out.println(Inventory.invSlotAmount4);
			} else if (Input.Keyboard(Keyboard.KEY_5)) {
				System.out.println(Inventory.invSlotItem5);
				System.out.println(Inventory.invSlotAmount5);
			} else if (Input.Keyboard(Keyboard.KEY_6)) {
				System.out.println(Inventory.invSlotItem6);
				System.out.println(Inventory.invSlotAmount6);
			} else if (Input.Keyboard(Keyboard.KEY_7)) {
				System.out.println(Inventory.invSlotItem7);
				System.out.println(Inventory.invSlotAmount7);
			} else if (Input.Keyboard(Keyboard.KEY_8)) {
				System.out.println(Inventory.invSlotItem8);
				System.out.println(Inventory.invSlotAmount8);
			} else if (Input.Keyboard(Keyboard.KEY_9)) {
				System.out.println(Inventory.invSlotItem9);
				System.out.println(Inventory.invSlotAmount9);
			}
			
			if (Input.Keyboard(Keyboard.KEY_RETURN)) {
				System.out.println("asd");
				Inventory.addItem("Apple", 1);
			}
			
			oldcamPos.setX(camPos.getX());
			oldcamPos.setY(camPos.getY());
			oldcamPos.setZ(camPos.getZ());
			
			for (Entity entity : entities) {
				entity.setZ(PlayerGroundZ);
			}
			
			for (Entity tree : trees) {
				tree.setZ(PlayerGroundZ);
			}
			
			// Update the Entities
			updateEntities();
			
			// Update the Trees
			updateTrees();
			
			// Update Our Inventory
			updateInventory();
			
			// check for input
			// Move The Player
			playerMovement();
			cameraMovement();
			break;
		}
			// Render
			Render3D();
			Render2D();
	}
	
	private static void Render3D() {
		setUp3D();
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		switch(GameState) {
		case Intro:
			
			break;
		case mainMenu:
			
			System.out.println(glGetString(GL_VERSION));
			
			for (Face f : face) {
				glColor4f(1, 1, 1, 1);
				LoadTextures.playerDown.bind();
				glBegin(GL_QUADS);
					glTexCoord2f(0, 0);
					glVertex3f(f.x, f.y, f.z);
					glTexCoord2f(1, 0);
					glVertex3f(f.x + 64, f.y, f.z);
					glTexCoord2f(1, 1);
					glVertex3f(f.x + 64, f.y - 128, f.z);
					glTexCoord2f(0, 1);
					glVertex3f(f.x, f.y - 128, f.z);
				glEnd();
			}
			
			break;
		case inGame:
			// draw ALL entities
			for (Entity entity : entities) {
				entity.draw();
			}
			
			for (Entity Trees : trees) {
				Trees.draw();
			}
			break;
		}
	}
	
	private static void Render2D() {
		setUp2D();
		
		glPushMatrix();
		
		switch (GameState) {
		case Intro:
			
			break;
		case mainMenu:
			if (menuButtonPlay.intersectsWithMouse(Mouse.getX(), Display.getDisplayMode().getHeight() - Mouse.getY() - 1)) {
				menuButtonPlay.setColor(Color.blue);
			} else {
				menuButtonPlay.setColor(Color.white);
			}
			
			if (menuButtonPlay.insideAndPressButton()) {
				GameState = GameStates.inGame;
				camPos.setZ(0);
			}
			
			menuButtonPlay.draw();
			
			break;
		case inGame:
			Inventory.drawInventory();
			
			if (cameraButton.releaseButton()) {
				FocusOnPlayer = !FocusOnPlayer;
			}

			if (cameraButton.insideAndPressButton()) {
				LoadTextures.cameraButtonPressed.bind();
			} else {
				LoadTextures.cameraButton.bind();
			}
			cameraButton.draw();
			
			uFont.drawString(100, 100, "Poop That Corn!\n\nCactus!\n\nIsaac Šr en nšrd!|\n VAA SAAA DOOOO?");
			glPopMatrix();
			break;
		}
	}
	
	/**
	 * Updates All Registered Entities
	 */
	private static void updateEntities() {
		for (Entity entity : entities) {
			entity.update(delta);
		}
	}
	
	/**
	 * Updates The Created Trees
	 */
	private static void updateTrees() {
		for (Entity Tree : trees) {
			Tree.update(delta);
			
			if (Tree.intersectsWithMouse(Mouse.getX(), Display.getDisplayMode().getHeight() - Mouse.getY() - 1)) {
				// if we're pressing the right mouse button inside the tree
				if (Input.Mouse(1)) {
					// add a drop down list
				}
				
				if (Input.Mouse(0)) {
					// do whatever's on top of the list:D
				}
			}
		}
	}
	
	/**
	 * Creates and updates The Player's Inventory
	 */
	private static void updateInventory() {
		
	}
	
	/**
	 * Sets up the fonts for use
	 */
	@SuppressWarnings("unchecked")
	private static void setUpFonts() {
		try{
			Font font=new Font( "Impact", Font.PLAIN, 40 );
		    uFont = new UnicodeFont(font, 40, false, false);
		    uFont.addAsciiGlyphs();
		    uFont.addGlyphs(400, 600);
		    uFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		    uFont.loadGlyphs();
		 } catch(SlickException e){
		    e.printStackTrace();
		 }
	}
	
	/**
	 * Switch to 3D viewing mode
	 */
	private static void setUp3D() {
		glMatrixMode (GL_PROJECTION);
		
		glLoadIdentity();
		gluPerspective(30, (float)Display.getDisplayMode().getWidth() / (float)Display.getDisplayMode().getHeight(), 0.001f, 1000000.0f);
		glTranslatef(camPos.getX(), camPos.getY(), camPos.getZ());
		
		glMatrixMode (GL_MODELVIEW);
		glLoadIdentity ();
		
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/**
	 * Switch to 2D viewing mode
	 */
	private static void setUp2D() {
		glMatrixMode (GL_PROJECTION);
		glLoadIdentity();
		
		glOrtho(0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight(), 0, -1, 1);
		glMatrixMode (GL_MODELVIEW);
		
		glLoadIdentity ();
		
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/**
	 * move The Camera Using Input
	 */
	private static void cameraMovement() {
		// check if the player is in focus, if not, set the player in focus by a key-press
		if (Input.KeyEvent(Keyboard.KEY_C)) {
			FocusOnPlayer = !FocusOnPlayer;
		}
		
		// Zoom The Camera
		PlayerGroundZ += Mouse.getDWheel();
		
		if (Player.getZ() > -80) {
			PlayerGroundZ = -81;
		}
		
		if (Player.getZ() < -10000) {
			PlayerGroundZ = -10000;
		}
		
		// Move The Camera
		if (Input.Keyboard(Keyboard.KEY_LEFT)) {
			float x = camPos.getX();
			camPos.setX(x += 5);
			FocusOnPlayer = false;
		}
		
		if (Input.Keyboard(Keyboard.KEY_RIGHT)) {
			float x = camPos.getX();
			camPos.setX(x -= 5);
			FocusOnPlayer = false;
		}
		
		if (Input.Keyboard(Keyboard.KEY_UP)) {
			float y = camPos.getY();
			camPos.setY(y -= 5);
			FocusOnPlayer = false;
		}
		
		if (Input.Keyboard(Keyboard.KEY_DOWN)) {
			float y = camPos.getY();
			camPos.setY(y += 5);
			FocusOnPlayer = false;
		}
	}
	
	/**
	 * move The Player Using Input
	 */
	private static void playerMovement() {
		// if The camera is Locked on the player
		if (FocusOnPlayer) {
			if (Player.getX() > Ground.getX() + 891 && Player.getX() < Ground.getX() + (Ground.getWidth() - 927)) {
				camPos.setX((float)-Player.getX()-66);
			}
			
			if (Player.getY() > Ground.getY() + 691 && Player.getY() < (Ground.getY() + Ground.getHeight()) - 291) {
				camPos.setY((float)-Player.getY()+150);
			}
			
			if (Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDX(-0.5);
				player.walkingLeft = true;
				player.walkingRight = false;
				player.walkingUp = false;
				player.walkingDown = false;
			} else if (!Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_A) ||
					Input.Keyboard(Keyboard.KEY_D) && Input.Keyboard(Keyboard.KEY_A) ||
					Input.Keyboard(Keyboard.KEY_S) && Input.Keyboard(Keyboard.KEY_A) ||
					Input.Keyboard(Keyboard.KEY_W) && Input.Keyboard(Keyboard.KEY_A)) {
				Player.setDX(0.0);
			}
			
			if (Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDX(0.5);
				player.walkingLeft = false;
				player.walkingRight = true;
				player.walkingUp = false;
				player.walkingDown = false;
			} else if (!Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_D) ||
					Input.Keyboard(Keyboard.KEY_A) && Input.Keyboard(Keyboard.KEY_D) ||
					Input.Keyboard(Keyboard.KEY_S) && Input.Keyboard(Keyboard.KEY_D) ||
					Input.Keyboard(Keyboard.KEY_W) && Input.Keyboard(Keyboard.KEY_D)) {
				Player.setDX(0.0);
			}
			
			if (Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDY(0.5);
				player.walkingLeft = false;
				player.walkingRight = false;
				player.walkingUp = true;
				player.walkingDown = false;
			} else if (!Input.Keyboard(Keyboard.KEY_S) && !Input.Keyboard(Keyboard.KEY_W) ||
					Input.Keyboard(Keyboard.KEY_A) && Input.Keyboard(Keyboard.KEY_W) ||
					Input.Keyboard(Keyboard.KEY_S) && Input.Keyboard(Keyboard.KEY_W) ||
					Input.Keyboard(Keyboard.KEY_D) && Input.Keyboard(Keyboard.KEY_W)) {
				Player.setDY(0.0);
			}
			
			if (Input.Keyboard(Keyboard.KEY_S) && !Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_A)) {
				Player.setDY(-0.5);
				player.walkingLeft = false;
				player.walkingRight = false;
				player.walkingUp = false;
				player.walkingDown = true;
			} else if (!Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_S) ||
					Input.Keyboard(Keyboard.KEY_A) && Input.Keyboard(Keyboard.KEY_S) ||
					Input.Keyboard(Keyboard.KEY_W) && Input.Keyboard(Keyboard.KEY_S) ||
					Input.Keyboard(Keyboard.KEY_D) && Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDY(0.0);
			}
		}
				
		// if the camera is not locked on the player
		if (!FocusOnPlayer) {
			if (Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDX(-0.5);
				player.walkingLeft = true;
				player.walkingRight = false;
				player.walkingUp = false;
				player.walkingDown = false;
			} else if (!Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_A) ||
					Input.Keyboard(Keyboard.KEY_D) && Input.Keyboard(Keyboard.KEY_A) ||
					Input.Keyboard(Keyboard.KEY_S) && Input.Keyboard(Keyboard.KEY_A) ||
					Input.Keyboard(Keyboard.KEY_W) && Input.Keyboard(Keyboard.KEY_A)) {
				Player.setDX(0.0);
			}
			
			if (Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDX(0.5);
				player.walkingLeft = false;
				player.walkingRight = true;
				player.walkingUp = false;
				player.walkingDown = false;
			} else if (!Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_D) ||
					Input.Keyboard(Keyboard.KEY_A) && Input.Keyboard(Keyboard.KEY_D) ||
					Input.Keyboard(Keyboard.KEY_S) && Input.Keyboard(Keyboard.KEY_D) ||
					Input.Keyboard(Keyboard.KEY_W) && Input.Keyboard(Keyboard.KEY_D)) {
				Player.setDX(0.0);
			}
			
			if (Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_A) && !Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDY(0.5);
				player.walkingLeft = false;
				player.walkingRight = false;
				player.walkingUp = true;
				player.walkingDown = false;
			} else if (!Input.Keyboard(Keyboard.KEY_S) && !Input.Keyboard(Keyboard.KEY_W) ||
					Input.Keyboard(Keyboard.KEY_A) && Input.Keyboard(Keyboard.KEY_W) ||
					Input.Keyboard(Keyboard.KEY_S) && Input.Keyboard(Keyboard.KEY_W) ||
					Input.Keyboard(Keyboard.KEY_D) && Input.Keyboard(Keyboard.KEY_W)) {
				Player.setDY(0.0);
			}
			
			if (Input.Keyboard(Keyboard.KEY_S) && !Input.Keyboard(Keyboard.KEY_D) && !Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_A)) {
				Player.setDY(-0.5);
				player.walkingLeft = false;
				player.walkingRight = false;
				player.walkingUp = false;
				player.walkingDown = true;
			} else if (!Input.Keyboard(Keyboard.KEY_W) && !Input.Keyboard(Keyboard.KEY_S) ||
					Input.Keyboard(Keyboard.KEY_A) && Input.Keyboard(Keyboard.KEY_S) ||
					Input.Keyboard(Keyboard.KEY_W) && Input.Keyboard(Keyboard.KEY_S) ||
					Input.Keyboard(Keyboard.KEY_D) && Input.Keyboard(Keyboard.KEY_S)) {
				Player.setDY(0.0);
			}
		}
	}
	
	/**
	 * Draws a face for the main menu
	 */
	protected static class Face {
		protected float x, y, z;

        public Face(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
	}
}