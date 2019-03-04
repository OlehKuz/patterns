package Package3;
import interfaceA.Go;
import testInnerClass.Test;

public class From3Package extends Test{
    public Go d(){
        return  new Test().pContents();
    }
    public static void main(String[] args){
        From3Package f = new From3Package();
        Go g = f.d();
        System.out.println(g.destination());
    }
}


