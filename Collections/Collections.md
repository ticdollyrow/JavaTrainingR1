https://www.javatpoint.com/collections-in-java

https://www.tutorialspoint.com/java/java_collections.htm

## Иерархия
The java.util package contains all the classes and interfaces for the Collection framework.
Интерфейс Collection - это основа, на которой построена инфраструктура Collections Framework, т.к. он должен быть реализован любым классом,
определяющим коллекцию.
Интерфейс Collection расширяет Iterable, т.е. по всем коллекциям можно проходить в цикле for стиля "for-each':

The Collection interface in Java provides basic methods to work with groups of objects, such as adding, removing, and iterate through each element.
They are as follows:
<table>
<thead>
<tr>
<th>Method</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>public boolean add(E e)</td>
<td>It is used to insert an element in this collection.</td>
</tr>
<tr>
<td>public boolean addAll(Collection<? extends E> c)</td>
<td>It is used to insert the specified collection elements in the invoking collection.</td>
</tr>
<tr>
<td>public boolean remove(Object element)</td>
<td>It is used to delete an element from the collection.</td>
</tr>
<tr>
<td>public boolean removeAll(Collection<?> c)</td>
<td>It is used to delete all the elements of the specified collection from the invoking collection.</td>
</tr>
<tr>
<td>default boolean removeIf(Predicate<? super E> filter)</td>
<td>It is used to delete all the elements of the collection that satisfy the specified predicate.</td>
</tr>
<tr>
<td>public boolean retainAll(Collection<?> c)</td>
<td>It is used to delete all the elements of invoking collection except the specified collection.</td>
</tr>
<tr>
<td>public boolean contains(Object element)</td>
<td>It is used to search an element.</td>
</tr>
<tr>
<td>public boolean containsAll(Collection<?> c)</td>
<td>It is used to search the specified collection in the collection.</td>
</tr>
</tbody>
</table>

There are only three methods in the Iterator interface. They are:
<table>
<thead>
<tr>
<th>Method</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>public boolean hasNext()</td>
<td>It returns true if the iterator has more elements otherwise it returns false.</td>
</tr>
<tr>
<td>public Object next()</td>
<td>It returns the element and moves the cursor pointer to the next element.</td>
</tr>
<tr>
<td>public void remove()</td>
<td>It removes the last elements returned by the iterator. It is less used.</td>
</tr>
</tbody>
</table>

Объекты добавляются в коллекцию с помощью вызова add ( ) . Обратите внимание, что метод add ( ) принимает аргумент типа Е, а это значит, что объекты,
добавляемые в коллекцию, должны быть совместимыми с типом данных, который ожидает коллекция. 
Вызвав метод addAll ( ) , можно добавить все содержимое одной коллекции в другую.
Объект удаляется с использованием метода remove ( ) . 
Для удаления группы объектов понадобится вызвать метод removeAll ( ) . 
Чтобы удалить все элементы кроме входящих в указанную группу необходимо вызвать метод retainAll ( ) . 
Для удаления элемента в случае, если он удовлетворяет некоторому условию, применяется метод removeif ( ) .
Чтобы очистить коллекцию, нужно вызвать метод clear ( ) . Для выяснения, содержит ли коллекция
конкретный объект, используется метод contains ( ) . Чтобы определить,
содержит ли одна коллекция все члены другой, понадобится вызвать метод
containsAll ( ) . Для определения, пуста ли коллекция, предназначен метод
isErnpty ( ) . Количество элементов, находящихся в текущий момент внутри
коллекции, позволяет выяснить метод size ( ) .



Все встроенные коллекции являются модифицируемыми.

### Интерфейс Queue
Интерфейс Queue расширяет Collection и обеспечивает поведение очереди, которая часто представляет собой список, действующий по принципу
"первым пришел - первым обслужен': 
Элементы можно удалять только из головы очереди

### Интерфейс Deque
расширяет Queue обеспечивает поведение двусторонней очереди. Двусторонние очереди могут функционировать как стандартные
очереди "первым пришел - первым обслужен" или как стеки "последний пришел - первым обслужен"

