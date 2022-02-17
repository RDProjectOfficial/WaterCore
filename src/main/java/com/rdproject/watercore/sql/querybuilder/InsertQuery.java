package com.rdproject.watercore.sql.querybuilder;

import com.rdproject.watercore.sql.*;

import java.sql.*;

@SuppressWarnings("ALL")
public class InsertQuery extends ExecuteQuery {

    public InsertQuery(MySQL sql, String query) {
        super(sql, query);
    }

    public InsertQuery insert(String insert) {
        query += "`"+insert+"`,";
        return this;
    }

    public InsertQuery value(Object value) {
        query = query.substring(0, query.length() - 1);
        if(firstvalue){
            query += ") VALUES (?)";
            firstvalue = false;
        }else query += ",?)";
        values.add(value);
        return this;
    }


    public Object executeAndGetKey() {
        return Integer.parseInt(execute(PreparedStatement.RETURN_GENERATED_KEYS).toString());
    }
    public int executeAndGetKeyAsInt(){
        return (int) executeAndGetKey();
    }
}
