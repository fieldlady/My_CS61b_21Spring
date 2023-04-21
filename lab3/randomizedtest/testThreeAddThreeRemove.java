package randomizedtest;

import edu.princeton.cs.algs4.In;
import org.junit.Assert;
import org.junit.Test;

public class testThreeAddThreeRemove {

    @Test
    public void test() {
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
}
