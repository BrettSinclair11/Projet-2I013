// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package applications.simpleworld;

import javax.media.opengl.GL2;

import objects.*;
import worlds.World;

public class WorldOfTrees extends World {

    protected ForestCA cellularAutomata;
    
    protected GrassCA cellularAutomata1;

    protected LavaCA cellularAutomata2;
    
    protected EauCA cellularAutomata3;
    
    protected RainCA cellularAutomata4;
    
    protected ThunderCA cellularAutomata5;
    
    protected Climat cellularAutomata6;

    public void init ( int __dxCA, int __dyCA, double[][] landscape )
    {
    	super.init(__dxCA, __dyCA, landscape);
    	
    	// add colors
    	
    	for ( int x = 0 ; x < __dxCA ; x++ )
    		for ( int y = 0 ; y < __dyCA ; y++ )
    		{
	        	float color[] = new float[3];

	        	float height = (float) this.getCellHeight(x, y);
		    	
		        if ( height >= 0 )
		        {
		        	// snowy mountains
		        	/**/
		        	color[0] = height / (float)this.getMaxEverHeight();
					color[1] = height / (float)this.getMaxEverHeight();
					color[2] = height / (float)this.getMaxEverHeight();
					/**/
		        	
					// green mountains
		        	/*
		        	color[0] = height / ( (float)this.getMaxEverHeight() );
					color[1] = 0.9f + 0.1f * height / ( (float)this.getMaxEverHeight() );
					color[2] = height / ( (float)this.getMaxEverHeight() );
					/**/
		        }
		        else
		        {
		        	// water
					color[0] = -height;
					color[1] = -height;
					color[2] = 1.f;
		        }
		        this.cellsColorValues.setCellState(x, y, color);
    		}
    	
    	// add some objects
    	for ( int i = 0 ; i < 11 ; i++ )
    	{
    		if ( i%10 == 0 )
    			uniqueObjects.add(new Monolith(110,110+i,this));
    		else
    			uniqueObjects.add(new BridgeBlock(110,110+i,this));
    	}
    	
    	uniqueDynamicObjects.add(new Cow(64,64,this));
    	
    }
    
    protected void initCellularAutomata(int __dxCA, int __dyCA, double[][] landscape)
    {
    	cellularAutomata4 = new RainCA(this,__dxCA,__dyCA,cellsHeightValuesCA);
    	cellularAutomata4.init();
    	cellularAutomata6 = new Climat(this,__dxCA,__dyCA,cellsHeightValuesCA,cellularAutomata4);
    	cellularAutomata6.init();
    	cellularAutomata3 = new EauCA(this,__dxCA,__dyCA,cellsHeightValuesCA);
    	cellularAutomata3.init();
    	cellularAutomata2 = new LavaCA(this,__dxCA,__dyCA,cellsHeightValuesCA,cellularAutomata3,cellularAutomata4);
    	cellularAutomata2.init();
    	cellularAutomata5 = new ThunderCA(this,__dxCA,__dyCA,cellsHeightValuesCA,cellularAutomata4);
    	cellularAutomata5.init();
    	cellularAutomata = new ForestCA(this,__dxCA,__dyCA,cellsHeightValuesCA,cellularAutomata2,cellularAutomata4,cellularAutomata5);
    	cellularAutomata.init();
    	cellularAutomata1 = new GrassCA(this,__dxCA,__dyCA,cellsHeightValuesCA,cellularAutomata,cellularAutomata2,cellularAutomata4,cellularAutomata5);
    	cellularAutomata1.init();
    }
    
    protected void stepCellularAutomata()
    {
    	if ( iteration%20 == 0 )
    		cellularAutomata.step();
    	if ( iteration%20 == 0 )
    		cellularAutomata1.step();
    	if ( iteration%20 == 0 )
    		cellularAutomata2.step();
    	if ( iteration%20 == 0 )
    		cellularAutomata3.step();
    	if ( iteration%20 == 0 )
    		cellularAutomata4.step();
    	if ( iteration%20 == 0 )
    		cellularAutomata5.step();
    	if ( iteration%20 == 0 )
    		cellularAutomata6.step(iteration%20);
    }
    
    protected void stepAgents()
    {
    	// nothing to do.
    	for ( int i = 0 ; i < this.uniqueDynamicObjects.size() ; i++ )
    	{
    		this.uniqueDynamicObjects.get(i).step();
    	}
    }

    public int getCellValue(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata.getCellState(x%dxCA,y%dyCA);
    }
    
    public int getCellValue1(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata1.getCellState(x%dxCA,y%dyCA);
    }
    
    public int getCellValue2(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata2.getCellState(x%dxCA,y%dyCA);
    }
    public int getCellValue3(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata3.getCellState(x%dxCA,y%dyCA);
    }
    public int getCellValue4(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata4.getCellState(x%dxCA,y%dyCA);
    }
    public int getCellValue5(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata5.getCellState(x%dxCA,y%dyCA);
    }
    public int getCellValue6(int x, int y) // used by the visualization code to call specific object display.
    {
    	return cellularAutomata6.getCellState(x%dxCA,y%dyCA);
    }

    public void setCellValue(int x, int y, int state)
    {
    	if(cellularAutomata3.getCellState(x%dxCA, y%dyCA)==2) {
    		state=cellularAutomata3.getCellState(x%dxCA, y%dyCA);
    	}
    	cellularAutomata.setCellState( x%dxCA, y%dyCA, state);
    }
    
    public void setCellValue1(int x, int y, int state)
    {
    	cellularAutomata1.setCellState( x%dxCA, y%dyCA, state);
    }
    
    public void setCellValue2(int x, int y, int state)
    {
    	cellularAutomata2.setCellState( x%dxCA, y%dyCA, state);
    }
    public void setCellValue3(int x, int y, int state)
    {
    	cellularAutomata3.setCellState( x%dxCA, y%dyCA, state);
    }
    public void setCellValue4(int x, int y, int state)
    {
    	cellularAutomata4.setCellState( x%dxCA, y%dyCA, state);
    }
    public void setCellValue5(int x, int y, int state)
    {
    	cellularAutomata5.setCellState( x%dxCA, y%dyCA, state);
    }
    public void setCellValue6(int x, int y, int state)
    {
    	cellularAutomata6.setCellState( x%dxCA, y%dyCA, state);
    }
    
	public void displayObjectAt(World _myWorld, GL2 gl, int cellState, int x,
			int y, double height, float offset,
			float stepX, float stepY, float lenX, float lenY,
			float normalizeHeight) 
	{
		switch ( cellState )
		{
		case 1: // trees: green, fire, burnt
		case 2:
		case 3:
			Tree.displayObjectAt(_myWorld,gl,cellState, x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);
		case 4:
		case 5:
		case 6:
			Grass.displayObjectAt(_myWorld,gl,cellState, x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);	
		case 7:
		case 8:
		case 9:
		case 10:
			Rain.displayObjectAt(_myWorld,gl,cellState, x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);
		case 11:
			Thunder.displayObjectAt(_myWorld,gl,cellState, x, y, height, offset, stepX, stepY, lenX, lenY, normalizeHeight);
		default:
			// nothing to display at this location.
		}
	}

	//public void displayObject(World _myWorld, GL2 gl, float offset,float stepX, float stepY, float lenX, float lenY, float heightFactor, double heightBooster) { ... } 
    
   
}