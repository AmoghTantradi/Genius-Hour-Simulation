package Simulation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends Rectangle2D.Double implements SimulationObject {
	
	protected ExplosionManager e;
	protected Color col;
	protected boolean isFalling = true;
	protected double dy = Constants.fallspeed;
	protected double height_of_explosion;
	
	public Bomb() {
		this(Constants.width/2,-1*Constants.Bomb_height,Constants.default_magnitude,Constants.default_height,Color.green);
	}
	public Bomb(double x, double y,int magnitude, int height, Color c) {
		
		super(x,y,Constants.Bomb_width,Constants.Bomb_height);
		e = new ExplosionManager(magnitude);
		height_of_explosion = height;
		this.col = c;
		System.out.println("Created");
		
		
	}
	
	public boolean isFinished() {
		for(int i = 0; i < e.extent.length; i++) {
			if(e.extent[i] != null) {
				return false; //if a particle is still there, it has not yet finished
			}
		}
		
		return true; //all the particles have exited the screen
	}	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("updating");
		this.setRect(this.x,this.y+this.dy, Constants.Bomb_width, Constants.Bomb_height);//falls/translates
		
		if(this.y+this.height >=height_of_explosion) {
			isFalling = false; //this is useful so then we can set it to null once all the particles exit
			if(!e.hasDetonated) {
				e.detonate(this);//this will initialize everything
				//change the color to the background color so it looks like it exploded
				col = Constants.background_color;
			}
			e.update();//this will update the particles once it has reached the detonation height
			
		}
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(col);
		win.fill(this);
		e.draw(win);
	}

}