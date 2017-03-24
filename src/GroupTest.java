import com.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileReader;
import java.util.*;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void testContains() throws Exception {
        System.out.println("Начато...");
        long start = System.currentTimeMillis();
        CSVReader reader = new CSVReader(new FileReader("Lng.csv"), ';');
        String[] nextLine;
        Computator cmp = new Computator(new TripleLong(1l,2l,3l));
        int i = 0;
        TripleLong tpl2 = new TripleLong(4l,4l,3l);
        cmp.Add(tpl2);
        TripleLong tpl3 = new TripleLong(5l,6l,7l);
        cmp.Add(tpl3);
        TripleLong tpl4 = new TripleLong(8l,8l,7l);
        cmp.Add(tpl4);
        TripleLong tp5 = new TripleLong(9l,6l,3l);
        cmp.Add(tp5);
        while ((nextLine = reader.readNext()) != null) {
            Long a,b,c;
            try {
                a = Long.valueOf(nextLine[0]);
            } catch (Exception e) {
                a=0l;
            }
            try {
                b = Long.valueOf(nextLine[1]);
            } catch (Exception e) {
                b=0l;
            }
            try {
                c = Long.valueOf(nextLine[2]);
            } catch (Exception e) {
                c=0l;
            }
            TripleLong trpLng = new TripleLong(a, b, c);
            cmp.Add(trpLng);
            //i++;
            //System.out.println(i);
        }
        Collections.sort(cmp.getListOfGroupedElements().getGroups(),
                (o1, o2) -> o2.get_tripleLongArrayList().Size() - o1.get_tripleLongArrayList().Size());
        long finish = System.currentTimeMillis();
        float timeConsumedSec = (finish - start)/1000F;
        System.out.println("Время выполнения: "+timeConsumedSec+" секунд");
        assertEquals("Expected size is 1989", 1989, cmp.getListOfGroupedElements().getGroups().size());
    }
}