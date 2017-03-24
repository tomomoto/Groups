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
        ArrayList<Integer> mergingIndexList = new ArrayList<>();
        boolean listsAlreadyMerged=false;
        int removedGroups = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (!groups.get(i - removedGroups).IsUnique(tripleLong)) {
                mergingIndexList.add(i - removedGroups);
                if (!listsAlreadyMerged){
                    groups.get(mergingIndexList.get(0)).Add(tripleLong);
                    listsAlreadyMerged=true;
                }
                if (mergingIndexList.size() == 2) {
                    //System.out.println("Merging triplelong");
                    groups.get(mergingIndexList.get(0)).Add(groups.get(mergingIndexList.get(1)));
                    mergingIndexList.remove(1);
                    groups.remove(i - removedGroups);
                    removedGroups++;
                }
            }
        }
    }

    public void Merge(Group group){
        ArrayList<Integer> mergingIndexList = new ArrayList<>();
        boolean listsAlreadyMerged=false;
        int removedGroups = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i - removedGroups).IsIntersect(group)) {
                mergingIndexList.add(i - removedGroups);
                if (!listsAlreadyMerged){
                    groups.get(mergingIndexList.get(0)).Add(group);
                    listsAlreadyMerged=true;
                }
                if (mergingIndexList.size() == 2) {
                    //System.out.println("Merging groups");
                    groups.get(mergingIndexList.get(0)).Add(groups.get(mergingIndexList.get(1)));
                    mergingIndexList.remove(1);
                    groups.remove(i - removedGroups);
                    removedGroups++;
                }
            }
        }
    }

}
