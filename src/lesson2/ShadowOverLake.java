package lesson2;

import java.util.Scanner;

public class ShadowOverLake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Сцена 1: Пробуждение
        System.out.println("Ты приходишь в себя на холодном песке у берега озера. Вокруг — туман, ночь, ни души.");
        System.out.println("Телефон в кармане почти разряжен (1%).");
        System.out.println("В другом кармане — спичка и клочок бумаги с надписью: \"Не доверяй голосам. Иди к северу.\"");
        System.out.println("Выбор:");
        System.out.println("1. Пойти на восток, туда, где в тумане мерцает свет.");
        System.out.println("2. Пойти на север, как советует записка.");
        System.out.println("3. Остаться у озера, может, кто-то придёт.");
        int choice1 = scanner.nextInt();

        if (choice1 == 1) {  // Сцена 2A: Восточный свет
            System.out.println("Ты идёшь на свет и находишь старую электростанцию. Внезапно загорается прожектор.");
            System.out.println("Голос в громкоговорителе: \"Стоять. Идентификация...\"");
            System.out.println("Ты ничего не понимаешь.");
            System.out.println("Выбор:");
            System.out.println("1. Ответить: \"Я человек, я потерялся!\"");
            System.out.println("2. Убежать назад в лес.");
            int choice2A = scanner.nextInt();

            if (choice2A == 1) {  // Сцена 3A: Попытка общения
                System.out.println("Ты кричишь, но свет слепит тебя. Из темноты появляется фигура в противогазе.");
                System.out.println("Вас усыпляют. Очнулся ты уже в лаборатории. Ты стал частью эксперимента.");
                System.out.println("Концовка: Неудача");
            } else if (choice2A == 2) {  // Сцена 3B: Побег
                System.out.println("Ты бежишь, но спотыкаешься. Прожектор гаснет. Что-то двигается в кустах.");
                System.out.println("Ты исчез без следа.");
                System.out.println("Концовка: Неудача");
            } else {
                System.out.println("Неверный выбор.");
            }

        } else if (choice1 == 2) {  // Сцена 2B: Северный путь
            System.out.println("Ты следуешь на север и находишь заброшенную деревню. Дома пусты, но в одном — следы костра и дневник.");
            System.out.println("\"Озеро просыпается в полнолуние. Не верь голосам. Прячься до рассвета.\"");
            System.out.println("Выбор:");
            System.out.println("1. Остаться в доме до рассвета.");
            System.out.println("2. Выйти и идти дальше в туман.");
            int choice2B = scanner.nextInt();

            if (choice2B == 1) {  // Сцена 3C: Ожидание
                System.out.println("Ты сидишь у костра. Проходят часы. На рассвете из тумана выходит группа людей — выжившие.");
                System.out.println("Они помогают тебе выбраться.");
                System.out.println("Концовка: Победа");
            } else if (choice2B == 2) {  // Сцена 3D: Поиски
                System.out.println("Ты блуждаешь в тумане и выходишь к маяку. Там — старая рация. Связь удаётся установить.");
                System.out.println("На следующий день — эвакуация.");
                System.out.println("Концовка: Победа");
            } else {
                System.out.println("Неверный выбор.");
            }

        } else if (choice1 == 3) {  // Сцена 2C: Ожидание у озера
            System.out.println("Ты остаёшься на месте. Из тумана слышишь детский голос: \"Помоги мне... пожалуйста...\"");
            System.out.println("Тебя охватывает страх.");
            System.out.println("Выбор:");
            System.out.println("1. Пойти на голос.");
            System.out.println("2. Убежать прочь в лес.");
            int choice2C = scanner.nextInt();

            if (choice2C == 1) {  // Сцена 3E: Девочка
                System.out.println("Ты идёшь на голос и видишь девочку в белом. Она улыбается и исчезает в воде.");
                System.out.println("Вокруг тебя — тени. Ты не можешь двигаться.");
                System.out.println("Концовка: Проклятие озера");
            } else if (choice2C == 2) {  // Сцена 3F: Побег в лес
                System.out.println("Ты бежишь прочь. Натыкаешься на подземный люк. Внутри — бункер. Там — доказательства эксперимента: мониторы, карты, журналы.");
                System.out.println("Выбор:");
                System.out.println("1. Разрушить центр управления.");
                System.out.println("2. Присоединиться к проекту.");
                int choice3F = scanner.nextInt();

                if (choice3F == 1) {  // Сцена 4A: Разрушение
                    System.out.println("Ты активируешь самоуничтожение. Озеро начинает светиться. Тьма уходит. Ты спас мир... но погиб.");
                    System.out.println("Концовка: Герой");
                } else if (choice3F == 2) {  // Сцена 4B: Присоединение
                    System.out.println("Ты входишь в проект. Тебе дают новое имя. Ты становишься частью того, что раньше преследовало тебя.");
                    System.out.println("Концовка: Тайный участник");
                } else {
                    System.out.println("Неверный выбор.");
                }

            } else {
                System.out.println("Неверный выбор.");
            }

        } else {
            System.out.println("Неверный выбор.");
        }

        scanner.close();
    }
}
