/**
 * Created by Tom on 23.03.2017.
 */

/**
 * Created by Tom on 18.03.2017.
 */
public class FrontGroup extends AbstractGroup {

    private TripleLongArrayList m_tripleLongArrayList;

    public FrontGroup() {
        super();
        m_tripleLongArrayList = new TripleLongArrayList();
    }

    public FrontGroup(Long a, Long b, Long c) {
        super(a, b, c);
        m_tripleLongArrayList = new TripleLongArrayList();
        m_tripleLongArrayList.Add(new TripleLong(a, b, c));
    }

    public FrontGroup(TripleLong tripleLong) {
        super(tripleLong);
        m_tripleLongArrayList = new TripleLongArrayList();
        m_tripleLongArrayList.Add(tripleLong);
    }

    public void Add(TripleLong tripleLong) {
        m_tripleLongHashSet.Add(tripleLong);
        m_tripleLongArrayList.Add(tripleLong);
    }

    public TripleLongArrayList getTripleLongArrayList() {
        return m_tripleLongArrayList;
    }

    public void setTripleLongArrayList(TripleLongArrayList tripleLongArrayList) {
        this.m_tripleLongArrayList = tripleLongArrayList;
    }

    public void RemoveFromA(Long a, Long b, Long c){
        m_tripleLongHashSet.Remove(a,b,c);
        int index = m_tripleLongArrayList.getAArray().indexOf(a);
        m_tripleLongArrayList.Remove(index);
    }

    public void RemoveFromB(Long a, Long b, Long c){
        m_tripleLongHashSet.Remove(a, b, c);
        int index = m_tripleLongArrayList.getBArray().indexOf(b);
        m_tripleLongArrayList.Remove(index);
    }

    public void RemoveFromC(Long a, Long b, Long c){
        m_tripleLongHashSet.Remove(a,b,c);
        int index = m_tripleLongArrayList.getCArray().indexOf(c);
        m_tripleLongArrayList.Remove(index);
    }
}