### Интерфейс List
Интерфейс List расширяет Collection и объявляет поведение коллекции, в которой хранится последовательность элементов. Элементы можно
вставлять или получать к ним доступ по позиции в списке, применяя индекс, который начинается с нуля.

List interface is the child interface of Collection interface. It inhibits a list type data structure in which we can store the ordered collection of objects. It can have duplicate values.
List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack.
```
List <data-type> list1= new ArrayList();  
List <data-type> list2 = new LinkedList();  
List <data-type> list3 = new Vector();  
List <data-type> list4 = new Stack();  
```

## !Класс ArrayList
https://www.javatpoint.com/java-arraylist

-----> extends
–––––> implements
ArrayList -----> AbstractList –––––> List –––––> Collection –––––> Iterable
```
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable  
```

Класс ArrayList поддерживает динамические массивы, которые по мере необходимости могут расти.
В классе ArrayList определены следующие конструкторы:
```
ArrayList ()
ArrayList (Collection<? extends Е> с)
ArrayList(int capacity)
```
увеличить емкость объекта ArrayList можно вручную, вызвав метод ensureCapacity ( ) .
если необходимо уменьшить размер массива, который лежит в основе объекта ArrayList, чтобы он был точно таким же, как количество
содержащихся в нем элементов, понадобится вызвать метод trimToSize ( )

хороши, когда нужно часто получать элемент по индексу
Операция удаления не дешевая, т.к. нужно перестраивать массив
Операция вставки тоже дорогая(в середину, в начало) т.к. нужно двигать элементы

```
import java.util.*;  
class TestJavaCollection1{  
public static void main(String args[]){  
ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
list.add("Ravi");//Adding object in arraylist  
list.add("Vijay");  
list.add("Ravi");  
list.add("Ajay");  
//Traversing list through Iterator  
Iterator itr=list.iterator();  
while(itr.hasNext()){  
System.out.println(itr.next());  
}  
}  
}  
```
The ArrayList in Java can also have duplicate elements.
Сохраняет порядок вставки: Java ArrayList гарантирует порядок, в котором элементы попадают в него. При просмотре ArrayList с помощью итерации доступ к элементам осуществляется в той же последовательности, в которой они были добавлены.
ArrayList не синхронизирован. Этот факт означает, что ArrayList не является потокобезопасным, поэтому при одновременном обращении к ArrayList нескольких потоков могут возникнуть проблемы с одновременной модификацией.
Поддержка случайного доступа: ArrayList позволяет реализовать быстрые операции произвольного доступа, используя позиции индексов элементов. Это связано с тем, что для внутренней реализации используется структура массива, которая обеспечивает постоянный доступ к элементам по индексу.
Более медленные манипуляции по сравнению с LinkedList: Операции манипулирования, такие как вставка и удаление, в ArrayList могут выполняться медленнее, чем в LinkedList. Так, в ArrayList приходится выполнять сдвиг элементов, когда элементы вставляются или удаляются из любого места, кроме конца списка. 
Требуются классы-обертки для примитивных типов: ArrayList не имеет прямой поддержки примитивных типов данных, таких как `int`, `float` и `char`. Вместо этого ему требуются классы-обертки, такие как `Integer`, `Float`, `Character` и т. д., для этих примитивных типов.
Динамическое изменение размера: ArrayList расширяется или сжимается при добавлении или удалении элементов, чтобы соответствовать требуемому новому размеру. Благодаря адаптивному изменению размера можно управлять онлайн-коллекциями без физического изменения размера.

Serialization and deserialization in Java are processes used to convert objects into byte streams for storage or transmission and then reconstruct the objects from those byte streams, respectively. This mechanism allows objects to be saved to files, sent over networks, or stored in databases.
```
import java.util.*;  
class ArrayList6 {  
    public static void main(String[] args) {  
        // Create an ArrayList and add elements to it  
        ArrayList<String> al = new ArrayList<String>();  
        al.add("Ravi");  
        al.add("Vijay");  
        al.add("Ajay");  
        try {  
            // Serialization  
            FileOutputStream fos = new FileOutputStream("file");  
            ObjectOutputStream oos = new ObjectOutputStream(fos);  
            oos.writeObject(al); // Write the ArrayList object to the file  
            fos.close();  
            oos.close();  
            // Deserialization  
            FileInputStream fis = new FileInputStream("file");  
            ObjectInputStream ois = new ObjectInputStream(fis);  
            // Read the ArrayList object from the file and cast it to ArrayList<String>  
            ArrayList list = (ArrayList) ois.readObject();  
            System.out.println(list); // Print the deserialized ArrayList  
            ois.close();  
            fis.close();  
        } catch (Exception e) {  
            System.out.println(e);  
        }  
    }  
}  
```

