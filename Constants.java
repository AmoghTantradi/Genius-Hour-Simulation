package Simulation;

import java.awt.Color;

public class Constants {
	
	public static double size_of_particle = 10;
	public static int width = 1000;
	public static int height = 800;
	public static double Bomb_width = 20.0;
	public static double Bomb_height = 50.0;
	public static double fallspeed = 2.5;
	public static int default_magnitude = 100;//the intensity of the bomb
	public static int atomic_magnitude = 1000*default_magnitude;
	public static int default_height = (int)( height*0.5);
	public static int atomic_height = height/2;
	public static double velocity = 30;
	public static double min_velocity = velocity/5;
	public static Color background_color = Color.black;
	public static int slide_count = 7;

}