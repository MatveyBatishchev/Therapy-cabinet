package ru.mospolytech.therapy_cabinet.mybatis.type_handlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import ru.mospolytech.therapy_cabinet.models.domain.user.Authority;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Dimevision
 * @version 0.1
 * <p>
 * Class made for handling {@link Authority} enum
 */

@MappedTypes(Authority.class)
public class UserRoleTypeHandler implements TypeHandler<List<Authority>> {

    @Override
    public void setParameter(PreparedStatement ps, int paramInt, List<Authority> authority, JdbcType jdbcType) throws SQLException {
        ps.setInt(paramInt, authority.get(0).getId());
    }

    @Override
    public List<Authority> getResult(ResultSet rs, String columnName) throws SQLException {
        String[] role = rs.getString(columnName).replaceAll("[{}|\"]", "").split(",");
        if (role.length == 0) {
            return Collections.emptyList();
        }

        Authority[] values = Authority.values();
        List<Authority> authorities = new ArrayList<>();

        for (String s : role) {
            for (Authority value : values) {
                if (Integer.parseInt(s) == value.getId()) {
                    authorities.add(value);
                }
            }
        }

        return authorities;
    }

    @Override
    public List<Authority> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String role = rs.getString(columnIndex);

        return role == null
                ? null
                : Arrays.stream(Authority.values())
                .filter(v -> v.name().equals(role))
                .collect(Collectors.toList());
    }

    @Override
    public List<Authority> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String role = cs.getString(columnIndex);

        return role == null
                ? null
                : Arrays.stream(Authority.values())
                .filter(v -> v.name().equals(role))
                .collect(Collectors.toList());
    }
}
