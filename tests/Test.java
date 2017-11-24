import controller.Controller;
import entity.ArrayListTest;
import entity.LinkedListTest;
import org.apache.log4j.Logger;


/**
 * Created by DNAPC on 24.11.2017.
 */
public class Test {
    private static final Logger log = Logger.getLogger(Test.class.getClass());

    @org.junit.Test
    public void test() {
        ArrayListTest arrayListTest = new ArrayListTest();
        LinkedListTest linkedListTest = new LinkedListTest();
        try {
            arrayListTest.get();
            arrayListTest.add();
            arrayListTest.remove();

            linkedListTest.get();
            linkedListTest.add();
            linkedListTest.remove();
        } catch (Exception ex) {
            log.error(ex);
        }
    }
}
