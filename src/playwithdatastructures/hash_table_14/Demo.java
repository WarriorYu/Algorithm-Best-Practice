package playwithdatastructures.hash_table_14;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/4
 * Describe :
 */
public class Demo {
    private int a;
    private int f;

    private long b;
    private long g;

    private boolean c;
    private boolean h;

    private String d;
    private String e;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demo demo = (Demo) o;

        if (a != demo.a) return false;
        if (f != demo.f) return false;
        if (b != demo.b) return false;
        if (g != demo.g) return false;
        if (c != demo.c) return false;
        if (h != demo.h) return false;
        if (d != null ? !d.equals(demo.d) : demo.d != null) return false;
        return e != null ? e.equals(demo.e) : demo.e == null;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + f;
        result = 31 * result + (int) (b ^ (b >>> 32));
        result = 31 * result + (int) (g ^ (g >>> 32));
        result = 31 * result + (c ? 1 : 0);
        result = 31 * result + (h ? 1 : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (e != null ? e.hashCode() : 0);
        return result;
    }
}
