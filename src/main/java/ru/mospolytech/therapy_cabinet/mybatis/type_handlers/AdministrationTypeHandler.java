package ru.mospolytech.therapy_cabinet.mybatis.type_handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@MappedTypes(AdministrationType.class)
@SuppressWarnings("OptionalGetWithoutIsPresent")
public class AdministrationTypeHandler extends BaseTypeHandler<AdministrationType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, AdministrationType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public AdministrationType getNullableResult(ResultSet rs, String columnName) throws SQLException, NoSuchElementException {
        int result = rs.getInt(columnName);
        if (result == 0 && rs.wasNull()) {
            return null;
        }
        return Arrays.stream(AdministrationType.values()).filter(v -> v.getCode() == result).findFirst().get();
    }

    @Override
    public AdministrationType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int result = rs.getInt(columnIndex);
        if (result == 0 && rs.wasNull()) {
            return null;
        }
        return Arrays.stream(AdministrationType.values()).filter(v -> v.getCode() == result).findFirst().get();
    }

    @Override
    public AdministrationType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int result = cs.getInt(columnIndex);
        if (result == 0 && cs.wasNull()) {
            return null;
        }
        return Arrays.stream(AdministrationType.values()).filter(v -> v.getCode() == result).findFirst().get();
    }

}
