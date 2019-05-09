package com.evanlab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class DBConnectionUtil {
    /*private static final Logger logger = Logger.getLogger(DBConnectionUtil.class);

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:microsoft:sqlserver://12.5.37.92:1433;DatabaseName=voice";//2000版本格式
//    static String url = "jdbc:sqlserver://12.5.37.92:1433;DatabaseName=voice";//2008版本格式
    static String user = "voice";
    static String passwd = "voice";*/

    /*public static void export() throws Exception {
        Connection conn = null;
        try {

//            Class.forName(driver);
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//SQL Server 2008 later
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");// SQL Server 2005 before
            conn = DriverManager.getConnection(url, user, passwd);
            int op = 0;

            // 插入
                String exportRoot = "d:/export/filecontent/";

                PreparedStatement ps1 = conn.prepareStatement("select docid,filearchno from atwritinfo where archyear <= '2017'" );
                ResultSet rs1 = ps1.executeQuery();
                while(rs1 != null && rs1.next()){
                   String  _docid = rs1.getString("docid");
                   String  _filearchno = rs1.getString("filearchno");
                   String docRoot = _docid;
                   if(_filearchno != null && !"".equalsIgnoreCase(_filearchno)){
                       docRoot = _filearchno+"("+_docid+")";
                   }
                    String docPath = exportRoot + docRoot;
                   new File(docPath).mkdirs();
                // 取出
                PreparedStatement ps = conn.prepareStatement("select docid,seqid,seqtitle,type,textorcontent from dttextcontent where docid = ?");
                ps.setString(1, _docid);
                ResultSet rs = ps.executeQuery();

                new File(docPath).mkdirs();
                while (rs != null && rs.next() && op < 10) {
                    String docid = rs.getString("docid");
                    String seqid = rs.getString("seqid");
                    String seqtitle = rs.getString("seqtitle");
                    String doctype = rs.getString("type");
                    InputStream in = rs.getBinaryStream("textorcontent");
                    FileOutputStream out = new FileOutputStream(docPath + "/" + seqtitle + "." + doctype);
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) != -1) {
                        out.write(b, 0, len);
                        out.flush();
                    }
                    out.close();
                    in.close();
                    op++;

                    rs.next();
                }
                    rs.close();
                    ps.close();

                    rs1.next();

                }

                rs1.close();
                ps1.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (conn != null) {
                ((Connection) conn).close();
            }
        }
    }

    public static void exportAccount() throws Exception {
        Connection conn = null;
        try {
//            Class.forName(driver);
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//SQL Server 2008 later
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");// SQL Server 2005 before
            conn = DriverManager.getConnection(url, user, passwd);
            int op = 0;

            // 插入
            String exportRoot = "d:/export/filecontent/";

            PreparedStatement ps1 = conn.prepareStatement("select docid,filearchno from atwritinfo where archyear <= '2017'" );
            ResultSet rs1 = ps1.executeQuery();
            while(rs1 != null && rs1.next()){
                String  _docid = rs1.getString("docid");
                String  _filearchno = rs1.getString("filearchno");
                String docRoot = _docid;
                if(_filearchno != null && !"".equalsIgnoreCase(_filearchno)){
                    docRoot = _filearchno+"("+_docid+")";
                }
                String docPath = exportRoot + docRoot;
                new File(docPath).mkdirs();
                // 取出
                PreparedStatement ps = conn.prepareStatement("select docid,seqid,seqtitle,type,textorcontent from dttextcontent where docid = ?");
                ps.setString(1, _docid);
                ResultSet rs = ps.executeQuery();

                new File(docPath).mkdirs();
                while (rs != null && rs.next() && op < 10) {
                    String docid = rs.getString("docid");
                    String seqid = rs.getString("seqid");
                    String seqtitle = rs.getString("seqtitle");
                    String doctype = rs.getString("type");
                    InputStream in = rs.getBinaryStream("textorcontent");
                    FileOutputStream out = new FileOutputStream(docPath + "/" + seqtitle + "." + doctype);
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) != -1) {
                        out.write(b, 0, len);
                        out.flush();
                    }
                    out.close();
                    in.close();
                    op++;

                    rs.next();
                }
                rs.close();
                ps.close();

                rs1.next();

            }

            rs1.close();
            ps1.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (conn != null) {
                ((Connection) conn).close();
            }
        }
    }

    public static void main(String[] args){
//        DBConnectionUtil util = new DBConnectionUtil();
        try {
            DBConnectionUtil.export();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }*/
}
