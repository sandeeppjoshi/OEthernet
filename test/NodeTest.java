import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    private String dAddress = "1000";
    private String sAddress = "1100";
    private String RARTag = "000000";
    @Test
    public void shouldCalculateRARTAG(){
        Node node = new Node(false);
        node.setAddress(sAddress);
        String actualRARTag = node.getRARTAG(dAddress);
        String expectedRARTag = RARTag;
        assertEquals(expectedRARTag,actualRARTag);

    }

    @Test
    public void shouldGetCorrectMask(){
        Node node = new Node(false);
        node.setAddress(sAddress);
        Integer actualMask = node.getMask(Integer.parseInt(dAddress, 2));
        Integer expectedMask =7;
        assertEquals(expectedMask,actualMask);
        assertEquals("100", node.getRemAddress(Integer.parseInt(sAddress,2),expectedMask));
    }

    @Test
    public void shouldReturnDegreeZeroForNoNeighbours(){
        Node node = new Node(false);
        assertEquals(0,node.getConnectivityDegree());
    }

    @Test
    public void shouldReturnNumberOfChildren(){
        Node parent = new Node(false);
        Node child = new Node(false);
        parent.addNeighbor(child);
        child.addNeighbor(parent);
        child.setParent(parent);
        assertEquals(1,parent.getNumChildren());
        assertEquals(0,child.getNumChildren());

    }


}
