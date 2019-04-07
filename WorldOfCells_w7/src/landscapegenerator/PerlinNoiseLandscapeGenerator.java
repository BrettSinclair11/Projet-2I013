// ### WORLD OF CELLS ### 
// created by nicolas.bredeche(at)upmc.fr
// date of creation: 2013-1-12

package landscapegenerator;


public class PerlinNoiseLandscapeGenerator {

    public static double[][] generatePerlinNoiseLandscape ( int dxView, int dyView, double scaling, double landscapeAltitudeRatio, int perlinLayerCount )
    {
    	double landscape[][] = new double[dxView][dyView];

    	// A ECRIRE ! 
    	// ...
    	//double h=1;
    	double e;
    	double p;
    	//double x2;
    	//double y2;
    	for ( int x = 0 ; x < dxView ; x++ ) {
    		for ( int y = 0 ; y < dyView ; y++ ) {
    			//x2 = (double)x/dxView-0.5;
    			//y2 = (double)y/dyView-0.5;
    			//e=ImprovedNoise.noise(y2,x2,h)+0.5*ImprovedNoise.noise(2*y2,2*x2,h)+0.13*ImprovedNoise.noise(8*y2,8*x2,h)+0.06*ImprovedNoise.noise(16*y2,16*x2,h)+0.03*ImprovedNoise.noise(32*y2,32*x2,h);
    			//e=ImprovedNoise.pnoise2d(y2,x2,dxView,dyView)+0.5*ImprovedNoise.pnoise2d(2*y2,2*x2,dxView,dyView)+0.13*ImprovedNoise.pnoise2d(8*y2,8*x2,dxView,dyView)+0.06*ImprovedNoise.pnoise2d(16*y2,16*x2,dxView,dyView)+0.03*ImprovedNoise.pnoise2d(32*y2,32*x2,dxView,dyView);
    			//e/=(1+0.5+0.25+0.13+0.06+0.03);
    			e=fBm(x*1/32.0,y*1/32.0,dxView*1/32.0,5,dxView,dyView,100);
    			p=Math.pow(e,2);
    			landscape[x][y] = perlinLayerCount*p;
    		}
    	}
    	/*for ( int x = dxView/2 ; x < dxView ; x++ ) { //quadrupler le quart et le bruiter
    		for ( int y = 0 ; y < dyView/2 ; y++ ) {
    			x2 = (double)x/dxView-0.5;
    			y2 = (double)y/dyView-0.5;
    			e=ImprovedNoise.noise(y2,x2,h)+0.5*ImprovedNoise.noise(2*y2,2*x2,h)+0.13*ImprovedNoise.noise(8*y2,8*x2,h)+0.06*ImprovedNoise.noise(16*y2,16*x2,h)+0.03*ImprovedNoise.noise(32*y2,32*x2,h);
    			e/=(1+0.5+0.25+0.13+0.06+0.03);
    			p=Math.pow(e,2);
    			landscape[x][y]=(landscape[dxView-x][y]);
    		}
    	}
    	for ( int x = 0 ; x < dxView/2 ; x++ ) {
    		for ( int y = dyView/2 ; y < dyView ; y++ ) {
    			x2 = (double)x/dxView-0.5;
    			y2 = (double)y/dyView-0.5;
    			e=ImprovedNoise.noise(y2,x2,h)+0.5*ImprovedNoise.noise(2*y2,2*x2,h)+0.13*ImprovedNoise.noise(8*y2,8*x2,h)+0.06*ImprovedNoise.noise(16*y2,16*x2,h)+0.03*ImprovedNoise.noise(32*y2,32*x2,h);
    			e/=(1+0.5+0.25+0.13+0.06+0.03);
    			p=Math.pow(e,2);
    			landscape[x][y]=(landscape[x][dyView-y]);
    		}
    	}
    	for ( int x = dxView/2 ; x < dxView ; x++ ) {
    		for ( int y = dyView/2 ; y < dyView ; y++ ) {
    			x2 = (double)x/dxView-0.5;
    			y2 = (double)y/dyView-0.5;
    			e=ImprovedNoise.noise(y2,x2,h)+0.5*ImprovedNoise.noise(2*y2,2*x2,h)+0.13*ImprovedNoise.noise(8*y2,8*x2,h)+0.06*ImprovedNoise.noise(16*y2,16*x2,h)+0.03*ImprovedNoise.noise(32*y2,32*x2,h);
    			e/=(1+0.5+0.25+0.13+0.06+0.03);
    			p=Math.pow(e,2);
    			landscape[x][y]=(landscape[dxView-x][dyView-y]);
    		}
    	}*/
    	// ...
    	// cf. http://freespace.virgin.net/hugo.elias/models/m_perlin.htm pour une explication


    	// scaling and polishing
    	landscape = LandscapeToolbox.scaleAndCenter(landscape, scaling, landscapeAltitudeRatio);
    	landscape = LandscapeToolbox.smoothLandscape(landscape);
    	
		return landscape;
    }
    
    public static double fBm(double x, double y,double per, double octs,int dx,int dy,int dz) {
    	double val=0;
    	for (int i=0;i<octs;i++) {
    		val+=Math.pow(0.5,i)*ImprovedNoise.pnoise(x*Math.pow(2, i),y*Math.pow(2, i),per*Math.pow(2, i),dx,dy,dz);
    	}
    	return val;
    }
}
