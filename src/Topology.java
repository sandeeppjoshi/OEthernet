import java.util.ArrayList;

public class Topology {


    private Node root;

    public Topology(Node root){

        this.root = root;
        root.setAddress("1");
    }

    public void makeBTree(){
        Queue queue = new Queue();
        queue.addQueue(root);
        while (!queue.isEmpty()){
            Node parent = queue.delQueue();
            ArrayList<Node> children = new ArrayList<Node>();
            children.addAll(parent.getNeighbours());
            if (parent.getParent() != null)
                children.remove(parent.getParent());

            for(Node node : children )
                queue.addQueue(node);

            while (parent.getNumChildren() > 2){
                parent.getNeighbours().removeAll(children);
                addVNodes(parent, children);
                children = parent.getNeighbours();
                if(parent.getParent()!= null)
                    children.remove(parent.getParent());
                for(Node node : children)
                {
                    node.setParent(parent);
                    node.addNeighbor(parent);
                }
            }
            children = parent.getNeighbours();
            if ( parent.getParent()!= null)
                children.remove(parent.getParent());
            if(children.size() >= 1)
            {
                children.get(0).setDirection(0);
                children.get(0).setParent(parent);
                if ( children.size() == 2)
                {
                    children.get(1).setDirection(1);
                    children.get(1).setParent(parent);
                }
            }
        }
    }

    private void addVNodes(Node parent, ArrayList<Node> children) {
        while(!children.isEmpty()){
            Node vNode = new Node(true);
            Node lChild = children.remove(0);
            lChild.removeNeighbor(parent);
            lChild.setParent(vNode);
            lChild.addNeighbor(vNode);
            vNode.addNeighbor(lChild);
            lChild.setDirection(0);
            if(!children.isEmpty())
            {
                Node rChild = children.remove(0);
                rChild.removeNeighbor(parent);
                rChild.setParent(vNode);
                vNode.addNeighbor(rChild);
                rChild.addNeighbor(vNode);
                rChild.setDirection(1);
            }
            parent.addNeighbor(vNode);
        }
    }
}
