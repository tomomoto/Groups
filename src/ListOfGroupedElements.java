import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Tom on 24.03.2017.
 */
public class ListOfGroupedElements {

    public ListOfGroupedElements() {
        groups = new ArrayList<>();
        m_tripleLongHashSet = new TripleLongHashSet();
    }

    public ListOfGroupedElements(ArrayList<Group> groups, TripleLongHashSet tripleLongHashSet) {
        this.groups = groups;
        this.m_tripleLongHashSet = tripleLongHashSet;
    }


    private ArrayList<Group> groups;

    private TripleLongHashSet m_tripleLongHashSet;

    public TripleLongHashSet getTripleLongHashSet() {
        return m_tripleLongHashSet;
    }

    public void setTripleLongHashSet(TripleLongHashSet tripleLongHashSet) {
        this.m_tripleLongHashSet = tripleLongHashSet;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public boolean IsUnique (TripleLong tripleLong){
        if (m_tripleLongHashSet.ContainsByA(tripleLong.getA()))
            return false;
        if (m_tripleLongHashSet.ContainsByB(tripleLong.getB()))
            return false;
        if (m_tripleLongHashSet.ContainsByC(tripleLong.getC()))
            return false;
        return true;
    }

    public boolean IsUnique (Group group){
        return !m_tripleLongHashSet.IsRetain(group.get_tripleLongHashSet());
    }

    public boolean AddGroup(Group group) {
        m_tripleLongHashSet.Merge(group.get_tripleLongHashSet());
        return groups.add(group);
    }

    public void Merge(TripleLong tripleLong){
        ArrayList<Integer> counter = new ArrayList<>();
        int offset = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (!groups.get(i - offset).IsUnique(tripleLong)) {
                counter.add(i - offset);
                groups.get(counter.get(0)).Add(tripleLong);
                if (counter.size() == 2) {
                    System.out.println("Merging groups");
                    groups.get(counter.get(0)).Add(groups.get(counter.get(1)));
                    counter.remove(1);
                    groups.remove(i - offset);
                    offset++;
                }
            }
        }
    }

    public void Merge(Group group){
        ArrayList<Integer> counter = new ArrayList<>();
        int offset = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i - offset).IsIntersect(group)) {
                counter.add(i - offset);
                groups.get(counter.get(0)).Add(group);
                if (counter.size() == 2) {
                    System.out.println("Merging groups");
                    groups.get(counter.get(0)).Add(groups.get(counter.get(1)));
                    counter.remove(1);
                    groups.remove(i - offset);
                    offset++;
                }
            }
        }
    }

}
