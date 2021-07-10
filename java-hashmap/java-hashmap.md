We've learned that arrays are useful for storing sequential lists of data. The index by which you access the item in the list has meaning. Sometimes, as programmers, we want to access our data in a different way.

In this article, we'll explore the `HashMap` in Java and study how it can be used differently from Arrays.

## Learning Goals

- Initialize a `HashMap`
- Place a key and value into a `HashMap`
- Access a `HashMap` value
- Iterate through a HashMap by enumerating keys
- Discuss the pluses and minuses of the `Map` classes

## Why We Need Associative Arrays

Let's imagine we wanted to correlate a list of book titles with their authors. Code wise, this gets awkward pretty fast.

```java
List<String> bookTitles = new ArrayList<String>();
List<String> authors = new ArrayList<String>();

bookTitles.add("War of Honor");
authors.add("David Weber");

bookTitles.add("Hard Magic");
authors.add("Larry Correia");
```

Basically, we **could** maintain two Arrays for two separate, but related pieces of data. But, what happens if the length of my `bookTitles` array is a different length than my `authors` array? What happens if I want to remove a book title from the list?

These are all valid questions, particularly as we add features to our software. So, what is a Java developer to do?

Well, thankfully, like in most programming languages we can create what is known as an associative array. We can link the book title to the author directly. In other languages, this type of data structure is referred to as a Hash or an Associative Array. In Java, we use what's called a `HashMap`.

## What is a HashMap?

A [HashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html) is different from `ArrayList`, focusing on pairing a key with a value. The key is important since it is what we will use to access the value. Where `ArrayList` is a sequential list of values that can be accessed by numeric index, a `HashMap` allows us to access a value based on its associated counterpart. For example, if I wanted to have a series of books and authors, I could have the author as the value and the book title as the key. With this in mind, let's go through the `HashMap` class.

A `HashMap` is a `Map` that uses the _keys_ to store _values_. This is normally very fast. A hash is the process of "hashing" the key to get a value. Think of the `HashMap` as a series of buckets. Each bucket is labeled with a key and can hold a value. When you want to get a value, look at the label on the bucket and return the value. You can also get a set of the keys if you want.

Let's say, I wanted to create a program that holds my book list. The first thing I would have to do is create a `HashMap`.

```Java
Map<String,String> bookList = new HashMap<String, String>();
```

Notice again, that we're programming by interface here. `HashMap` implements the `Map` interface, so we assign our `HashMap` instance to a `Map` variable.

Also notice that we're using generics here to signify that we're mapping `String` values by `String` keys. In Java and with `HashMap` instances, we can use any arbitrary object as a key. In our examples, we'll stick to the `String`. This is so common, that in later versions of Java, a shortcut was added.

```java
Map<String,String> bookList = new HashMap<>();
```

If we want to add a book to our hash map, we can leverage the `put` method:

```java
bookList.put("War of Honor", "David Weber");
```

Notice that I used the title of the book as the key and the author as the value. The order of these arguments is extremely important!

Now, to be able to get the author of a book, all I need to do is:

```Java
String author = bookList.get("War of Honor");
```

What happens if I try to access the author of a book that is not in the `HashMap`?

```java
System.out.println(bookList.get("Welcome to Deadhouse"));
```

This will output `null`.

If we were to sell a book, it can be removed from the data structure:

```java
String author = bookList.remove("War of Honor");
```

If you want to remove all the books from my list, I can use `clear()`.

```Java
bookList.clear();
```

## Iterating Through a HashMap

### Getting the keySet

If you want to retrieve a collection of the keys, use the `keySet` of the `Map`, which is a `Set`.

The code below will assign our list of book titles to the `titles` `Set`.

```Java
Set<String> titles = bookList.keySet();
```

A `Set` is yet another interface in Java. It's a collection that has a unique set of values.

### Getting the valueSet

Similarly, if we want a collection of the values, use the `values` of the `Map`.

```Java
Collection<String> authors = bookList.values();
```

The distinction here is that we **can** have duplicate values in our collection. While keys in our `HashMap` must be unique, we can have the same value appear twice in the `HashMap` under different keys. So, we can't assign our list of values to a `Set` instance.

### Iterating Through

All `Collection` implementers also implement the `Iteratable` interface. As of Java 5, classes that implement the `Iteratable` interface can use a special version of the `for` loop, which we have seen before!

```java
//prints out every title in the `bookList` HashMap
Set<String> titles = bookList.keySet();
for(String title : titles) {
  System.out.println(title);
}
```

We _do_ have the option to use a `for` loop to iterate through each of our key-value **pairs**. This looks like the below, where we use `entrySet()` to get a grouping of our pairs:

```java
for(Map.Entry<String, String> bookAuthorPair : bookList.entrySet()) {
  String title = bookAuthorPair.getKey();
  String value = bookAuthorPair.getValue();
}
```

This is quite ugly and uncommon, though. It requires a lot of code when we could accomplish the same goal with less syntax by using our `get` method and our collection of titles.

```java
for(String title : titles) {
  System.out.println(title + ": " + bookList.get(title));
}
```

## In Summary

The `HashMap` allows us to relate two pieces of data together as a key-value pair. Java provides us with a rich set of methods to manipulate and traverse this data structure. Each key in a `HashMap` must be unique, but we can have duplicate values in the data structure.

We can use a special version of the `for` loop to iterate through an implementer of `Collection`.
