package com.rdproject.watercore.sql;

import com.rdproject.watercore.sql.querybuilder.*;

@SuppressWarnings("ALL")
public class MySQLTable {

    private String name;
    private MySQL sql;

    public MySQLTable(MySQL sql,String name) {
        this.name = name;
        this.sql = sql;
    }

    public String getName(){
        return this.name;
    }

    public MySQL getSQL() {
        return this.sql;
    }

    public CreateQuery create(){
        return new CreateQuery(sql,"CREATE TABLE IF NOT EXISTS `"+this.name+"` (");
    }

    public InsertQuery insert(){
        return new InsertQuery(sql,"INSERT INTO `"+this.name+"` (");
    }

    public UpdateQuery update(){
        return new UpdateQuery(sql,"UPDATE `"+this.name+"` SET");
    }

    public SelectQuery selectAll(){
        return select("*");
    }

    public SelectQuery select() {
        return selectAll();
    }

    public SelectQuery select(String selection){
        return new SelectQuery(sql, "SELECT "+selection+" FROM `"+this.name+"`");
    }
    public void execute(String query){
        new ExecuteQuery(sql,query).execute();
    }

    public DeleteQuery delete(){
        return new DeleteQuery(sql, "DELETE FROM `"+this.name+"`");
    }
}
