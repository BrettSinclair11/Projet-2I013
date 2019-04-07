// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import cellularautomata.CellularAutomataDouble;
import cellularautomata.CellularAutomataInteger;
import worlds.World;

public class ForestCA extends CellularAutomataInteger {

	CellularAutomataDouble _cellsHeightValuesCA;
	
	World world;
	
	LavaCA lave;
	RainCA Rain;
	ThunderCA thunder;
	
	public ForestCA ( World __world, int __dx , int __dy, CellularAutomataDouble cellsHeightValuesCA ,LavaCA cellularAutomata2,RainCA cellularAutomata4,ThunderCA cellularAutomata5)
	{
		super(__dx,__dy,true ); // buffering must be true.
		
		_cellsHeightValuesCA = cellsHeightValuesCA;
		
		this.world = __world;
		
		lave=cellularAutomata2;
		Rain=cellularAutomata4;
		thunder=cellularAutomata5;
	}
	
	public void init()
	{
		for ( int x = 0 ; x != _dx ; x++ )
    		for ( int y = 0 ; y != _dy ; y++ )
    		{
    			if ( _cellsHeightValuesCA.getCellState(x,y) >= 0 )
    			{
    				if ( Math.random() < 0.53 ) // was: 0.71
    					this.setCellState(x, y, 1); // tree
    				else
    					this.setCellState(x, y, 0); // empty
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
    			if ( this.getCellState(i, j) == 1 || this.getCellState(i, j) == 2 || this.getCellState(i, j) == 3 )
    			{
	    			if ( this.getCellState(i,j) == 1) // tree?
		    		{
		    			// check if neighbors are burning
		    			if ( 
		    					((this.getCellState( (i+_dx-1)%(_dx) , j ) == 2 ||
		    					this.getCellState( (i+_dx+1)%(_dx) , j ) == 2 ||
		    					this.getCellState( i , (j+_dy+1)%(_dy) ) == 2 ||
		    					this.getCellState( i , (j+_dy-1)%(_dy) ) == 2 ||
		    					lave.getCellState( i, j) == 7 ||
		    					lave.getCellState( (i+_dx-1)%(_dx) , j ) == 7 ||
		    	    			lave.getCellState( (i+_dx+1)%(_dx) , j ) == 7 ||
		    	   				lave.getCellState( i , (j+_dy+1)%(_dy) ) == 7 ||
		    	    			lave.getCellState( i , (j+_dy-1)%(_dy) ) == 7 ||
		    	    			lave.getCellState( (i+_dx-1)%(_dx) , (j+_dy-1)%(_dy) ) == 7 ||
		    	  				lave.getCellState( (i+_dx-1)%(_dx) , (j+_dy+1)%(_dy) ) == 7 ||
		    	  				lave.getCellState( (i+_dx+1)%(_dx) , (j+_dy-1)%(_dy) ) == 7 ||
		    	   				lave.getCellState( (i+_dx+1)%(_dx) , (j+_dy+1)%(_dy) ) == 7)
		    					&& !Rain.pluie) ||
		    					thunder.getCellState(i, j) == 11)
		    			{
		    				this.setCellState(i,j,2);
		    			}
		    			else
		    				if (Math.random() < 0.00001 && !Rain.pluie) // spontaneously take fire ?
		    				{
		    					this.setCellState(i,j,2);
		    				}
		    				else
		    				{
		    					this.setCellState(i,j,1); // copied unchanged
		    				}
		    		}else
	    			{
        				if ( this.getCellState( i , j ) == 2 ) // burning?
        				{
        					this.setCellState(i,j,3); // burnt
        				}
        				else
        				{
        					if ( Math.random() < 0.001 && lave.getCellState(i,j) != 7 && thunder.getCellState(i,j) != 11) {
        						this.setCellState(i, j, 1); // revive
        					} // copied unchanged
        					else {
        						this.setCellState(i,j,this.getCellState(i, j));
        					}
        				}
	    			}
	    			
	    			float color[] = world.getCellColorValue(i, j);
	    			switch ( this.getCellState(i, j) )
	    			{
	    				case 0:
	    					break;
	    				case 1:
	    					color[0] = 0.f;
	    					color[1] = 0.3f;
	    					color[2] = 0.f;
	    					break;
	    				case 2: // burning tree
	    					color[0] = 1.f;
	    					color[1] = 0.f;
	    					color[2] = 0.f;
	    					break;
	    				case 3: // burnt tree
	    					color[0] = 0.f;
	    					color[1] = 0.f;
	    					color[2] = 0.f;
	    					break;
	    				default:
	    					color[0] = 0.5f;
	    					color[1] = 0.5f;
	    					color[2] = 0.5f;
	    					System.out.print("cannot interpret CA state: " + this.getCellState(i, j));
	    					System.out.println(" (at: " + i + "," + j + " -- height: " + this.world.getCellHeight(i,j) + " )");
	    			}
	    			switch ( lave.getCellState(i, j) )
	    			{
	    				case 0:
	    					break;
	    				case 7:
	    					color[0] = 1.f;
	    					color[1] = 0.f;
	    					color[2] = 0.f;
	    					break;
	    				case 8:
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
    		}
    	this.swapBuffer();
	}

	
}