```
//Removing elements on the basis of specified condition  
          al.removeIf(str -> str.contains("Ajay"));   //Here, we are using Lambda expression   
```
Накладные расходы при динамическом изменении размера: Функция динамического изменения размера ArrayList, хотя и полезна для размещения добавленных или удаленных элементов, влечет за собой накладные расходы на производительность. Поскольку внутренний массив динамически расширяется или сжимается, частые операции изменения размера, особенно при работе с большими списками ArrayList, приводят к заметным накладным расходам. Каждое изменение размера включает выделение новой памяти, копирование существующих элементов и деаллокацию старого массива, что требует вычислительных ресурсов и времени. Следовательно, чрезмерное изменение размера может повлиять на эффективность программы, что приведет к замедлению времени выполнения. Поэтому, несмотря на гибкость ArrayList, разработчики должны тщательно управлять операциями изменения размера, чтобы снизить потери производительности и обеспечить оптимальную работу приложений, работающих с большими или часто изменяемыми списками массивов.

Нерациональное использование памяти: ArrayList выделяет память блоками и может выделять ее больше, чем достаточно для будущего увеличения. Это может привести к нерациональному использованию памяти, особенно если список ArrayList имеет большой объем, хотя содержит всего несколько элементов.          

## Vector
Vector uses a dynamic array to store the data elements. It is similar to ArrayList. However, it is synchronized and contains many methods that are not the part of Collection framework.
Класс Vector устарел начиная с Java 5.

## Stack
The stack is the subclass of Vector. It implements the last-in-first-out data structure, i.e., Stack. The stack contains all of the methods of Vector class and also provides its methods like boolean push(), boolean peek(), boolean push(object o), which defines its properties.

## !класс LinkedList
It inherits the AbstractList class and implements List and Deque interfaces.
реализует интерфейсы List, Deque и Queue.

можно добавлять в начало и конец (Быстрая вставка/удаление в начало или конец (O(1)). Поиск по индексу – O(n).)
можно добавлять по индексу
дорогая операция поиска/получения элемента
Может также работать как Queue/Deque.

Unlike arrays, which store elements in contiguous memory locations, a linked list stores elements as nodes, where each node contains the element itself and a reference (or pointer) to the next node in the sequence.

The important points about Java LinkedList are:

Java LinkedList class can contain duplicate elements.
Java LinkedList class maintains insertion order.
Java LinkedList class is non synchronized.
In Java LinkedList class, manipulation is fast because no shifting needs to occur.
Java LinkedList class can be used as a list, stack or queue.

accessing elements by index in a LinkedList is less efficient compared to arrays, as it requires traversing the list from the beginning or end to reach the desired element.

Java LinkedList Example to reverse a list of elements
```
import java.util.*;  
public class LinkedList4{  
 public static void main(String args[]){  
  
  LinkedList<String> ll=new LinkedList<String>();  
           ll.add("Ravi");  
           ll.add("Vijay");  
           ll.add("Ajay");  
           //Traversing the list of elements in reverse order  
           Iterator i=ll.descendingIterator();  
           while(i.hasNext())  
           {  
               System.out.println(i.next());  
           }  
             
 }  
}  
```
### Difference Between ArrayList and LinkedList
1) ArrayList internally uses a dynamic array to store the elements.
LinkedList internally uses a doubly linked list to store the elements.
2) Manipulation with ArrayList is slow because it internally uses an array. If any element is removed from the array, all the other elements are shifted in memory.
Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.
3) An ArrayList class can act as a list only because it implements List only.
LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
4) ArrayList is better for storing and accessing data.
LinkedList is better for manipulating data.
5) The memory location for the elements of an ArrayList is contiguous.
The location for the elements of a linked list is not contagious.
6) Generally, when an ArrayList is initialized, a default capacity of 10 is assigned to the ArrayList.
There is no case of default capacity in a LinkedList. In LinkedList, an empty list is created when a LinkedList is initialized.
7) To be precise, an ArrayList is a resizable array.
LinkedList implements the doubly linked list of the list interface.

