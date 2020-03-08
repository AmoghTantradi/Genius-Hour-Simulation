package Simulation;

import java.awt.Color;
import java.awt.Graphics2D;

public class AtomicExplosive extends Bomb {
	
	public AtomicExplosive() {
		super(Constants.width/2,-Constants.Bomb_height,Constants.atomic_magnitude,Constants.atomic_height,Color.orange);
	}
	
	public void update() {
		super.update();
	}
	
	public void draw(Graphics2D win) {
		super.draw(win);
	}

}
