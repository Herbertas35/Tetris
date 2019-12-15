package application.Random;

import application.form.Form;
import application.form.FormFactory;
import application.form.FormJ;
import application.gameState.GameStateHandler;

public class RandomFormGenerator {
    private FormFactory formFactory = new FormFactory();


    public RandomFormGenerator(){};

    public  Form getRandomForm(){
        int randomNumber = generateRandomNumber(0, 6);
        System.out.println(randomNumber);
        GameStateHandler gameStateHandler = new GameStateHandler();
        gameStateHandler.setNeedForm(false);
        switch (randomNumber){
            case 0:
                return formFactory.getForm(FormFactory.FormType.I);
            case 1:
                return formFactory.getForm(FormFactory.FormType.J);
            case 2:
                return formFactory.getForm(FormFactory.FormType.L);
            case 3:
                return formFactory.getForm(FormFactory.FormType.O);
            case 4:
                return formFactory.getForm(FormFactory.FormType.S);
            case 5:
                return formFactory.getForm(FormFactory.FormType.T);
            case 6:
                return formFactory.getForm(FormFactory.FormType.Z);
            default:
                gameStateHandler.setNeedForm(true);
        }
        return null;
    }

    private int generateRandomNumber(int min, int max){
        int range = max - min + 1;
        return (int)(Math.random() * range)+ min;
    }

}
