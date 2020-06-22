import com.alibaba.fastjson.JSON;
import com.spring.annotation.config.AppConfig;
import com.spring.annotation.config.AppConfig2;
import com.spring.annotation.config.AppConfig3;
import com.spring.annotation.control.RoleController2;
import com.spring.annotation.entity.DbSource;
import com.spring.annotation.entity.Role;
import com.spring.annotation.control.RoleController;
import com.spring.annotation.service.impl.RoleServiceImpl2;
import com.spring.el.ElShow;
import com.spring.pojo.LogInfo;
import com.spring.pojo.SpringBeanConfigDemo;
import com.spring.annotation.service.RoleService;
import com.spring.annotation.service.impl.RoleServiceImpl;
import com.spring.util.DbManager;
import com.spring.util.LoggerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @description:Spring Bean 测试
 * @author: Cherry
 * @time: 2020/6/4 16:04
 */
public class SpringBean {
    ApplicationContext app = null;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Logger logger = LogManager.getLogger(SpringBean.class.getName());

    @Before
    public void beforeTest() {
        app = new ClassPathXmlApplicationContext("config/spring-config.xml");
    }

    @After
    public void afterTest() throws SQLException {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }

    @Test
    public void beanShow() throws SQLException {
        DbManager manager = (DbManager) app.getBean("dbManager");
        conn = manager.getConnection();
        String sql = "select * from teacher where uuid = ?";

        ps = conn.prepareCall(sql);
        ps.setInt(1, 1);

        rs = ps.executeQuery();
        while (rs.next()) {
            show(rs.getString(1));
            show(rs.getString(2));
            show(rs.getString(3));
        }
    }

    @Test
    public void beanShow2(){
        SpringBeanConfigDemo sbcd = (SpringBeanConfigDemo) app.getBean("beanDemo");

        String str = JSON.toJSONString(sbcd);

        show(str);
    }

    @Test
    public void beanShow3(){
        SpringBeanConfigDemo sbcd = (SpringBeanConfigDemo) app.getBean("beanDemo2");

        String str = JSON.toJSONString(sbcd);

        show(str);
    }

    @Test
    public void beanShow4(){
       app = new AnnotationConfigApplicationContext(AppConfig.class);

       Role r = (Role) app.getBean("role");
        String str = JSON.toJSONString(r);

        show(str);
    }

    @Test
    public void beanShow5(){
        app = new AnnotationConfigApplicationContext(Role.class,RoleServiceImpl.class, RoleServiceImpl2.class, RoleController.class, DbSource.class);

        RoleService service = (RoleService) app.getBean(RoleService.class);
        service.atack();

        RoleController controller = app.getBean(RoleController.class);
        controller.show();
    }

    @Test
    public void beanShow6() throws SQLException {
        app = new AnnotationConfigApplicationContext(AppConfig2.class);

        Role r = (Role) app.getBean("role");
        String str = JSON.toJSONString(r);
        show(str);

        RoleController controller = app.getBean(RoleController.class);
        show(controller.getRole(2));
    }

    @Test
    public void beanShow7() throws SQLException {
        app = new AnnotationConfigApplicationContext(AppConfig3.class);

        String url = app.getEnvironment().getProperty("jdbc.database.url");
        show(url);

        RoleController2 controller2 = (RoleController2) app.getBean("roleController2");
        show(controller2.getRole(1));
    }

    @Test
    public void beanEl() throws SQLException {
        app = new AnnotationConfigApplicationContext(Role.class,DbSource.class, ElShow.class);
        ElShow bean = app.getBean(ElShow.class);
        show(bean);

        DataSource data = app.getBean(DataSource.class);

        conn = data.getConnection();
        String sql = "select * from teacher where uuid = ?";

        ps = conn.prepareCall(sql);
        ps.setInt(1, 1);

        rs = ps.executeQuery();
        while (rs.next()) {
            show(rs.getString(1));
            show(rs.getString(2));
            show(rs.getString(3));
        }
    }

    @Test
    public void showJson(){
        LogInfo logInfo = new LogInfo(1,"一泻千里","2020-6-5");
        String beanStr = JSON.toJSONString(logInfo);
        show(beanStr);

        HashMap<String,Object> map = new HashMap<>(10);
        map.put("id",1);
        map.put("name","Cherry");
        map.put("content","望尘莫及");
        map.put("array",new String[]{"一心一意","一叶知秋","一丘之貉"});
        String mapStr = JSON.toJSONString(map);
        show(mapStr);
    }

    public void show(Object obj){
        LoggerUtil.getLog(SpringBean.class).info(obj);
    }
}
