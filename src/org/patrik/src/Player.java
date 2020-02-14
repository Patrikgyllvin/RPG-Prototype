package org.patrik.src;

import org.patrik.Game.LoadTextures;
import static org.lwjgl.opengl.GL11.*;

public class Player extends AbstractEntityLiving {
	
	public static boolean walkingLeft = false;
	public static boolean walkingRight = false;
	public static boolean walkingUp = false;
	public static boolean walkingDown = true;
	
	public Player(double x, double y, double z, double width, double height, double alpha) {
		 
		super(x, y, z, width, height, alpha);
	}
	
	public void update(int delta) {
		this.x += delta * dx;
		this.y += delta * dy;
		this.z += delta * dz;
		
		if (health <= 0) {
			onDeath();
		}
	}
	
	public void draw() {
		// draw the Player
		
		if (walkingDown) {
			LoadTextures.playerDown.bind();
		}
		else if (walkingUp) {
			LoadTextures.playerUp.bind();
		}
		else if (walkingLeft) {
			LoadTextures.playerLeft.bind();
		}
		else if (walkingRight) {
			LoadTextures.playerRight.bind();
		}
		
		glColor4d(1, 1, 1, alpha);
		
		glBegin(GL_QUADS);
			glTexCoord2d(0, 0);
			glVertex3d(x, y, z);
			
			glTexCoord2d(1, 0);
			glVertex3d(x + width, y, z);
			
			glTexCoord2d(1, 1);
			glVertex3d(x + width, y - height, z);
			
			glTexCoord2d(0, 1);
			glVertex3d(x, y - height, z);
		glEnd();
		
		glColor4d(1, 1, 1, 1);
		
		// draw the HUD (health, hunger)
		
	}
}