Если частота добавления или удаления превышает частоту чтения сценариев, выбирайте LinkedList. С другой стороны, если частота сценариев чтения превышает частоту добавления или удаления, то ArrayList имеет преимущество перед LinkedList.

Расход памяти в LinkedList больше, чем в ArrayList. Это связано с тем, что в LinkedList есть две дополнительные ссылки (next и previous), так как требуется хранить адреса предыдущего и следующего узлов, и эти ссылки занимают дополнительное место. В ArrayList таких ссылок нет.

### How to convert Array to List
https://www.geeksforgeeks.org/program-to-convert-array-to-list-in-java/

Method 1: Using Arrays.asList()
Method 2: Collections.addAll(list, array);
```
Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
List<Integer> targetList = Arrays.asList(sourceArray);

List<Integer> targetList = new ArrayList<Integer>(Arrays.asList(sourceArray));

Collections.addAll(arrlist, "1", "2", "3"); 
```    
Метод Arrays.asList()преобразует заданный массив в список. Возвращаемый список поддерживается исходным массивом, что означает, что изменения в списке повлияют на массив.

```
// array declaration
Double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};
        
// Converting array to list using Stream API
List<Double> lis = Arrays.stream(arr).collect(Collectors.toList());
```
The Arrays.stream() method creates a stream from the array, and Collectors.toList() collects the elements of the stream into a list.
This is a clean and efficient way to convert an array to a list, especially when you want to apply additional operations on the stream before collecting the results.

you can use the List.of() method to create immutable lists directly from the array.
```
 // taking an array
        String[] arr = {"geeks", "for", "geeks"};
        
// Converting array to immutable list
        List<String> list = List.of(arr);
 ```


### How to convert List to Array
List.toArray() method
```
List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
Integer[] targetArray = sourceList.toArray(new Integer[0]);
```


### Queue Interface
Queue interface maintains the first-in-first-out order.
The most common classes that implement the Queue interface in Java are LinkedList and PriorityQueue. 

Некоторые методы генерируют ClassCastException, коrда объект несовместим с элементами в очереди. Исключение NullPointerException возникает,
если предпринимается попытка сохранить объект null, а элементы null в очереди не разрешены. Исключение I llegalArgumentException происходит
в случае использования недопустимого аргумента.
Исключение I llegalStateException генерируется при попытке добавления элемента в заполненную очередь фиксированной длины. Исключение
NoSuchElementException возникает при попытке удаления элемента из пустой очереди.
Элементы можно удалять только из головы очереди.
существуют два метода для получения и удаления элементов:
poll ( ) и remove ( ) . 
Разница между ними в том, что poll ( ) возвращает null, если очередь пуста, а remove ( ) генерирует исключение.
метод offer ( ) только пытается добавить элемент в очередь. Поскольку некоторые очереди имеют фиксированную длину и могут
быть заполнены, метод offer ( ) может завершиться неудачей.


#### PriorityQueue
Реализует очередь с приоритетом через двоичную кучу (binary heap). Он создает очередь с приоритетом на основе компаратора очереди.
Выборка/удаление «наименьшего» или «наибольшего» элемента – O(log n).
PriorityQueue doesn't allow null values to be stored in the queue.

В классе PriorityQueue определены семь конструкторов:
PriorityQueue ()
PriorityQueue(int capacity)
PriorityQueue(Comparator<? super Е> comp)
PriorityQueue(int capacity, Comparator<? super Е> comp)
PriorityQueue(Collection<? extends Е> с)
PriorityQueue(PriorityQueue<? extends Е> с)
PriorityQueue(SortedSet<? extends Е> с)


### Deque Interface
Deque interface extends the Queue interface. In Deque, we can remove and add the elements from both the side. Deque stands for a double-ended queue which enables us to perform the operations at both the ends.

