package com.softserve.sprint10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*public*/ class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
//        DriverManager.registerDriver(new org.h2.Driver());
        try {
            Class.forName ("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        this.connection = DriverManager.getConnection ("jdbc:h2:~/test", "oleg","oleg");
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }
    public void closeStatement() throws SQLException {
        statement.close();
    }
    public void createSchema(String schemaName) throws SQLException {
        statement.execute("CREATE SCHEMA " + schemaName + ";");
        this.schemaName = schemaName;
    }
    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName + ";");
    }
    public void dropSchema(String schemaName) throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName + ";");
    }
    public void useSchema() throws SQLException {
        statement.execute("USE " +schemaName + ";");
    }
    public void useSchema(String schemaName) throws SQLException {
        statement.execute("USE " +schemaName + ";");
    }

    // -------------Methods for creating tables
    public void createTableRoles() throws SQLException {
        statement.execute("CREATE TABLE Roles"
                + "( id INT NOT NULL AUTO_INCREMENT,"
                + " roleName VARCHAR(20) NOT NULL,"
                + " PRIMARY KEY (id),"
                + "UNIQUE INDEX id_ROLES (id ASC));"
        );
    }
    public void createTableDirections() throws SQLException {
        statement.execute("CREATE TABLE Directions (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "directionName VARCHAR (20) NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE KEY id_DIRECTIONS (id ASC) " +
                ");");
    }

    public void createTableProjects() throws SQLException {
        statement.execute("CREATE TABLE Projects (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "projectName VARCHAR (20) NOT NULL, " +
                "directionId INT NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE INDEX id_PROJECTS (id ASC), " +
                "FOREIGN KEY (directionId) REFERENCES Directions(id)" +
                ");");
    }
    public void createTableEmployee() throws SQLException {
        statement.execute("CREATE TABLE Employee (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR (20) NOT NULL, " +
                "roleId INT NOT NULL, " +
                "projectId INT NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE INDEX id_EMPLOYEE (id ASC), " +
                "FOREIGN KEY (roleId) REFERENCES Roles(id), " +
                "FOREIGN KEY (projectId) REFERENCES Projects(id) " +
                ");");
    }
    public void dropTable(String tableName) throws SQLException {
        statement.execute("DROP Table " + tableName + " cascade;");
    }

//     ----------Methods for insert data to tables
    public void insertTableRoles(String roleName) throws SQLException {
        PreparedStatement psmt = connection.prepareStatement("INSERT INTO Roles (roleName) VALUES ( ? )");
        psmt.setString(1, roleName);
        psmt.executeUpdate();
    }
    public void insertTableDirections(String directionName) throws SQLException {
        PreparedStatement psmt = connection.prepareStatement("INSERT INTO Directions " +
                "(directionName) " +
                "VALUES ( ? )");
        psmt.setString(1, directionName);
        psmt.executeUpdate();
    }
    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        PreparedStatement psmt = connection.prepareStatement("INSERT INTO Projects " +
                "(projectName, directionId) VALUES ( " +
                "?, " +
                "(SELECT id FROM Directions WHERE Directions.directionName = ? )" +
                "  )");
        psmt.setString(1, projectName);
        psmt.setString(2, directionName);
        psmt.executeUpdate();
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        PreparedStatement psmt = connection.prepareStatement("INSERT INTO Employee " +
                "(firstName, roleId, projectId) " +
                "VALUES ( " +
                "?, " +
                "(SELECT id FROM Roles WHERE Roles.roleName = ?), " +
                "(SELECT id FROM Projects WHERE Projects.projectName = ?)" +
                ")");
        psmt.setString(1, firstName);
        psmt.setString(2, roleName);
        psmt.setString(3, projectName);
        psmt.executeUpdate();
    }

