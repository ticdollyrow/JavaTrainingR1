package org.example.InnerClass.Task3;

public class OuterClass {
    private String name;
    private String surname;

    private void print(){
        System.out.println(name + " " + surname);
    }

    public void create(){
        InnerClass innerClass = new InnerClass();
        innerClass.change("Sofia");
        innerClass.midnm = "Middle";

        System.out.println(innerClass.midnm);
    }

    class InnerClass{
        private String midnm;

        public void change(String name){
            OuterClass.this.name = name;
            surname = name;
            print();
        }
    }

    public static void main(String[] args) {
        new OuterClass().create();
    }
}
