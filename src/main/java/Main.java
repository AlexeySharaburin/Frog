import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;

        Frog frog = new Frog();

        System.out.println("Добрый день! Начинаем прыжки!");
        paintPosition(frog.getPosition());

        while (true) {
            System.out.print(
                    "Ввведите команду для лягушки:\n" +
                            "++ - прыгни на N шагов направо\n" +
                            "-- - прыгни на N шагов налево\n" +
                            "<< - Undo (отмени последнюю команду)\n" +
                            ">> - Redo (повтори отменённую команду)\n" +
                            "!! - повтори последнюю команду\n" +
                            "0 - выход\n" +
                            ": ");

            String enter = scanner.next();

            if (enter.equals("0")) {
                break;
            }

            if (enter.equals("<<")) { // Undo (отмени последнюю команду)
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand)._undo();
                    curCommand--;
                }
            }


            if (enter.equals(">>")) { // Redo (повтори отменённую команду)
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand)._do();
                }
            }


            if (enter.equals("!!")) { // повтори последнюю команду
                if (curCommand <= 0) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(curCommand)._do();
                    curCommand++;
                }
            }

            if (enter.equals("++")) { // jump right
                System.out.print("Введите длину прыжка лягушки: ");
                int stepsRight = scanner.nextInt();
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, stepsRight);
                curCommand++;
                commands.add(cmd);
                cmd._do();
            }

            if (enter.equals("--")) { // jump left
                System.out.print("Введите длину прыжка лягушки: ");
                int stepsLeft = scanner.nextInt();
                FrogCommand cmd = FrogCommands.jumpLeftCommand(frog, -stepsLeft);
                curCommand++;
                commands.add(cmd);
                cmd._do();
            }

            System.out.println("Текущее число команд: " + commands.size());
            System.out.println("Текущие команды: " + commands.toString());
            System.out.println("Текущее состояние счётчика команд: " + curCommand);

            paintPosition(frog.getPosition());

        }

    }

    public static void paintPosition(int position) {
        System.out.println("\nПоложение лягушки в данный момент");
        for (int i = 0; i < position; i++) {
            System.out.print(" _ ");
        }
        System.out.print(" F ");
        for (int i = position; i < (Frog.MAX_POSITION); i++) {
            System.out.print(" _ ");
        }
        System.out.println();
        for (int i = 0; i < (Frog.MAX_POSITION + 1); i++) {
            System.out.format(" %d ", i);
        }
        System.out.println();
    }

}