## ArrayDeque
ArrayDeque class implements the Deque interface. 
Null elements are not allowed in the ArrayDeque.

ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.
Реализован на массиве, использует кольцевой буфер.
Быстрые операции добавления/удаления с обоих концов (O(1) амортизированно).

## Set
Интерфейс Set определяет набор. Он расширяет интерфейс Collection и задает поведение коллекции, которое не допускает дублирования элементов,
поэтому метод add () возвращает false, если предпринимается попытка добавления в набор повторяющихся элементов.

It represents the unordered set of elements which doesn't allow us to store the duplicate items. We can store at most one null value in Set. Set is implemented by HashSet, LinkedHashSet, and TreeSet.

### HashSet
Java HashSet class is used to create a collection that uses a hash table for storage. It inherits the AbstractSet class and implements Set interface.

The important points about Java HashSet class are:

HashSet stores the elements by using a mechanism called hashing.
HashSet contains unique elements only.
HashSet allows null value.
HashSet class is non synchronized.
HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
HashSet is the best approach for search operations.
The initial default capacity of HashSet is 16, and the load factor is 0.75.

конструктор принимает Collections
нет дублей
не сохраняет порядок

HashSet does not allow null elements, but it can contain a single null value.
If we attempt to add a duplicate element to a HashSet, the add method will return false and the HashSet will remain unchanged.

```
 ArrayList<String> list=new ArrayList<String>();    
           list.add("Ravi");    
           list.add("Vijay");    
           list.add("Ajay");    
               
           HashSet<String> set=new HashSet(list);   
```           

 эффективная работа с основными операциями, такими как добавление, удаление и проверка наличия элементов. HashSet достигает этой эффективности за счет использования хэш-таблицы для хранения
 Кроме того, Java HashSets предоставляет широкий спектр операций с множествами, таких как объединение, пересечение и разность, которые могут быть полезны для работы с множествами элементов. Эти операции также выполняются эффективно, что делает HashSet подходящим выбором для задач, связанных с манипулированием множествами.

 Один из недостатков заключается в том, что HashSet не гарантирует порядок следования элементов. Это означает, что порядок добавления элементов в HashSet не сохраняется при итерации по элементам. Если вам нужен определенный порядок, возможно, вам придется использовать другую структуру данных, например LinkedHashSet, которая сохраняет порядок вставки своих элементов.
 
### LinkedHashSet
сохраняет порядок вставки
LinkedHashSet class represents the LinkedList implementation of Set Interface. It extends the HashSet class and implements Set interface.

The important points about the Java LinkedHashSet class are:

Java LinkedHashSet class contains unique elements only like HashSet.
Java LinkedHashSet class provides all optional set operations and permits null elements.
Java LinkedHashSet class is non-synchronized.
Java LinkedHashSet class maintains insertion order.



Интерфейс SortedSet расширяет Set и обеспечивает поведение набора, отсортированного в возрастающем порядке.
```
SortedSet<data-type> set = new TreeSet();  
```
### TreeSet
сортирует элементы
The important points about the Java TreeSet class are:

Java TreeSet class contains unique elements only like HashSet.
Java TreeSet class access and retrieval times are quiet fast.
Java TreeSet class doesn't allow null element.
Java TreeSet class is non synchronized.
Java TreeSet class maintains ascending order.

The TreeSet can only allow those generic types that are comparable. 

```
TreeSet<Human> humans = new TreeSet<>();
класс Human должен имплементировать интерфейс Comparable и реализовать метод int compareTo( возвращает целочисленное значение. Если 0, то равны, если положительное, то первый объект юольше второго, если отрицательное, то наоборот )

```
If we add an object of the class that is not implementing the Comparable interface, the ClassCast Exception is raised.


