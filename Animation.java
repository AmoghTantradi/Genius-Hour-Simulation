package Simulation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Utilities.GDV5;

public class Animation implements SimulationObject {
	
	//make all the objects here
	Bomb norm,atom;
	BufferedImage [] slides;
	int state = 0;
	public Animation(BufferedImage [] slides) {
		
		//initialize all the objects here
		this.slides = slides;
		norm = new ConventionalExplosive();
//start with a normal bomb
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//update everything here 
		if(GDV5.KeysTyped[KeyEvent.VK_RIGHT]) {
		if(state != slides.length-1)	{
			state = ((state+1)%(slides.length));
			stopAnimation();
		}
		else {
			state = -1;
			dropConventional();
		}
			
			System.out.println("hello"+": "+ state);
		}
		if(state == -1) {
			bombControl();
		}
		GDV5.KeysTyped[KeyEvent.VK_RIGHT] = false;
	}
	
	public void stopAnimation() {
		norm = null;
		atom = null;
	}
	public void bombControl() {//add stuff here I guess
		if(norm!=null) {
			norm.update();
			
			if(!norm.isFalling) {
				if(norm.isFinished()) {
					norm = null;
					//drops the Atom Bomb now
					dropAtom();
				}
			}
		}
		else if(atom!=null) {
			atom.update();
			if(!atom.isFalling) {
				if(atom.isFinished()) {
					atom = null;
					dropConventional();
				}
			}
		}
	}
	
	public void dropAtom() {
		atom = new AtomicExplosive();
	}
	
	public void dropConventional() {
		norm = new ConventionalExplosive();
	}
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		//draw everything here 
		if(state == -1) {
		if(norm!=null) norm.draw(win);
		if(atom!=null) atom.draw(win);
		}
		else {
			win.drawImage(slides[state],0,0,null);
		}
		
	}
	
	
	
	

}
