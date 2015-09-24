 Bacteria[] colony;
 int more=100;//declare bacteria variables here   
 void setup()   
 {     
 	size(600,600);
 	water = new Predator;
 	//initialize bacteria variables here   
 	colony = new Bacteria[more];
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i]= new Bacteria();
 		more=more+10;

 	}
 

 }   
 void draw()   
 { 
 	background(255);
 	 int x,y ;
 	x=200;
 	y=200;//(int)(Math.random()*255+1);
 	///int myColor=(int)(Math.random()*255+1);
 	frameRate(3);
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i].move();
 		colony[i].show();
 	}
 	

 	//move and show the bacteria   
 }  
 class Predator
 {
 	int wX, xY;
 	Predator()
 	{
 		wX =

 	}
 }
 class Bacteria    
 {  
 	int myX,myY,myColor;//colorR,colorG, colorB;
 Bacteria()
 {
 	myX=(int)(Math.random()*600+1);
 	myY=(int)(Math.random()*600+1);
 	
 	int colorR=(int)(Math.random()*255+1);
 	int colorG=(int)(Math.random()*255+1);
 	int colorB=(int)(Math.random()*255+1);
	myColor=color (colorR,colorG,colorB,60);

 }   
 	void move()
 	{
 		myX=myX+ (int)(Math.random()*15-7);
 		myY=myY+(int)(Math.random()*15-7 );
 	}
 	void show()
 	{
 		noStroke();
 		fill(myColor*2);//colorR,colorG,colorB);
 		ellipse(myX,myY,15,15);
 		//fire
noStroke();
fill(245, 147, 61,30);

beginShape();

curveVertex(215,304);
curveVertex(215,304);
curveVertex(224,273);
curveVertex(208,281);
curveVertex(200,264);
curveVertex(191,280);
curveVertex(175,276);
curveVertex(185,304);
curveVertex(183,304);
endShape();
ellipse(200, 300, 38, 30);
//inside shape
fill(240,43,21,45);
beginShape();
curveVertex(212,297);
curveVertex(209,304);
curveVertex(219,279);
curveVertex(207,286);
curveVertex(199,272);
curveVertex(192,287);
curveVertex(180,281);
curveVertex(191,305);
curveVertex(186,304);
endShape();
ellipse(200, 300, 28, 23);
fill(255);
ellipse(195,296,7,7);
ellipse(206,296,7,7);
fill(0);
ellipse(195,296,2,2);
ellipse(206,296,2,2);
 	}//lots of java!   
 }    