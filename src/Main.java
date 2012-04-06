import java.lang.String;

public class Main {

    public static void main(String args[]){

        Node one = new Node(false);
        Node two = new Node(false);
        Node three = new Node(false);
        Node four = new Node(false);
        Node five = new Node(false);
        Node six = new Node(false);
        Node seven = new Node(false);
        one.addNeighbor(two);
        one.addNeighbor(three);
        one.addNeighbor(four);
        two.addNeighbor(one);
        three.addNeighbor(one);
        four.addNeighbor(one);
        four.addNeighbor(five);
        four.addNeighbor(six);
        four.addNeighbor(seven);
        five.addNeighbor(four);
        six.addNeighbor(four);
        seven.addNeighbor(four);
        Topology topology = new Topology(one);
        topology.makeBTree();
        System.out.println("1 = "+one.getAddress());
        System.out.println("2 = "+two.getAddress());
        System.out.println("3 = "+three.getAddress());
        System.out.println("4 = "+four.getAddress());
        System.out.println("5 = "+five.getAddress());
        System.out.println("6 = "+six.getAddress());
        System.out.println("7 = "+seven.getAddress());
        System.out.println("6 to 7 = " + six.getRARTAG(seven.getAddress()));



    }


}
