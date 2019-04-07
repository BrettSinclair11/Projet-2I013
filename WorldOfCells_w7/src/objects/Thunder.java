package objects;

import javax.media.opengl.GL2;

import worlds.World;

public class Thunder extends CommonObject {
	 public static void displayObjectAt(World myWorld, GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight ) {
		 gl.glColor3f(1.f,1.f,0.f);   
		 if ( cellState == 12 )
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
