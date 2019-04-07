package applications.simpleworld;

import cellularautomata.CellularAutomataDouble;
import cellularautomata.CellularAutomataInteger;
import worlds.World;

public class EauCA extends CellularAutomataInteger{
	CellularAutomataDouble _cellsHeightValuesCA;
	
	World world;
	public EauCA ( World __world, int __dx , int __dy, CellularAutomataDouble cellsHeightValuesCA )
	{
		super(__dx,__dy,true ); // buffering must be true.
		
		_cellsHeightValuesCA = cellsHeightValuesCA;
		
		this.world = __world;
	}
	public void init()
	{
		for ( int x = 0 ; x != _dx ; x++ )
    		for ( int y = 0 ; y != _dy ; y++ )
    		{
    			if ( _cellsHeightValuesCA.getCellState(x,y) >= 0 )
    			{
    					if(world.getCellHeight(x, y)>0.05 && Math.random()<0.001){
    						this.setCellState(x, y, -1);
    					}else {
    						this.setCellState(x, y, 0);
    					}
    			}
    			else
    			{
    				this.setCellState(x, y, -1); // water (ignore)
    			}
    		}
    	this.swapBuffer();
	}
	public void step()
	{
    	for ( int i = 0 ; i != _dx ; i++ )
    		for ( int j = 0 ; j != _dy ; j++ )
    		{
    			if ( this.getCellState(i, j) <= 0)
    			{
    				if((this.getCellState( (i+_dx-1)%(_dx) , j ) == -1 &&
	    	    			world.getCellHeight( (i+_dx-1)%(_dx) , j ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx+1)%(_dx) , j ) == -1  &&
	    					world.getCellHeight( (i+_dx+1)%(_dx) , j ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( i , (j+_dy+1)%(_dy) ) == -1 &&
	    					world.getCellHeight( i , (j+_dy+1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( i , (j+_dy-1)%(_dy) ) == -1 &&
	    					world.getCellHeight( i , (j+_dy-1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx-1)%(_dx) , (j+_dy-1)%(_dy) ) == -1 &&
	    					world.getCellHeight( (i+_dx-1)%(_dx) , (j+_dy-1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx-1)%(_dx) , (j+_dy+1)%(_dy) ) == -1 &&
	    					world.getCellHeight( (i+_dx-1)%(_dx) , (j+_dy+1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx+1)%(_dx) , (j+_dy-1)%(_dy) ) == -1 &&
	    					world.getCellHeight( (i+_dx+1)%(_dx) , (j+_dy-1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx+1)%(_dx) , (j+_dy+1)%(_dy) ) == -1 &&
	    					world.getCellHeight( (i+_dx+1)%(_dx) , (j+_dy+1)%(_dy) ) > world.getCellHeight(i, j))) {
    					this.setCellState(i, j,-1);
    				}else
	    			{
						this.setCellState(i,j, this.getCellState(i,j) );
	   				}
    				
    				float height =(float)world.getCellHeight(i, j);
	    			float color[] = world.getCellColorValue(i, j); 
	    			switch ( this.getCellState(i, j) )
	    			{
	    				case 0:
	    					break;
	    				case -1:
	    					color[0] = (-height);
	    					color[1] = (height)*0.3f;
	    					color[2] = 1.0f;
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
    		}
    	this.swapBuffer();
	}
}
