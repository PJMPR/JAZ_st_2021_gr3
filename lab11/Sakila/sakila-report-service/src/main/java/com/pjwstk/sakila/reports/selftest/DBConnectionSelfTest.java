package com.pjwstk.sakila.reports.selftest;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import com.pjwstk.sakila.diagnostics.selftest.SelfTestBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBConnectionSelfTest extends SelfTestBase {
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.url}")
    String url;

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult selftestResult = new SelfTestResult("DBConnectionSelfTest", "Checks if connection with database is possible.", false, errors);

        try (Connection connection = DriverManager.getConnection(url, username, password);) {
            selftestResult.setPassed(true);
        }
        catch (SQLException e) {
            errors.add("SQL exception " + e.getMessage());
        }

        return selftestResult;
    }
}
