import java.util.*;
import java.io.*;

class Node 
{
    Node left;
    Node right;
    int data;
    
    Node(int data) 
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution 
{
	public static void topView(Node root) 
    {
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        
        traverse(map, root, 0, 0);
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            System.out.print(entry.getValue().get(0) + " ");
        }
    }
    
    public static void traverse(TreeMap<Integer, List<Integer>> map, Node root, int hd, int level)
    {
        if(root != null)
        {
            if(!map.containsKey(hd))
            {
                map.put(hd, new ArrayList<Integer>(){{add(root.data); add(level);}});
            } else if(map.get(hd).get(1) > level)
            {
                map.put(hd, new ArrayList<Integer>(){{add(root.data); add(level);}});
            }
            
            traverse(map, root.left, hd - 1, level + 1);
            traverse(map, root.right, hd + 1, level + 1);
        }
    }

	public static Node insert(Node root, int data) 
    {
        if(root == null) 
        {
            return new Node(data);
        } else 
        {
            Node cur;
            if(data <= root.data) 
            {
                cur = insert(root.left, data);
                root.left = cur;
            } else 
            {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) 
        {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}