import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    static class Node
    {
        private int id;
        private int parent;
        private long subNodeSum;

        public Node(int id, int parent, long subNodeSum)
        {
            this.id = id;
            this.parent = parent;
            this.subNodeSum = subNodeSum;
        }

        public Node(int id, int parent)
        {
            this.id = id;
            this.parent = parent;
            this.subNodeSum = 0;
        }
    }

    static class Tree
    {
        private Node[] nodes;
        private int numberOfNode;
        private int query;

        public Tree(int n, int q)
        {
            this.numberOfNode = n;
            this.query = q;
            this.nodes = new Node[n + 1];
            this.nodes[0] = new Node(0, 0, 0);
            this.nodes[1] = new Node(1, 1, 0);
        }

        public void makeEdge(int v1, int v2)
        {
            if(v1 < v2)
                this.nodes[v2] = new Node(v2, v1);
            else
                this.nodes[v1] = new Node(v1, v2);
        }

        public void solve(Scanner in)
        {
            for(int i = 0; i < query * 2; i = i + 2)
            {
                Arrays.stream(this.nodes).forEach(n -> {
                    if(n != null)
                    {
                        n.subNodeSum = 0;
                    }
                });
                in.nextLine();
                long setSum = Arrays.stream(in.nextLine().split(" ")).mapToLong(it -> {
                    int ret = Integer.parseInt(it);
                    Node node = this.nodes[ret];
                    long asLong = node.id;
                    node.subNodeSum = asLong;
                    return ret;
                }).sum();

                long sum = 0;
                for(int j = this.numberOfNode; j > 0; j--)
                {
                    Node n = this.nodes[j];
                    if(n.subNodeSum > 0)
                    {
                        sum += (setSum - n.subNodeSum) * (n.subNodeSum % 1_000_000_007) % 1_000_000_007;
                    }
                    this.nodes[n.parent].subNodeSum += n.subNodeSum;
                }

                System.out.println(sum % 1_000_000_007);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] inQN = in.nextLine().split(" ");
        int n = Integer.parseInt(inQN[0]);
        int q = Integer.parseInt(inQN[1]);

        Tree tree = new Tree(n, q);

        for (int i = 1;  i < n;  i++)
        {
            String[] inputEdges = in.nextLine().split(" ");
            tree.makeEdge(Integer.parseInt(inputEdges[0]), Integer.parseInt(inputEdges[1]));
        }

        tree.solve(in);
    }
}
