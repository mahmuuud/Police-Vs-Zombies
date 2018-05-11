package Entities;

public class bulletZombieCollisionDetector {
    zombie zombie;
    Bullet bullet;

    public bulletZombieCollisionDetector(zombie zombie,Bullet bullet){
        this.bullet=bullet;
        this.zombie=zombie;
    }

    public boolean isCollided(){
        if(bullet.getBounds().intersects(zombie.getBounds())){

            return true;

        }
        return false;
    }
}
