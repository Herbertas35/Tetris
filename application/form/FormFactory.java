package application.form;

public class FormFactory {

    public enum FormType{
        I,
        J,
        L,
        O,
        S,
        T,
        Z
    }

    public FormFactory(){};

    public Form getForm(FormType formType){
        switch (formType){
            case I:
                return new FormI();

            case J:
                return new FormJ();

            case L:
                return new FormL();

            case O:
                return new FormO();

            case S:
                return new FormS();

            case T:
                return new FormT();

            case Z:
                return new FormZ();
        }
        return null;
    }
}
