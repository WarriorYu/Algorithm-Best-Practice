package designPattern.bigtalkdesignpattern.prototype;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 浅拷贝和深拷贝  深拷贝通过序列化实现，即先将对象序列化，然后再反序列化成新的对象。
 */
public class ProtoTypeClient {
    public static void main(String[] args) {
        System.out.println("----------------测试浅拷贝----------------");
        shallowCopy();

        System.out.println("----------------测试深拷贝----------------");
        deepCopy();
    }

    private static void deepCopy() {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男", "18");
        a.setWorkExperience("1998-01-19", "a企业");

        Resume b = (Resume) a.deepClone();
        b.setWorkExperience("2000-2005", "b企业");
        Resume c = (Resume) a.deepClone();
        c.setPersonalInfo("女", "28");
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

    }

    private static void shallowCopy() {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男", "18");
        a.setWorkExperience("1998-01-19", "a企业");

        try {
            Resume b = (Resume) a.clone();
            b.setWorkExperience("2000-2005", "b企业");
            Resume c = (Resume) a.clone();
            c.setPersonalInfo("女", "28");
            System.out.println(a.toString());
            System.out.println(b.toString());
            System.out.println(c.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
