import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria[] colony;
 int more=40;//declare bacteria variables here   
 public void setup()   
 {     
 	size(400,400);
 	//initialize bacteria variables here   
 	colony = new Bacteria[more];
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i]= new Bacteria();

 	}
 

 }   
 public void draw()   
 { 
 	background(255);
 	 int x,y ;
 	filter(BLUR);
 	x=200;
 	y=200;//(int)(Math.random()*255+1);
 	///int myColor=(int)(Math.random()*255+1);
 	frameRate(3);
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i].move();
 		colony[i].show();
 	}
 		more=more+40;

 	//move and show the bacteria   
 }  
 class Bacteria    
 {  
 	int myX,myY,myColor;//colorR,colorG, colorB;
 Bacteria()
 {
 	myX=(int)(Math.random()*400+1);
 	myY=(int)(Math.random()*400+1);
 	
 	int colorR=(int)(Math.random()*255+1);
 	int colorG=(int)(Math.random()*255+1);
 	int colorB=(int)(Math.random()*255+1);
	myColor=color (colorR,colorG,colorB,60);

 }   
 	public void move()
 	{
 		myX=myX+ (int)(Math.random()*15-7);
 		myY=myY+(int)(Math.random()*15-7 );
 	}
 	public void show()
 	{
 		noStroke();
 		fill(myColor*2);//colorR,colorG,colorB);
 		ellipse(myX,myY,15,15);
 	}//lots of java!   
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
