package ru.mospolytech.therapy_cabinet.mybatis.type_handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@MappedTypes(IndexType.class)
@SuppressWarnings("OptionalGetWithoutIsPresent")
public class IndexTypeTypeHandler extends BaseTypeHandler<IndexType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, IndexType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public IndexType getNullableResult(ResultSet rs, String columnName) throws SQLException, NoSuchElementException {
        int result = rs.getInt(columnName);
        if (result == 0 && rs.wasNull()) {
            return null;
        }
        return Arrays.stream(IndexType.values()).filter(v -> v.getCode() == result).findFirst().get();
    }

    @Override
    public IndexType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int result = rs.getInt(columnIndex);
        if (result == 0 && rs.wasNull()) {
            return null;
        }
        return Arrays.stream(IndexType.values()).filter(v -> v.getCode() == result).findFirst().get();
    }

    @Override
    public IndexType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int result = cs.getInt(columnIndex);
        if (result == 0 && cs.wasNull()) {
            return null;
        }
        return Arrays.stream(IndexType.values()).filter(v -> v.getCode() == result).findFirst().get();
    }

}
