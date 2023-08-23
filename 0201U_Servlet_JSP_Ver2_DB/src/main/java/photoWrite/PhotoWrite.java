package photoWrite;

import java.sql.*;
import java.io.*;

class PhotoWrite {

	public static void main(String argv[]) {
		Connection con = null;
		PreparedStatement pstmt = null;
		InputStream fin = null;
		String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
		String userid = "root";
		String passwd = "0987242920";
		String photos = "src/main/webapp/resources/DB_photos1"; //測試用圖片已置於【專案錄徑】底下的【resources/DB_photos1】目錄內
		String update = "update EMP3 set upFiles =? where empno=?";

		int count = 7001;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(update);
			File[] photoFiles = new File(photos).listFiles();
			for (File f : photoFiles) {
				fin = new FileInputStream(f);
				pstmt = con.prepareStatement(update);
				pstmt.setInt(2, count);
				pstmt.setBinaryStream(1, fin);
				pstmt.executeUpdate();
				count++;
				System.out.print(" update the database...");
				System.out.println(f.toString());
			}

			fin.close();
			pstmt.close();
			System.out.println("加入圖片-更新成功.........");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
