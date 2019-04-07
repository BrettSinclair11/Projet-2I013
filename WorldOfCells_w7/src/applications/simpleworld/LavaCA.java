package applications.simpleworld;

import cellularautomata.CellularAutomataDouble;
import cellularautomata.CellularAutomataInteger;
import worlds.World;

public class LavaCA extends CellularAutomataInteger{
	
	CellularAutomataDouble _cellsHeightValuesCA;
	
	World world;
	
	EauCA Eau;
	RainCA Rain;
	
	boolean erruption;
	
	public LavaCA ( World __world, int __dx , int __dy, CellularAutomataDouble cellsHeightValuesCA,EauCA cellularAutomata3,RainCA cellularAutomata4 )
	{
		super(__dx,__dy,true ); // buffering must be true.
		
		_cellsHeightValuesCA = cellsHeightValuesCA;
		
		this.world = __world;
		Eau=cellularAutomata3;
		Rain=cellularAutomata4;
		erruption=true;
	}
	public void init()
	{
		double max=0;
		for ( int x = 0 ; x != _dx ; x++ )
    		for ( int y = 0 ; y != _dy ; y++ )
    		{
    			if(world.getCellHeight(x,y)>max) {
    				max=world.getCellHeight(x,y);
    			}
    		}
		for ( int x = 0 ; x != _dx ; x++ )
    		for ( int y = 0 ; y != _dy ; y++ )
    		{
    			if ( _cellsHeightValuesCA.getCellState(x,y) >= 0 )
    			{
    				if ( world.getCellHeight(x,y) == max )
    				{
    					if(Eau.getCellState(x, y) != -1) {
    						this.setCellState(x, y, 7);
    					}else {
        					this.setCellState(x, y, 8);
    					}
    				}else
    				{
    					this.setCellState(x, y, 0);
    				}
    			}
    			else
    			{
    				this.setCellState(x, y, -1); // water (ignore)
    			}
    		}
		if( Math.random()<0.025) {
			erruption=true;
		}
    	this.swapBuffer();
	}
	public void step()
	{
		if (erruption) {
    	for ( int i = 0 ; i != _dx ; i++ )
    		for ( int j = 0 ; j != _dy ; j++ )
    		{
    			if(Eau.getCellState(i, j) != -1) {
    				if ( this.getCellState(i, j) >= 0 )
    				{
    					if (
   							(this.getCellState( (i+_dx-1)%(_dx) , j ) == 7 &&
    						world.getCellHeight( (i+_dx-1)%(_dx) , j ) > world.getCellHeight(i, j)) ||
    						(this.getCellState( (i+_dx+1)%(_dx) , j ) == 7  &&
    						world.getCellHeight( (i+_dx+1)%(_dx) , j ) > world.getCellHeight(i, j)) ||
    						(this.getCellState( i , (j+_dy+1)%(_dy) ) == 7 &&
    						world.getCellHeight( i , (j+_dy+1)%(_dy) ) > world.getCellHeight(i, j)) ||
    						(this.getCellState( i , (j+_dy-1)%(_dy) ) == 7 &&
	    					world.getCellHeight( i , (j+_dy-1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx-1)%(_dx) , (j+_dy-1)%(_dy) ) == 7 &&
	    					world.getCellHeight( (i+_dx-1)%(_dx) , (j+_dy-1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx-1)%(_dx) , (j+_dy+1)%(_dy) ) == 7 &&
	    					world.getCellHeight( (i+_dx-1)%(_dx) , (j+_dy+1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx+1)%(_dx) , (j+_dy-1)%(_dy) ) == 7 &&
	    					world.getCellHeight( (i+_dx+1)%(_dx) , (j+_dy-1)%(_dy) ) > world.getCellHeight(i, j)) ||
	    					(this.getCellState( (i+_dx+1)%(_dx) , (j+_dy+1)%(_dy) ) == 7 &&
	    					world.getCellHeight( (i+_dx+1)%(_dx) , (j+_dy+1)%(_dy) ) > world.getCellHeight(i, j)))
    					{
    						if (Rain.pluie ||
    							Eau.getCellState( (i+_dx-1)%(_dx) , j ) == -1 ||
    							Eau.getCellState( (i+_dx+1)%(_dx) , j ) == -1 ||
    							Eau.getCellState( i , (j+_dy+1)%(_dy) ) == -1 ||
    							Eau.getCellState( i , (j+_dy-1)%(_dy) ) == -1 ||
    							Eau.getCellState( (i+_dx-1)%(_dx) , (j+_dy-1)%(_dy) ) == -1 ||
    							Eau.getCellState( (i+_dx-1)%(_dx) , (j+_dy+1)%(_dy) ) == -1 ||
    							Eau.getCellState( (i+_dx+1)%(_dx) , (j+_dy-1)%(_dy) ) == -1 ||
    							Eau.getCellState( (i+_dx+1)%(_dx) , (j+_dy+1)%(_dy) ) == -1)
            				{
        						this.setCellState(i, j, 8);
            				}else {
            					
            					this.setCellState(i, j,7);
            				}
    					}else
    					{
    						this.setCellState(i,j, this.getCellState(i,j) );
    					}
    					float color[] = world.getCellColorValue(i, j);
    					switch ( this.getCellState(i, j) )
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
    					float height =(float)world.getCellHeight(i, j);
    					switch ( Eau.getCellState(i, j) )
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

    		}
    	this.swapBuffer();
		}
		if( Math.random()<0.025) {
			erruption=true;
		}
	}
}
