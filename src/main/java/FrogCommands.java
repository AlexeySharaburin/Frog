public class FrogCommands {

    public static FrogCommand jumpRightCommand(Frog frog, int steps) {

        FrogCommand frogCommand = new FrogCommand() {

            @Override
            public boolean doIt() {
                if (frog.jump(steps)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean undoIt() {
                frog.jump(-steps);
                return true;
            }
        };

        return frogCommand;


    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {

        FrogCommand frogCommand = new FrogCommand() {

            @Override
            public boolean doIt() {
                if (frog.jump(steps)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean undoIt() {
                frog.jump(-steps);
                return true;
            }
        };

        return frogCommand;
    }

}

