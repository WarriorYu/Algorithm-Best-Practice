package designPattern.bigtalkdesignpattern.prototype;

import java.io.Serializable;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe :
 */
public class WorkExperience implements Cloneable, Serializable {
    public String workData;
    public String company;

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workData='" + workData + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
