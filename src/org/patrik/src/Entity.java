package org.patrik.src;

public interface Entity {
	public void draw();
	public void update(int delta);
	
	// setters
	public void setPosition(double x, double y, double z);
	public void setX(double x);
	public void setY(double y);
	public void setZ(double z);
	public void setWidth(double width);
	public void setHeight(double height);
	public void setAlpha(double alpha);
	
	// getters
	public double getX();
	public double getY();
	public double getZ();
	public double getWidth();
	public double getHeight();
	public double getAlpha();
	
	public boolean intersectsWithEntity(Entity entity);
	public boolean intersectsWithMouse(int mouseX, int mouseY);
}