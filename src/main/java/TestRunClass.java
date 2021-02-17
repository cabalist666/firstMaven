import java.sql.*;

public class TestRunClass {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6,7,8,9,10};
        float[][] floatArray ={{1.1f,2.2f,3,2},{10,20.f,30.f,5},{1,2,3,4}};
        String[] stringArray = {"abc", "a23"};
        System.out.println(floatArray[0][0]);
        System.out.println(floatArray[1][1]);
        /////
        float[][] TfloatArray = new float[3][];
        TfloatArray[0] = new float[4];
        TfloatArray[1] = new float[3];
        TfloatArray[2] = new float[7];
        System.out.println(TfloatArray[2][5]); //prints: 0.0

        for(Season1 s: Season1.values()){
            System.out.print(s.toString() + " ");
             //prints: Spring Summer Autumn Winter
        }
    }
    enum Season1 {
        SPRING, SUMMER, AUTUMN, WINTER;
        public String toString() {
            return this.name().charAt(0) +
                    this.name().substring(1).toLowerCase();
        }
    }

    public static void test2() {
        Connection conn;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection("dburl", "username", "password");
            rs = conn.createStatement().executeQuery("select * from some_table");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        try (conn; rs) {
            while (rs.next()) {
//process the retrieved data
            }
        } catch (SQLException ex) {
//Do something
//The exception was probably caused by incorrect SQL statement
        }
    }

    void throwsDemo() throws SQLException {
        Connection conn = DriverManager.getConnection("url","user","pass");
        ResultSet rs = conn.createStatement().executeQuery("select * ...");
        try (conn; rs) {
            while (rs.next()) {
//process the retrieved data
            }
        } finally { }
    }
}
