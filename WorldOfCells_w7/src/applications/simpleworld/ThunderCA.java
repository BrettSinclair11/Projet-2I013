package applications.simpleworld;

import cellularautomata.CellularAutomataDouble;
import cellularautomata.CellularAutomataInteger;
import worlds.World;

public class ThunderCA extends CellularAutomataInteger{
	
	CellularAutomataDouble _cellsHeightValuesCA;
	
	World world;
	
	RainCA Rain;
	
	public ThunderCA ( World __world, int __dx , int __dy, CellularAutomataDouble cellsHeightValuesCA,RainCA cellularAutomata4)
	{
		super(__dx,__dy,true ); // buffering must be true.
		
		_cellsHeightValuesCA = cellsHeightValuesCA;
		
		this.world = __world;
		Rain=cellularAutomata4;
	}
	public void init()
	{
		for ( int x = 0 ; x != _dx ; x++ )
    		for ( int y = 0 ; y != _dy ; y++ )
    		{
    			this.setCellState(x, y, 0);
    		}
    	this.swapBuffer();
	}
	public void step()
	{
    	for ( int i = 0 ; i != _dx ; i++ )
    		for ( int j = 0 ; j != _dy ; j++ )
    		{
    			if(Math.random()<0.0001 && this.getCellState(i, j) == 0 && Rain.pluie) {
        			this.setCellState(i, j, 11);
    			}else{
    				if(this.getCellState(i, j)==11) {
    					this.setCellState(i, j, 12);
    				}else {
    					this.setCellState(i, j, 0);
    				}
    			}
    				float color[] = world.getCellColorValue(i, j);
    				switch ( this.getCellState(i, j) )
    				{
    					case 0:
    						break;
    					case 11:
    						color[0] = 1.f;
    						color[1] = 1.f;
    						color[2] = 0.f;
    						break;
    					case 12:
    						color[0] = 0.3f;
    						color[1] = 0.3f;
    						color[2] = 0.3f;
    						break;
    					default:
    						color[0] = 0.5f;
    						color[1] = 0.5f;
    						color[2] = 0.5f;
    						System.out.print("cannot interpret CA state: " + this.getCellState(i, j));
    						System.out.println(" (at: " + i + "," + j + " -- height: " + this.world.getCellHeight(i,j) + " )");
    				}
    				this.world.cellsColorValues.setCellState(i, j, color);
    		}
    	this.swapBuffer();
	}
}