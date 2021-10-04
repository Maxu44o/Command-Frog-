public class FrogCommands {

    public static Command jumpRightCommand(Frog frog, int steps) {
        return new Command() {
            @Override
            public boolean doo() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(-steps);
            }
        };
    }
}
