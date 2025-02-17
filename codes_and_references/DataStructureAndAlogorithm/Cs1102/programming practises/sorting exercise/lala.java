import java.util.*;
class lala{
  public static void main(String[]args){
    ArrayList<Person> list = new ArrayList<Person>();
    
    AgeComparator ageComp = new AgeComparator();
    
    Person a = new Person("shawn",17,188);
    Person b = new Person("john",19,175);
    Person c = new Person("dennis",14,168);
    
    list.add(a);
    list.add(b);
    list.add(c);
    
    Collections.sort(list,ageComp);
    
    Collections.reverse(list);//reverse the order
    
    for(Person p: list){
      System.out.println(p.name+" "+p.age);
    }
  }
}

class AgeComparator implements Comparator<Person>{
  public int compare(Person a, Person b){
    return a.age-b.age;
  }
  
  public boolean equals(Object obj){
    return this==obj;
  }
}