package lesson03.streetFighter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
class StreetFighter {
    private final int code;
    private final String name;
    private int health;
    private final int attack;


    public String getFighterInfo() {
        return "Code: " + code +
            ", Name: " + name +
            ", Health: " + health +
            ", Attack: " + attack;
    }

    public static void getFighters(List<StreetFighter> fighters) {
        System.out.println("=== StreetFighters List ===");
        for (StreetFighter f : fighters) {
            System.out.println(f.getFighterInfo());
        }
    }

    public void fight(StreetFighter opponent) {
        Random r = new Random();
        StreetFighter attacker = r.nextBoolean() ? this : opponent;
        StreetFighter defender = (attacker == this) ? opponent : this;

        System.out.println("Battle starts between " + this.name + " and " + opponent.name);
        System.out.println(attacker.name + " makes the first move!");

        while (this.health > 0 && opponent.health > 0) {
            defender.health -= attacker.attack;
            System.out.println(attacker.name + " hits " + defender.name + " for " + attacker.attack + " damage. "
                + defender.name + " health: " + Math.max(defender.health, 0));

            StreetFighter temp = attacker;
            attacker = defender;
            defender = temp;

        }

        if (this.health <= 0) {
            System.out.println(this.name + " has been defeated! Winner: " + opponent.name);
        } else {
            System.out.println(opponent.name + " has been defeated! Winner: " + this.name);
        }
    }
}