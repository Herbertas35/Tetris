package application.controller;

public class CommandHandler {
    private Command command;

    public CommandHandler(Command command){
        this.command = command;
    }

    public CommandHandler(){};

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
        clearCommand();
    }

    private void clearCommand(){
        this.command = null;
    }

    public boolean isCommandNull(){
        return this.command == null;
    }
}
