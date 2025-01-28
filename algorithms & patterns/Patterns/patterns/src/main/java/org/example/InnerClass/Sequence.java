package org.example.InnerClass;

interface Selector{
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }

    private class SequeceSelector implements Selector{
        private int i = 0;
        public boolean end(){
            return i == items.length;
        }
        public Object current(){
            return items[i];
        }
        public void next(){
            if( i < items.length){
                i++;
            }
        }

        public Sequence getSequence(){
            return Sequence.this;
        }
    }

    public Selector selector(){
        return new SequeceSelector();
    }

    public SequeceSelector selectorC(){
        return new SequeceSelector();
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i< 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }

        System.out.println();
        Sequence.SequeceSelector sq = sequence.selectorC();
        while (! sq.end()){
            System.out.println(sq.current());
            sq.next();
        }

        Sequence.SequeceSelector sq1 = sequence.new SequeceSelector();

    }
}


  class TestSequence{
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i< 10; i++){
            sequence.add(Integer.toString(i));
        }

        //внутренний класс является закрьтым(private),
        // поэтому нигде, кроме как во внешнем для него классе
        //нельзя получить к нему доступ.
//        Sequence.SequeceSelector sq = sequence.selectorC();
    }
}