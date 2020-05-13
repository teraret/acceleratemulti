package usermanagement

import io.micronaut.core.annotation.Introspected

@Introspected
class Staff {

    private String name
    private  Integer age
    private String status
    private String profession

    Staff() {
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Integer getAge() {
        return age
    }

    void setAge(Integer age) {
        this.age = age
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }

    String getProfession() {
        return profession
    }

    void setProfession(String profession) {
        this.profession = profession
    }
}
