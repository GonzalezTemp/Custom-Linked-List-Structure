
package namelist; 

public class NameList {

    Node head;
    
    static class Node {
        String name;
        Node next;
        
        Node(String n)
        {
            name = n;
            next = null;
        }
    }
    
    public static NameList add(NameList list, String name)
    {
        Node NewNode = new Node(name);
        NewNode.next = null;
        char letter = NewNode.name.charAt(0);
        String conv = Character.toString(letter);
        
        if(list.head == null)
        {
            Node temp = new Node(conv);
            
            list.head = temp;
            temp.next = NewNode;
            
            return list;
        }
        else
        {
            Node current = list.head;
            int count = 0;
            while(current != null)
            {   
                if(current.name.charAt(0) == letter)
                {
                    count++;
                }       
                current = current.next;
            }
            current = list.head;
            if(count == 0)
            {
                while(current != null)
                {
                    if(current.name == null)
                    {
                        Node temp = new Node(conv);
                        current.next = temp;
                        temp.next = NewNode;
                        break;
                    }
                    current = current.next;
                }
            }
            else
            {
                while(current != null)
                {
                    if(current.next == null)
                    {
                        current.next = NewNode;
                        break;
                    }
                    current = current.next;
                }
            }
        }
        
        return list;
    }
    
    public static NameList remove(NameList list, String target)
    {
        Node current = list.head;
        Node previous = null;
        
        while(current != null)
        {
            previous = current;
            current = current.next;
            if(current == null)
            {
                break;
            }
            
            if(current.name == target)
            {
                previous.next = current.next;
                current = previous;
            }    
        }
        
        current = list.head;
        previous = null;
        char check = target.charAt(0);
        int count = 0;
        while(current != null)
        {   
            if(current.name.charAt(0) == check)
            {
                count++;
            }    
            current = current.next;
        }
        if(count < 2)
        {
            list = removeLetter(list, check);
        }
        
        return list;
    }
    
    public static NameList removeLetter(NameList list, char target)
    {
        Node current = list.head;
        Node previous = null;
        
        while(current != null)
        {
            previous = current;
            current = current.next;
            if(current == null)
            {
                break;
            }
            
            if(current.name.charAt(0) == target)
            {
                previous.next = current.next;
                current = previous;
            }
            
        }
        return list;
    }
    
    public static boolean find(NameList list, String target)
    {
        Node current = list.head;
        
        while(current != null)
        {
            if(current.name == target)
            {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    public static void tostring(NameList list)
    {
        Node current = list.head;
        int length;
        
        while(current != null)
        {
            length = current.name.length();
            
            if(length == 1)
            {
                System.out.println(current.name);
            }
            else
            {
                System.out.println("  " + current.name);
            }
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        NameList test = new NameList();
        
        test = add(test, "Bob");
        test = add(test, "Dan");
        test = add(test, "Ben");
        
        tostring(test);
        System.out.println("---------");
        
        test = add(test, "Deb");
        test = add(test, "Sarah");
        
        tostring(test);
        System.out.println("---------");
        
        test = remove(test, "Deb");
        test = remove(test, "Sarah");
        
        tostring(test);
        System.out.println("---------");
        
        System.out.println(find(test, "Bob"));
        System.out.println("---------");
        
        test = removeLetter(test, 'D');
        
        tostring(test);
        System.out.println("---------");
    }
    
}
