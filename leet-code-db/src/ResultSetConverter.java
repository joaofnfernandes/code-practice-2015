import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultSetConverter {
    private static final int IDENTATION_FACTOR = 4;

    public static String convert(ResultSet resultSet) {
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
        } catch (SQLException e) {
            System.err
                    .println("Error interpreting resultset meta data to create json");
            return "";
        }
        try {
            while (resultSet.next()) {
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();

                for (int i = 1; i < numColumns + 1; i++) {
                    String column_name = rsmd.getColumnName(i);

                    if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
                        obj.put(column_name, resultSet.getArray(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
                        obj.put(column_name, resultSet.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
                        obj.put(column_name, resultSet.getBoolean(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
                        obj.put(column_name, resultSet.getBlob(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
                        obj.put(column_name, resultSet.getDouble(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
                        obj.put(column_name, resultSet.getFloat(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
                        obj.put(column_name, resultSet.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
                        obj.put(column_name, resultSet.getNString(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
                        obj.put(column_name, resultSet.getString(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
                        obj.put(column_name, resultSet.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
                        obj.put(column_name, resultSet.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
                        obj.put(column_name, resultSet.getDate(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
                        obj.put(column_name,resultSet.getTimestamp(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.NULL) {
                        obj.put(column_name, JSONObject.NULL);
                    } else {
                        obj.put(column_name, resultSet.getObject(column_name));
                    }
                    json.put(obj);
                }
                return json.toString(IDENTATION_FACTOR);
            }
        } catch (SQLException e) {
            json = null;
            System.err.println("Error reading dataset when converting to json");
        } catch (JSONException e) {
            json = null;
            System.err.println("Error serializing json from dataset");
        }
        return "";
    }
}
