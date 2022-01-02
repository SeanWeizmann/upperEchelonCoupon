package coupon_project.db_util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) throws SQLException {
        String sql = "DELETE * FROM COUPON WHERE name LIKE %?% AND qty>? " +
                "AND companyVIP=? ";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, "soup");
        params.put(2, 4);
        params.put(3, false);
        DataBaseUtil.runQuery(sql, params);
    }
}
