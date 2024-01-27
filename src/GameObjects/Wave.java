package GameObjects;
import TexturesAndImages.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Wave {
    private House house;
    private ArrayList<Enemy> enemies;
    private int initial_amount;
    private int alive_enemies;
    public boolean isFinished() {
        return alive_enemies == 0;
    }
    public int getAlive_enemies() {
        return alive_enemies;
    }
    public Wave(int amount, House house) {
        this.house = house;
        this.initial_amount = amount;
        this.enemies = new ArrayList<>();
        this.alive_enemies = initial_amount;
        create();
    }
    public Enemy getEnemyByIndex(int index){
        return enemies.get(index);
    }
    private EnemyType randomEnemy(){
        return EnemyType.values()[new Random().nextInt(EnemyType.values().length)];
    }
    public void create() {
        Random random = new Random();
        for(int a = 0; a < initial_amount; a++){
            int x = random.nextInt(700, 1000);
            int y = random.nextInt(400, 500);
            switch(randomEnemy()){
                case Bandit -> enemies.add(new Bandit(x,y,Constants.getGeneral_character_sizeX(),Constants.getGeneral_character_sizeY(), house));
                case Villager -> enemies.add(new Villager(x,y,Constants.getGeneral_character_sizeX(),Constants.getGeneral_character_sizeY(), house));
            }
            enemies.get(a).initializeHitbox(-60,40,74,80);
        }
    }
    public void render(Graphics graphics){
        for (Enemy enemy: enemies){
            enemy.renderIt(graphics);
        }
    }
    public void checkForDeadEnemies() {
        for (int b = 0; b < enemies.size(); b++){
            if(enemies.get(b).isDead() && enemies.get(b).playDeathAnimation()){
                enemies.remove(b);
                alive_enemies--;
            }
        }
    }
    public void updateIt(boolean hit, Rectangle playerHitbox, int damage){
        checkForDeadEnemies();
        for (Enemy enemy: enemies){
            enemy.checkForHitFromAttacker(hit, damage, playerHitbox);
            enemy.attackManage(playerHitbox);
            enemy.updateHitbox();
            enemy.updateIt();
        }
    }
}
