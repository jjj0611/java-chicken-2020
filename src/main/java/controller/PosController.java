package controller;

import domain.command.Command;
import view.InputView;

public class PosController {

    public void run() {
        while (true) {
            runCommand();
        }
    }

    private void runCommand() {
        try {
            int commandNumber = InputView.inputCommandNumber();
            Command command = Command.of(commandNumber);
            switch (command) {
                case ORDER:
                    order();
                    break;
                case PAY:
                    pay();
                    break;
                case EXIT:
                    exit();
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {

    }

    private void pay() {

    }

    private void exit() {

    }

}
