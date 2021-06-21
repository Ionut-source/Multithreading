package ro.ctrln.java.concurrency.model;

import java.util.Objects;

public class Teacher {

    private String firsName;
    private String lastName;
    private Integer age;
    private String domain;

    public Teacher(String firsName, String lastName, Integer age, String domain) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.age = age;
        this.domain = domain;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return firsName.equals(teacher.firsName) && lastName.equals(teacher.lastName) && age.equals(teacher.age) && domain.equals(teacher.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName, age, domain);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", domain='" + domain + '\'' +
                '}';
    }
}
