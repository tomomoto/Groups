
public class Group extends AbstractGroup {

    public TripleLongArrayList get_tripleLongArrayList() {
        return m_tripleLongArrayList;
    }

    public void set_tripleLongArrayList(TripleLongArrayList m_tripleLongArrayList) {
        this.m_tripleLongArrayList = m_tripleLongArrayList;
    }

    private TripleLongArrayList m_tripleLongArrayList;

    public Group(TripleLongHashSet tlhs, TripleLongArrayList m_tripleLongArrayList) {
        super(tlhs);
        this.m_tripleLongArrayList = m_tripleLongArrayList;
    }

    public Group() {
        super();
        m_tripleLongArrayList = new TripleLongArrayList();
    }

    public Group(Long a, Long b, Long c) {
        super(a, b, c);
        m_tripleLongArrayList = new TripleLongArrayList();
        m_tripleLongArrayList.Add(new TripleLong(a, b, c));
    }

    public Group(TripleLong tripleLong) {
        super(tripleLong);
        m_tripleLongArrayList = new TripleLongArrayList();
        m_tripleLongArrayList.Add(tripleLong);
    }

    public void Add(TripleLong tripleLong) {
        super.AddToTripledSet(tripleLong);
        m_tripleLongArrayList.Add(tripleLong);
    }

    public void Add(Group group) {
        super.AddToTripledSet(group.get_tripleLongHashSet());
        m_tripleLongArrayList.Add(group.get_tripleLongArrayList());
    }

    /*@Override
    public boolean IsUnique(TripleLong tripleLong) {
        return super.IsUnique(tripleLong);
    }*/

    public Group GetGroupAndRemove(TripleLong tripleLong) {
        TripleLongHashSet tripleLongHashSet = new TripleLongHashSet(tripleLong);
        TripleLongArrayList tripleLongArrayList = new TripleLongArrayList(tripleLong);
        Long a = tripleLong.getA();
        Long b = tripleLong.getB();
        Long c = tripleLong.getC();
        if (ContainsByA(a)){
            TripleLong tl = m_tripleLongArrayList.RemoveRowByAValue(a);
            get_tripleLongHashSet().Remove(tl);
            tripleLongHashSet.Add(tl);
            tripleLongArrayList.Add(tl);
        }
        if (ContainsByB(b)){
            TripleLong tl = m_tripleLongArrayList.RemoveRowByBValue(b);
            get_tripleLongHashSet().Remove(tl);
            tripleLongHashSet.Add(tl);
            tripleLongArrayList.Add(tl);
        }
        if (ContainsByC(c)){
            TripleLong tl = m_tripleLongArrayList.RemoveRowByCValue(c);
            get_tripleLongHashSet().Remove(tl);
            tripleLongHashSet.Add(tl);
            tripleLongArrayList.Add(tl);
        }
        RemoveFromTripeledSet(tripleLong);
        return new Group(tripleLongHashSet,tripleLongArrayList);
    }
}

