package soap.service;

import soap.common.User;
import soap.common.UserService;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public class UserServiceImpl implements UserService {



    public User getUserIfoById(Integer id) {
        User u = new User();

        if (3 == id) {
            u.setName("我是3号，张三");
            return u;
        } else if (4 == id) {
            u.setName("我是4号，李四");
            return u;
        } else if (5 == id) {
            u.setName("我是5号，王五");
            return u;
        } else {
            u.setName("查无此人！");
            return u;
        }

    }
}
