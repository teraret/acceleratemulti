package usermanagement

class Organisation {
    String name
    String namespace
    Plan plan
    Date validity
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
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        website nullable: true, blank: true
        fax nullable: true, blank: true
    }
}
