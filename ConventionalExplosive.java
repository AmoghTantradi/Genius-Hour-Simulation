package Simulation;

import java.awt.Graphics2D;

public class ConventionalExplosive extends Bomb  {

	public ConventionalExplosive() {
		super();
		System.out.println("Created");
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		System.out.println("updating");
		super.update();
	}
	
	public void draw(Graphics2D win) {
		super.draw(win);
	}


}
