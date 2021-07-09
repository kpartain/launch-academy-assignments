Java supports several data structures. Just like any skilled professional, it's important for us to consider the right tool for the job. In this article, we'll study the `LinkedList` and compare it to the `ArrayList`.

## Learning Goals

- Instantiate and manipulate a `LinkedList`
- Discuss the queue data structure
- Address errors coming from the `LinkedList` object

## Array Performance Considerations

We store and interact with information in our programs as **data**. The way that we structure our data varies depending on how we plan to use it. Will we primarily be reading or writing data? Do we need to insert data in arbitrary positions or can we just keep appending to the end? Does this data need to be kept sorted in any particular order? Questions like these and others will often dictate the **data structures** we use in our programs.

Thus far, when it comes to storing `List`s, we've relied heavily on the `ArrayList`. The performance of accessing individual elements by index is strong. But, what about manipulating the list? Let's consider the following code:

```java
ArrayList<Integer> numList = new ArrayList<Integer>();
numList.add(8);
numList.add(2);
numList.add(3);
numList.add(7);

//expensive
numList.add(1, 5);
```

Here, our last `add()` call inserts `5` at index `1`. Adding a value in the middle of the `ArrayList` requires us to **shift** all values after what we're inserting. So, in this case, `2`, `3` and `7` must be moved to higher indexes to make room for the `5` value. As our list grows, this gets increasingly expensive. So, if we're writing to or removing items from lists often, we may want to consider an alternative data structure.

## What is a Linked List?

[Linked lists][linked_lists] are ordered collections of **nodes** that store two pieces of data. Each node stores its value as well as a reference to the next node in the collection.

Appreciating the benefit of the `LinkedList` requires an understanding of what, and how much, work our system is doing behind the code. For example: we know that with arrays, our system is using the _index_ to keep track of which element comes first, second, third, etc in our array. It simply takes all elements and puts them in a line - which is why inserting one element somewhere in the middle requires so much work (updating the index of that element and all that come after it).

A `LinkedList`, on the other hand, doesn't worry about keeping the items in a line so that it can keep track of the order. Rather than having to keep track of the index of ALL elements to remember the order, it just tells each individual node to keep track of who comes after it.

![Linked List Order Diagram][linked_list_order_diagram]

> Array objects stored at consecutive memory addresses vs. linked list objects stored anywhere. Courtesy of [Jill Pratts][jill_pratts_article]

By storing the position of the next node we can iterate through the entire list by repeatedly grabbing the next node in the chain. Since each node has a reference to its neighbor, we don't need to keep the nodes adjacent to each other in memory. If we had a linked list with four elements it might look something like the following:

![Linked List Structure][linked_list_structure_image]

This gives us a bit more freedom about where to store our nodes but it does come at a cost: if we only store the location of the first node, how do we access random elements from the list? For example, if we wanted to see what the value the fourth node contains, we'd have to start at the beginning, jump to the second node, then the third node, and finally end up at the fourth. If our list was 1000 nodes long, we'd have to make 1000 jumps to get to the last node.

As we've mentioned, there are strengths and weaknesses to each type of `List` we can use, and our job as developers is to figure out the best tool for the job. As discussed above, our `LinkedList`s aren't great at accessing random elements in our list: which means that `ArrayList`s end up being more efficient at _accessing_ elements. However, `LinkedList`s are more efficient at _inserting_ or _deleting_ elements, thanks to the way they keep track of positioning. When we are inserting or deleting nodes within the list, we only need to update the pointer to the next node rather than shifting around a whole bunch of elements. For example, to insert the value _5_ in the second position (e.g. `add(1, 5)`), we just have to change two links in the chain as shown in the following:

![Inserting a node in a linked list][linked_list_insert_image]

### The LinkedList in Java

Thankfully, we don't have to worry too much about these implementation details. Java supplies with a `LinkedList` class. This class implements a [Doubly Linked List][doubly-linked-list], which is well optimized for insertion and deletion. Where nodes in a traditional LinkedList point to the next value, a doubly linked list points to both the previous value and the next value.

In making our decision about which tool to use, we can consider how we will be interacting with our list. Typically, if you're managing a list that is frequently manipulated, you should consider using a [LinkedList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html).

## Using a LinkedList as a Queue

The `LinkedList` class implements the `Queue` interface. A Queue, as you might already be familiar from queueing up at the Post Office, is simply an ordered list of items (or people). You `add()` to the queue at the end, and you `poll()` the queue from the front. We can also `peek()`, which should show us what is at the front of the queue, and we can use `isEmpty()` to tell us if there is anyone or anything left in line.

We call this a First-In, First-Out (FIFO) data structure.

Let's implement our `readingList` using this data structure, where the front of the line represents the book we're currently reading.

```Java
LinkedList<String> readingList = new LinkedList<>();
```

This gives us a working object to use. If we want to add something to it, we `add()` the data to the queue.

```Java
readingList.add("On Basilisk Station");
readingList.add("Hard Magic");
```

If we want to see the head of the queue, but not remove it, we can use `peek()`.

```Java
System.out.println("Currently Reading: " + readingList.peek());
```

The data structure will be unchanged. If we want to remove the book we were reading after we're done, we can call `poll()`, which will both return the item at the front of the line, and remove it from the queue.

```Java
System.out.println("Finished Reading: " + readingList.poll());
```

### External Resources

- [Wikipedia: Dynamic Arrays][dynamic_arrays]
- [Wikipedia: Linked Lists][linked_lists]
- [Wikipedia: Linked Lists vs Dynamic Arrays][linked_list_vs_dynamic_array]
- [Wikipedia: Variations of Linked Lists][linked_list_variations]

[binary_search_tree]: http://en.wikipedia.org/wiki/Binary_search_tree
[dynamic_arrays]: http://en.wikipedia.org/wiki/Dynamic_array
[jill_pratts_article]: https://medium.com/@jillplatts/6-minute-beginners-guide-to-java-s-linked-list-data-structure-bb2fbcca81b1
[linked_lists]: http://en.wikipedia.org/wiki/Linked_list
[linked_list_insert_image]: https://s3.amazonaws.com/horizon-production/images/article/java-linkedlist/linked_list_insert.png
[linked_list_order_diagram]: https://s3.amazonaws.com/horizon-production/images/article/java-linkedlist/linked_list_order_diagram.png
[linked_list_structure_image]: https://s3.amazonaws.com/horizon-production/images/article/java-linkedlist/linked_list_structure.png
[linked_list_vs_dynamic_array]: http://en.wikipedia.org/wiki/Linked_list#Tradeoffs
[linked_list_variations]: http://en.wikipedia.org/wiki/Linked_list#Basic_concepts_and_nomenclature
[doubly-linked-list]: https://en.wikipedia.org/wiki/Doubly_linked_list
