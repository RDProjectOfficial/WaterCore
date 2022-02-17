package com.rdproject.watercore.sql.querybuilder;

import com.rdproject.watercore.sql.*;

import java.sql.*;
import java.util.*;

@SuppressWarnings("ALL")
public class Query {

    public static List<String> DEFAULT_END_OPTIONS;

    static {
        DEFAULT_END_OPTIONS = new LinkedList<>();
        DEFAULT_END_OPTIONS.addAll(QueryOption.getPossibleEndOptions());
    }

    protected final MySQL sql;
    protected String query = "";
    protected PreparedStatement preparedStatement;
    protected boolean firstvalue = true;
    protected boolean and = false;
    protected boolean comma = false;
    protected final List<Object> values = new LinkedList<>();
    protected final Map<String, String> endOptions = new LinkedHashMap<>();

    public Query(MySQL sql, String query) {
        this.sql = sql;
        this.query = query;
    }

    public Connection getConnection() {
        return this.sql.getConnection();
    }

    public List<Object> getValues(){
        return this.values;
    }

    public String toString(){
        return this.query;
    }
}
