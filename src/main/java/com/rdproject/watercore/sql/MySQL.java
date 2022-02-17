package com.rdproject.watercore.sql;

import lombok.*;

import java.sql.*;
import java.util.concurrent.*;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Getter
public class MySQL {

    private final Connection connection;
    private final ExecutorService executorService;

    @SneakyThrows
    public PreparedStatement prepareStatement(String query, Object... args) {

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        int i = 0;
        for (Object arg : args) {

            if (arg instanceof String) {
                preparedStatement.setString(i, (String) arg);
            } else if (arg instanceof Integer) {
                preparedStatement.setInt(i, (int) arg);
            } else if (arg instanceof Float) {
                preparedStatement.setFloat(i, ((Float) arg));
            } else {
                preparedStatement.setObject(i, arg);
            }

            i++;
        }

        return preparedStatement;

    }

    public CompletableFuture<Boolean> executeUpdate(PreparedStatement preparedStatement) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return preparedStatement.execute();
            } catch (SQLException e) {
                return false;
            }
        }, executorService);

    }

    public CompletableFuture<Boolean> executeUpdate(String query, Object... args) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return prepareStatement(query, args).execute();
            } catch (SQLException e) {
                return false;
            }
        }, executorService);

    }

    public CompletableFuture<ResultSet> getResult(PreparedStatement preparedStatement) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return preparedStatement.executeQuery();
            } catch (SQLException e) {
                return null;
            }
        }, executorService);

    }

    public CompletableFuture<ResultSet> getResult(String query, Object... args) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return prepareStatement(query, args).executeQuery();
            } catch (SQLException e) {
                return null;
            }
        }, executorService);

    }

}
