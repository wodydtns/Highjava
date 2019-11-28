package crudDao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import crudVO.CrudVO;
import util.DBUtil3;

public class ICrudDaoImple implements ICrudDao{

	private static ICrudDao dao;
	private static SqlMapClient smc;
	
	private ICrudDaoImple() {
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		
		}catch(IOException e) {
			System.out.println("sql map 객체 생성 실패");
			e.printStackTrace();
		}
	}
	public static ICrudDao getInstance() {
		if(dao == null) {
			dao = new ICrudDaoImple();
		}
		return dao;
	}
	
	@Override
	public int write(CrudVO cv) {
		int cnt =0;
		try {
			Object obj = smc.insert("crud.insertCrud",cv);
			if(obj == null) {
				cnt =1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean getNum(int num) {
		boolean flag = false;
		int cnt = 0;
		try {
			cnt =(int) smc.queryForObject("crud.getCrud",num);
			if(cnt > 0) {
				flag = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<CrudVO> displayList() {
		List<CrudVO> crudList = new ArrayList<>();
		try {
			crudList = smc.queryForList("crud.displayListCrud");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return crudList;
	}

	@Override
	public int modify(CrudVO cv) {
		int cnt = 0;
		try {
			cnt = smc.update("crud.modifyCrud",cv);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete(int num) {
		int cnt =0;
		try {
			cnt = smc.delete("crud.deleteCrud",num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<CrudVO> search(CrudVO cv) {
		List<CrudVO> crudList = new ArrayList<>();
		try {
			crudList = smc.queryForList("crud.search",cv);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return crudList;
	}

}
