import java.util.HashSet;

/**
 * Created by Tom on 23.03.2017.
 */
public class TripleLongHashSet {

    protected HashSet<Long> ALongSet;
    protected HashSet<Long> BLongSet;
    protected HashSet<Long> CLongSet;

    public TripleLongHashSet() {
        ALongSet = new HashSet<>();
        BLongSet = new HashSet<>();
        CLongSet = new HashSet<>();
    }

    public TripleLongHashSet(HashSet<Long> ALongSet, HashSet<Long> BLongSet, HashSet<Long> CLongSet) {
        this.ALongSet = ALongSet;
        this.BLongSet = BLongSet;
        this.CLongSet = CLongSet;
    }

    public TripleLongHashSet(TripleLongArrayList tlArray){
        for (int i=0;i<tlArray.Size();i++)
            Add(tlArray.Get(i).getA(),tlArray.Get(i).getB(),tlArray.Get(i).getC());
    }

    public void Add(TripleLongArrayList tlArray){
        for (int i=0;i<tlArray.Size();i++)
            Add(tlArray.Get(i).getA(),tlArray.Get(i).getB(),tlArray.Get(i).getC());
    }

    public TripleLongHashSet(TripleLong tl){
        Add(tl.getA(), tl.getB(), tl.getC());
    }

    public void Add(HashSet<Long> a, HashSet<Long> b, HashSet<Long> c){
        ALongSet.addAll(a);
        BLongSet.addAll(b);
        CLongSet.addAll(c);
    }

    public void Add(TripleLongHashSet tlhs){
        ALongSet.addAll(tlhs.ALongSet);
        BLongSet.addAll(tlhs.BLongSet);
        CLongSet.addAll(tlhs.CLongSet);
    }

    public void Add(Long a, Long b, Long c){
        if (a != 0L)
            ALongSet.add(a);
        if (b != 0L)
            BLongSet.add(b);
        if (c != 0L)
            CLongSet.add(c);
    }

    public void Add(TripleLong tl){
        Add(tl.getA(), tl.getB(), tl.getC());
    }

    public void Remove(Long a, Long b, Long c){
        ALongSet.remove(a);
        BLongSet.remove(b);
        CLongSet.remove(c);
    }

    public void Remove(TripleLong tripleLong){
        Remove(tripleLong.getA(), tripleLong.getB(), tripleLong.getC());
    }

    public HashSet<Long> getALongSet() {
        return ALongSet;
    }

    public void setALongSet(HashSet<Long> ALongSet) {
        this.ALongSet = ALongSet;
    }

    public HashSet<Long> getBLongSet() {
        return BLongSet;
    }

    public void setBLongSet(HashSet<Long> BLongSet) {
        this.BLongSet = BLongSet;
    }

    public HashSet<Long> getCLongSet() {
        return CLongSet;
    }

    public void setCLongSet(HashSet<Long> CLongSet) {
        this.CLongSet = CLongSet;
    }
}
