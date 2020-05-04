package acceleratemulti

import usermanagement.Organisation
import usermanagement.Plan
import usermanagement.Product
import usermanagement.Role
import usermanagement.Subscription
import usermanagement.User
import usermanagement.UserRole

class BootStrap {

    def init = { servletContext ->




        Organisation teraret = new Organisation(name: "Teraret Managed Cloud Private Limited",namespace: "teraret.com",email: "sales@teraret.com",mobile: "+91-8667710055").save()
        Organisation qualifica = new Organisation(name: "Qualifica Group",namespace: "qualificagroup.it",email: "sales@qualificagroup.it",mobile: "+91-8665510077").save()

        User admin = new User(organisation: teraret,username: "babuamuda@gmail.com",password:"B@vana20").save()
        User qualificaadmin = new User(organisation: qualifica,username: "audit@qualificagroup.it",password:"test@123").save()


        Product workflow = new Product(name: "Accelerate Workflow",namespace: "accelerate-workflow",user: admin).save()
        Plan freeplan =  new Plan(product: workflow,name: "Free Plan",namespace: "free-plan",features: "Free Plan",price: 0.0,validity: 30,user: admin).save()

         new Subscription(organisation: teraret,plan: freeplan).save()


        User customer = new User(organisation: teraret,username: "liricsdash2014@gmail.com",password:"lirics@123").save()
        User account = new User(organisation: teraret,username: "akshitharajappa10@gmail.com",password:"akshitha@123").save()
        Role adminrole = new Role(authority: "ROLE_ADMIN").save()
        Role companyrole =new Role(authority: "ROLE_COMPANY").save()

        Role contactrole =new Role(authority: "ROLE_CONTACT").save()
        Role customerrole = new Role(authority: "ROLE_CUSTOMER").save()
        Role accountrole = new Role(authority: "ROLE_ACCOUNT").save()

        UserRole.create(admin,adminrole)
        UserRole.create(qualificaadmin,companyrole)
        UserRole.create(customer,customerrole)
        UserRole.create(account,accountrole)
    }

    def destroy = {

    }

}
