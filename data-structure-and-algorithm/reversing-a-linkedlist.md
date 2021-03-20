# Reversing a LinkedList

[https://www.geeksforgeeks.org/reverse-a-linked-list/](https://www.geeksforgeeks.org/reverse-a-linked-list/)

```text
while (curr){

    next = curr -> next;
    curr -> next = prev;
    prev = curr;
    curr = next;

}

return prev;
```

