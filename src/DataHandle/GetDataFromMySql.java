package DataHandle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class GetDataFromMySql {
	static ConnectToMysql c = new ConnectToMysql();
	Connection con = c.getcon();

	public void displayGoods() {
		try {
			String strsql = "select * from goods";
			PreparedStatement psql = con.prepareStatement(strsql);
			ResultSet rs = psql.executeQuery();
			long id = 0, typeid = 0, num = 0;
			String goodsname, address, date1, date2;
			float price;
			while (rs.next()) {
				// 获取这列数据
				id = rs.getInt("GoodsID");
				typeid = rs.getInt("TypeID");
				goodsname = rs.getString("GoodsName");
				price = rs.getFloat("Price");
				address = rs.getString("ProductAddress");
				num = rs.getInt("Number");
				date1 = rs.getString("DateOfManufacture");
				date2 = rs.getString("DateOfStock");
				System.out.println(id + "\t" + typeid + "\t" + goodsname + "\t" + price + "\t" + address + "\t"
						+ address + "\t\t" + num + "\t\t" + date1 + "\t" + date2);
			}
			rs.close();
			psql.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void addGoods(long GoodsID, int TypeID, String GoodsName, float Price, String ProductAddress, int Number,
			String DateOfManufacture, String DateOfStock) {
		try {
			String strsql = "insert into Goods (GoodsID,TypeID,GoodsName,Price,ProductAddress,Number,DateOfManufacture,DateOfStock) values(?,?,?,?,?,?,?,?)";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setLong(1, GoodsID);
			psql.setInt(2, TypeID);
			psql.setString(3, GoodsName);
			psql.setFloat(4, Price);
			psql.setString(5, ProductAddress);
			psql.setInt(6, Number);
			psql.setString(7, DateOfManufacture);
			psql.setString(8, DateOfStock);
			ResultSet rs = psql.executeQuery();
			con.commit();
			psql.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addGoodsType(long GoodsTypeID, String TypeName) {
		try {
			String strsql = "insert into GoodsType (GoodsTypeID,TypeName) values(?,?)";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setLong(1, GoodsTypeID);
			psql.setString(2, TypeName);
			ResultSet rs = psql.executeQuery();
			con.commit();
			psql.close();
			rs.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addGoodsInOneOrder(long OrderID, long GoodsID) {
		try {
			String strsql = "insert into GoodsInOneOrder (OrderID,GoodsID) values(?,?)";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setLong(1, OrderID);
			psql.setLong(2, GoodsID);
			ResultSet rs = psql.executeQuery();
			con.commit();
			psql.close();
			rs.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addOrders(long OrderID, String CreateTime,int MachineNum,float TotalPrice,int TotalNum) {
		try {
			String strsql = "insert into Orders (OrderID,CreateTime,MachineNum,TotalPrice,TotalNum) values(?,?,?,?,?)";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setLong(1, OrderID);
			psql.setString(2, CreateTime);
			psql.setInt(3, MachineNum);
			psql.setFloat(4,TotalPrice);
			psql.setInt(5,TotalNum);
			ResultSet rs = psql.executeQuery();
			con.commit();
			psql.close();
			rs.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addchips(String chipID, long GoodsID,int State) {
		try {
			String strsql = "insert into chips (chipID,GoodsID,State) values(?,?,?)";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setString(1, chipID);
			psql.setLong(2, GoodsID);
			psql.setInt(3, State);
			ResultSet rs = psql.executeQuery();
			con.commit();
			psql.close();
			rs.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void addRole(int RoleID, String RoleName) {
		try {
			String strsql = "insert into Role (RoleID,RolreName) values(?,?)";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setInt(1, RoleID);
			psql.setString(2, RoleName);
			ResultSet rs = psql.executeQuery();
			con.commit();
			psql.close();
			rs.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String selectAdmin_ID_Password(int adminid) {// 查找账户是否存在和并取密码
		String password = null;
		try {
			String strsql = "select password from Administrator where adminid=?";
			PreparedStatement psql = con.prepareStatement(strsql);
			psql.setInt(1, adminid);
			ResultSet rs = psql.executeQuery();
			while (rs.next()) {
				// 获取这列数据
				password = rs.getString("password");
			}
			rs.close();
			psql.close();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return password;

	}
}
