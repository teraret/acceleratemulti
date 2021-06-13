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


        Role adminrole = new Role(authority: "ROLE_ADMIN").save()
        Role companyrole =new Role(authority: "ROLE_COMPANY").save()
        Role contactrole =new Role(authority: "ROLE_CONTACT").save()
        Role customerrole = new Role(authority: "ROLE_CUSTOMER").save()
        Role accountrole = new Role(authority: "ROLE_ACCOUNT").save()


        Set<Role> adminset = new HashSet<>()
        adminset.add(adminrole)
        adminset.add(companyrole)

        Set<Role> companyset = new HashSet<>()
        companyset.add(companyrole)



        User admin = new User(organisation: teraret,email: "harish.babu@teraret.com",mobile: "+91-8667710055",username: "harish.babu@teraret.com",password:"B@vana20",authorities: adminset).save()
        User qualificaadmin = new User(organisation: qualifica,email:"audit@qualificagroup.it",mobile: "+91-8665510077",username: "audit@qualificagroup.it",password:"test@123",authorities: companyset).save()



        Product workflow = new Product(name: "Accelerate Workflow",namespace: "accelerate-workflow",user: admin).save()
        Plan freeplan =  new Plan(product: workflow,name: "Free Plan",namespace: "free-plan",features: "Free Plan",price: 0.0,validity: 30,user: admin).save()

         new Subscription(organisation: teraret,plan: freeplan).save()










    }

    def destroy = {

    }

}
