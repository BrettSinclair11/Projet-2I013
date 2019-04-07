package applications.simpleworld;

import cellularautomata.CellularAutomataDouble;
import cellularautomata.CellularAutomataInteger;
import worlds.World;

public class Climat extends CellularAutomataInteger{
	
	CellularAutomataDouble _cellsHeightValuesCA;
	
	World world;
	
	RainCA Rain;
	int temp;
	
	public Climat ( World __world, int __dx , int __dy, CellularAutomataDouble cellsHeightValuesCA,RainCA cellularAutomata5)
	{
		super(__dx,__dy,true ); // buffering must be true.
		
		_cellsHeightValuesCA = cellsHeightValuesCA;
		
		this.world = __world;
		Rain=cellularAutomata5;
		temp=1;
	}
	public void init()
	{
		if(Rain.pluie) {
			temp--;
		}
	}
	public void step(int iteration)
	{
		if(iteration<5) {
			temp=1;
		}else if(iteration<10) {
			temp=3;
		}else if(iteration<15) {
			temp=5;
		}else {
			temp=3;
		}
		if(Rain.pluie) {
			temp--;
		}
	}
}