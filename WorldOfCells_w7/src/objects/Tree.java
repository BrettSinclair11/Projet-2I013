// ### WORLD OF CELLS ###
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package objects;

import javax.media.opengl.GL2;

import worlds.World;

public class Tree extends CommonObject {

    public static void displayObjectAt(World myWorld, GL2 gl, int cellState, float x, float y, double height, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight )
    {
        //float smoothFactorAvg = ( smoothFactor[0] + smoothFactor[1] + smoothFactor[2] + smoothFactor[3] ) / 4.f;

        if ( cellState > 0  && cellState < 4)
        {
    			float altitude = (float)height * normalizeHeight ;

    			//float heightFactor, double heightBooster, float smoothFactor[]

						//Arbre origine
    			switch ( cellState )
    	        {
    	        	case 1:
    	        		gl.glColor3f(0.f,0.6f,0.f);
    	        		break;
    	        	case 2:
    	        		gl.glColor3f(1.f,0.f,0.f);
    	        		break;
    	        	case 3:
    	        		gl.glColor3f(0.f,0.f,0.f);
    	        		break;
    	        }		
    			
            gl.glVertex3f( offset+x*stepX-lenX/12.f, offset+y*stepY+lenY/1.5f, altitude );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude + 6.5f );
            gl.glVertex3f( offset+x*stepX+lenX/12.f, offset+y*stepY-lenY/1.5f, altitude );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude + 6.5f );

            gl.glVertex3f( offset+x*stepX-lenX/1.5f, offset+y*stepY+lenY/12.f, altitude );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude + 6.5f );
            gl.glVertex3f( offset+x*stepX+lenX/1.5f, offset+y*stepY-lenY/12.f, altitude );
            gl.glVertex3f( offset+x*stepX, offset+y*stepY, altitude + 6.5f );


						//Mon arbre


						//Tronc

					/*if (cellState == 1) gl.glColor3f(88.f / 250.f, 41.f / 250.f, 0.f);

					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude);
					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude);

					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude);
					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude);

					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude);
					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude);

					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude);
					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY - 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude + 2.f);
					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY + 0.5f * lenY + 0.f, altitude);


						//Feuilles

					switch ( cellState )
	        {
	        	case 1:
	        		gl.glColor3f(0.f,0.6f,0.f);
	        		break;
	        	case 2:
	        		gl.glColor3f(1.f,0.f,0.f);
	        		break;
	        	case 3:
	        		gl.glColor3f(0.f,0.f,0.f);
	        		break;
	        }

					gl.glVertex3f( offset + x * stepX - 2.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY - 0.5f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY - 0.5f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX - 0.f * lenX, offset + y * stepY - 2.f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX - 0.f * lenX, offset + y * stepY - 2.f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY - 0.5f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY - 0.5f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX + 2.f * lenX, offset + y * stepY - 0.f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX + 2.f * lenX, offset + y * stepY - 0.f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY + 0.5f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX + 0.5f * lenX, offset + y * stepY + 0.5f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 2.f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 2.f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY + 0.5f * lenY, altitude + 2.f);

					gl.glVertex3f( offset + x * stepX - 0.5f * lenX, offset + y * stepY + 0.5f * lenY, altitude + 2.f);
        	gl.glVertex3f( offset + x * stepX + 0.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 8.f);
        	gl.glVertex3f( offset + x * stepX - 2.f * lenX, offset + y * stepY + 0.f * lenY, altitude + 2.f);
*/
        }
    }

}