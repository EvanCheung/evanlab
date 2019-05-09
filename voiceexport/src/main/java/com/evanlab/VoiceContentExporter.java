package com.evanlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

public class VoiceContentExporter {
    private static final Logger logger = Logger.getLogger(VoiceContentExporter.class);

    public static void export(String exportRoot,String tableName,String extCond) throws Exception {
        logger.debug("file content will be save in [" + exportRoot + "] and for ["+tableName+"] & condition = ["+extCond+"]" );
        Connection conn = null;
        int writcount = 0 ;
        int contentCount = 0 ;
        try {
            conn = DBUtil.getConnection();
            int op = 0;
            // 插入
//                String exportRoot = "d:/export/filecontent/";
            String cond = extCond;
            if(cond != null && !"".equalsIgnoreCase(cond.trim()))cond = " where " + extCond;
            PreparedStatement ps1 = conn.prepareStatement("select id,docid,filearchno from "+ tableName + cond +" order by id" );
            ResultSet rs1 = ps1.executeQuery();
            while(rs1 != null && rs1.next()){
               writcount++;
               Integer fileid = rs1.getInt("id");
               String  _docid = rs1.getString("docid");
               String  _filearchno = rs1.getString("filearchno");
               logger.debug("catch content for filearchno = ["+_filearchno+"] & docid = ["+_docid+"]");
               String docRoot = fileid + "(" + _docid + ")";
               if(_filearchno != null && !"".equalsIgnoreCase(_filearchno)){
                   docRoot = _filearchno+"("+_docid+")";
               }
                String docPath = exportRoot + docRoot;
               new File(docPath).mkdirs();
               logger.debug("Path has been created successfully : ["+docPath+"]");
                // 取出
                PreparedStatement ps = conn.prepareStatement("select docid,seqid,seqtitle,type,content from dttextcontent where docid = '"+_docid+"' and content is not null");
                //ps.setString(1, _docid);
				logger.debug("query content for fileid ["+fileid+"] - docid ["+_docid+"]");
                ResultSet rs = ps.executeQuery();
				logger.debug("successfully query content for fileid ["+fileid+"] - docid ["+_docid+"]");
                while (rs != null && rs.next() ) {
                    contentCount ++;
                    String docid = rs.getString("docid");
                    String seqid = rs.getString("seqid");
                    String seqtitle = rs.getString("seqtitle");
                    String doctype = rs.getString("type");
                    logger.debug("Get content for file ["+_filearchno+"] & ["+_docid+"] - " + seqid + ";" + seqtitle + ";" + doctype);
                    InputStream in =rs.getBinaryStream("content");
                    logger.debug("before output contentCount = " + contentCount + " of file :["+docid+"]");
                    FileOutputStream out = null;
                    try{
                        out = new FileOutputStream(docPath + "/" + seqtitle + "." + doctype);
                    }catch(FileNotFoundException e){
                        out = new FileOutputStream(docPath +"/" + docid +"-"+seqid+ "." + doctype);
                        logger.error(e.getMessage(),e);
                    }
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) != -1) {
                        out.write(b, 0, len);
                        out.flush();
                    }
                    out.close();
                    in.close();
                    logger.debug("Successfully get content for file ["+_filearchno+"] & ["+_docid+"] - " + seqid + ";" + seqtitle + ";" + doctype);
                    logger.info(tableName + " - " + fileid + "-[" + _docid + "] - " + seqid);
                    logger.debug("contentCount = " + contentCount);
                   // rs.next();
                }
                rs.close();
                ps.close();

                logger.debug("writ file count = " + writcount);
               // rs1.next();

            }

            rs1.close();
            ps1.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
        } finally {
            if (conn != null) {
                ((Connection) conn).close();
            }
        }
    }

    public static void exportAccount() throws Exception {

    }

    public static void main(String[] args){
        try {
            String docRoot = "e:/voice/exportroot/";
            String tablename = "atwritinfo";
            String extCond = "";
            if(args.length >=2 && args.length <= 3 ){
                if(args.length >= 2){
                    docRoot = args[0].trim();
                    tablename = args[1].trim();
                }
                if(args.length == 3){
                    extCond = args[2].trim();
                }
            }else{
                logger.debug("usage : java com.evanlab.VoiceContentExporter [exportRoot] [tablename] [extCondition]");
                logger.debug("for example : java com.evanlab.VoiceContentExporter 'e:/exportroot/voice/' 'atwritinfo' \"archyear='2017'\"");
            }
            VoiceContentExporter.export(docRoot,tablename,extCond);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
