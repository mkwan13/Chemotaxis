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

 //declare bacteria variables here   
 Bacteria [] colony;
 Bacteria bact;

 public void setup()   
{
    // initialize bacteria variables here
 	size(500, 500);
 	bact = new Bacteria ();
 	colony = new Bacteria [40];
 	for(int i = 0; i < colony.length; i++)
 	{
 		colony [i] = new Bacteria();
 	}  
 }   

 public void draw()   
 {    
 	background(0);
 	for (int i = 0; i < colony.length; i++)
 	{
 		colony[i].show();
 		colony[i].move();
 	}
}

 class Bacteria    
 {     
 	//lots of java!
 	int pX, pY;
 	int bX, bY;
 	Bacteria()
 	{
 		pX = (int)(Math.random()*500);
 		pY = (int)(Math.random()*500);
 		bX = (int)(Math.random()*500);
 		bY = (int)(Math.random()*500); 
 	}

 	public void move()
 	{
 		// pink circles
 		pX = pX + (int)(Math.random()*2-1.5f);
 		pY = pY + (int)(Math.random()*2-1.5f);
 		if(pX > bX)
 		{
 			pX = pX + (int)(Math.random()*1-1);
 		}
 		if(pY > bY)
 		{
 			pY = pY + (int)(Math.random()*1-1);
 		}
 		if(pX < bX)
 		{
 			pX = pX + (int)(Math.random()*1+.5f);
 		}
 		if(pY < bX)
 		{
 			pY = pY + (int)(Math.random()*1+.5f);
 		}

 		// blue circles
 		bX = bX + (int)(Math.random()*2-1.5f);
 		bY = bY + (int)(Math.random()*2-1.5f);
 		if(bX > pX)
 		{
 			bX = bX + (int)(Math.random()*1-1);
 		}
 		if(bY > pY)
 		{
 			bY = bY + (int)(Math.random()*1-1);
 		}
 		if(bX < pX)
 		{
 			bX = bX + (int)(Math.random()*1+.5f);
 		}
 		if(bY < pY)
 		{
 			bY = bY + (int)(Math.random()*1+.5f);
 		}

 		if(pX == bX && pY == bY)
 		{
 			bX = (int)(Math.random()*500);
 			bY = (int)(Math.random()*500);
 			pX = (int)(Math.random()*500);
 			pY = (int)(Math.random()*500);
 		}
 	}

 	public void show()
 	{
 		stroke(255, 0, 255);
 		ellipse(pX, pY, 6, 6);

 		stroke(0, 255, 255);
 		ellipse(bX, bY, 6, 6);
 	}

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
