package per.ojr.springBoot.tutorial.beans;

public class ComplexBean {
    public void init() {
        System.out.println("@@@@@@@@@@@@@@ calling init() of ComplexBean");
    }

    public void destroy() {
        System.out.println("@@@@@@@@@@@@@@ calling destroy() of ComplexBean");
    }
}
