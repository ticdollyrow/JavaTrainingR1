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

 public int getPlayerScore(String playerFile)
  throws FileNotFoundException {
 
    Scanner contents = new Scanner(new File(playerFile));
    return Integer.parseInt(contents.nextLine());
 }

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

 public int getPlayerScore(String playerFile) {
    try {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch ( FileNotFoundException noFile ) {
        logger.warn("File not found, resetting score.");
        return 0;
    }
 }

#### finally

#### try-with-resources