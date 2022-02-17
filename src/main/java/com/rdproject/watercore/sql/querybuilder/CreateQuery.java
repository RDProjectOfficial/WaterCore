package com.rdproject.watercore.sql.querybuilder;

import com.rdproject.watercore.sql.*;

@SuppressWarnings("ALL")
public class CreateQuery extends ExecuteQuery {

    public CreateQuery(MySQL sql, String query) {
        super(sql, query);
        firstvalue = true;
    }

    public CreateQuery create(String field, String type, QueryOption... options) {
        return create(field, type, QueryOption.getAsStringArray(options));
    }

    public CreateQuery create(String field, String type, String... options) {
        return create(field, type, 0, options);
    }

    public CreateQuery create(String field, String type, int size) {
        return create(field, type, size, QueryOption.getAsStringArray());
    }

    public CreateQuery create(String field, String type, int size, QueryOption... options) {
        return create(field, type, size, QueryOption.getAsStringArray(options));
    }

    public CreateQuery create(String field, String type, int size, String... options) {
        StringBuilder builder = new StringBuilder();
        builder.append("`").append(field).append("` ").append(type);
        if(size != 0) builder.append("(").append(size).append(")");
        for(String option : options) {
            builder.append(" ").append(option);
        }
        return create(builder.toString());
    }

    public CreateQuery create(String value) {
        if(!firstvalue) query = query.substring(0,query.length()-1)+",";
        else firstvalue = false;
        query += value+")";
        return this;
    }
}