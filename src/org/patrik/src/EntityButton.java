package org.patrik.src;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public interface EntityButton extends Entity {
	public boolean insideAndPressButton();
	public boolean releaseButton();
	
	public void setTransparent(boolean transparent);
	public void setText(boolean Text, String text, Color color);
	public void setColor(Color color);
	public void setHasTextures(boolean hasTextures);
	
	public Color getColor();
}