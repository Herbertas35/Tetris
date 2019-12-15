package application.Random;

import application.form.Form;
import application.form.FormFactory;
import application.form.FormJ;

public class RandomFormGenerator {
    private FormFactory formFactory;
    public RandomFormGenerator(){};


    public Form getRandomForm(){
        int randomNumber = generateRandomNumber(0, 7);
        switch (randomNumber){
            case 0:
                return formFactory.getForm(FormFactory.FormType.I);
            case 1:
                return formFactory.getForm(FormFactory.FormType.J);
            case 3:
                return formFactory.getForm(FormFactory.FormType.L);
            case 4:
                return formFactory.getForm(FormFactory.FormType.O);
            case 5:
                return formFactory.getForm(FormFactory.FormType.S);
            case 6:
                return formFactory.getForm(FormFactory.FormType.T);
            case 7:
                return formFactory.getForm(FormFactory.FormType.Z);
        }
        return null;
    }

    private int generateRandomNumber(int min, int max){
        int range = max - min + 1;
        return (int)(Math.random() * range)+ min;
    }

}