//     -----------Methods to obtaining data from tables
    public int getRoleId(String roleName) throws SQLException {
        PreparedStatement psmt = connection.prepareStatement("SELECT id " +
                "FROM Roles " +
                "WHERE roleName = ?");
        psmt.setString(1, roleName);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public int getDirectionId(String directionName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM Directions " +
                "WHERE directionName = ?");
        ps.setString(1, directionName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
    public int getProjectId(String projectName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM Projects " +
                "WHERE projectName = ?");
        ps.setString(1, projectName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM Employee " +
                "WHERE firstName = ?");
        ps.setString(1, firstName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
    public List<String> getAllRoles() throws SQLException {
        return getAllbyColName("Roles", "roleName");
    }
    private List<String> getAllbyColName(String tableName, String colName) throws SQLException {
        ResultSet rs = connection
                .createStatement()
                .executeQuery(String.format("SELECT %s FROM %s;",
                colName, tableName));
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }
    public List<String> getAllDirestion() throws SQLException {
        return getAllbyColName("Directions", "directionName");
    }
    public List<String> getAllProjects() throws SQLException {
        return getAllbyColName("Projects", "projectName");
    }
    public List<String> getAllEmployee() throws SQLException {
        return getAllbyColName("Employee", "firstName");
    }
    public List<String> getAllDevelopers() throws SQLException {
        ResultSet rs = connection
                .createStatement()
                .executeQuery("SELECT firstName " +
                "from Employee " +
                "INNER JOIN Roles ON Employee.roleId = Roles.id AND roleName = 'Developer';");
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        ResultSet rs = connection
                .createStatement()
                .executeQuery("SELECT firstName " +
                        "FROM Employee " +
                        "INNER JOIN Projects " +
                        " ON Employee.projectId = Projects.id " +
                        "INNER JOIN Directions " +
                        " ON Directions.id = Projects.directionId" +
                        "  AND Directions.directionName = 'Java' " +
                        "INNER JOIN Roles " +
                        " ON Roles.id = Employee.roleId " +
                        "   AND Roles.roleName = 'Developer'" +
                        "ORDER BY firstName " +
                        ";");
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }
    public List<String> getAllJavaProjects() throws SQLException {
        ResultSet rs = connection.createStatement()
                .executeQuery(
                        "SELECT projectName FROM Projects " +
                                "INNER JOIN Directions " +
                                "ON Directions.id = Projects.directionId " +
                                "  AND Directions.directionName = 'Java'"
                );
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }
}


public class Task1 {
    public static void main(String[] args) throws SQLException {
        MyUtils db = new MyUtils();
        try {
            db.createConnection();
            db.createStatement();

//            db.createSchema("schemaOleg");
//            db.useSchema();

//            db.dropSchema("schemaOleg");
            db.useSchema("schemaOleg");

//            db.createTableRoles();
//            db.createTableDirections();
//            db.createTableProjects();
//            db.createTableEmployee();
//
//            db.insertTableRoles("Developer");
//            db.insertTableRoles("DevOps");
//            db.insertTableRoles("QA");
//
//            db.insertTableDirections("Java");
//            db.insertTableDirections("Python");
//            db.insertTableDirections("Net");
//
//            db.insertTableProjects("MoonLight", "Java");
//            db.insertTableProjects("Sun", "Java");
//            db.insertTableProjects("Mars", "Python");
//
//            db.insertTableEmployee("Ivan", "Developer", "MoonLight");
//            db.insertTableEmployee("Petro", "Developer", "Sun");
//            db.insertTableEmployee("Stephan", "Developer", "Mars");
//            db.insertTableEmployee("Andriy", "DevOps", "MoonLight");
//            db.insertTableEmployee("Vasyl", "DevOps", "Mars");
//            db.insertTableEmployee("Ira", "Developer", "MoonLight");
//            db.insertTableEmployee("Anna", "QA", "MoonLight");
//            db.insertTableEmployee("Olya", "QA", "Sun");
//            db.insertTableEmployee("Maria", "QA", "Mars");

//            System.out.println(db.getRoleId("Developer"));
//            System.out.println(db.getDirectionId("Python"));
//            System.out.println(db.getDirectionId("Pytho"));
//            System.out.println(db.getProjectId("Sun"));
//            System.out.println(db.getEmployeeId("Ivan"));
//            db.getAllRoles().stream().forEach(System.out::println);
//            db.getAllDirestion().stream().forEach(System.out::println);
//            db.getAllProjects().stream().forEach(System.out::println);
//            db.getAllEmployee().stream().forEach(System.out::println);
//            db.getAllDevelopers().stream().forEach(System.out::println);
            db.getAllJavaDevelopers().stream().forEach(System.out::println);
//            db.getAllJavaProjects().stream().forEach(System.out::println);
//            db.test();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            db.closeStatement();
            db.closeConnection();
        }
    }
}
