// ### WORLD OF CELLS ###
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import java.util.ArrayList;

import javax.media.opengl.GL2;

import objects.UniqueDynamicObject;

import worlds.World;

public class Cow extends Agent {
	
	public Cow ( int __x , int __y, World __world ) {

		super(__x,__y,__world);
		ID 		   = "COW";
		HP 		   = 150;
		SpotRange  = 8;
		FoodRange  = 8;
		WaterRange = 10;
		TotalFood  = 150;
		Food 	   = 150;
		TotalWater = 120;
		Water 	   = 120;
		Stamina    = 80;
		Predators  = this.getPredators(ID);
		Preys	   = new ArrayList<Agent>();
	}
	
	public boolean FindFood() {

		int minDistance = this.FoodRange;
		boolean modified = false;

		for(int i = this.x - this.FoodRange; i <= this.x + this.FoodRange; i ++) {
			for(int j = this.y - this.FoodRange; j <= this.y + this.FoodRange; j ++) {

				if (super.world.getCellValue1(i, j) == 4 && Math.abs(i) + Math.abs(j) < minDistance) {

					minDistance = Math.abs(i) + Math.abs(j);
					modified = true;

					if 		(j >= this.y) this.Direction = 0.f;
					else if (i >= this.x) this.Direction = 0.25f;
					else if (j <= this.x) this.Direction = 0.5f;
					else if (i <= this.x) this.Direction = 0.75f;
				}
			}
		}
		return modified;
	}

	public void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x,
			int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight)
	{


			//gl.glColor3f(0.f+(float)(0.5*Math.random()),0.f+(float)(0.5*Math.random()),0.f+(float)(0.5*Math.random()));

		int x2 = (x-(offsetCA_x%myWorld.getWidth()));
		if ( x2 < 0) x2 += myWorld.getWidth();
		int y2 = (y-(offsetCA_y%myWorld.getHeight()));
		if ( y2 < 0) y2 += myWorld.getHeight();

		float height = Math.max ( 0 , (float)myWorld.getCellHeight(x, y) );


		// display a PINGUIN

		/*
			gl.glColor3f(1.f,1.f,1.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);

			gl.glColor3f(1.f,1.f,1.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);

			gl.glColor3f(1.f,1.f,1.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight);

			gl.glColor3f(1.f,1.f,1.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 4.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight);

			gl.glColor3f(1.f,1.f,0.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
			gl.glVertex3f( offset+x2*stepX-lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY+lenY, height*normalizeHeight + 5.f);
			gl.glVertex3f( offset+x2*stepX+lenX, offset+y2*stepY-lenY, height*normalizeHeight + 5.f);
			*/

		//diplay a COOO, OOOOOW


			// Face A

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);


				//Face B


			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 0 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);


				//Avant

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);


				//Arrière


			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 3.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 2.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);


				//Interieur pate avant gauche


			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);


				//Interieur pate avant droite


			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(0.f, 0.f, 0f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 0.f);


				//Interieur pate arriere gauche


			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);


				//Interieur pate avant droite


			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 2.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 0.f);

			gl.glColor3f(1.f, 1.f, 1f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 0.f);


				//Dessus

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 1.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1 * lenY, height * normalizeHeight + 4.f);


			//Tête


			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);

			gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);

		gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX + 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX + 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);

		gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX - 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX - 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);

		gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX - 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);

		gl.glColor3f(1.f, 1.f, 1.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 4.f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2 * lenY, height * normalizeHeight + 5.f);


			//Yeux


		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX + 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX + 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.1f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX - 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.8f);
		gl.glVertex3f( offset + x2 * stepX - 0.3f * lenX, offset + y2 * stepY + 3 * lenY, height * normalizeHeight + 4.4f);


			//Oreilles


		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX - 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 4.6f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 4.6f);

		gl.glColor3f(0.f, 0.f, 0.f);
			gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.6f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);
		gl.glVertex3f( offset + x2 * stepX + 0.7f * lenX, offset + y2 * stepY + 2.8f * lenY, height * normalizeHeight + 5.4f);

	}
}
