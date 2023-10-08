
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        battle(creating_player(), creating_monster());
    }

    public static Player creating_player() {
        Player player = new Player();
        player.setAttack(new Random().nextInt(1, 30));
        player.setProtection(new Random().nextInt(1, 30));
        player.setDamage(new Random().nextInt(5) + 1, new Random().nextInt(5) + 1);
        return player;
    }


    public static Monster creating_monster() {
        Monster monster = new Monster();
        monster.setAttack(new Random().nextInt(1, 31));
        monster.setProtection(new Random().nextInt(1, 31));
        monster.setDamage(new Random().nextInt(1,10) , new Random().nextInt(1,10));
        return monster;
    }

    public static void battle(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в игру "Великая битва"
                Для того чтобы узнать характеристики героев напишите "qualities"\s
                Чтобы следить за ходом битвы нажимайте любую клавишу\s
                Во время игры вы можете до 4-х раз излечить Игрока, написав "healing"\s
                Для начала игры нажмите клавишу ENTER""");
        while (true) {
            String start_word = scanner.nextLine();
            if (start_word.equals("")) {
                System.out.println("Битва началась");
                while (player.getHealth() > 0 && monster.getHealth() > 0) {
                    player.kick(player, monster);
                    System.out.println("Игрок атакует, здоровье соперника:  " + monster.getHealth());
                    if (monster.getHealth() <= 0) {
                        System.out.println("Игрок победил. Игра окончена");
                        break;
                    }
                    String word = scanner.nextLine();
                    if (word.equals("healing") && player.getHealth() <= 70) {
                        player.health_UP();
                    }
                    monster.kick(monster, player);
                    System.out.println("Монстр атакует, здоровье соперника: " + player.getHealth());
                    if (player.getHealth() <= 0) {
                        System.out.println("Монстр победил. Игра окончена");
                        break;
                    }
                    String word_2 = scanner.nextLine();
                    if (word_2.equals("healing") && player.getHealth() <= 70) {
                        player.health_UP();
                    }
                }
                break;
            } else if (start_word.equals("qualities")) {
                qualities(player, monster);
            }
        }
    }

    public static void qualities(Player player, Monster monster){
        System.out.printf("""
                    Характеристики героя\s
                    Атака: %d
                    Защита: %d
                    Урон: %s
                    """, player.getAttack(), player.getProtection(), Arrays.toString(player.getDamage()));
        System.out.printf("""
                    Характеристики монстра\s
                    Атака: %d
                    Защита: %d
                    Урон: %s
                    """, monster.getAttack(), monster.getProtection(), Arrays.toString(monster.getDamage()));
    }
}


