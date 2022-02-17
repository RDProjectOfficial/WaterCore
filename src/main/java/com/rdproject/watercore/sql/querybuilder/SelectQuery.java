package com.rdproject.watercore.sql.querybuilder;

import com.rdproject.watercore.sql.*;

import java.sql.*;

@SuppressWarnings("ALL")
public class SelectQuery extends Query {

    private boolean addNoCase;

    public SelectQuery(MySQL sql, String query) {
        super(sql, query);
        addNoCase = false;
    }

    public SelectQuery where(String key, Object value) {
        addNoCase = true;
        if(!and) {
            query += " WHERE";
            and = true;
        }else query += " AND";
        query += " `"+key+"`=?";
        values.add(value);
        return this;
    }

    public SelectQuery whereWithOr(String key, Object value) {
        addNoCase = true;
        if(!and){
            query += " WHERE";
            and = true;
        }else query += " or";
        query += " `"+key+"`=?";
        values.add(value);
        return this;
    }

    public void execute() {
        execute(object -> null);
    }

    public <R> R execute(String query, ConsumerReturn<ResultSet,R> consumer) {
        this.query = query;
        this.addNoCase = false;
        return execute(consumer);
    }

    public <R> R execute(ConsumerReturn<ResultSet,R> consumer) {
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int i = 1;
            for (Object object : values) {
                preparedStatement.setObject(i, object);
                i++;
            }
            return consumer.accept(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(sql != null)connection.close();
            } catch (SQLException ignored) {}
        }
    }

    public SelectQuery noCase() {
        this.query += " COLLATE NOCASE";
        return this;
    }
    public interface ConsumerReturn<T,R> {

        public R accept(T object);

    }
}