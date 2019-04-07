// ### WORLD OF CELLS ###
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import javax.media.opengl.GL2;

import objects.UniqueDynamicObject;

import worlds.World;

public class Raptor extends Agent {

	public Raptor ( int __x , int __y, World __world ) {

		super(__x,__y,__world);
		ID 		   = "Raptor";
		HP 		   = 100;
		SpotRange  = 10;
		FoodRange  = 10;
		WaterRange = 10;
		TotalFood  = 100;
		Food 	   = 100;
		TotalWater = 80;
		Water 	   = 80;
		Stamina    = 100;
		Predators  = this.getPredators(ID);
		Preys	   = this.getPreys(ID);
	}
	
	public boolean FindFood() {

		int minDistance = this.FoodRange;
		boolean modified = false;

		for(int i = this.x - this.FoodRange; i <= this.x + this.FoodRange; i ++) {
			for(int j = this.y - this.FoodRange; j <= this.y + this.FoodRange; j ++) {
				
				if (this.isPredator(position) != null && Math.abs(i) + Math.abs(j) < minDistance) {

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


				//Display a TORRAP


			//Queue


		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 5.f * lenX, offset + y2 * stepY + 0.f * lenY, height * normalizeHeight + 1.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 5.f * lenX, offset + y2 * stepY + 0.f * lenY, height * normalizeHeight + 1.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX - 5.f * lenX, offset + y2 * stepY + 0.f * lenY, height * normalizeHeight + 1.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 5.f * lenX, offset + y2 * stepY + 0.f * lenY, height * normalizeHeight + 1.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.f);


			//Corps arriere

		//Dessous
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.375f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.375f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.375f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.375f);

		//Dessus
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.875f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.875f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.875f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.875f);

		//lateral droit
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		//lateral gauche
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.5f);


			//Pattes

		//Droite

