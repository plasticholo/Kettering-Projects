package ch06.lists;

public class TestBasic
{
   public static void main(String[] args) 
   {
        ABList<String> list = new ABList<>();

        //add test
        System.out.println("Add : ");
        //adds elements
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        //prints results
        System.out.println(list);

        //size test
        System.out.println("Size of the list is: "+ list.size());

        //contains test
        System.out.println("List contains 'two': " + list.contains("two"));

        //get test
        System.out.println("Get 'three': "+ list.get("three"));
        
        //remove test
        list.remove("two");
        System.out.println("List after removing 'two': ");
   }
}