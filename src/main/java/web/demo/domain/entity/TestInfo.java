package web.demo.domain.entity;

/**
 * @author sunc
 * @date 2019/11/15 17:57
 * @description TableInfo
 */

public class TestInfo {

    private int age;
    private String name;
    private String description;

    public int getAge() {
        return age;
    }

    public TestInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TestInfo setDescription(String description) {
        this.description = description;
        return this;
    }
}
