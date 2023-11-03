package beans.inrerfaces;

@FunctionalInterface
public interface Calculator {

    int sum(int a, int b);

    default int subtract(int a, int b){
        return a-b;
    }

    default int multiply(int a, int b){
        return a*b;
    }

    static int divide(int a, int b){
        return a/b;
    }
}
