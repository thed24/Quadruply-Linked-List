package QuadruplyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class QuadruplyLinkedListTests {
    @Test
    public void list_creates_with_given_height() {
        QuadruplyLinkedList<Integer> linkedList = new QuadruplyLinkedList<Integer>(3, 3);
        Integer expected = 3;
        Integer actual = linkedList.getHeight();
        Assert.assertEquals(expected, actual);
     }

     @Test
     public void list_creates_with_given_width() {
         QuadruplyLinkedList<Integer> linkedList = new QuadruplyLinkedList<Integer>(3, 3);
         Integer expected = 3;
         Integer actual = linkedList.getWidth();
         Assert.assertEquals(expected, actual);
      }
      
      @Test
      public void list_instantiates_every_node_with_pointers_to_other_nodes() {
          Node<Integer> currentNode;
          int actual = 0;
          int expected = 9;
          QuadruplyLinkedList<Integer> linkedList = new QuadruplyLinkedList<Integer>(3, 3);
          for (int i = 0; i < linkedList.getHeight(); i++) {
              for (int j = 0; j < linkedList.getWidth(); j++) {
                  currentNode = linkedList.getNode(i, j);
                  if (currentNode.up != null
                  && currentNode.down != null
                  && currentNode.left != null
                  && currentNode.right != null){
                    actual++;
                  }
              }
          }
          Assert.assertEquals(expected, actual);
       }
}