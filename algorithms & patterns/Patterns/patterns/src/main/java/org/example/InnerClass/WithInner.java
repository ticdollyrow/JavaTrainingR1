package org.example.InnerClass;

public class WithInner {
    class Inner{}
}

class InheritInner extends WithInner.Inner{
    InheritInner(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
    }
}
