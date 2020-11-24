public class FrogCommands {

    public static FrogCommand jumpRightCommand(Frog frog, int steps) {

        FrogCommand frogCommand = new FrogCommand() {

            @Override
            public boolean _do() {
                frog.jump(steps);
                return true;
            }

            @Override
            public boolean _undo() {
                frog.jump(-steps);
                return true;
            }
        };

        return frogCommand;

    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {

        FrogCommand frogCommand = new FrogCommand() {

            @Override
            public boolean _do() {
                frog.jump(steps);
                return true;
            }

            @Override
            public boolean _undo() {
                frog.jump(-steps);
                return true;
            }
        };

        return frogCommand;
    }

}

