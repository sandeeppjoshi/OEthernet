import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TopologyTest {
    private Node one;
    private Node two;
    private Node three;
    private Node four;
    private Node five;
    private Topology topology;

    @Before
    public void setUp(){
        one = new Node(false);
        two = new Node(false);
        three = new Node(false);
        four = new Node(false);
        five = new Node(false);
        one.addNeighbor(two);
        one.addNeighbor(three);
        one.addNeighbor(four);
        two.addNeighbor(one);
        three.addNeighbor(one);
        four.addNeighbor(one);
        four.addNeighbor(five);
        topology = new Topology(one);
    }

    @Test
    public void shouldConvertToBTree(){
          topology.makeBTree();
          assertEquals(2,one.getConnectivityDegree());
          assertEquals("1100",five.getAddress());
    }


}
