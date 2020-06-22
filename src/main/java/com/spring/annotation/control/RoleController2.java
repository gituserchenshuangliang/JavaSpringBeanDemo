package com.spring.annotation.control;

import com.spring.annotation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:Contoller
 * @author: Cherry
 * @time: 2020/6/6 10:18
 */
@Component("roleController2")
public class RoleController2 {

    @Autowired
    private DataSource dataSource;

    public Role getRole(int id) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Role role = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select id, role_name, note from role where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("role_name"));
                role.setNote(rs.getString("note"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return role;
    }
}
