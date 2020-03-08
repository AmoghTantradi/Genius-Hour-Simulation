package Simulation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Particle extends Rectangle2D.Double implements SimulationObject {

	double dx, dy;

	public Particle(double x, double y, double dx, double dy) {
		super(x, y, Constants.size_of_particle, Constants.size_of_particle);
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.setRect(this.x + this.dx, this.y + this.dy, Constants.size_of_particle, Constants.size_of_particle);
	}

	public boolean outBounds() {
		return (this.x + this.width < 0 || this.x > Constants.width || this.y > Constants.height
				|| this.y + this.height < 0);

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(Color.red);
		win.fill(this);
	}

}