// ### WORLD OF CELLS ###
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import java.util.ArrayList;

import javax.media.opengl.GL2;

import objects.UniqueDynamicObject;

import worlds.World;

public abstract class Agent extends UniqueDynamicObject{
	
	protected String ID;
	
	protected int HP, SpotRange, FoodRange, WaterRange, TotalFood, TotalWater, Food, Water, Stamina;
	
	protected int [] position = this.getCoordinate();
	
	protected float Direction;
	
	protected ArrayList<Agent> Predators;
	
	protected ArrayList<Agent> Preys;
	
	public Agent(int __x , int __y, World __world) {
		
		super(__x,__y,__world);
	}

	public void step() {
		
		if (this.isPrey(position) != null) this.Eat();
		
		else if (this.CanDrink()) Drink();
			
		boolean modified = false;

		if 		(this.Water / TotalWater 	<= 0.5) modified = this.FindWater() || modified;
		else if (this.Food / this.TotalFood <= 0.5) modified = this.FindFood()  || modified;

		modified = this.AvoidDanger() || modified;

		this.Move(modified);
	}
	
	public void Move(boolean modified) {

		float TempDirection = this.Direction;

		if (!modified) {

			float r = (float) Math.random();

			if (r < 0.3) TempDirection = (TempDirection - 0.25f) % 1.f;
			if (r > 0.6) TempDirection = (TempDirection + 0.25f) % 1.f;
		}

		if (TempDirection == 0.f) 	this.y += 1;
		if (TempDirection == 0.25f) this.x += 1;
		if (TempDirection == 0.5f) 	this.y -= 1;
		if (TempDirection == 0.75f) this.x -= 1;
	}

	public boolean AvoidDanger() {

		float InitialDirection = this.Direction;
		boolean modified = false;

		for(int i = this.x - this.SpotRange; i <= this.x + this.SpotRange; i ++) {
			for(int j = this.y - this.SpotRange; j <= this.y + this.SpotRange; j ++) {
				
				if (this.Direction == (InitialDirection - 0.25f) % 1.f) break;

				if (	 (this.Direction == 0.f 	 && j >= this.y)
						|| (this.Direction == 0.25f  && i >= this.x)
						|| (this.Direction == 0.5f 	 && j <= this.x)
						|| (this.Direction == 0.75f  && i <= this.x)) {

					if ((super.world.getCellValue(i, j) == 7 || super.world.getCellValue(i , j) == 2 && Math.abs(i) + Math.abs(j) <= this.SpotRange)
					 || (this.isPredator(position) != null && Math.abs(i) + Math.abs(j) <= this.SpotRange * 3 / 4)) {

						this.Direction = (this.Direction + 0.25f) % 1.f;
						modified = true;
					}
				}
			}
		}
		return modified;
	}

	public abstract boolean FindFood();

	public boolean FindWater() {

		int minDistance = this.WaterRange;
		boolean modified = false;
		
		for(int i = this.x - this.WaterRange; i <= this.x + this.WaterRange; i ++) {
			for(int j = this.y - this.WaterRange; j <= this.y + this.WaterRange; j ++) {

				if (super.world.getCellValue(i, j) == -1 && Math.abs(i) + Math.abs(j) < minDistance) {

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
	
	public boolean CanDrink() {
		
		if (   super.world.getCellValue3(x + 1, y	 ) == -1
			|| super.world.getCellValue3(x - 1, y	 ) == -1
			|| super.world.getCellValue3(x	  , y + 1) == -1
			|| super.world.getCellValue3(x	  , y - 1) == -1)
			
			return true;
		
		return false;
	}
	
	public void Drink() {
		
		Water += 10;
		if (Water > TotalWater) Water = TotalWater;
	}
	
	public void Eat() {
		
		if (ID == "COW" && super.world.getCellValue1(x, y) == 4) {
			
			Food += 10;
			super.world.setCellValue1(x, y, 0);
		
		}else if (ID == "Raptor") {
			
			Food +=15;
			isPrey(position).Bleed(15);
		
		}else {
			
			if(isPrey(position).ID== "COW" ) {
				
				Food += 150;
				isPrey(position).Bleed(150);
			
			}else {
				
				Food += 100;
				isPrey(position).Bleed(100);
			}	
		}
		if (Food > TotalFood) Food = TotalFood;
	}
	
	public void Bleed(int i) {
		
		HP -= i;
		if (HP <= 0) super.world.getUniqueDynamicObjects().remove(this);
	}
	
	public ArrayList<Agent> getPredators(String name) {
		
		ArrayList<Agent> Predators = new ArrayList<Agent>();
		
		for(UniqueDynamicObject agent : super.world.getUniqueDynamicObjects()) {
			
			if (name == "COW") {
				
				if (!(agent instanceof Cow)) Predators.add((Agent) agent);
			}
			else if (name == "Raptor") {
				
				if (agent instanceof TRex) Predators.add((Agent) agent);
			
			}else {
				
				if (agent instanceof TRex) Predators.add((Agent) agent);
			}
		}
		return Predators;
	}
	
	public ArrayList<Agent> getPreys(String name) {
		
		ArrayList<Agent> Preys = new ArrayList<Agent>();
		
		for(UniqueDynamicObject agent : super.world.getUniqueDynamicObjects()) {
			
			if (name == "Raptor")
				if (agent instanceof Cow) Preys.add((Agent) agent);
			
			else if (name == "TRex") Preys.add((Agent) agent);
		}
		return Preys;
	}
	
	public Agent isPredator(int[] position) {
		
		for(Agent agent: this.Predators)
			if (agent.position == position) return agent;
			
		return null;
	}
	
	public Agent isPrey(int[] position) {
		
		for(Agent agent: this.Preys)
			if (agent.position == position) return agent;
			
		return null;
	}

	public abstract void displayUniqueObject(World myWorld, GL2 gl, int offsetCA_x,
		int offsetCA_y, float offset, float stepX, float stepY, float lenX, float lenY, float normalizeHeight);
	}
