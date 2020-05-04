package usermanagement

class Product {
    String name
    String namespace
    String description
    User user

    static constraints = {
        description nullable: true, blank: true
    }
}
