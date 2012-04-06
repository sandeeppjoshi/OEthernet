import java.util.ArrayList;

public class Node {

    private String  address;
    private ArrayList<Node> neighbors;
    private Node parent;
    private boolean virtual;
    private int direction;

    public Node(boolean virtual){
        neighbors = new ArrayList<Node>();
        this.virtual = virtual;
    }

    public void setParent(Node node){
        parent = node;
    }

    public String getAddress(){
        if (address != null)
            return address;
        address = parent.getAddress()+direction;
        return parent.getAddress()+direction;
    }
    public void setAddress(String address) {
        this.address = address;
//
    }
    public void addNeighbor(Node node){
        neighbors.add(node);
    }

    public String getRARTAG(String destinationAddress) {
        Integer dAddress = Integer.parseInt(destinationAddress,2);
        Integer sAddress = Integer.parseInt(address,2);
        Integer mask = getMask(dAddress);
        String sourceRem = getRemAddress(sAddress, mask);
        String destinationRem = getRemAddress(dAddress, mask);
        String reversedSourceRemAddress = new StringBuffer(sourceRem).reverse().toString();
        String bitFlipped = flipLastBit(reversedSourceRemAddress);
        return bitFlipped+destinationRem;
    }

    private String flipLastBit(String reversedSourceRemAddress) {

        return Integer.toBinaryString(Integer.parseInt(1+reversedSourceRemAddress,2) ^ 1).substring(1);
    }

    public Integer getMask(Integer dAddress) {
        return (int)Math.pow(2,(Integer.toBinaryString(Integer.parseInt(address,2) ^ dAddress).length() )) - 1;
    }

    public String getRemAddress(Integer address, Integer mask) {
        return (Integer.toBinaryString(address & mask | (mask + 1))).substring(1);
    }

    public int getConnectivityDegree() {
        return neighbors.size();
    }

    public ArrayList<Node> getNeighbours() {
        return neighbors;
    }

    public Node getParent() {
        return parent;
    }

    public void setDirection(int direction) {

        this.direction = direction;
    }

    public int getNumChildren() {
        if (parent != null)
            return getConnectivityDegree()-1;
        return getConnectivityDegree();

    }
    public void removeNeighbor(Node node) {
        neighbors.remove(node);
    }
}
