package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> one = new AListNoResizing<Integer>();
        BuggyAList<Integer> two = new BuggyAList<Integer>();

        one.addLast(4);
        two.addLast(4);

        one.addLast(5);
        two.addLast(5);

        one.addLast(6);
        two.addLast(6);

        Assert.assertEquals(one.size(), two.size());

        int a = one.removeLast();
        int b = two.removeLast();

        Assert.assertEquals(a, b);

        a = one.removeLast();
        b = two.removeLast();

        Assert.assertEquals(a, b);

        a = one.removeLast();
        b = two.removeLast();

        Assert.assertEquals(a, b);

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<Integer>();
        BuggyAList<Integer> B = new BuggyAList<Integer>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                Assert.assertEquals(L.size(), B.size());

//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                if (size1 > 0 && size2 > 0) {
                    int temp1 = L.getLast();
                    int temp2 = B.getLast();

//                    System.out.println("getLast: " + temp1);
                    Assert.assertEquals(L.size(), B.size());
                    Assert.assertEquals(temp1, temp2);
                }
            } else if (operationNumber == 2) {
                int size1 = L.size();
                int size2 = B.size();
                if (size1 > 0 && size2 > 0) {
                    int temp1 = L.removeLast();
                    int temp2 = B.removeLast();
//                    System.out.println("removeLast: " + temp1);
                    Assert.assertEquals(L.size(), B.size());
                    Assert.assertEquals(temp1, temp2);
                }
            } else {
                int size1 = L.size();
//                System.out.println("L size: " + size1);
                int size2 = B.size();
//                System.out.println("B size: " + size2);
            }
        }

    }
}
