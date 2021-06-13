package crm

class OfficeType {
    String name

    static constraints = {
        name unique:true
    }
}
