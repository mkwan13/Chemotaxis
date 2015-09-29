 //declare bacteria variables here   
 Bacteria [] colony;
 Bacteria bact;

 void setup()   
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

 void draw()   
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

 	void move()
 	{
 		// pink circles
 		pX = pX + (int)(Math.random()*2-1.5);
 		pY = pY + (int)(Math.random()*2-1.5);
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
 			pX = pX + (int)(Math.random()*1+.5);
 		}
 		if(pY < bX)
 		{
 			pY = pY + (int)(Math.random()*1+.5);
 		}

 		// blue circles
 		bX = bX + (int)(Math.random()*2-1.5);
 		bY = bY + (int)(Math.random()*2-1.5);
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
 			bX = bX + (int)(Math.random()*1+.5);
 		}
 		if(bY < pY)
 		{
 			bY = bY + (int)(Math.random()*1+.5);
 		}

 		if(pX == bX && pY == bY)
 		{
 			bX = (int)(Math.random()*500);
 			bY = (int)(Math.random()*500);
 			pX = (int)(Math.random()*500);
 			pY = (int)(Math.random()*500);
 		}
 	}

 	void show()
 	{
 		stroke(255, 0, 255);
 		ellipse(pX, pY, 6, 6);

 		stroke(0, 255, 255);
 		ellipse(bX, bY, 6, 6);
 	}

 }    