import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Tom on 23.03.2017.
 */
public class Computator {

    private FrontGroup frontGroup;
    private FrontGroup deepFrontGroup;
    private ArrayList<BackGroup> backGroupList;

    public FrontGroup getFrontGroup() {
        return frontGroup;
    }

    public void setFrontGroup(FrontGroup frontGroup) {
        this.frontGroup = frontGroup;
    }

    public ArrayList<BackGroup> getBackGroupList() {
        return backGroupList;
    }

    public void setBackGroupList(ArrayList<BackGroup> backGroupList) {
        this.backGroupList = backGroupList;
    }

    public Computator() {
        frontGroup = new FrontGroup();
        backGroupList = new ArrayList<>();
        deepFrontGroup = new FrontGroup();
    }

    public Computator(FrontGroup frontGroup, ArrayList<BackGroup> backGroup, FrontGroup deepFrontGroup) {
        this.frontGroup = frontGroup;
        this.backGroupList = backGroup;
        this.deepFrontGroup = deepFrontGroup;
    }

    public void Add(TripleLong tripleLong){
        TripleLongHashSet tlhs = new TripleLongHashSet();
        TripleLongArrayList tlal = new TripleLongArrayList();
        TripleLongHashSet hs = frontGroup.get_tripleLongHashSet();
        Long a1 = tripleLong.getA();
        Long b1 = tripleLong.getB();
        Long c1 = tripleLong.getC();
        TripleLongArrayList tripleLongArrayList = frontGroup.getTripleLongArrayList();
        boolean setContainsA = hs.ALongSet.contains(a1) && a1!= 0L;
        if (setContainsA){
            int i = tripleLongArrayList.GetIndexByA(a1);
            Long bLong = tripleLongArrayList.getBArray().get(i);
            Long cLong = tripleLongArrayList.getCArray().get(i);
            tlhs.Add(a1,bLong,cLong);
            tlal.Add(a1,bLong,cLong);
            frontGroup.RemoveFromA(a1, bLong, cLong);
        }
        boolean setContainsB = hs.BLongSet.contains(b1) && b1!= 0L;
        if (setContainsB ){
            int i = tripleLongArrayList.GetIndexByB(b1);
            Long aLong = tripleLongArrayList.getAArray().get(i);
            Long cLong = tripleLongArrayList.getCArray().get(i);
            tlhs.Add(aLong,b1,cLong);
            tlal.Add(aLong,b1,cLong);
            frontGroup.RemoveFromB(aLong, b1, cLong);
        }
        boolean setContainsC = hs.CLongSet.contains(c1) && c1!= 0L;
        if (setContainsC){
            int i = tripleLongArrayList.GetIndexByC(c1);
            Long bLong = tripleLongArrayList.getBArray().get(i);
            Long aLong = tripleLongArrayList.getAArray().get(i);
            tlhs.Add(aLong,bLong,c1);
            tlal.Add(aLong,bLong,c1);
            frontGroup.RemoveFromC(aLong, bLong, c1);
        }
        if (setContainsA || setContainsB || setContainsC) {
            tlhs.Add(tripleLong);
            tlal.Add(tripleLong);
            boolean merging = false;
            ArrayList<Integer> counter = new ArrayList<>();
            int offset = 0;
            for (int i = 0; i < backGroupList.size(); i++) {
                if (backGroupList.get(i - offset).CanMerge(tlhs)) {
                    counter.add(i - offset);
                    merging = true;
                    backGroupList.get(counter.get(0)).Merge(tlhs,tlal);
                    if (counter.size() == 2) {
                        System.out.println("Merging groups");
                        backGroupList.get(counter.get(0)).Merge(backGroupList.get(counter.get(1)));
                        counter.remove(1);
                        backGroupList.remove(i - offset);
                        offset++;
                    }
                }
            }



            /*boolean adding = false;
            for (int j=0;j<backGroupList.size();j++){
                if (backGroupList.get(j).canMerge(tlhs)){
                    backGroupList.get(j).Merge(tlhs, tlal);
                    merging = true;
                }
            }*/
            if (!merging)
                backGroupList.add(new BackGroup(tlhs,tlal));
        }
        else {
            boolean grouping = false;
            ArrayList<Integer> counter = new ArrayList<>();
            int offset = 0;
            for (int i = 0; i < backGroupList.size(); i++) {
                if (backGroupList.get(i - offset).add_if_any_set_contains(tripleLong)) {
                    grouping = true;
                    counter.add(i - offset);
                    if (counter.size() == 2) {
                        System.out.println("Merging groups");
                        backGroupList.get(counter.get(0)).Merge(backGroupList.get(counter.get(1)));
                        counter.remove(1);
                        backGroupList.remove(i - offset);
                        offset++;
                    }
                }
            }
            if (!grouping) {
                frontGroup.Add(tripleLong);
            }

        }
    }
}
