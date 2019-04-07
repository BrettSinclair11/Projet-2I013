package applications.simpleworld;

import cellularautomata.CellularAutomataDouble;
import cellularautomata.CellularAutomataInteger;
import worlds.World;

public class RainCA extends CellularAutomataInteger{
	
	CellularAutomataDouble _cellsHeightValuesCA;
	
	World world;
	
	boolean pluie;
	
	public RainCA ( World __world, int __dx , int __dy, CellularAutomataDouble cellsHeightValuesCA )
	{
		super(__dx,__dy,true ); // buffering must be true.
		
		_cellsHeightValuesCA = cellsHeightValuesCA;
		
		this.world = __world;
		pluie=false;
	}
	public void init()
	{
		for ( int x = 0 ; x != _dx ; x++ )
    		for ( int y = 0 ; y != _dy ; y++ )
    		{
    			if ( (x+y%2)==0 )
    			{
    				this.setCellState(x, y, 9);
    			}else {
    				this.setCellState(x, y, 10);
    			}
    		}
		if( Math.random()<0.025) {
			pluie=true;
		}
    	this.swapBuffer();
	}
	public void step()
	{
		if (pluie) {
			for ( int i = 0 ; i != _dx ; i++ )
				for ( int j = 0 ; j != _dy ; j++ )
				{
					if(this.getCellState(i, j)==9) {
						this.setCellState(i, j, 10);
					}else if(this.getCellState(i, j)==10) {
						this.setCellState(i, j, 9);
					}
					float color[] = world.getCellColorValue(i, j);
					switch ( this.getCellState(i, j) )
					{
					case 0:
						break;
					case 9:
						break;
					case 10:
						break;
					default:
						color[0] = 0.5f;
						color[1] = 0.5f;
						color[2] = 0.5f;
						System.out.print("cannot interpret CA state: " + this.getCellState(i, j));    							System.out.println(" (at: " + i + "," + j + " -- height: " + this.world.getCellHeight(i,j) + " )");
					}
				this.world.cellsColorValues.setCellState(i, j, color);
				}
		this.swapBuffer();
		}
		if( Math.random()<0.025) {
			pluie=!pluie;
		}
	}
}