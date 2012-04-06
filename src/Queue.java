import java.util.ArrayList;

public class Queue {

    public ArrayList<Node> queue;

    public Queue(){
        queue = new ArrayList<Node>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void addQueue(Node node){
        queue.add(queue.size(),node);
    }

    public Node delQueue(){
        return queue.remove(0);
    }
}
