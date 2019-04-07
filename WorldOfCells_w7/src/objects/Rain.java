package objects;

import javax.media.opengl.GL2;

import worlds.World;

public class Rain extends CommonObject {
	 public static void displayObjectAt(World myWorld, GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight ) {
		 	gl.glColor3f((float)(-height),(float)(height)*0.3f,1.0f);
	        if ( cellState == 9 )
	        {
	    		float altitude = (float)height * normalizeHeight ;
	    		
	    		//float heightFactor, double heightBooster, float smoothFactor[]
	    		
	    		 //state 1
	        }else if ( cellState == 10 )
	        {
	    		float altitude = (float)height * normalizeHeight ;
	    		
	    		//float heightFactor, double heightBooster, float smoothFactor[]
	    		
	    		//state 2 #decalage
	        }
	 }
	 
	 
	 
	 
}
