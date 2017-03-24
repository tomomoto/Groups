import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Tom on 23.03.2017.
 */
public class TripleLongArrayList {

    private ArrayList<Long> ALongArray;
    private ArrayList<Long> BLongArray;
    private ArrayList<Long> CLongArray;


    public TripleLongArrayList() {
        ALongArray = new ArrayList<>();
        BLongArray = new ArrayList<>();
        CLongArray = new ArrayList<>();
    }

    public TripleLongArrayList(ArrayList<Long> ALongArray, ArrayList<Long> BLongArray, ArrayList<Long> CLongArray) {
        this.ALongArray = ALongArray;
        this.BLongArray = BLongArray;
        this.CLongArray = CLongArray;
    }

    public ArrayList<Long> getALongArray() {
        return ALongArray;
    }

    public void setALongArray(ArrayList<Long> ALongArray) {
        this.ALongArray = ALongArray;
    }

    public ArrayList<Long> getBLongArray() {
        return BLongArray;
    }

    public void setBLongArray(ArrayList<Long> BLongArray) {
        this.BLongArray = BLongArray;
    }

    public ArrayList<Long> getCLongArray() {
        return CLongArray;
    }

    public void setCLongArray(ArrayList<Long> CLongArray) {
        this.CLongArray = CLongArray;
    }

    public TripleLong Get(int index){
        return new TripleLong(ALongArray.get(index),BLongArray.get(index),CLongArray.get(index));
    }

    public boolean Add(Long a, Long b, Long c){
        boolean add_a = ALongArray.add(a);
        boolean add_b = BLongArray.add(b);
        boolean add_c = CLongArray.add(c);
        return (add_a || add_b || add_c);
    }

    public boolean Add(TripleLong tripleLong){
        boolean add = ALongArray.add(tripleLong.getA());
        boolean add1 = BLongArray.add(tripleLong.getB());
        boolean add2 = CLongArray.add(tripleLong.getC());
        return (add || add1 || add2);
    }

    public ArrayList<Long> getAArray (){
        return ALongArray;
    }

    public ArrayList<Long> getBArray (){
        return BLongArray;
    }

    public ArrayList<Long> getCArray (){
        return CLongArray;
    }

    public int GetIndexByA (Long el){
        return ALongArray.indexOf(el);
    }

    public int GetIndexByB (Long el){
        return BLongArray.indexOf(el);
    }

    public int GetIndexByC (Long el){
        return CLongArray.indexOf(el);
    }


    public void Remove(int index){
        ALongArray.remove(index);
        BLongArray.remove(index);
        CLongArray.remove(index);
    }

    public int Size() {
        int asize = ALongArray.size();
        int bsize = BLongArray.size();
        int csize = CLongArray.size();
        if (asize == bsize && asize == csize)
            return  asize;
        else
            return 0;
    }
}
