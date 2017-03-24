/**
 * Created by Tom on 18.03.2017.
 */
public class TripleLong {

    private Long a;
    private Long b;
    private Long c;

    public TripleLong() {
    }

    public TripleLong(Long a, Long b, Long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }

    public Long getB() {
        return b;
    }

    public void setB(Long b) {
        this.b = b;
    }

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    @Override
    public int hashCode() {
        return (a.toString()+'a'+b.toString()+'b'+c.toString()+'c').hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
                return true;
        TripleLong tripleLong = (TripleLong) obj;
        if (a == tripleLong.getA() && b == tripleLong.getB() && c == tripleLong.getC())
            return true;
        return false;
    }
}
