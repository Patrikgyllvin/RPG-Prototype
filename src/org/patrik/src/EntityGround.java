package org.patrik.src;

import static org.lwjgl.opengl.GL11.*;

import org.patrik.Game.LoadTextures;

public class EntityGround extends AbstractEntityLiving {
	public EntityGround(double x, double y, double z, double width, double height, double alpha) {
		super(x, y, z, width, height, alpha);
	}
	
	// Cant Die
	public void update(int delta) {
		this.x += delta * dx;
		this.y += delta * dy;
	}
	
	public void setHealth(double health) {
		// No Health
	}
	
	public void setHunger(double hunger) {
		// No Hunger
	}
	
	public double getHealth() {
		// No Health
		return 0;
	}
	
	public double getHunger() {
		// No Hunger
		return 0;
	}
	
	public void draw() {
		for(double posX = x; posX < x + width; posX += 128) {
			for (double posY = y; posY < y + height; posY += 128) {
				LoadTextures.ground.bind();
				
				glColor4d(1, 1, 1, alpha);
				
				glBegin(GL_QUADS);
					glTexCoord2f(0, 0);
					glVertex3d(posX, posY, z);
					glTexCoord2f(1, 0);
					glVertex3d(posX + 128, posY, z);
					glTexCoord2f(1, 1);
					glVertex3d(posX + 128, posY + 128, z);
					glTexCoord2f(0, 1);
					glVertex3d(posX, posY + 128, z);
				glEnd();
				
				glColor4d(1, 1, 1, 1);
			}
		}
	}
}