Java as a statically typed language imposes a lot of structure. With an understanding of the language and its capabilities, this structure can result in more elegant code. One of these elements of structure is known as method overloading. In a nutshell, we can define variants of our methods to give outside callers choices when it comes to invoking the functions we create.

## Learning Goals

- Overload an instance method

##

```no-highlight
et get java-method-overloading
cd java-method-overloading
idea .
```


## Greetings, in English

We're building some software that welcomes people as they enter a room. You can run this code by adding it to `src/Person.java` (make sure to set your sources root!) Consider the class below:

```java
public class Person {
  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String greet() {
    StringBuilder builder = new StringBuilder();
    builder.append("Hi, ");
    builder.append(firstName);
    return builder.toString();
  }

  public static void main(String[] args) {
    Person dan = new Person("Dan", "Smith");
    Person susan = new Person("Susan", "Doe");

    System.out.println(dan.greet());
  }
}
```

Notice here, two peripheral items. First, we're using the `StringBuilder` class to build our greeting of a `Person`. It's a more object oriented approach to creating new strings, and it can lead to some performance benefits both in memory and computation if we're dealing with a large number of string operations. For most use cases, you can continue to use standard concatenation with a `+` sign, but we wanted to demonstrate the use of a `StringBuilder` here.

Secondly, we've placed a `static void main` in this class. For the purposes of experimenting, we can place our `static void main` inside the class we're building, allowing us to essentially "execute" the file.

In this code, we're maintaining `firstName` and `lastName` attributes as state. We define a `greet` method that effectively returns a string welcoming the `Person` by first name.

What happens, however, if we want to internationalize this application? We need a way to optionally specify a language for our greeting.

That's where method overloading comes into play. We can specify two variants for our `greet` method. One where we specify a language, and one where we default to English.

```java
public class Person {
  private String firstName;
  private String lastName;
  public static final String DEFAULT_LANGUAGE = "en";

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String greet() {
    return this.greet(DEFAULT_LANGUAGE);
  }

  public String greet(String language) {
    StringBuilder builder = new StringBuilder();
    if(language.equals("en")) {
      builder.append("Hi, ");
    }
    else {
      throw new Error("Language not supported");
    }
    builder.append(firstName);
    return builder.toString();
  }

  public static void main(String[] args) {
    Person dan = new Person("Dan", "Smith");
    Person susan = new Person("Susan", "Doe");

    System.out.println(dan.greet());
    System.out.println(susan.greet("es"));
  }
}
```

While we receive an exception with the example above, our overloading method is much more functional. Now, if we want to support more than 1 language, we can just add additional branches to our conditional.

```java
public String greet(String language) {
  StringBuilder builder = new StringBuilder();
  if(language.equals("en")) {
    builder.append("Hi, ");
  }
  else if(language.equals("es")) {
    builder.append("Hola, ");
  }
  else if(language.equals("fr")) {
    builder.append("Bonjour, ");
  }
  else {
    throw new Error("Language not supported");
  }
  builder.append(firstName);
  return builder.toString();
}
```

Unlike JavaScript, there is no way to define default values for arguments, so method overloading must be implemented like we have done above.

## Why This Matters

Method overloading is used constantly in Java. With a statically typed language, we can be more prescriptive in how we expect outside callers to use our methods. As class authors, it can also help us to write more flexible interfaces, providing outside callers with options on how to invoke our defined functions.

## In Summary

In order to call Java methods with a different number of arguments, or with different types of arguments, we must define the different variants separately, through a process known as overloading the method.
