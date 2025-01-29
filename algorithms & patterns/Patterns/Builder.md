### Строитель — паттерн, порождающий объекты.

### Назначение
Отделяет конструирование сложного объекта от его представления, так что в результате одного и того же процесса конструирования могут получаться
разные представления.

### Применимость
алгоритм создания сложного объекта не должен зависеть от того, из каких частей состоит объект и как они стыкуются между собой;
процесс конструирования должен обеспечивать различные представления конструируемого объекта.



Flexibility – by decoupling the construction process from the actual object representation, 
the Builder Pattern allows us to create objects with varying configurations without cluttering our codebase with multiple constructors or setters
(Гибкость - отделяя процесс конструирования от фактического представления объекта, паттерн Builder позволяет нам создавать объекты с различной конфигурацией,
 не загромождая кодовую базу множеством конструкторов и сеттеров)


 In the classic implementation of the Builder Pattern, we create a separate Builder inner class. 
 This inner class contains methods to set each property of the constructed object.

 In the builder class, we’ve declared the same set of fields that the outer class contains.