import java.sql.*;

public class RegisterDAOImpl implements RegisterDAO {
    private JdbcConnectionPool connectionPool = new JdbcConnectionPool();
    private String SQL_CREATE_USER = "INSERT INTO users (name,email, username,pwd,dor) VALUES (?, ?, ?, ?, ?)";

    @Override
    public void registerUser(User user) {
        PreparedStatement preparedStatement=null;
        ResultSet generatedKeys=null;
        Connection connection=null;

        connection= getConnectionFromPool();
        try {
            preparedStatement= connection.prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getDate());
            preparedStatement.executeUpdate();
            generatedKeys=preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                user.setID(generatedKeys.getInt(1));
            }
            returnConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private Connection getConnectionFromPool() {
        Connection connection = connectionPool.getConnectionFromPool();
        return connection;
    }

    private void returnConnection(Connection connection) {
        connectionPool.returnConnectionToPool(connection);
    }
}
