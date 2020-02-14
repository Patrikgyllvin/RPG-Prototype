package org.patrik.src;

public interface EntityLiving extends Entity {
	// a living entity obviously will walk?
	// setters
	public void setHealth(double h);
	public void setHunger(double h);
	public void setDX(double dx);
	public void setDY(double dy);
	public void setDZ(double dz);
	
	// getters
	public double getHealth();
	public double getHunger();
	public double getDX();
	public double getDY();
	public double getDZ();
	
	public void onDeath();
}