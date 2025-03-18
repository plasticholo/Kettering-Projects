public class TestIterator
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

        Iterator<String> iterator = list.iterator();

        System.out.println("Iterating through list: ");

        while(iterator.hasNext())
        {
            String selected = iterator.next;
            System.out.println("Selected: "+ selected);

            if(selected.equals("pear"))
            {
                iterator.remove();
                System.out.println("Removed 'pear'");
            }
        }

        System.out.println("list after removing pear" + list); 

        
    }
}