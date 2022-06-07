package common.mybatis.type_handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;

/**
 * @see <a href="https://github.com/LukeL99/joda-time-mybatis">github</a>
 */
@MappedTypes(DateTime.class)
public class DateTimeTypeHandler extends BaseTypeHandler<DateTime>
{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
        } else {
            ps.setTimestamp(i, null);
        }
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnName);
        if (ts != null) {
            return new DateTime(ts.getTime(), DateTimeZone.UTC);
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnIndex);
        if (ts != null) {
            return new DateTime(ts.getTime(), DateTimeZone.UTC);
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp ts = cs.getTimestamp(columnIndex);
        if (ts != null) {
            return new DateTime(ts.getTime(), DateTimeZone.UTC);
        }
        return null;
    }
}
