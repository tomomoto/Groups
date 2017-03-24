import java.util.HashSet;

/**
 * Created by Tom on 18.03.2017.
 */
public class BackGroup extends AbstractGroup {

    private HashSet<String> strings;

    public BackGroup() {
        super();
        strings = new HashSet<>();
    }

    public BackGroup(Long a, Long b, Long c) {
        super(a, b, c);
        strings = new HashSet<>();
        strings.add(new String(a.toString()+';'+b.toString()+';'+c.toString()));
    }

    public BackGroup(TripleLongHashSet tlhs, TripleLongArrayList tlal){
        super(tlhs);
        strings = new HashSet<>();
        Add(tlal);
        //for (int i=0;i<tlal.Size();i++)
        //    strings.add(new String(tlal.Get(i).getA().toString()+';'+tlal.Get(i).getB().toString()+';'+tlal.Get(i).getC().toString()));
    }
    /*public BackGroup(HashSet<Long> a, HashSet<Long> b, HashSet<Long> c) {
        super(a, b, c);
        strings = new HashSet<>();
        strings.add(new String(a.toString()+';'+b.toString()+';'+c.toString()));
    }*/

    public BackGroup(TripleLong tripleLong) {
        super(tripleLong);
        strings = new HashSet<>();
        strings.add(new String(tripleLong.getA().toString() + ';' + tripleLong.getB().toString() + ';' + tripleLong.getC().toString()));
    }

    public BackGroup(TripleLongHashSet tlhs){
        super(tlhs);

    }

    private boolean contains(Long a, Long b, Long c){
        if (a != 0l && get_tripleLongHashSet().ALongSet.contains(a))
            return true;
        if (b != 0l && get_tripleLongHashSet().BLongSet.contains(b))
            return true;
        if (c != 0l && get_tripleLongHashSet().CLongSet.contains(c))
            return true;
        return false;
    }

    public boolean add(Long a, Long b, Long c){
        String str = new String(a.toString()+';'+b.toString()+';'+c.toString());
        strings.add(str);
        boolean add_a = false;
        boolean add_b = false;
        boolean add_c = false;
        if (a != 0L)
            add_a = get_tripleLongHashSet().ALongSet.add(a);
        if (b != 0L)
            add_b = get_tripleLongHashSet().BLongSet.add(b);
        if (c != 0L)
            add_c = get_tripleLongHashSet().CLongSet.add(c);
        return (add_a || add_b || add_c);
    }

    public void Add(TripleLongArrayList tripleLongArrayList){
        for (int i=0;i<tripleLongArrayList.Size();i++)
            strings.add(new String(tripleLongArrayList.Get(i).getA().toString()+';'+
                    tripleLongArrayList.Get(i).getB().toString()+';'+
                    tripleLongArrayList.Get(i).getC().toString()));
    }

    public boolean Add(TripleLong tripleLong){
        return add(tripleLong.getA(),tripleLong.getB(),tripleLong.getC());
    }


    public boolean add_if_any_set_contains (Long a1, Long b1, Long c1){
        if (contains(a1,b1,c1)) {
            boolean add = add(a1, b1, c1);
            return add;
        }
        return false;
    }

    public boolean add_if_any_set_contains (String str){
        String[] parts = str.split(";");
        Long strLong1 = Long.valueOf(parts[0]);
        Long strLong2 = Long.valueOf(parts[1]);
        Long strLong3 = Long.valueOf(parts[2]);
        if (contains(strLong1,strLong2,strLong3)) {
            boolean add = add(strLong1, strLong2, strLong3);
            return add;
        }
        return false;
    }

    public boolean add_if_any_set_contains (TripleLong tripleLong){
        if (contains(tripleLong.getA(), tripleLong.getB(), tripleLong.getC())) {
            boolean add = add(tripleLong.getA(), tripleLong.getB(), tripleLong.getC());
            return add;
        }
        return false;
    }

    public boolean CanMerge (TripleLongHashSet tripleLongHashSet){
        HashSet<Long> aLongSet = tripleLongHashSet.ALongSet;
        for (Long aLong:aLongSet){
            if (m_tripleLongHashSet.ALongSet.contains(aLong))
                return true;
        }
        HashSet<Long> bLongSet = tripleLongHashSet.BLongSet;
        for (Long bLong:bLongSet){
            if (m_tripleLongHashSet.BLongSet.contains(bLong))
                return true;
        }
        HashSet<Long> cLongSet = tripleLongHashSet.CLongSet;
        for (Long cLong:cLongSet){
            if (m_tripleLongHashSet.CLongSet.contains(cLong))
                return true;
        }
        return false;
    }

    public boolean Merge (BackGroup group){
        boolean merge_a = m_tripleLongHashSet.ALongSet.addAll(group.get_tripleLongHashSet().ALongSet);
        boolean merge_b = m_tripleLongHashSet.BLongSet.addAll(group.get_tripleLongHashSet().BLongSet);
        boolean merge_c = m_tripleLongHashSet.CLongSet.addAll(group.get_tripleLongHashSet().CLongSet);
        strings.addAll(group.strings);
        return (merge_a || merge_b || merge_c);
    }

    public boolean Merge (TripleLongHashSet tlhs, TripleLongArrayList tlal){
        boolean merge_a = m_tripleLongHashSet.ALongSet.addAll(tlhs.ALongSet);
        boolean merge_b = m_tripleLongHashSet.BLongSet.addAll(tlhs.BLongSet);
        boolean merge_c = m_tripleLongHashSet.CLongSet.addAll(tlhs.CLongSet);
        Add(tlal);
        return (merge_a || merge_b || merge_c);
    }

    public HashSet<String> return_string_list (){
        return strings;
    }
}
