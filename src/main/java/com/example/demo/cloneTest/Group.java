package com.example.demo.cloneTest;

public class Group implements Cloneable {
    private String groupName;
    private String groupId;
    private Person person;

    public Group() {

    }

    public Group(String groupName, String groupId, Person person) {
        super();
        this.groupName = groupName;
        this.groupId = groupId;
        this.person = person;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Group [groupName=" + groupName + ", groupId=" + groupId + ", person=" + person + "]";
    }

    public Object clone() {
        Group group = null;
        try {
            group = (Group) super.clone();
            //深克隆，将属性person也进行克隆，Person要实现Cloneable
            group.person = (Person) person.clone();
            return group;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return group;

    }

}