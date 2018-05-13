package boying.service.user;

import boying.dao.user.UserDao;
import boying.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 2017/7/4.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional("userTransactionManager")
    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getUser(long userId){
        return userDao.getUserById(userId);
    }


}
