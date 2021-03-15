package designPattern.bigtalkdesignpattern.prototype;

import java.io.*;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe :
 */
public class Resume implements Cloneable, Serializable {
    public int age;
    public String sex;
    public String name;
    // 工作信息
    public WorkExperience work;

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    public Resume(WorkExperience work) {
        try {
            this.work = (WorkExperience) work.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void setPersonalInfo(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public void setWorkExperience(String workData, String company) {
        work.workData = workData;
        work.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 通过对象序列化，实现深拷贝
     *
     * @return
     */
    protected Object deepClone() {
        // 将对象写入流内
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            // 从流内读出对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Resume obj = (Resume) ois.readObject();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", work=" + work +
                '}';
    }
}
