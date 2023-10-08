import java.util.Random;

public abstract class Creature {
    private int attack;
    private int protection;
    private int health = 100;
    private int[] damage;


    public void setHealth(int health) {
        this.health += health;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


    public int getAttack() {
        return attack;
    }


    public void setProtection(int protection) {
        this.protection = protection;
    }


    public int getProtection() {
        return protection;
    }


    public void setDamage(int M, int N) {
        if (M > N) {
            int a = M;
            M = N;
            N = a;
        }
        damage = new int[N];
        for (int i = 0; i < N; i++) {
            this.damage[i] = M;
            M++;
        }
    }

    public int[] getDamage() {
        return damage;
    }

    public int getDamage(int i) {
        return damage[i];
    }


    public void kick(Creature attacking, Creature defending){
        int k = 0;
        int attack_modifier = attacking.getAttack() - defending.getProtection() + 1;
        while (k < attack_modifier) {
            int digit = new Random().nextInt(1, 7);
            if (digit == 5 || digit == 6) {
                defending.health -= attacking.getDamage(new Random().nextInt(attacking.getDamage().length));
            }
            k++;
        }
    }

}
