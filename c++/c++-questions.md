---
description: 'https://github.com/huihut/interview/blob/master/README_en.md'
---

# C++ questions

[When do we need to use initialisation list ?](https://www.geeksforgeeks.org/when-do-we-use-initializer-list-in-c/)

* for initialisation of non-static const data members 
* for initialisation of reference members 
* for initialisation of objects which do not have default constructor 
* for initialisation of base class members 

when should we use explicit constructor ?

* to avoid behind-the-scene type conversions.

**const**  

```cpp
#include <iostream>
#include <bit>
using namespace std;

int main(){

  int x = 5;
  
  // const int means int value itself can not change 
  // const y means the pointer y can not be pointed to another variable 
    
  const int * const y = &x;   
  
  int g = 6;

  * y = 6;

  cout << * y<< endl;
}
```

**Static** 

* make the variable stored in the static area, allocate space before the main function runs 
* decorate member variables so that all objects hold only one of the variable 
* decorate member functions so that they can be accessed without generating objects

**Inline function** 

* writing the contents of the function at the call of inline function 
* equivalent to macro , but with more type checking than a macro 
* function defined in class declarations other than virtual functions are automatically treated as inline 
* advantages \(avoid putting parameters on the stack , improving execution speed, performs security check, debuggable at runtime\)
* disadvantages \(code bloat, changes to inline function requires recompilation\) 
* inline or not depends on compiler, it's just a suggestion to compiler.

can a virtual function be an inline function ?

answer -&gt; only when compiler knows the implementation at compile time, if it has polymorphism , then it can not do inline.

**Volatile** 

* type modifier to tell compiler that objects should not be optimized and must be fetched from memory each time.

**Explicit** 

* prevents implicit conversion and copy initialization

**Enum vs Enum class** 

**Decltype** 

* used to check the declared type and value classification fo an entity 

**Reference** 

* Lvalue reference 
* Rvalue reference \( reference bound to rvalue , which implements Move and Perfect forwarding\) 

**OOP Concepts**

* Encapsulation \(private, protect, public\)
* polymorphism \( Static vs Dynamic -&gt; virtual pointer\)
* inheritance 

**VTable** 

* each class object if it implements a virtual function, will have a virtual pointer that pointers to a virtual function table , the table is in the program read-only data section.

\*\*\*\*[**Virtual inheritance** ](https://en.wikipedia.org/wiki/Virtual_inheritance)\*\*\*\*

* resolve diamond inheritance issue 

**Memory allocation and Management** 

* malloc & free 
* New & delete \( underlying it calls malloc and free to allocate and remove the memory usage\)

**How to define class to generate objects on the heap / on the stack only ?**

* only on the heap \( make destructor private, complier allocates stack space by first checking destructor accessibility \) 
* on the stack \( overload new and delete as private\) 

**Smart Pointer** 

* shared\_ptr
* unique\_ptr
* weak\_ptr -&gt; allows you to share but does not own the object

**Casting** 

* static\_cast
* dynamic\_cast
* const\_cast
* reinterpret\_cast 

Runtime Type Information \(RTTI\)

