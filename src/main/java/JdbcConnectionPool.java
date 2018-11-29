import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class JdbcConnectionPool implements DBConfig {

        List<Connection> availableConnections = new ArrayList<Connection>();

        public JdbcConnectionPool(){
            initializeConnectionPool();
        }



        private void initializeConnectionPool() {
            while(!connectionPoolIsFull()){
                availableConnections.add(createNewConnectionForPool()); }
        }

        private synchronized boolean connectionPoolIsFull()
        {if(availableConnections.size()<maxConnections){
            return false;
        }
            return true ;}


        private Connection createNewConnectionForPool() {
            Connection connection=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(dbURL, username, password);
                System.out.println("DB connection successful to: " + dbURL);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return connection;}

        public synchronized Connection getConnectionFromPool()
        {
            Connection connection = null;
            if(availableConnections.size() > 0)
            {
                connection = (Connection) availableConnections.get(0);
                availableConnections.remove(0);
            }
            return connection;
        }

        public synchronized void returnConnectionToPool(Connection connection)
        {
            availableConnections.add(connection);
        }
    }



