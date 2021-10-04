import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog frog = new Frog();
        frog.printFrog();

        List<Command> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(0)) break;
            else {
                if (input.equals("<<")) { //отменить действие
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undo();
                        curCommand--;
                    }
                } else if (input.equals(">>")) { //восстановить действие
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего восстанавливать");
                    } else {
                        curCommand++;
                        commands.get(curCommand).doo();
                    }
                } else if (input.equals("!!")) { //повторить действие
                    if (curCommand < 0) {
                        System.out.println("Нечего повторять");
                    } else {
                        commands.get(curCommand).doo();
                        if (commands.get(curCommand).doo()) curCommand++;
                    }
                } else { // новое действие
                    if (curCommand != commands.size() - 1) {
                        for (int i = curCommand + 1; i < commands.size(); i++)
                            commands.remove(i);
                    }
                    int tmp = Integer.parseInt(input);
                    Command cmd = FrogCommands.jumpRightCommand(frog, tmp);
                    curCommand++;
                    commands.add(cmd);
                    cmd.doo();
                }

                frog.printFrog();
            }
        }
    }
}

