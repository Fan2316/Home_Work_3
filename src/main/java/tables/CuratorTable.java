package tables;


import objects.Curator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CuratorTable extends AbsTable {
    private final static String TABLE_NAME = "curator";

    public CuratorTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("id", "bigint");
        columns.put("curatorFIO", "varchar(50)");
        create();
    }

    public ArrayList<Curator> selectAll() {

        final String sqlRequest = String.format("SELECT * FROM %s", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        return resultSetToArray(rs);
    }

    public void insert(Curator curator) {

        final String sqlRequest = String.format("INSERT INTO %s (id, curatorFIO) " +
                        "VALUES (%d, '%s')",
                tableName, curator.getId(), curator.getCuratorFIO());
        db.executeRequest(sqlRequest);
    }

    private ArrayList<Curator> resultSetToArray(ResultSet rs) {
        ArrayList<Curator> result = new ArrayList<>();

        try {
            while (rs.next()) {
                result.add(
                        new Curator(
                                rs.getLong("id"),
                                rs.getString("curatorFIO")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
