package Simulation;

import java.awt.Color;
import java.awt.Graphics2D;

import Utilities.GDV5;

public class Simulation extends GDV5{
	
	Animation a;
	
	public Simulation() {
		super();//constructs the object 
		super.setSize(Constants.width, Constants.height);//let's make 1000*1000
		super.setBackground(Constants.background_color);
		super.setTitle("The Atom Bomb");
		a = new Animation();
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