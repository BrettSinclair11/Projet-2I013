package objects;

import javax.media.opengl.GL2;

import worlds.World;

public class Grass extends CommonObject {
	 public static void displayObjectAt(World myWorld, GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight ) {
		 switch ( cellState )
	        {
	        	case 4://normal
	        		gl.glColor3f(0.f,0.6f,0.f);
	        		break;
	        	case 5://feu
	        		gl.glColor3f(1.f,0.f,0.f);
	        		break;
	        	case 6://cendre
	        		gl.glColor3f(0.f,0.f,0.f);
	        		break;
	        }

	        if ( cellState > 3 && cellState < 7 )
	        {
	    		float altitude = (float)height * normalizeHeight ;
	    		
	    		//float heightFactor, double heightBooster, float smoothFactor[]
	    		
	    		 gl.glVertex3f( offset+x*stepX-lenY/16.f, offset+y*stepY+lenY/2.f,altitude + 1.f );
		         gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
		         gl.glVertex3f( offset+x*stepX+lenY/16.f, offset+y*stepY-lenY/2.f, altitude + 1.f );
		         gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );

		         gl.glVertex3f( offset+x*stepX-lenY/2.f, offset+y*stepY+lenY/16.f, altitude + 1.f );
		         gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
		         gl.glVertex3f( offset+x*stepX+lenY/2.f, offset+y*stepY-lenY/16.f, altitude + 1.f );
		         gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude );
	        }
	 }
	 
	 
	 
	 
}
