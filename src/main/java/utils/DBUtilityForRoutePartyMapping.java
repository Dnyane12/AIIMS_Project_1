package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public  class DBUtilityForRoutePartyMapping {
    public Map<String, String> getRoutePartyMapping(
            String routeName, String entityCode, String partyCode) {

        String query =
            "SELECT rm.slrm_route_name AS route_name, " +
            "am.acnt_account_code AS party_code " +
            "FROM sl_route_mst rm " +
            "JOIN sl_route_dtl rd ON rd.slrd_route_id_slrm = rm.slrm_id " +
            "JOIN fin_account_mst am ON am.acnt_account_id = rd.slrd_party_id_acnt " +
            "WHERE rm.slrm_route_name = ? " +
            "AND rm.slrm_entity_code_ent = ? " +
            "AND am.acnt_account_code = ?";

        Map<String, String> result = new HashMap<>();

        try {
            ResultSet rs = DatabaseUtility.executeSelectQuery(
                query, routeName, entityCode, partyCode
            );

            if (rs.next()) {
                result.put("route_name", rs.getString("route_name"));
                result.put("party_code", rs.getString("party_code"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch Route–Party mapping", e);
        }

        return result;
    }
}
