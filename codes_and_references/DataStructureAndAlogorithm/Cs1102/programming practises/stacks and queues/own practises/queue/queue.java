class queue{
  private Object[]arr;
  private int front,back;
  private int maxSize;
  private final int InitialSize=1000;
  
  public queue(){
    arr= new Object[InitialSize];
    front =0; 
    back = 0;
    maxSize=InitialSize;
  }
  
  public boolean isEmpty(){
    return (front==back);
  }
  
  public Object dequeue()throws Underflow{
    Object object = getFront();
    front= (front+1)%maxSize;
    return object;
  }
  
  public Object getFront()throws Underflow{
    if(isEmpty()){
      throw new Underflow("invalid operation on empty q");
    }
    else{
      return arr[front];
    }
  }
  
  public void enqueue (Object o){
    if(((back+1)%maxSize)==front){
      enlargeArr();
    }
      arr[back]=o;
      back = (back+1)%maxSize;
  }
  
  public  void enlargeArr(){
    int newSize = maxSize*2;
    Object[]x=new Object[newSize];
    for(int j=0; j<maxSize;j++){
      x[j]= arr[(front+j)%maxSize];
    }
    front= 0;
    back= maxSize-1;
    maxSize= newSize;
    arr=x;
  }
}

class Underflow extends Exception{
  public Underflow(String msg){
  super(msg);
  }
}
       
        