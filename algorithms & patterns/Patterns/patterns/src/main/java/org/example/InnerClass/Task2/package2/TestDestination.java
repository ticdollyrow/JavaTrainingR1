package org.example.InnerClass.Task2.package2;

import org.example.InnerClass.Task2.package1.Destination;

public class TestDestination {
    protected class innerDestination implements Destination{
        @Override
        public String readLabel() {
            return "InnerClassDestination";
        }

        public innerDestination(){

        }

        //the default constructor of a protected class is implicitly protected.
    }
}
