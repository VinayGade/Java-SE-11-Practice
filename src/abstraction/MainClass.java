package abstraction;

abstract class A{
    protected abstract void firstMethod();

    public void secondMethod(){
        System.out.println("Second");
        firstMethod();
    }
}

abstract class B extends A{

    @Override
    public void firstMethod(){
        System.out.println("First");
    }

    //private abstract void thirdMethod();
    abstract void thirdMethod();
}

class C extends B{
    @Override
    void thirdMethod(){
        System.out.println("Third");
    }

    /*
    @Override
    protected void firstMethod() {

    }
     */
}

public class MainClass {

    public static void main(String[] args) {
        C c = new C();

        A ac = new C();

        B bc = new C();

        System.out.println("\n methods on c");
        c.firstMethod();
        c.secondMethod();
        c.thirdMethod();


        System.out.println("\n methods on ac");
        ac.firstMethod();
        ac.secondMethod();
        //ac.thirdMethod();


        System.out.println("\n methods on bc");
        bc.firstMethod();
        bc.secondMethod();
        bc.thirdMethod();
    }
}
