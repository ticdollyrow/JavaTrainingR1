package org.example.InnerClass;

public class Parcel2 {
    class Contents{
        private int i = 11;
        public int value(){ return  i; };
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    public Destination to(String s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    public void ship(String dest){
        Contents contents = contents();
        Destination destination = to(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Танзания");

        Parcel2 q = new Parcel2();
        //Определение ссылок на внутренние классы
        Parcel2.Contents contents = q.contents();
        Parcel2.Destination  destination= q.to("Borneo");
        //Если вам понадобится создать объект внутреннего класса где-либо еще, кроме как в нестатическом
        //методе внешнего класса, нужно будет указать тип этого объекта следующим
        //образом: ИмяВнешнегоКласса.ИмяВнутреннегоКласса
    }

}
