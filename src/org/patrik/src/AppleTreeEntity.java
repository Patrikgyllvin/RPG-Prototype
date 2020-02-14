package org.patrik.src;

import java.util.Random;

import org.patrik.Game.LoadTextures;

import static org.lwjgl.opengl.GL11.*;

public class AppleTreeEntity extends AbstractEntityLiving {
	
	private Random rand = new Random();
	private int apples;
	private int growTime;
	private boolean hasApples;
	
	public AppleTreeEntity(double x, double y, double z, double width,
			double height, double alpha) {
		super(x, y, z, width, height, alpha);
		apples = 0;
		hasApples = false;
		growTime = (rand.nextInt(1000) + 1000);
	}
	
	@Override
	public void draw() {
		glColor4f(1, 1, 1, 1);
		
		LoadTextures.Tree.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3d(x, y, z);
			
			glTexCoord2f(1, 0);
			glVertex3d(x + width, y, z);
			
			glTexCoord2f(1, 1);
			glVertex3d(x + width, y - height, z);
			
			glTexCoord2f(0, 1);
			glVertex3d(x, y - height, z);
		glEnd();
		
		if (apples >= 1 && hasApples) {
			LoadTextures.Apple.bind();
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex3d(x + 45, y - 100, z + 1);
				
				glTexCoord2f(1, 0);
				glVertex3d(x + 45 + 64, y - 100, z + 1);
				
				glTexCoord2f(1, 1);
				glVertex3d(x + 45 + 64, y - 100 - 64, z + 1);
				
				glTexCoord2f(0, 1);
				glVertex3d(x + 45, y - 100 - 64, z + 1);
			glEnd();
		}
		
		if (apples >= 2 && hasApples) {
			LoadTextures.Apple.bind();
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex3d(x + 90, y - 30, z + 1);
				
				glTexCoord2f(1, 0);
				glVertex3d(x + 90 + 64, y - 30, z + 1);
				
				glTexCoord2f(1, 1);
				glVertex3d(x + 90 + 64, y - 30 - 64, z + 1);
				
				glTexCoord2f(0, 1);
				glVertex3d(x + 90, y - 30 - 64, z + 1);
			glEnd();
		}
		
		if (apples >= 3 && hasApples) {
			LoadTextures.Apple.bind();
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex3d(x + 150, y - 80, z + 1);
				
				glTexCoord2f(1, 0);
				glVertex3d(x + 150 + 64, y - 80, z + 1);
				
				glTexCoord2f(1, 1);
				glVertex3d(x + 150 + 64, y - 80 - 64, z + 1);
				
				glTexCoord2f(0, 1);
				glVertex3d(x + 150, y - 80 - 64, z + 1);
			glEnd();
		}
		
		if (apples >= 4 && hasApples) {
			LoadTextures.Apple.bind();
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex3d(x + 105, y - 130, z + 1);
				
				glTexCoord2f(1, 0);
				glVertex3d(x + 105 + 64, y - 130, z + 1);
				
				glTexCoord2f(1, 1);
				glVertex3d(x + 105 + 64, y - 130 - 64, z + 1);
				
				glTexCoord2f(0, 1);
				glVertex3d(x + 105, y - 130 - 64, z + 1);
			glEnd();
		}
	}
	
	public void update(int delta) {
		if (growTime > 0) {
			growTime--;
		}
		
		if (growTime == 0 && apples == 0) {
			apples = (rand.nextInt(3) + 1);
		}
		
		if (apples > 0) {
			hasApples = true;
		}
		
		if (health <= 0) {
			onDeath();
		}
	}
}