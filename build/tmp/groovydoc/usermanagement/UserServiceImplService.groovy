package usermanagement

import grails.gorm.transactions.Transactional

@Transactional
class UserServiceImplService implements UserService {


    @Override
    User get(Serializable id) {
        return null
    }

    @Override
    List<User> list(Map args) {
        def c = User.createCriteria()
        List<User> result = c.list{

            if(args.mobile){
                eq('mobile',args.mobile)
            }
        }
        return result
    }

    @Override
    Long count() {
        return list().size()
    }

    @Override
    void delete(Serializable id) {

    }

    @Override
    User save(User user) {
        return null
    }
}
