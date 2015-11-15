package tank;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

import wingman.game.BackgroundObject;
import wingman.game.GameObject;

public class BreakableWall extends BackgroundObject {
	int timer = 400;
	
	public BreakableWall(int x, int y){
		super(new Point(x*32, y*32), new Point(0,0), TankWorld.sprites.get("wall2"));
	}
 //You need to fill in here  	
    public boolean collision(GameObject otherObject) {
    	if(location.intersects(otherObject.getLocation())){ 
         	if(otherObject instanceof TankBullet) 
         		show = false; 
         	return true; 
         }  
        return false;
    }
  //You need to fill in here     
    public void draw(Graphics g, ImageObserver obs) {
    	if(show) 
     		super.draw(g, obs); 
     	else { 
     		timer--; 
     		if(timer == 0){ 
     			timer = 400; 
     			show = true; 
     		} 
     	} 
    }
}