TreeSet Vs. HashSet
<table>
<thead>
<tr>
<th>Feature</th>
<th>TreeSet</th>
<th>HashSet</th>
</tr>
</thead>
<tbody>
<tr>
<td>Underlying Data Structure</td>
<td>Red-Black Tree</td>
<td>Hash Table/td>
</tr>
<tr>
<td>Ordering of Elements</td>
<td>Keeps elements sorted, which facilitates ordered traversal and quick-range searches.</td>
<td>Does not maintain any order; element arrangement is determined by the hash function.</td>
</tr>
<tr>
<td>Performance for Basic Operations</td>
<td>Somewhat increased temporal complexity; operations like add, delete, and contain are O(logN).</td>
<td>Constant-time complexity O(1) for basic operations like add, delete, and contain, making it highly efficient.</td>
</tr>
<tr>
<td>Best Use Case</td>
<td>Better suited for applications requiring ordered data management, such as range queries or sequential access.</td>
<td>Ideal for scenarios where quick retrieval and manipulation are more important than element order.</td>
</tr>
<tr>
<td>Sorting</td>
<td>Automatically sorts elements according to their natural ordering or a specified comparator.</td>
<td>No sorting of elements; storage is hash-based.</td>
</tr>
<tr>
<td>Application Suitability</td>
<td>Preferred for applications where elements need to be maintained in a sorted manner.</td>
<td>More suitable for applications requiring fast access and where element order is not a concern.</td>
</tr>
</tbody>
</table>


### EnumSet
Он предназначен для использования с объектами типа enum и является обобщенным классом с таким объявлением:
class EnumSet<E extends Enum <E> >
Конструкторы в классе EnumSet не определены. Взамен для создания объектов применяются фабричные методы



### Map
Интерфейс Мар сопоставляет уникальные ключи со значениями. не реализует интерфейс Collection
A Map cannot contain duplicate keys; each key can map to at most one value. The Map interface is used to store key-value pairs, where each key is unique, and it provides an efficient way to retrieve, update, and manipulate data based on keys.
You can use any object as a key, which must implement hashCode() and equals() methods

entrySet метод  - It returns the Set view containing all the keys and values.
```
   // Iterate through the HashMap and print each key-value pair.  
        for (Map.Entry<Integer, String> entry : numbersMap.entrySet()) {  
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());  
        }  
```


## HashMap
Быстрый доступ/вставка/удаление по ключу (O(1) амортизированно).
Порядок ключей не гарантирован.

## LinkedHashMap
Наследует свойства HashMap, но хранит порядок вставки 

## TreeMap
TreeMap in Java is a sorted map implementation that stores key-value pairing in a Red-Black tree structure. 
This data structure offers operations of O(log n) time-efficiency for insertion, deletion, and retrieval.
конструкторы, которые определены в TreeMap:
TreeMap ( )
TreeMap ( Comparator<? super К> comp )
TreeMap (Map<? extends К, ? extends V> m)
TreeMap ( SortedMap<K, ? extends V> sm)

метод класса Object  hashcode


## Компараторы
метод Collections.sort
если класс не может имплементировать интерфейс Comparable можно использовать Comparator


interface Comparator<T>
метод compare ( ) сравнивает два элемента по порядку:
int compare ( T obj1 , Т obj2 )
Обычно метод compare ( ) возвращает ноль, если объекты равны, положительное значение, если obj1 больше obj2, и отрицательное значение, если obj1 меньше obj2. 


С помощью метода reversed ( ) можно получить компаратор, изменяющий
упорядочение компаратора, для которого он вызывается, на противоположное:
default Comparator<T> reversed ( )


Другим стандартным методом является thenComparing ( ) . Он возвращает
компаратор, который выполняет второе сравнение, когда результат первого
сравнения указывает, что сравниваемые объекты равны.


Интерфейс Comparator определяет, каким образом сравниваются два объекта
public void sort(List list, Comparator c): is used to sort the elements of List by the given Comparator.
```
Collections.sort(humans, Comparator
        .comparingInt(Human::getLimit)
        .comparingInt(Human::getAge)
        .reversed() );

 Comparator<Person> personByNameComparator = Comparator.comparing(Person::name);
 persons.sort(personByNameComparator);
 //если сравнивать по нескольким показателям

 Comparator<Person> personByNameComparator = Comparator.comparing(Person::name).thenComparing(Person::age);
 persons.sort(personByNameComparator);
```

Java Comparable interface
This interface is found in java.lang package and contains only one method named compareTo(Object). 

public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns
positive integer, if the current object is greater than the specified object.
negative integer, if the current object is less than the specified object.
zero, if the current object is equal to the specified object.


алгоритмы определены в
виде статических методов класса Collections