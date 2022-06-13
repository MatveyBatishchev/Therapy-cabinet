package ru.mospolytech.therapy_cabinet.mybatis.type_handlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import ru.mospolytech.therapy_cabinet.exception.RoleNotFoundException;
import ru.mospolytech.therapy_cabinet.models.domain.user.Authority;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static ru.mospolytech.therapy_cabinet.exception.RoleNotFoundException.ROLE_NOT_EXISTS;


/**
 * @author Dimevision
 * @version 0.1
 * <p>
 * Class made for handling {@link ru.mospolytech.therapy_cabinet.models.domain.user.Authority} enum
 */

@MappedTypes(Authority.class)
public class UserRoleTypeHandler implements TypeHandler<Authority> {

    @Override
    public void setParameter(PreparedStatement ps, int paramInt, Authority authority, JdbcType jdbcType) throws SQLException {
        ps.setInt(paramInt, authority.getId());
    }

    @Override
    public Authority getResult(ResultSet rs, String columnName) throws SQLException {
        String role = rs.getString(columnName);

        return role == null
                ? null
                : Arrays.stream(Authority.values())
                .filter(v -> v.name().equals(role)).findFirst()
                .orElseThrow(() ->
                        new RoleNotFoundException(String.format(ROLE_NOT_EXISTS, role)));
    }

    @Override
    public Authority getResult(ResultSet rs, int columnIndex) throws SQLException {
        String role = rs.getString(columnIndex);

        return role == null
                ? null
                : Arrays.stream(Authority.values())
                .filter(v -> v.name().equals(role)).findFirst()
                .orElseThrow(() ->
                        new RoleNotFoundException(String.format(ROLE_NOT_EXISTS, role)));
    }

    @Override
    public Authority getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String role = cs.getString(columnIndex);

        return role == null
                ? null
                : Arrays.stream(Authority.values())
                .filter(v -> v.name().equals(role)).findFirst()
                .orElseThrow(() ->
                        new RoleNotFoundException(String.format(ROLE_NOT_EXISTS, role)));
    }
}
