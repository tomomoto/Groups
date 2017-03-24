import com.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileReader;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Tom on 18.03.2017.
 */
public class GroupTest {

    @Test
    public void testContains() throws Exception {
        CSVReader reader = new CSVReader(new FileReader("Lng.csv"), ';');
        String[] nextLine;
        LinkedList<TripleLong> longs = new LinkedList<>();
        Computator cmp = new Computator();
        int i = 0;
        TripleLong tpl1 = new TripleLong(1l,2l,3l);
        cmp.Add(tpl1);
        TripleLong tpl2 = new TripleLong(4l,4l,3l);
        cmp.Add(tpl2);
        TripleLong tpl3 = new TripleLong(5l,6l,7l);
        cmp.Add(tpl3);
        while ((nextLine = reader.readNext()) != null) {
            if (i == 400000){
                TripleLong tpl4 = new TripleLong(8l,8l,7l);
                cmp.Add(tpl4);
            }
            Long a = 0L,b=0L,c=0L;
            try {
                a = Long.valueOf(nextLine[0]);
            } catch (Exception e) {

            }
            try {
                b = Long.valueOf(nextLine[1]);
            } catch (Exception e) {

            }
            try {
                c = Long.valueOf(nextLine[2]);
            } catch (Exception e) {

            }
            TripleLong trpLng = new TripleLong(a, b, c);
            cmp.Add(trpLng);
            //System.out.println(j);
            //longs.add(trpLng);
            i++;
            //System.out.println(i);
        }
        TripleLong tp5 = new TripleLong(9l,6l,3l);
        cmp.Add(tp5);
        /*int j=0;
        for (TripleLong tripleLong : longs) {
            cmp.Add(tripleLong);
            System.out.println(j);
            j++;
        }*/

        Collections.sort(cmp.getBackGroupList(), new Comparator<BackGroup>() {
            @Override
            public int compare(BackGroup o1, BackGroup o2) {
                return o2.return_string_list().size() - o1.return_string_list().size();
            }
        });

        /*ArrayList<BackGroup> groups = new ArrayList<>();



        TripleLong tripleLong = new TripleLong(1l, 1l, 1l);
        groups.add(new BackGroup(tripleLong));
        computation(longs, groups);
        Collections.sort(groups, new Comparator<BackGroup>() {
            @Override
            public int compare(BackGroup o1, BackGroup o2) {
                return o2.return_string_list().size() - o1.return_string_list().size();
            }
        });*/
        assertEquals("Expected size is 1", 0, cmp.getBackGroupList().size());
    }

    @Test
    public void testAdd() throws Exception {

    }
}