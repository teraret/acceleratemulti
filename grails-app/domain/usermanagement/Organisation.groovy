package usermanagement

class Organisation {
    String name
    String website

    static constraints = {
        name unique:true
        website unique:true
    }
}
