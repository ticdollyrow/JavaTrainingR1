package org.example.InnerClass.Task4;

public class Outer {

    protected static class InnerClass{
        String name;
        public InnerClass(){
            name = "Test";
        }

        public void print(){
            System.out.println(name);
        }
    }

    public static InnerClass create(){
        return new InnerClass();
    }

    public static void main(String[] args) {
        InnerClass inner = create();
        inner.print();
    }

}


class OuterTest{
    public static void main(String[] args) {
        Outer.InnerClass testInnerClass = new Outer.InnerClass();
        testInnerClass.print();
    }
}
