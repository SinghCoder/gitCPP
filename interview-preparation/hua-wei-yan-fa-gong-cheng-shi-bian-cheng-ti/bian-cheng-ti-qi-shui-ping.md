# \[编程题\]汽水瓶



Question1

有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？  
  


**输入描述:**

```text
输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
```

**输出描述:**

```text
对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
```

**输入例子1:**

```text
3
10
81
0
```

**输出例子1:**

```text
1
5
40
```

Answer

```cpp

#include <iostream>

using namespace std;

int process(int value){
    int totalExchange =0;
    
    if (value <2)
        return 0;
    
    while(value >=3){
        int numExchange = value/3;
        totalExchange += numExchange;
        value = value % 3 + numExchange;
    }   
    
    if(value ==2){
        totalExchange +=1;
    }
    return totalExchange;
}

int main(){
    int value;
    cin>> value;
    while(value){
        cout << process(value) <<endl;
        cin >> value;
    }
    return 0;
}
```

Better one - using recursion

```cpp

/*
递归问题
3个瓶子换1瓶水+1个空瓶子，两个瓶子换1瓶水+0个空瓶子，1个瓶子换0瓶水。
f(1) = 0
f(2) = 1
f(3) = 1
f(4) = f(2)+1    //4个瓶子，其中3个可以换1瓶水+1个空瓶，所以是f(2)+1
f(5) = f(3)+1    //3个瓶子换1瓶水+1个空瓶，所以是f(3)+1
...
f(n) = f(n-2)+1 */
#include <iostream>
  
using namespace std;
  
int f(int n)
{
    if(n==1) return 0;
    if(n==2) return 1;
    return f(n-2)+1;
}
  
int main()
{
    int n;
    while(cin >> n){
        if(n==0)
            break;
        cout<<f(n)<<endl;
    }
    return 0;
}

```



