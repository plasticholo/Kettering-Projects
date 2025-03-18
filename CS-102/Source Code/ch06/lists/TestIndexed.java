public class TestIndexed 
{
    public static void main(String[] args) 
    {
        ABList<String> list = new ABList<>();

        //add test
        System.out.println("Initial List: ");
        //adds elements
        list.add("apple");
        list.add("orange");
        list.add("pear");
        list.add("banana");
        //prints results
        System.out.println(list);

        list.add(3,"grape");
        System.out.println("list after adding 'five' at index 3: "+ list);

        //get test
        System.out.println("Get index 2: "+ list.get(2));
        
        //remove test
        list.remove(2);
        System.out.println("List after removing at index 2: ");

        //set test
        list.set(2,"apple");
        System.out.println("List after setting index 2 to apple");
    }
}
