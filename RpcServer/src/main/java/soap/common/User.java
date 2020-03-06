package soap.common;

import java.io.Serializable;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class User implements Serializable {

    private static final long serialVersionUID = -9002346286111540628L;

    /** id */
    private Integer id;

    /** name */
    private String name;

    /** age */
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
