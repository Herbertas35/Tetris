package application.controller;

public class CommandHandler {
    private Command command;

    public CommandHandler(Command command){
        this.command = command;
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }
}
