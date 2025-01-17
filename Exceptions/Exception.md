## Java Exceptions
общая форма блока обработки исключений
> try {  
>    // Code that may throw an exception  
> } catch (Exception e) {  
>    // Exception handling code  
> } finally {  
>    // Cleanup code  
> }  

Все типы исключений являются подклассами встроенного класса Throwable. 
Непосредственно под Throwable находятся два подкласса, которые разделяют исключения на две отдельные ветви. Одну 
ветвь возглавляет класс Exception, используемый для представления исключительных условий, которые должны перехватываться пользовательскими
программами. Он также будет служить подклассом для создания собственных специальных типов исключений. Кроме того, у класса Exception имеется
важный подкласс, который называется RuntimeException.

Другую ветвь возглавляет класс Error, определяющий исключения, которые не должны перехватываться программой в обычных условиях.
Исключения типа Error применяется исполняющей средой Java для указания ошибок, связанных с самой средой. Примером такой ошибки является переполнение
стека. 


              ---> Throwable <--- 
              |    (checked)     |
              |                  |
              |                  |
      ---> Exception           Error
      |    (checked)        (unchecked)
      |
     RuntimeException
     (unchecked)

Checked exceptions are exceptions that the Java compiler requires us to handle. We have to either declaratively throw the exception up the call stack, or we have to handle it ourselves. 
Unchecked exceptions are exceptions that the Java compiler does not require us to handle.

Любое исключение, которое не перехвачено вашей программой, в конечном итоге бужет обработано стандартным 
обработчиком. Стандартный обработчик отображает строку с описанием исключения, выводит трассировку 
стека от точки, где произошло исключение, и прекращает работу программы. 

В классе Thowable переопределен метод toString(), так что он возвращает строку, содержащую 
описание исключения. 
В классе Throwable определен метод printStackTrace(), который выводит полную информацию об
исключении в консоль

При использовании нескольких конструкций catch важно помнить о том, что подклассы исключений должны предшествовать любым из своих
суперклассов. 

Программа может генерировать исключение явно с применением оператора throw со следующей общей формой:
> throw Throwableinstance;

Здесь Throwableinstance должен быть объектом типа Throwable или подклассом Throwable.
Поток выполнения останавливается сразу после оператора throw; любые последующие операторы не выполняются.

Подклассы RuntimeException непроверяемых искnючений Java,опредеnенные в java.lang
<table>
<thead>
<tr>
<th>Исключение</th>
<th>Описание</th>
</tr>
</thead>
<tbody>
<tr>
<td>ArithrneticException</td>
<td>Арифметическая ошибка, такая как деление на ноль</td>
</tr>
<tr>
<td>ArrayindexOutOfBoundsException</td>
<td>Выход за допустимые пределы индекса в массиве</td>
</tr>
<tr>
<td>ArrayStoreException</td>
<td>Присваивание элементу массива значения несовместимого типа</td>
</tr>
<tr>
<td>ClassCastException</td>
<td>Недопустимое приведение</td>
</tr>
<tr>
<td>EnurnConstantNotPresentException</td>
<td>Попытка использования неопределенного значения перечисления</td>
</tr>
<tr>
<td>IllegalArgumentException</td>
<td>Использование недопустимого аргумента при вызове метода</td>
</tr>
<tr>
<td>IllegalStateException</td>
<td>Некорректное состояние среды или приложения</td>
</tr>
<tr>
<td>NullPointerException</td>
<td>Недопустимое использование ссылки nul l</td>
</tr>
<tr>
<td>NumЬerFormatException</td>
<td>Недопустимое преобразование строки в числовой формат</td>
</tr>
</tbody>
</table>


 Классы nроверяемых искnючений Jаva, оnределенные в java.lang
<table>
<thead>
<tr>
<th>Исключение</th>
<th>Описание</th>
</tr>
</thead>
<tbody>
<tr>
<td>ClassNotFoundException</td>
<td>Класс не найден</td>
</tr>
<tr>
<td>IllegalAccessException</td>
<td>Доступ к классу запрещен</td>
</tr>
<tr>
<td>InterruptedException</td>
<td>Один поток был прерван другим потоком</td>
</tr>
</tbody>
</table>



Для создания собственного класса исключений достаточно определить его как производный от любого
класса-исключения (Exception, RuntimeException, IOException, NullPointerException и др.), его “группа”
(checked или unchecked) будет такой же как и “группа” суперкласса. В собственных классах
исключений даже не обязательно добавлять какие-либо поля или методы, их присутствия в системе
типов уже достаточно, чтобы пользоваться ими как исключениями.


### Handling Exceptions

#### throws
The simplest way to “handle” an exception is to rethrow it:
```
public int getPlayerScore(String playerFile)
  throws FileNotFoundException {
 
    Scanner contents = new Scanner(new File(playerFile));
    return Integer.parseInt(contents.nextLine());
}
```

Because FileNotFoundException is a checked exception, this is the simplest way to satisfy the compiler, but it does mean that anyone that calls our method now needs to handle it too!

