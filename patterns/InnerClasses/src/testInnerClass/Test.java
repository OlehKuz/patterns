package testInnerClass;

import interfaceA.Go;

public class Test {
    protected class PContents implements Go {
        private String i = "sfd";
        public String destination(){
            System.out.println("From Pcontents");
            return i;
        }

    }
    public PContents pContents(){
        return new PContents();
    }
}
