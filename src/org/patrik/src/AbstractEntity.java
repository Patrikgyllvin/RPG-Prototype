package org.patrik.src;

import java.awt.Rectangle;

public abstract class AbstractEntity implements Entity {
	
	protected double x, y, z, width, height, alpha;
	protected Rectangle hitBox = new Rectangle();
	
	public AbstractEntity(double x, double y, double z, double width, double height, double alpha) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.alpha = alpha;
	}
	
	@Override
	public void setPosition(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}
	
	@Override
	public double getZ() {
		return z;
	}
	
	@Override
	public double getWidth() {
		return width;
	}
	
	@Override
	public double getHeight() {
		return height;
	}
	
	@Override
	public double getAlpha() {
		return alpha;
	}
	
	@Override
	public boolean intersectsWithEntity(Entity entity) {
		hitBox.setBounds((int)x, (int)y, (int)width, (int)height);
		return hitBox.intersects(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
	}
	
	@Override
	public boolean intersectsWithMouse(int mouseX, int mouseY) {
		hitBox.setBounds((int)x, (int)y, (int)width, (int)height);
		return hitBox.intersects(mouseX, mouseY, 1, 1);
	}

}