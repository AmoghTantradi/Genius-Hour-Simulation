package Simulation;

import java.awt.Graphics2D;
import java.util.Random;

public class ExplosionManager implements SimulationObject {

	Particle[] extent;
	Random rand;
	boolean hasDetonated = false;//this ensures that the isFinished method is not called and that the bomb is not set to null

	public ExplosionManager(int magnitude) {

		extent = new Particle[magnitude];// we still have to initialize the objects
		rand = new Random();
		
	}

	public void detonate(Bomb b) { //this will be called by the bomb once the bomb has reached its detonation height
		for (int i = 0; i < extent.length; i++) {
			extent[i] = new Particle(b.getCenterX(), b.getCenterY(),
					rand.nextGaussian() * Constants.velocity + Constants.min_velocity,
					rand.nextGaussian() * Constants.velocity + Constants.min_velocity);// make sure to give it a
																						// velocity greater than 0
		}
		hasDetonated = true;
	}

	public void update() {// this will continue the explosion

		for (int i = 0; i < extent.length; i++) {
			if (extent[i] != null) {
				extent[i].update();
				if (extent[i].outBounds()) {
					extent[i] = null;// if it exits the screen, set it to null
					// this is imporant so that we save memory
				}
			}
		}
	}
	

	public void draw(Graphics2D win) {

		for (int i = 0; i < extent.length; i++) {

			if (extent[i] != null) {
				extent[i].draw(win);//draws the particles if they aren't null
			}

		}

	}

}