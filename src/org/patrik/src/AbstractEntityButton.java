package org.patrik.src;

import org.patrik.Game.Input;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public abstract class AbstractEntityButton extends AbstractEntity implements EntityButton {
	
	protected boolean isTransparent, pressButton, hasText, hasTextures, lastFrameButton;
	protected String Text;
	protected Color Textcolor;
	
	public AbstractEntityButton(double x, double y, double z, double width,
			double height, double alpha) {
		super(x, y, z, width, height, alpha);
	}
	
	@Override
	public boolean insideAndPressButton() {
		if (intersectsWithMouse(Mouse.getX(), Display.getDisplayMode().getHeight() - Mouse.getY() - 1)) {
			if (isTransparent)
				setAlpha(1.0);
			
			if (Input.Mouse(0)) {
				pressButton = true;
			} else {
				pressButton = false;
			}
		} else {
			if (isTransparent)
				setAlpha(0.5);
			
			pressButton = false;
		}
		return pressButton;
	}
	
	@Override
	public boolean releaseButton() {
		insideAndPressButton();
		
		if (pressButton == false && lastFrameButton == true) {
			lastFrameButton = pressButton;
			return true;
		} else {
			lastFrameButton = pressButton;
			return false;
		}
	}
	
	public void setTransparent(boolean transparent) {
		this.isTransparent = transparent;
	}
	
	public void setText(boolean Text, String text, Color color) {
		this.hasText = Text;
		this.Text = text;
		this.Textcolor = color;
	}
	
	public void setColor(Color color) {
		this.Textcolor = color;
	}
	
	public void setHasTextures(boolean hasTextures) {
		this.hasTextures = hasTextures;
	}
	
	public Color getColor() {
		return this.Textcolor;
	}
}