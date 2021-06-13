package usermanagement

import org.bson.types.ObjectId

class Organisation {
    ObjectId id
    String name
    String namespace
    String description
    Date establishedDate
    String email
    String mobile
    String website
    String fax
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
        namespace unique:true
        email unique:true
        mobile unique:true
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        website nullable: true, blank: true
        fax nullable: true, blank: true
    }
}
