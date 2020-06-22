import com.spring.annotation.config.AppConfig2;
import com.spring.annotation.control.RoleController;
import com.spring.annotation.entity.Role;
import com.spring.util.LoggerUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description:Spring Annotation 测试
 * @author: Cherry
 * @time: 2020/6/6 12:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig2.class})
@ActiveProfiles("test")
public class SpringAnnotation {
    @Autowired
    private RoleController roleController;

    @Test
    public void show() throws SQLException {
        Role role = roleController.getRole(2);
        show(role);
    }

    public void show(Object obj){
        LoggerUtil.getLog(SpringBean.class).info(obj);
    }
}
