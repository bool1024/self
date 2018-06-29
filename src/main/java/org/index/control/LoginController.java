package org.index.control;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.user.model.User;

@Controller
public class LoginController {

    private static final String INDEX_PAGE = "index";
    
    private SqlSessionTemplate sqlSession;
    
    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }



    @RequestMapping(value = "web/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        System.out.println(username);
        
        User user = (User)sqlSession.selectOne("User.selectUser","test");
        System.out.println(user.getPassword());
        
        return INDEX_PAGE;
    }
}
