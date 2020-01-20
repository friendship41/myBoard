package stage.spring.web.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import stage.spring.web.common.JDBCUtil;
import stage.spring.web.user.UserVO;

@Repository
public class UserDAO 
{
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String USER_GET = "select * from myuser where id=? and password=?";
	
	public UserVO getUser(UserVO userVO)
	{
		System.out.println("JDBC로 getUser()기능 처리");
		
		UserVO vo = null;
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				vo = new UserVO();
				vo.setId(rs.getString("ID"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setRole(rs.getString("ROLE"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(rs, pstmt, con);
		}
		return vo;
	}
}