		//Cuisse
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1.f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1.f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1.f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 1.f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.25f * lenY, height * normalizeHeight + 3.125f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 3.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.125f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);

		//Jambe
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 0.25f);

		//Gauche

		//Cuisse
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1.f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1.f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1.f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 1.f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.25f * lenY, height * normalizeHeight + 3.125f);
		gl.glVertex3f( offset + x2 * stepX - 1.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 3.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.125f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 3.5f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);

		//Jambe
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.75f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 0.25f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX + 0.5f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 2.f);
		gl.glVertex3f( offset + x2 * stepX - 0.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 0.25f);


			//Tits bras

		//Droit

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.32f * lenX, offset + y2 * stepY + 0.65f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.56f * lenX, offset + y2 * stepY + 0.6f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 2.32f * lenX, offset + y2 * stepY + 0.6f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.08f * lenX, offset + y2 * stepY + 0.65f * lenY, height * normalizeHeight + 2.42f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.37f * lenX, offset + y2 * stepY + 0.9f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.61f * lenX, offset + y2 * stepY + 0.85f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 2.37f * lenX, offset + y2 * stepY + 0.85f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.13f * lenX, offset + y2 * stepY + 0.9f * lenY, height * normalizeHeight + 2.42f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.61f * lenX, offset + y2 * stepY + 0.85f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 1.56f * lenX, offset + y2 * stepY + 0.6f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 2.32f * lenX, offset + y2 * stepY + 0.6f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.37f * lenX, offset + y2 * stepY + 0.85f * lenY, height * normalizeHeight + 2.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.32f * lenX, offset + y2 * stepY + 0.65f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.37f * lenX, offset + y2 * stepY + 0.9f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 2.13f * lenX, offset + y2 * stepY + 0.9f * lenY, height * normalizeHeight + 2.42f);
		gl.glVertex3f( offset + x2 * stepX + 2.08f * lenX, offset + y2 * stepY + 0.65f * lenY, height * normalizeHeight + 2.42f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.32f * lenX, offset + y2 * stepY + 0.65f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.56f * lenX, offset + y2 * stepY + 0.6f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 1.61f * lenX, offset + y2 * stepY + 0.85f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 1.37f * lenX, offset + y2 * stepY + 0.9f * lenY, height * normalizeHeight + 4.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.08f * lenX, offset + y2 * stepY + 0.65f * lenY, height * normalizeHeight + 2.42f);
		gl.glVertex3f( offset + x2 * stepX + 2.32f * lenX, offset + y2 * stepY + 0.6f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.37f * lenX, offset + y2 * stepY + 0.85f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.13f * lenX, offset + y2 * stepY + 0.9f * lenY, height * normalizeHeight + 2.42f);

		//Gauche

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.32f * lenX, offset + y2 * stepY - 0.65f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.56f * lenX, offset + y2 * stepY - 0.6f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 2.32f * lenX, offset + y2 * stepY - 0.6f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.08f * lenX, offset + y2 * stepY - 0.65f * lenY, height * normalizeHeight + 2.42f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.37f * lenX, offset + y2 * stepY - 0.9f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.61f * lenX, offset + y2 * stepY - 0.85f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 2.37f * lenX, offset + y2 * stepY - 0.85f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.13f * lenX, offset + y2 * stepY - 0.9f * lenY, height * normalizeHeight + 2.42f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.61f * lenX, offset + y2 * stepY - 0.85f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 1.56f * lenX, offset + y2 * stepY - 0.6f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 2.32f * lenX, offset + y2 * stepY - 0.6f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.37f * lenX, offset + y2 * stepY - 0.85f * lenY, height * normalizeHeight + 2.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.32f * lenX, offset + y2 * stepY - 0.65f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.37f * lenX, offset + y2 * stepY - 0.9f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 2.13f * lenX, offset + y2 * stepY - 0.9f * lenY, height * normalizeHeight + 2.42f);
		gl.glVertex3f( offset + x2 * stepX + 2.08f * lenX, offset + y2 * stepY - 0.65f * lenY, height * normalizeHeight + 2.42f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 1.32f * lenX, offset + y2 * stepY - 0.65f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 1.56f * lenX, offset + y2 * stepY - 0.6f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 1.61f * lenX, offset + y2 * stepY - 0.85f * lenY, height * normalizeHeight + 4.08f);
		gl.glVertex3f( offset + x2 * stepX + 1.37f * lenX, offset + y2 * stepY - 0.9f * lenY, height * normalizeHeight + 4.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.08f * lenX, offset + y2 * stepY - 0.65f * lenY, height * normalizeHeight + 2.42f);
		gl.glVertex3f( offset + x2 * stepX + 2.32f * lenX, offset + y2 * stepY - 0.6f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.37f * lenX, offset + y2 * stepY - 0.85f * lenY, height * normalizeHeight + 2.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.13f * lenX, offset + y2 * stepY - 0.9f * lenY, height * normalizeHeight + 2.42f);


			//Cou

		//Dessus
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);

		//Dessous
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.f);

		//Gauche
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.f);

		//Droite
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.f);

			//Tête

		//Dessus
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);

		//Dessous
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		//Gauche

		//Visage
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.625f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.625f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.625f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.875f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.875f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);

		//Oeil
		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.5f);

		gl.glColor3f(0.f, 0.f, 0.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.375f);

		//Dents
		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.625f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.875f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);

		//Droite

		//Visage
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 2.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.625f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.625f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.625f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.875f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 3.875f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);

		//Oeil
		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.5f);

		gl.glColor3f(0.f, 0.f, 0.f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 3.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 3.125f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.625f);
		gl.glVertex3f( offset + x2 * stepX + 3.25f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.375f);

		//Dents
		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 3.5f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.625f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 3.75f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 3.875f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.625f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);


			//Museau

		//Dessus
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.25f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY + 0.25f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY + 0.125f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.125f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.125f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY - 0.125f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.12865f * lenX, offset + y2 * stepY - 0.25f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.25f * lenY, height * normalizeHeight + 5.5f);

		gl.glColor3f(0.f, 0.f, 0.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.25f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY - 0.25f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY - 0.125f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.125f * lenY, height * normalizeHeight + 5.5f);

		gl.glColor3f(0.f, 0.f, 0.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.25f * lenY, height * normalizeHeight + 5.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY + 0.25f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.18625f * lenX, offset + y2 * stepY + 0.125f * lenY, height * normalizeHeight + 5.375f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.125f * lenY, height * normalizeHeight + 5.5f);

		//Dessous
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);

		//Gauche
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.625f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.625f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY - 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY - 0.625f * lenY, height * normalizeHeight + 4.75f);

		//Droite
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.625f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.625f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.5f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(1.f, 1.f, 1.f);
		gl.glVertex3f( offset + x2 * stepX + 4.f * lenX, offset + y2 * stepY + 0.75f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.125f * lenX, offset + y2 * stepY + 0.625f * lenY, height * normalizeHeight + 4.75f);

		//Avant
		gl.glColor3f(91.f / 255.f, 60.f / 255.f, 17.f / 255.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 4.75f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.25f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 4.75f);

		gl.glColor3f(0.f, 0.f, 0.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY + 0.5f * lenY, height * normalizeHeight + 5.f);
		gl.glVertex3f( offset + x2 * stepX + 4.25f * lenX, offset + y2 * stepY - 0.5f * lenY, height * normalizeHeight + 5.f);
	}
}
