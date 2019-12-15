package application.rotator;

public class RotatorContext {

    private RotatorStrategy strategy;

    public RotatorContext(RotatorStrategy strategy){
        this.strategy = strategy;
    }

    public void executeRotation(){
         strategy.rotate();
    }
}
