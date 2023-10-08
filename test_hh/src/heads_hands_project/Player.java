public class Player extends Creature{
    int healing_amount = 0;
    public void health_UP() {
        if (healing_amount >= 4) {
            System.out.println("Вы исцелили Игрока больше 4-х раз!");
        }
        else {
            setHealth(30);
            healing_amount++; }
    }
}
