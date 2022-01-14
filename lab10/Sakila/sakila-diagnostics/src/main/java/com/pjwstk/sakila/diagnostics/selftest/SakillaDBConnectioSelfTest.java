package com.pjwstk.sakila.diagnostics.selftest;


import org.springframework.stereotype.Component;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

@Component

public class SakillaDBConnectioSelfTest extends SelfTestBase {
    public SakillaDBConnectioSelfTest() {
        name = "SakilaDBConnectionSelfTest";
        description = "Checks the connection with sakila database ";
    }

    @Override
    public SelftestResult execute() {
      List <String> errors = new ArrayList<>();
       SelftestResult selftestResult = new SelftestResult(name, description, false, (List<String>) errors);
        String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);) {
            selftestResult.setPassed(true);
        }
        catch (SQLException e) {
            selftestResult.setPassed(false);
            errors.add("SQL exception occurred, this was the stack: " + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return selftestResult;
    }
}

