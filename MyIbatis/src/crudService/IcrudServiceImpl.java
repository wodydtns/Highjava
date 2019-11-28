package crudService;

import java.util.List;

import crudDao.ICrudDao;
import crudDao.ICrudDaoImple;
import crudVO.CrudVO;

public class IcrudServiceImpl implements IcrudService{
	
	private static IcrudServiceImpl service;
	
	private ICrudDao crudDao;
	
	private IcrudServiceImpl() {
		crudDao = ICrudDaoImple.getInstance();
	}
	public static IcrudServiceImpl getInstance() {
		if(service == null) {
			service = new IcrudServiceImpl();
		}
		return service;
	}
	@Override
	public int write(CrudVO cv) {
		return crudDao.write(cv);
	}

	@Override
	public boolean getNum(int num) {
		return crudDao.getNum(num);
	}

	@Override
	public List<CrudVO> displayList() {
		return crudDao.displayList();
	}

	@Override
	public int modify(CrudVO cv) {
		return crudDao.modify(cv);
	}

	@Override
	public int delete(int num) {
		return crudDao.delete(num);
	}

	@Override
	public List<CrudVO> search(CrudVO cv) {
		return crudDao.search(cv);
	
	}
	
}
