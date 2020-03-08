package Simulation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Utilities.GDV5;

public class Simulation extends GDV5{
	
	Animation a;
	BufferedImage [] slides;
	
	public Simulation() {
		super();//constructs the object 
		super.setSize(Constants.width, Constants.height);//let's make 1000*1000
		super.setBackground(Constants.background_color);
		super.setTitle("The Atom Bomb");
		initialize();
		a = new Animation(this.slides);
	}
	
	public void initialize() {
		slides = new BufferedImage[Constants.slide_count];
		for(int i = 0; i< slides.length; i++) {
			slides[i] = this.addImage("Images/Slide"+(i+1)+".PNG");
		}
		
		
	}
	
	public static void main(String [] args) {
		Simulation s = new Simulation();
		s.start();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		a.update();
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		a.draw(win);
	}

}