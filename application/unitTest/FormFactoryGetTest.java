package application.unitTest;

import application.Random.RandomFormGenerator;
import application.form.*;

public class FormFactoryGetTest {

    public FormFactoryGetTest(){};

    public boolean checkFormFactoryGet(){
        FormFactory formFactory = new FormFactory();
        Form form;
        for(int i = 0; i <= 6; i++){
            switch (i){
                case 0:
                    form = formFactory.getForm(FormFactory.FormType.I);
                    if(form.getClass() != FormI.class)
                        return false;
                case 1:
                    form = formFactory.getForm(FormFactory.FormType.J);
                    if(form.getClass() != FormJ.class)
                        return false;
                case 2:
                    form = formFactory.getForm(FormFactory.FormType.L);
                    if(form.getClass() != FormL.class)
                        return false;
                case 3:
                    form = formFactory.getForm(FormFactory.FormType.O);
                    if(form.getClass() != FormO.class)
                        return false;
                case 4:
                    form = formFactory.getForm(FormFactory.FormType.S);
                    if(form.getClass() != FormS.class)
                        return false;
                case 5:
                    form = formFactory.getForm(FormFactory.FormType.T);
                    if(form.getClass() != FormT.class)
                        return false;
                case 6:
                    form = formFactory.getForm(FormFactory.FormType.Z);
                    if(form.getClass() != FormZ.class)
                        return false;

            }
        }
        return true;
    }
}
