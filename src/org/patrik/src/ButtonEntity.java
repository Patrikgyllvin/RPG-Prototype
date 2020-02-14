package org.patrik.src;

import org.patrik.Game.*;
import org.newdawn.slick.Color;

import static org.lwjgl.opengl.GL11.*;

public class ButtonEntity extends AbstractEntityButton {
	
	public ButtonEntity(double x, double y, double z, double width, double height, double alpha) {
		super(x, y, z, width, height, alpha);
	}
	
	public void draw() {
		if (hasTextures) {
			glColor4d(1.0, 1.0, 1.0, alpha);
		} else {
			glColor4d(0.5, 0.5, 0.5, alpha);
			LoadTextures.noTextureButton.bind();
		}
		
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2d(x, y);
			glTexCoord2f(1, 0);
			glVertex2d(x + width, y);
			glTexCoord2f(1, 1);
			glVertex2d(x + width, y + height);
			glTexCoord2f(0, 1);
			glVertex2d(x, y + height);
		glEnd();
		glColor4d(1, 1, 1, 1);
		
		if (hasText) {
			GameLogic.uFont.drawString((float)x + 5, (float)y + 5, Text, Textcolor);
		}
	}
	
	public void update(int delta) {
		// Do nothing
	}
}