parseInt can throw a NumberFormatException, but because it is unchecked, we aren’t required to handle it.

#### try-catch
If we want to try and handle the exception ourselves, we can use a try-catch block. We can handle it by rethrowing our exception:

```
public int getPlayerScore(String playerFile) {
    try {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException noFile) {
        throw new IllegalArgumentException("File not found");
    }
}
```
 
Or by performing recovery steps:
```
public int getPlayerScore(String playerFile) {
    try {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch ( FileNotFoundException noFile ) {
        logger.warn("File not found, resetting score.");
        return 0;
    }
}
```

#### finally
For each try block there can be zero or more catch blocks, but only one finally block.
The finally block will not be executed if the program exits (either by calling System.exit() or by causing a fatal error that causes the process to abort).

#### try-with-resources
Fortunately, as of Java 7, we can simplify the above syntax when working with things that extend AutoCloseable:
```
public int getPlayerScore(String playerFile) {
    try (Scanner contents = new Scanner(new File(playerFile))) {
      return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException e ) {
      logger.warn("File not found, resetting score.");
      return 0;
    }
}
```
When we place references that are AutoClosable in the try declaration, then we don’t need to close the resource ourselves.
We can still use a finally block, though, to do any other kind of cleanup we want.

When we know that the way we handle errors is going to be the same, though, Java 7 introduced the ability to catch multiple exceptions in the same block:
```
public int getPlayerScore(String playerFile) {
    try (Scanner contents = new Scanner(new File(playerFile))) {
        return Integer.parseInt(contents.nextLine());
    } catch (IOException | NumberFormatException e) {
        logger.warn("Failed to load score!", e);
        return 0;
    }
}
```

We can also choose to rethrow an exception we’ve caught:
```
public List<Player> loadAllPlayers(String playersFile) throws IOException {
    try { 
        // ...
    } catch (IOException io) { 		
        throw io;
    }
}
```

Or do a wrap and rethrow:
```
public List<Player> loadAllPlayers(String playersFile) 
  throws PlayerLoadException {
    try { 
        // ...
    } catch (IOException io) { 		
        throw new PlayerLoadException(io);
    }
}
```
This can be nice for consolidating many different exceptions into one.


### Inheritance
When we mark methods with a throws keyword, it impacts how subclasses can override our method.

In the circumstance where our method throws a checked exception:
```
public class Exceptions {
    public List<Player> loadAllPlayers(String playersFile) throws TimeoutException {
        // ...
    }
}
```

A subclass can have a “less risky” signature:
```
public class FewerExceptions extends Exceptions {	
    @Override
    public List<Player> loadAllPlayers(String playersFile) {
        // overridden
    }
}
```

But not a “more riskier” signature:
```
public class MoreExceptions extends Exceptions {		
    @Override
    public List<Player> loadAllPlayers(String playersFile) throws MyCheckedException {
        // overridden
    }
}
```
This is because contracts are determined at compile time by the reference type. If I create an instance of MoreExceptions and save it to Exceptions:
```
Exceptions exceptions = new MoreExceptions();
exceptions.loadAllPlayers("file");
```
Then the JVM will only tell me to catch the TimeoutException, which is wrong since I’ve said that MoreExceptions#loadAllPlayers throws a different exception.

Simply put, subclasses can throw fewer checked exceptions than their superclass, but not more.

If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
If the superclass method declares an exception, subclass overridden method can declare the same subclass exception 
or no exception but cannot declare parent exception.
```
import java.io.*;    
class Parent{    
  void msg()throws ArithmeticException {  
    System.out.println("parent method");  
  }    
}    
    
public class TestExceptionChild2 extends Parent{    
  void msg()throws Exception {  
    System.out.println("child method");  
  }    
    
  public static void main(String args[]) {    
   Parent p = new TestExceptionChild2();    
     
   try {    
   p.msg();    
   }  
   catch (Exception e){}   
  
  }    
}     
```
будет ошибка компиляции


https://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.20


A Custom Resource With AutoCloseable 
To construct a custom resource that will be correctly handled by a try-with-resources block, the class should implement 
the Closeable or AutoCloseable interfaces and override the close method:
```
public class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closed MyResource");
    }
}
```
Resources that were defined/acquired first will be closed last. Let’s look at an example of this behavior
A try-with-resources block can still have the catch and finally blocks, which will work in the same way as with a traditional try block.

s of Java 9 and as part of JEP 213, we can now use final or even effectively final variables inside a try-with-resources block:
```
final Scanner scanner = new Scanner(new File("testRead.txt"));
PrintWriter writer = new PrintWriter(new File("testWrite.txt"))
try (scanner;writer) { 
    // omitted
}
```
Put simply, a variable is effectively final if it doesn’t change after the first assignment, even though it’s not explicitly marked as final.

As shown above, the scanner variable is declared final explicitly, so we can use it with the try-with-resources block. Although the writer variable is not explicitly final, it doesn’t change after the first assignment. So, we can to use the writer variable too.