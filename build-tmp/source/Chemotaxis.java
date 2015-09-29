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
 Predator water; 
 int more=100;//declare bacteria variables here   
 public void setup()   
 {     
 	size(800,600);
 	

 	//initialize bacteria variables here   
 	colony = new Bacteria[more];
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i]= new Bacteria();
 		more=more+10;

 	}
 	water = new Predator();

 }   
 public void draw()   
 { 
 	background(255);
 	 int x,y ;
 	x=200;
 	y=200;
 	
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i].move();
 		colony[i].show();
 	}
 	water.show();

 	// 
 }  
 class Predator
 {
 
 	Predator()
 	{
 	
 	}
 	public void show()
 	{
 		
 		fill(94,169,228,170);
 		ellipse(mouseX,mouseY,50,50);
 		fill(64,166,245,200);
 		ellipse(mouseX,mouseY,30,30);
 	}

 }
 class Bacteria    
 {  

 	int myX,myY,myColor;//colorR,colorG, colorB;
 Bacteria()
 {

 	myX=(int)(Math.random()*800+1);
 	myY=(int)(Math.random()*600+1);
 	
 	int colorR=(int)(Math.random()*255+1);
 	int colorG=(int)(Math.random()*255+1);
 	int colorB=(int)(Math.random()*255+1);
	myColor=color (colorR,colorG,colorB,60);

 }   
 	public void move()
 	{
 		frameRate(25);
 		myX=myX+ (int)(Math.random()*14-7);
 		myY=myY+(int)(Math.random()*14-7);
 		//get away from water
 		if (mouseX+15 <myX && mouseY+15<myY )//rightanddown
 		{
 			myX=myX+ (int)(Math.random()*5+1);
 		    myY=myY+(int)(Math.random()*5+1);
 		}
 		else if (mouseX+15 >myX && mouseY+15>myY )
 		{
 			myX=myX- (int)(Math.random()*5+1);
 		    myY=myY-(int)(Math.random()*5+1);
 		}
 		else if (mouseX+15 <myX && mouseY+15>myY )
 		{
 			myX=myX+ (int)(Math.random()*5+1);
 		    myY=myY-(int)(Math.random()*5+1);
 		}
 		else if (mouseX+15 >myX && mouseY+15<myY )
 		{
 			myX=myX- (int)(Math.random()*5+1);
 		    myY=myY+(int)(Math.random()*5+1);
 		}
 		//refresh pg
 		if(keyPressed==true)
 		{
 			myX=(int)(Math.random()*800+1);
 			myY=(int)(Math.random()*600+1);
 		}
 		//disappear
 		if(get(myX,myY) == color(94,169,228,170) )
 		{
 			myX= -200;
 		    myY= -200;
 		}

 	}


 	public void show()
 	{

 		noStroke();
 		fill(myColor*2);//colorR,colorG,colorB);
 		ellipse(myX,myY,15,15);
 		//fire
	noStroke();
	fill(245, 147, 61,160);

	beginShape();

	curveVertex(215+myX-150,304+myY-230);
	curveVertex(215+myX-150,304+myY-230);
	curveVertex(224+myX-150,273+myY-230);
	curveVertex(208+myX-150,281+myY-230);
	curveVertex(200+myX-150,264+myY-230);
	curveVertex(191+myX-150,280+myY-230);
	curveVertex(175+myX-150,276+myY-230);
	curveVertex(185+myX-150,304+myY-230);
	curveVertex(183+myX-150,304+myY-230);
	endShape();
	ellipse(200+myX-150, 300+myY-230, 38, 30);
	//inside shape
	fill(240,43,21,170);
	beginShape();
	curveVertex(212+myX-150,297+myY-230);
	curveVertex(209+myX-150,304+myY-230);
	curveVertex(219+myX-150,279+myY-230);
	curveVertex(207+myX-150,286+myY-230);
	curveVertex(199+myX-150,272+myY-230);
	curveVertex(192+myX-150,287+myY-230);
	curveVertex(180+myX-150,281+myY-230);
	curveVertex(191+myX-150,305+myY-230);
	curveVertex(186+myX-150,304+myY-230);
	endShape();
	ellipse(200+myX-150, 300+myY-230, 28, 23);
	fill(255);
	ellipse(195+myX-150,296+myY-230,7,7);
	ellipse(206+myX-150,296+myY-230,7,7);
	fill(0);
	ellipse(195+myX-150,296+myY-230,2,2);
	ellipse(206+myX-150,296+myY-230,2,2);
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
