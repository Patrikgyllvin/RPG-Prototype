package org.patrik.src;

public abstract class AbstractEntityLiving extends AbstractEntity implements EntityLiving {
	
	protected double dx, dy, dz, hunger, health;
	protected boolean dead;
	
	public AbstractEntityLiving(double x, double y, double z, double width, double height, double alpha) {
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
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public void setHunger(double hunger) {
		this.hunger = hunger;
	}
	
	public void setDX(double dx) {
		this.dx = dx;
	}
	
	public void setDY(double dy) {
		this.dy = dy;
	}
	
	public void setDZ(double dz) {
		this.dz = dz;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getHunger() {
		return health;
	}
	
	public double getDX() {
		return dx;
	}
	
	public double getDY() {
		return dy;
	}
	
	public double getDZ() {
		return dz;
	}
	
	public void onDeath() {
		// play death sond
		
		dead = true;
	}
}