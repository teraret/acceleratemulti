package usermanagement

import org.bson.types.ObjectId

class Plan {
    ObjectId id
    Product product
    String name
    String namespace
    String features
    Float price
    Integer validity
    User user

    static constraints = {
    }
}
