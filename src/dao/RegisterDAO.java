package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Register;

public class RegisterDAO extends DAO{
	public List<Register> search(String keyword) throws Exception{
		List<Register> list=new ArrayList<>();
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from register where name like ?");
		st.setString(1,"%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while(rs.next()){
			Register p=new Register();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setCourse(rs.getString("course"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public int insert(Register register) throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"insert into register values(null,?,?)");
		st.setString(1,register.getName());
		st.setString(2,register.getCourse());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}