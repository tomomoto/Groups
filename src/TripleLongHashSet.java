import java.util.HashSet;

/**
 * Created by Tom on 23.03.2017.
 */
public class TripleLongHashSet {

    private HashSet<Long> ALongSet;
    private HashSet<Long> BLongSet;
    private HashSet<Long> CLongSet;

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

    public TripleLongHashSet(TripleLong tl){
        ALongSet = new HashSet<>();
        BLongSet = new HashSet<>();
        CLongSet = new HashSet<>();
        Add(tl.getA(), tl.getB(), tl.getC());
    }

    public TripleLongHashSet(TripleLongArrayList tlArray){
        ALongSet = new HashSet<>();
        BLongSet = new HashSet<>();
        CLongSet = new HashSet<>();
        for (int i=0;i<tlArray.Size();i++)
            Add(tlArray.Get(i).getA(),tlArray.Get(i).getB(),tlArray.Get(i).getC());
    }

    public void Add(TripleLongArrayList tlArray){
        for (int i=0;i<tlArray.Size();i++)
            Add(tlArray.Get(i).getA(),tlArray.Get(i).getB(),tlArray.Get(i).getC());
    }

    public void Merge(HashSet<Long> a, HashSet<Long> b, HashSet<Long> c){
        ALongSet.addAll(a);
        BLongSet.addAll(b);
        CLongSet.addAll(c);
    }

    public void Merge(TripleLongHashSet tlhs){
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

    public void Add(TripleLong tripleLong){
        Long a = tripleLong.getA();
        Long b = tripleLong.getB();
        Long c = tripleLong.getC();
        if (a != 0L)
            ALongSet.add(a);
        if (b != 0L)
            BLongSet.add(b);
        if (c != 0L)
            CLongSet.add(c);
    }



    public boolean Remove(Long a, Long b, Long c){
        boolean remA=false,remB=false,remC=false;
        if (ALongSet.contains(a)){
            ALongSet.remove(a);
            remA = true;
        }
        if (BLongSet.contains(b)){
            BLongSet.remove(b);
            remB = true;
        }
        if (CLongSet.contains(c)){
            CLongSet.remove(c);
            remC = true;
        }
        return (remA || remB || remC);
    }

    public boolean ContainsByA (Long a){
        return ALongSet.contains(a);
    }

    public boolean ContainsByB (Long b){
        return BLongSet.contains(b);
    }

    public boolean ContainsByC (Long c){
        return CLongSet.contains(c);
    }

    public boolean Remove(TripleLong tripleLong){
        return Remove(tripleLong.getA(), tripleLong.getB(), tripleLong.getC());
    }

    public boolean IsRetain(TripleLongHashSet tripleLongHashSet){
        HashSet<Long> aclone = (HashSet<Long>) ALongSet.clone();
        aclone.retainAll(tripleLongHashSet.ALongSet);
        if (aclone.size()> 0)
            return true;
        HashSet<Long> bclone = (HashSet<Long>) BLongSet.clone();
        bclone.retainAll(tripleLongHashSet.BLongSet);
        if (bclone.size()> 0)
            return true;
        HashSet<Long> cclone = (HashSet<Long>) CLongSet.clone();
        cclone.retainAll(tripleLongHashSet.CLongSet);
        if (cclone.size()> 0)
            return true;
        return false;
    }

}
