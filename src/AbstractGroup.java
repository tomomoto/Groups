import java.util.HashSet;

/**
 * Created by Tom on 23.03.2017.
 */
public abstract class AbstractGroup {

    private TripleLongHashSet m_tripleLongHashSet;

    public TripleLongHashSet get_tripleLongHashSet() {
        return m_tripleLongHashSet;
    }

    public void set_tripleLongHashSet(TripleLongHashSet m_tripleLongHashSet) {
        this.m_tripleLongHashSet = m_tripleLongHashSet;
    }

    public AbstractGroup() {
        m_tripleLongHashSet = new TripleLongHashSet();
    }

    public AbstractGroup(Long a, Long b, Long c) {
        m_tripleLongHashSet = new TripleLongHashSet();
        m_tripleLongHashSet.Add(a, b, c);
    }

    public AbstractGroup(TripleLong tripleLong) {
        m_tripleLongHashSet = new TripleLongHashSet();
        m_tripleLongHashSet.Add(tripleLong);
    }

    public AbstractGroup(TripleLongHashSet tlhs) {
        m_tripleLongHashSet = new TripleLongHashSet();
        m_tripleLongHashSet.Merge(tlhs);
    }

    public boolean IsUnique(TripleLong tripleLong) {
        Long a = tripleLong.getA();
        Long b = tripleLong.getB();
        Long c = tripleLong.getC();
        if (a != 0l && m_tripleLongHashSet.ContainsByA(a))
            return false;
        if (b != 0l && m_tripleLongHashSet.ContainsByB(b))
            return false;
        if (c != 0l && m_tripleLongHashSet.ContainsByC(c))
            return false;
        return true;
    }

    public boolean IsIntersect(AbstractGroup group) {
        TripleLongHashSet tripleLongHashSet = group.m_tripleLongHashSet;
        if (m_tripleLongHashSet.IsRetain(tripleLongHashSet))
            return true;
        return false;
    }

    public AbstractGroup(HashSet<Long> a, HashSet<Long> c, HashSet<Long> b) {
        m_tripleLongHashSet.Merge(a, b, c);
    }

    public void AddToTripledSet(TripleLong tripleLong){
        m_tripleLongHashSet.Add(tripleLong);
    }

    public void AddToTripledSet(TripleLongHashSet tl){
        m_tripleLongHashSet.Merge(tl);
    }

    public void AddAll(AbstractGroup abstGr){
        m_tripleLongHashSet.Merge(abstGr.get_tripleLongHashSet());
    }

    public boolean RemoveFromTripeledSet(TripleLong tripleLong){
        return m_tripleLongHashSet.Remove(tripleLong);
    }

    public boolean ContainsByA(Long a){
        return m_tripleLongHashSet.ContainsByA(a);
    }

    public boolean ContainsByB(Long b){
        return m_tripleLongHashSet.ContainsByB(b);
    }

    public boolean ContainsByC(Long c){
        return m_tripleLongHashSet.ContainsByC(c);
    }


}
