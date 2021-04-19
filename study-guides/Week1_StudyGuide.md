## Java Study Guide

You should be able to explain and apply the following topics:

### Fundamentals
- Features, benefits, and drawbacks of the Java language

  - WORA (write once, run anywhere)//java can run on any OS that supports the JRE

  - Backed by Oracle//they developed it, continue to improve/add to it

  - Rich APIs (e.g. Collections API)//the application programming interface gives detailed information about the Java library

  - Object-oriented//turns everything into data structures that contain states and behaviors

  - Strongly/strictly typed//variables must be declared before they are assigned a value

  - High level (e.g. memory handled via automatic garbage collection)

- POJO vs Bean// bean utilizes special formatting, all fields private, use get/set methods to access/change fields

- Stack vs Heap// stack is last-in-first-out, heap is dynamic memory allocation for Java objects and JRE classes at the runtime

- Purpose and contents of the JDK, JRE, and JVM//java development kit has the software needed to code in java, Java runtime enviornment proivdes the minimum requirements to execute java applications, JVM executes the code

- Garbage collection (generally, what does the garbage collector do?)//removes unused code/data

- Main method signature and significance//used to execute the program

- Compiling and executing Java code on the command line
  - java command//launch java application
  - javac command//creates java class file
- JavaDocs - What is it, what is it used for, how do you access it?
	-a document generator tool in Java programming language for generating standard documentation in HTML format. It generates API documentation.

- Primitive data types
  - boolean//true false

  - byte//8 bits

  - char//single letter/number

  - short//16 bit

  - int//32 bit (default)

  - float//32 bit with decimal

  - double//64 bit with decimal (default)

  - long//64 bit

- Operators
<<<<<<< HEAD
  - bnary//true false
    - pre/post increment/decrement//++x adds then shows, x++ shows then adds
    - not//!
    - instanceof//tests whether the object is an instance of the specified type (class or subclass or interface).

=======
  - unary
    - pre/post increment/decrement
    - not
    - instanceof
>>>>>>> 19268f2b4b948d9a8598da6e3e2c4b4366afc698
  - binary
    - mathematical//% is modulos & and ^exclusive or |inclusive or. 
    - logical//&& and ||or
 
  - assignment//go from left to right, always
  - ternary//test (boolean) ? If true : if false

- Scopes of variables//deeper scopes can call outter variables, not vice versa
  - static/class
  - object/instance
  - method
  - block

- Control flow statements
  - for
  - enhanced for loop//for(int n : numbers)
  - if/else 
  - while
  - do-while
  - switch
  - labels
  - break/continue

- Class members
  - Fields/Variables
  - Methods
    - Arguments vs Parameters
  - Constructors

- Access modifiers
  - public// visible to all classes, everywhere
  - protected//visible to all classes in the same package, and within subclasses
  - default//(Package-Private): visible to all classes in the same package
  - private//visible only within the current class

- Non-access modifiers
  - static//resource to be available without needing to create an instance of the class and shares the resource across all members of a class.
  - final//the last implementation, which cannot be extended, overridden, or changed.
  - abstract//declaration of a class or method without implementation.
  - synchronized//Limits the number of threads that can access a resource at a given time to 1.
  - transient//Prevents the resource from being serialized.

- Packages and import statements
  - static imports// In order to access static members, it is necessary to qualify references with the class they came from
- this and super keywords//this references object specific variable, or references another constructor this(), super() refers to parent class
- Constructor chaining//this in same class, super in parent class

- JRE library classes
  - Object
    - equals, hashCode, and toString methods//equal checks values, hashCode returns an int value for identification, toString converts object to string
  - System
  - String//immutable
  - StringBuilder//like string, but easier to modify via methods(good for single thread)
  - StringBuffer//like string, but easier to modify via methods
  - Collections//collection is interface used by many data types
  - Arrays//hold single type of data, indexed

- Wrapper classes
  - Autoboxing / unboxing//primitives can be turned into objects and back

- String pool//where string values are held in common
- == vs .equals()//method vs operator, checks memory vs value of two objects
- Making objects immutable//no setter method, declared final and private
- Varargs//variable arguments list allows arbitrary # values last parameter ...

### OOP
- Object-oriented programming principles
  - Abstraction//iding certain details and showing only essential information to the user
    - Abstract classes//restricted class, can't be instantiated
    - Interfaces//completely abstract class that is used to group related methods with empty bodies. implement key word
  - Polymorphism
    - Overloading//same method different parameters in a class
    - Overriding//same method different classes (from parent to child)
    - Covariant return types// different return type in overidden method, but same subtype
  - Inheritance
    - Inheriting from classes vs interfaces//class inheritance doesn't have to be abstract, interface inheritance is abstract, and must be defined in the inheritor
  - Encapsulation//The act of wrapping code into a single unit and then selectively exposing and restricting access to that code based on functionality or use within classes.
    - Using access modifiers with getters/setters//getters/setters methods allows access to restricted code, makes for a cleaner code

- Object vs class//class is the template, object is the instance
- Abstract classes
  - Difference between abstract and concrete class//abstract classes can have abstract methods, can't be instantiated
- Interfaces
  - Implicit modifiers for variables and methods//abstract, default, and static methods in an interface are implicitly public. All constant values defined in an interface are implicitly public , static , and final
  - When to use instead of abstract class//When working mith multiple classes that only some will share similarities(animal super should not include fly methods, since not all animals fly)

### Collections & Generics
- Collections API(Application Program Interface)
  - Inheritance hierarchy//inheritinc class is subclass, parent is superclass
  - List, Set, Map, and Queue interfaces and their differences//ordered collection (indexed), can't contain duplicates, utilizes key/value pairs(key is hashed & used as index value), ordered and first in first out
  - Concrete implementations of above interfaces and their differences
  - Using enhanced for loops//reduces chance of bugs, traverses each element one by one
  - Comparable and Comparator interfaces//Comparable is implemented by the object itself, Comparator is implemented by a 3rd party class, and can define a single method for comparing two objects.
  - Iterable vs Iterator interfaces//Iterable interface specifies the behavior for being able to return an Iterator, An iterator is a simple way of allowing some to loop through a collection of data without assignment privileges (though with ability to remove).
(All java collections are iterable. They have iterators)

- Annotations
  - @Override//used when a subclass overrides superclass
  - @Deprecated//tells developers the marked element should no longer be used
- Generics//<Type>
  - Generic classes//Generics are a way of saying, “I don’t know what type this will be right now, but when this class is instantiated into an object, a type will be provided”
  - Generic methods//same as class, except parameters instead of instantiation. 
  - Diamond operator and type inference//< and > are the diamond operators. Inference is Java compiler's ability to look at each method invocation and corresponding declaration to determine the type argument (or arguments) that make the invocation applicable. 

### Exceptions
- Class hierarchy
- Error
- Exception
- RuntimeException
- Checked vs unchecked exceptions
- Handling or declaring exceptions
- try/catch/finally blocks
  - rules for multiple catch blocks
- Creating custom exceptions
