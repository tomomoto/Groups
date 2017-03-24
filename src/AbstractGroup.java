import java.util.HashSet;

/**
 * Created by Tom on 23.03.2017.
 */
public abstract class AbstractGroup {

    protected TripleLongHashSet m_tripleLongHashSet;

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
        m_tripleLongHashSet.Add(tlhs);
    }

    public AbstractGroup(HashSet<Long> a, HashSet<Long> c, HashSet<Long> b) {
        m_tripleLongHashSet.Add(a,b,c);
    }

    public void AddAll(TripleLongHashSet tl){
        m_tripleLongHashSet.Add(tl);
    }

    public void AddAll(AbstractGroup abstGr){
        m_tripleLongHashSet.Add(abstGr.get_tripleLongHashSet());
    }
}
