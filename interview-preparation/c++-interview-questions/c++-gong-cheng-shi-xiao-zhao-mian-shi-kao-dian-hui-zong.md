# c++工程师校招面试考点汇总

作者：牛妹  
链接：[https://www.nowcoder.com/discuss/164721?type=0&order=0&pos=16&page=0](https://www.nowcoder.com/discuss/164721?type=0&order=0&pos=16&page=0)  
来源：牛客网  
  


### **一、基础知识**

#### **1、基本语言**

**1、**[**说一下\*\*static关键字的作用\*\*** ](https://www.geeksforgeeks.org/static-keyword-cpp/)\*\*\*\*

Answer : static can be used on variables or functions.

static variables are initialised only once and saved on separate static storage. it can be put in functions or classes. 

static functions are independent from any object of the class. it can be called directly using the class name itself. static functions can only access static data members or other static member functions of the class

[2**、说一下C++和C的区别** ](https://www.geeksforgeeks.org/difference-between-c-and-c/)\*\*\*\*

Answer : C++ can be consider as a super set of C.

C++ is object oriented and procedure

C is only procedure

Based on the concept of a procedure call, Procedural Programming divides the program into procedures, which are also known as routines or functions, simply containing a series of steps to be carried out.

[**5、说一说c++中四种cast转换** ](https://www.geeksforgeeks.org/static_cast-in-c-type-casting-operators/)\*\*\*\*

dynamic cast - part of Run-Time type identification RTTI 

if issue happens, it returns NULL

```cpp
pB = dynamic_cast<B*>(&a;); // allowed but it returns NULL
```

static cast - compile time casting

```cpp

int main ( )
{
  
  int x = 5;

  string y = static_cast<string> (x); // will throw invalid cast during compile

  cout << y << endl;


  return 0;
}

```

const cast - removes constantness of a variable 

```cpp
const int x = 50;   // by right the value can not be changed
const int* y = &x;
cout<<"old value is"<<*y<<"\n";
int* z=const_cast<int *>(y);
*z=100;
cout<<"new value is"<<*y;
//Output: old value is 50
//new value is 100
```

reinterpret cast - can type cast any pointer to any other data type, byte-by-byte cast

```cpp
int main() 
{ 
    int* p = new int(65); 
    char* ch = reinterpret_cast<char*>(p); 
    cout << *p << endl; 
    cout << *ch << endl; 
    cout << p << endl; 
    cout << ch << endl; 
    return 0; 
} 

```

**6.** [**请说一下C/C++ 中指针和引用的区别？** ](https://www.geeksforgeeks.org/pointers-vs-references-cpp/)\*\*\*\*

pointer is a variable that holds memory address of another variable. 

can be re-assigned. 

pointer has it's own memory address.

pointer can accept null

reference is an alias to existing variable. can not be re-assigned 

reference shares the same memory address with the variable

reference doesnt accept null



7、给定三角形ABC和一点P\(x,y,z\)，判断点P是否在ABC内，给出思路并手写代码   
8、怎么判断一个数是二的倍数，怎么求一个数中有几个1**，**说一下你的思路并手写代码

[**9、请你说一下你理解的c++中的smart pointer四个智能指针：**](https://www.geeksforgeeks.org/smart-pointers-cpp/)\*\*\*\*

Answer  :

shared\_ptr

unique\_ptr

[weak\_ptr](https://www.modernescpp.com/index.php/std-weak-ptr) -&gt; temporary ownership , borrows resource from shared\_ptr. it can help to bereak cyclic reference of shared\_ptr;

auto\_ptr \(deprecated in c++ 11\)

\*\*\*\*[**10、请回答一下数组和指针的区别**](https://www.programming-techniques.com/2011/08/difference-between-array-and-pointer-in-c-c.html)\*\*\*\*

Answer:

array is a single, pre-allocated contigous elements of fixed size. 

pointer is a place in memory that keeps the address of another place inside 

\*\*\*\*[**11、请你回答一下野指针是什么？**](https://www.geeksforgeeks.org/what-are-wild-pointers-how-can-we-avoid/) 

what is wild pointer ?

it's uninitialised pointer because they pointe to some arbitary memory location 

```cpp
int * p;

```



\*\*\*\*[**13、请你回答一下\*\*智能指针有没有内存泄露的情况** ](https://stackoverflow.com/questions/38298008/possible-memory-leaks-with-smart-pointers)\*\*\*\*

can smart pointer cause memory leak ?

Answer : 

yea. if you have circular link, then memory will not be freed 

void function\(std::unique\_ptr\(new A\(\)\), std::unique\_ptr\(new B\(\)\)\) { ... } --&gt; if you dont use make\_shared, if any exception is thrown in B, then A will not be released.

To Fix - use weak\_ptr, and make\_shared 

**17、**[**请你回答一下为什么析构函数必须是虚函数**](https://www.geeksforgeeks.org/virtual-destructor/)**？**[**为什么C++默认的析构函数不是虚函数** ](https://stackoverflow.com/questions/1117481/can-the-default-destructor-be-generated-as-a-virtual-destructor-automatically)\*\*\*\*

[why destructor should be declared as virtual ?](https://www.geeksforgeeks.org/virtual-destructor/)

answer :

base class's destructor should always be virtual to ensure child's destructor will be called 

[why destructor is not default as virtual ?](https://stackoverflow.com/questions/1117481/can-the-default-destructor-be-generated-as-a-virtual-destructor-automatically)

There is a cost associated with making a method virtual, and C++ has a philosophy of not making you pay for things that you don't explicitly state that you want to use. If a virtual destructor would have been generated automatically, you would have been paying the price automatically.

\*\*\*\*[**18. difference between inline vs Macro**](https://www.programmerinterview.com/c-cplusplus/inline-vs-macro/)

inline functions are parsed by compiler, macros are expanded by C++ preprocessor \(simple text replacement\).

for inline functions, whenever it finds a call to inline functions, it writes a copy of compiled function definition, for regular function, a normal function call is generated.  

macro is dangerous and hard to debug since it's text replacement

```cpp
#define Double(X) X*X

int y = 3;
int j = Double(++y) == Double(++y * ++y)

```

**18**、**请你来说一下**函数指针 

**1**9**、**请你来说一下**\*\*fork函数**

**20**、**请你来说一下C++中**析构函数的作用\*\* 

**21、请你来说一下静态函数和虚函数的区别**

**22、请你来说一说重载和覆盖**

**23、请你来说一说static关键字**

**24.、请你说一说strcpy和strlen**

**25、请你说一说你理解的虚函数和多态**

**26、请你来回答一下++i和i++的区别**

**27、请你来说一说++i和i++的实现**

**28、请你来写个函数在main函数执行前先运行**

**29、有段代码写成了下边这样，如果在只修改一个字符的前提下，使代码输出20个hello?**

**30、请你来说一下智能指针shared\_ptr的实现**

**31、以下四行代码的区别是什么？**

**32、请你来说一下C++里是怎么定义常量的？常量存放在内存的哪个位置？**

**33、请你来回答一下const修饰成员函数的目的是什么？**

**34、如果同时定义了两个函数，一个带const，一个不带，会有问题吗？**

**35、请你来说一说隐式类型转换**

**36、说说你了解的类型转换**

**37、请你来说一说C++函数栈空间的最大值**

**38、请你来说一说extern“C”**

**39、请你回答一下new/delete与malloc/free的区别是什么**

**40、请你说说你了解的RTTI**

**41、请你说说虚函数表具体是怎样实现运行时多态的?**

**42、请你说说C语言是怎么进行函数调用的？**

**43、请你说说C语言参数压栈顺序？**

**44、请你说说C++如何处理返回值？**

**45、请你回答一下C++中拷贝赋值函数的形参能否进行值传递？**

**46、请你回答一下malloc与new区别**

**47、请你说一说select**

**48、请你说说fork,wait,exec函数**

**49、请你回答一下静态函数和虚函数的区别**

**50、请你说一说重载和覆盖**

**51、请你说一说static关键字**

**52、请你说一说strcpy和strlen**

#### **2、容器和算法**

**1、请你来说一下**map和set有什么区别，**分别又是**怎么实现的 

**2、**请你来**介绍一下**STL的allocaotr 

**3、请你来说一说**STL迭代器删除元素 

**4、请你说一说STL中MAP数据存放形式**

**5、请你讲讲STL有什么基本组成**

**6、请你说说STL中map与unordered\_map**

**7**、**请你说一说**vector和list的区别，应用，越详细越好\*\* 

**8**、**请你来说一下**STL中迭代器的作用，有指针为何还要迭代器\*\* 

**9、请你说一说epoll原理**

**10、请你说一说STL迭代器是怎么删除元素的呢**

**11、请你说一说STL中MAP数据存放形式**

**12、n个整数的无序数组，找到每个元素后面比它大的第一个数，要求时间复杂度为O\(N\)**

**13、请你回答一下STL里resize和reserve的区别14**、**请你说一说**stl里面set和map怎么实现的   


#### **3、类和数据抽象**

**1.**请你来说一下**C**++**\*\*中类成员的访问权限**

**2、请你来说一下C++中struct和class的区别3、请你回答一下C++类内可以定义引用数据成员吗？**  


#### **4、面向对象与泛型编程**

**1、请你回答一下\*\***什么是右值引用，跟左值**又**有什么区别？   


#### **5、编译与底层**

1、 **请你来说一下**一个C++源文件从文本到可执行文件经历的过程**？**

2、 **请你来回答一下**include**头文件的顺序以及双引号**””**和尖括号**的区别？ 

3、 **请你回答一下**malloc的原理**，**另外**brk系统调用**和m**map**系统调用的作用分别是什么？ 

4、 **请你说一说**C++的内存管理**是怎样的**？ 

**5、请你来说一下**C++/C的内存分配 

**6、请你回答一下\*\***如何判断内存泄漏？ 

**7**.**请你来说一下**什么时候会发生段错误 

**8**、**请你来回答一下什么是**memory leak**，**也就是**内存泄漏**

**9**、**请你来回答一下**new和malloc的区别 

**1**0**、**请你来说一下_共享内存相关api_ 

**11、请你来说一下**reactor模型组成 

**12、请\*\***自己设计**一下**如何采用单线程的方式处理高并发 

**13、请你说说**C++如何处理内存泄漏？ 

**14**、**请你说说**select，epoll的区别**，**原理，性能，限制都说**一**说 **15、请你说一说**C++ STL **的**内存优化   


#### **6、C++11**

**1、请问**C++11有哪些新特性**？2、请你**详细介绍一下C**++11**中的**可变参数模板**、**右值引用**和**lambda**这几个新特性。   


### 二、**操作系统**

**1**、**请你说一下**进程与线程的概念，**以及**为什么要有进程线程，其中有什么区别，他们各自**又是**怎么同步的 

**2**、**请你说一说**Linux虚拟地址空间 

**3**、**请你说一说操作系统中的**程序的内存结构 

**4**、**请你说一说操作系统中的**缺页中断 

**5**、**请你回答一下**fork和vfork的区别 

**6**、**请问**如何修改文件最大句柄数？ 

**7**、**请你说一说**并发\(concurrency\)和并行\(parallelism\) 

**8**、**请问**MySQL的端口号是多少，如何修改这个端口号 

**9**、**请你说一说操作系统中的**页表寻址 

**10、请你说一说\*\***有了进程，**为什么**还**要有线程**？ 

**11**、**请问**单核机器上写多线程程序，是否需要考虑加锁，为什么？ 

**12**、**请问**线程需要保存哪些上下文，SP、PC、EAX这些寄存器是干嘛用的 

**1**3**、**请你说一说**\*\*线程间的同步方式，最好说出具体的系统调用**

**14**、**请你说一下**多线程和多进程的不同 

**15、请你说一说\*\***进程和线程**的**区别 

**16、**游戏服务器应该为每个用户开辟一个线程还是一个进程，为什么？ 

**17、请你说一说**OS**缺页置换算法**

**18、请你说一说\*\***进程和线程区别 

**19**、**请你说一下**多进程和多线程的使用场景 

**20**、**请你说一说**死锁发生的条件以及如何解决死锁 

**21**、**请问**虚拟内存和物理内存怎么对应 

**22**、**请你说一说操作系统中的**结构体对齐，字节对齐 

**23**、**请问**进程间怎么通信 

**24、**请你说一下**虚拟内存置换的方式**

**25**、**请你说一下**多线程，线程同步的几种方式 

**26**、**请你讲述一下**互斥锁（**mutex）机制**，**以及**互斥锁和读写锁的区别 

**27**、**请回答一下**进程和线程的区别 

**2**8**、**请你说一说**进程状态转换图，动态就绪，静态就绪，动态阻塞，静态阻塞**

**2**9_**、A**_**a = new A; a-&gt;i = 10;在内核中的内存分配上发生了什么？**

**30**、给你一个类，里面有static，virtual，之类的，**来说一说**这个类的内存分布 

**31、请你回答一下**软链接和硬链接区别 

**32、请问**什么是大端小端以及如何判断大端小端 

**33**、**请你回答一下**静态变量什么时候初始化 

**3**4**、**请你说一说**\*\*用户态和内核态区别**

**35、请问如何设计server，使得能够接收多个客户端的请求**

**36、死循环+来连接时新建线程的方法效率有点低，怎么改进？**

**37、请问怎么唤醒被阻塞的socket线程？**

**38、请问怎样确定当前线程是繁忙还是阻塞？**

**39、空闲的进程和阻塞的进程状态会不会在唤醒的时候误判？**

**40、请问就绪状态的进程在等待什么？**

**41、请你说一说多线程的同步，锁的机制**

**42、两个进程访问临界区资源，会不会出现都获得自旋锁的情况？**

**43、假设临界区资源释放，如何保证只让一个线程获得临界区资源而不是都获得？**

**44、windows消息机制知道吗，请说一说**

**45、C++的锁你知道几种?**

**46、说一说你用到的锁**

**47、请你说一说死锁产生的必要条件？**

**48、**请你说一说**什么是线程和进程，多线程和多进程通信方式**

**49、**请你说一说**\*\*内存溢出和内存泄漏**

**50、进程和线程的区别，你都使用什么线程模型**

**51、**请你来说一说**协程**

**52、系统调用是什么，你用过哪些系统调用  
53、**请你来**手写**一下**fork调用示例**

**54、**请你来说一说**用户态到内核态的转化原理**

**55、**请你说一下**源码到可执行文件的过程**

**56、**请你来说一下**微内核与宏内核  
57、请你说一下僵尸进程**

**58、请问GDB调试用过吗，什么是条件断点**

**59、请你来介绍一下5种IO模型**

**60、请你说一说异步编程的事件循环**

**61、请你回答一下操作系统为什么要分内核态和用户态**

**62、请你回答一下为什么要有page cache，操作系统怎么设计的page cache**

**63、server端监听端口，但还没有客户端连接进来，此时进程处于什么状态？**

**64、请问如何设计server，使得能够接收多个客户端的请求**

**65、死循环+来连接时新建线程的方法效率有点低，怎么改进？**

**66、就绪状态的进程在等待什么？**

**67、请你说一下多线程的同步，锁的机制**

**68、两个进程访问临界区资源，会不会出现都获得自旋锁的情况？**

**69、假设临界区资源释放，如何保证只让一个线程获得临界区资源而不是都获得？**

**70、请问怎么实现线程池**

**71、Linux下怎么得到一个文件的100到200行**

**72、**请你来说一下**awk的使用**

**73、**请你来说一下l**inux内核中的Timer 定时器机制**

### 三、**计算机网络**

**1.你的研究方向是无线传感器网络，\*\***请问**\*\*怎么确保节点传输存储的可靠性**

**2.请你说一下\*\***TCP怎么保证可靠性，**并且**简述**一下**TCP建立连接和断开连接的过程 

**3**、**请你说一说**TCP的模型，状态转移 

**4**、**请回答一下**HTTP和HTTPS的区别，**以及**HTTPS有什么**缺点？**

5、请你说一说HTTP和HTTPS的不同 

**6**.**请你说一说**HTTP**返回码**

**7**.**请你说一说**IP**地址作用**，**以及**M**AC**地址作用 

**8、请**介绍一下**操作系统中的**中断 

**9**.**请回答**OSI**七层模型和T**CP/IP**四层模型，每层列举2个协议**

**10**、**请你说一说**TCP**的三次握手和四次挥手的过程及原因**

**11、搜索baidu，会用到计算机网络中的什么层？每层是干什么的**

**12、**请你说一说**TCP拥塞控制？**以及**达到什么情况的时候开始减慢增长的速度？**

**13、**请问T**CP用了哪些措施保证其可靠性**

**14、请你说说\*\***TCP/IP数据链路层的交互过程 

**15、请你说说传递到IP层怎么知道报文该给哪个应用程序，它怎么区分UDP报文还是TCP报文**

**16、请问你有没有基于做过socket的开发？具体网络层的操作该怎么做？（其实就是网络编程的基本步骤）**

**17、请问server端监听端口，但还没有客户端连接进来，此时进程处于什么状态？**

**18、请问TCP三次握手是怎样的？**

**19、请问tcp握手为什么两次不可以？为什么不用四次？**

**22、请你来说一下TCP拥塞控制？**

**20、TCP和UDP的区别和各自适用的场景**

**21、**请你来说一下**TCP三次握手四次挥手的过程，为什么tcp连接握手需要三次, time\_wait状态**

**22、请你来说一说http协议**

**23、**请你来说一下**GET和POST的区别**

**24、**请你来说一下**socket编程中服务器端和客户端主要用到哪些函数**

**25、**请你来说一下**\*\*数字证书是什么，里面都包含那些内容**

**2**6**、**请你来**介绍**一下UDP**的connect函数**

**27、请你讲述一下TCP三次握手，四次挥手，以及为什么用三次握手？**

**28、请你说一下阻塞，非阻塞，同步，异步**

**29、请你讲述一下Socket编程的send\(\) recv\(\) accept\(\) socket\(\)函数？**

**30、请你说一下http协议会话结束标志怎么截出来？**

**31、请你说一说三次握手**

**32、请你说一说四次挥手**

**33、请你说一说TCP/IP数据链路层的交互过程**

### 四、**数据库**

#### 1、数据库基础 

**1.**请你说一下**数据库事务以及四个特性**

**2**.**请你说一说**数据库的三大范式\*\* 

**3请你**介绍一下数据库的A**CID**特性\*\* 

**4、请你说一说数据库索引**

**5、请你说一说数据库事务**

**6、请你说一说数据库事务隔离**

**7、请你说一说inner join和left join**

**8、请你聊一聊\*\***数据库事物的一致性 

**9、请你说说\*\***索引是什么**，**多加索引一定会好吗 

**10、k-v存储中，key有哪些要求？11、介绍数据库中的WAL技术**  


#### 2、Mysql 

**1**.**请你说一说**mysql**的**四种隔离状态 

**2**.**请你**介绍一下m**ysql**的M**VCC**机制 

**3、请问**S**QL**优化方法有哪些 **4、请你说一下**MySQL引擎和区别   


#### 3、Redis 

**1**.**请你回答一下**mongodb**和**redis**的**区别 

**2**.**请你说一下**mysql引擎**以及其**区别 

**3**、**请你来说一说**Redis的定时机制怎么实现的 

**4**、**请你来说一说**Redis是单线程的，**但是**为什么这么高效**呢**? 

**5**、**请问**Redis的数据类型有哪些，底层怎么实现**?**

**6**、**请问**Redis的rehash怎么做的，为什么要渐进rehash，渐进rehash**又是**怎么实现**的?**

**7**、**请你来说一下**Redis和memcached的区别 

**8、请问**Redis怎么实现的定期删除功能 

**9、**请你说一说**\*\*Redis对应的命令和数据类型...**

### **五、算法与数据结构**

#### 1、树 

**1**.**请你来说一说**红黑树和AVL树的定义，特点，以及二者区别 

**2、请你聊一聊哈夫曼编码**

**3**、**请你回答一下**map底层为什么用红黑树实现 

**4、请你**介绍一下**B+**树 

**5、请你说一说**map和u**nordered\_map**的**底层实现**

**6、请你回答一下**m**ap**和u**nordered\_map**优点和缺点 

**7、请你回答一下**epoll怎么实现的 

**8、请你说一说**C++两种map 

**9、请问红黑树了解吗**

**10、请你说一说**红黑树的性质还有左右旋转 

**11、请你说一说\*\***红黑树的原理以及erase以后迭代器的具体分布情况？ 

**12、请你实现二叉树的层序遍历并输出13、手写代码：二叉树序列化反序列化**  


#### 2、堆与栈 

**1**、**请说一说你理解的**stack overflow，并举个简单例子导致栈溢出 

**2、请你回答一下**栈和堆的区别，**以及**为什么栈要快 

**3、手写代码：两个栈实现一个队列**

**4**、**请你来说一下**堆和栈的区别 **5、请你说一说**小根堆特点   


#### 3、数组 

**1、请你回答一下\*\***Array&List， 数组和链表的区别 **2.一个长度为N的整形数组，数组中每个元素的取值范围是\[0,n-1\],判断该数组否有重复的数，请说一下你的思路并手写代码**  


#### **4、排序**

**1、请你来手写一下\*\***快排**\*\*的代码**

**2、请你手写一下\*\***快排**\*\*的代码**

**3.**请问**求第k大的数的方法以及各自的复杂度**是怎样的，另外追问一下，**当有相同元素时，还可以使用什么不同的方法求第k大的元素**

**4**、**请你来**介绍**一下**各种排序算法及时间复杂度 

**5、**请你说一说你知道的**\*\*排序算法及其复杂度**

**6、请问**海量数据如何去取最大的k个 

**7**、**请你说一说**T**op**\(K\)**问题**

**8、请问**快排的时间复杂度最差是多少？什么时候时间最差 

**9、请问稳定排序哪几种？**

**10、请你**介绍**一下**快排算法；**以及**什么是稳定性排序，快排是稳定性的吗；快排算法最差情况推导公式   
****

#### **5、哈希**

**1、请你来说一说**hash表的实现，包括STL中的哈希桶长度常数。 

**2**、**请你回答一下**hash表如何rehash，**以及**怎么处理其中保存的资源 

**3、请你说一下**哈希表的桶个数为什么是质数，合数有何不妥？ 

**4、请你说一下**解决h**ash**冲突的方法 **5、请你说一说**哈希冲突的解决方法   


#### **6、动态规划**

**1、请你手写代码：**最长公共连续子序列 

**2、手写代码：**求一个字符串最长回文子串 **3、手写代码：**查找最长回文子串   


#### **7、链表**

**1.**请你手写代码，如何**合并两个有序链表**

**2、手写代码：反转链表**

**3、**判断一个链表是否为回文链表**，**说出你的思路并手写代码 

**4、请你**手写链表反转 **5、**什么是单向链表，如何判断两个单向链表是否相交   


#### **7、高级算法**

**1**、**如果让**你**做自然语言理解（NLU），在处理语言规则的时候大概会用到什么算法**

**2、请问**加密方法都有哪些 

**3、**什么是LRU缓存 **4、请你说一说**洗牌算法   


#### **8、字符串**

**1、给你一个字符串，找出第一个不重复的字符，如“abbbabcd”，则第一个不重复就是c**  


### **六、项目相关**

**1、请你回答一下**git中Merge和rebase区别 

### **七、设计模式**

**1、请问你**用过哪些设计模式，**介绍一下**单例模式的多线程安全问题 

**2、请问你**了解哪些设计模式？ 

**3、请问**如何保证单例模式只有唯一实例？**你知道的都**有哪些方法？ 

**4**、**请你说一说**OOP的设计模式**的**五项原则 

**5、请你说说\*\***工厂模式的优点？ 

**6、请你说一下观察者模式**

**7、请你介绍一下单例模式**

**8、单例模式中的懒汉加载，如果并发访问该怎么做？**

**9、**装饰器模式和单例模式，使用单例模式应该注意什么 

### **八、场景题**

**1、**给你两个球，100层楼，每个球在一定高度扔下去会碎，怎么用最少的次数给判断是几层楼能把求摔碎？ 

### **九、分布式与架构**

**1、**分布式缓存和分布式存储的设计

