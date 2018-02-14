package Tools;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AlphabeticalStringListComparator {

    public static void compareTwoStringLists(List<String> l1, List<String> l2) {
        l1.sort(Comparator.naturalOrder());
        l2.sort(Comparator.naturalOrder());
        assertEquals(l1, l2);
    }
}
