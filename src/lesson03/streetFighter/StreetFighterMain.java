package lesson03.streetFighter;

import java.util.ArrayList;
import java.util.List;

public class StreetFighterMain {
    public static void main(String[] args) {
        List<StreetFighter> fighters = new ArrayList<>();

        StreetFighter f1 = new StreetFighter(1, "Ryu", 100, 20);
        StreetFighter f2 = new StreetFighter(2, "Ken", 100, 18);
        StreetFighter f3 = new StreetFighter(3, "Chun-Li", 100, 15);

        fighters.add(f1);
        fighters.add(f2);
        fighters.add(f3);

        StreetFighter.getFighters(fighters);

        System.out.println("\n=== FIGHT START ===\n");
        f1.fight(f2);
    }
}
