import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;

public class OrdersServlet extends HttpServlet {
  private static long pooledDuration, nonPooledDuration;
  private static long pooledCount, nonPooledCount;
  private DataSource datasource = null;

  public void init(ServletConfig config) throws ServletException {
    try {
      //Create a datasource for pooled connections.
      //Register the driver for non pooled connections.
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      datasource = (DataSource) envCtx.lookup("jdbc/MyDataSource");
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    }
    catch (Exception e) {
      throw new ServletException(e.getMessage());
    }
  }

  private Connection getConnection(boolean pooledConnection) throws SQLException {
    if (pooledConnection) {
      pooledCount++;
      return datasource.getConnection();
    }
    else {
      nonPooledCount++;
      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//<server>/orcl", "scott", "tiger");
      return con;
    }
  }

  public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String queryStr = req.getQueryString();
    boolean poolingEnabled = queryStr == null || !queryStr.equals("disablePooling");

    PrintWriter	out = res.getWriter();
    res.setContentType("text/html");
    out.println("<html><head><title>Orders</title></head><body>");
    out.println("<br>PooledConnectionCount:"+pooledCount+", nonPooledConnectionCount:"+nonPooledCount+"<br>");
    if (pooledDuration > 0 && nonPooledDuration > 0) {
      out.println("<br>"+
                  "Average pooled response:"+pooledDuration/pooledCount+
                  "Average non pooled response:"+nonPooledDuration/nonPooledCount);
    }

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    long startTime = System.currentTimeMillis();

    try {
      connection = getConnection(poolingEnabled);
      stmt = connection.createStatement();
      String sqlSelect = "SELECT ORDERS.ORDER_ID, ORDERS.CUSTOMER_ID," +
        "LINES.LINE_ITEM_ID, LINES.LINE_ITEM_ID, LINES.PRODUCT_ID, LINES.UNIT_PRICE, LINES.QUANTITY "+
        "FROM OE.ORDERS ORDERS INNER JOIN OE.ORDER_ITEMS LINES "+
        "ON LINES.ORDER_ID = ORDERS.ORDER_ID "+
        "ORDER BY ORDER_ID, LINES.LINE_ITEM_ID";
      rs = stmt.executeQuery(sqlSelect);
      ResultSetMetaData dbMeta = rs.getMetaData();
      out.println("<br><table border='1'>");

      //Create the table headers

      out.println("<tr>");
      for (int col=0; col<dbMeta.getColumnCount(); col++) {
        out.println("<th>" + dbMeta.getColumnName(col+1) + "</th>");
      }
      out.println("</tr>");

      //Create the table data

      while (rs.next()) {
        out.println("<tr>");
        for (int col=0; col < dbMeta.getColumnCount(); col++) {
          out.println("<td>" + rs.getString(col+1) + "</td>");
        }
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("</body></html>");
      connection.close();
    }
    catch (SQLException e) {
      throw new ServletException(e.getMessage());
    }
    finally {
      try {if (rs != null) rs.close();} catch (SQLException e) {}
      try {if (stmt != null) stmt.close();} catch (SQLException e) {}
      try {if (connection != null) connection.close();} catch (SQLException e) {}
      long elapsed = System.currentTimeMillis() - startTime;
      //Collect the times
      if (poolingEnabled)
        this.pooledDuration += elapsed;
      else
        this.nonPooledDuration += elapsed;
    }
  }

}
