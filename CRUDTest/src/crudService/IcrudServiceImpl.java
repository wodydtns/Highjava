package crudService;

import java.util.List;

import crudDao.ICrudDao;
import crudDao.ICrudDaoImple;
import crudVO.CrudVO;

public class IcrudServiceImpl implements IcrudService{
	
	private ICrudDao crudDao;
	
	public IcrudServiceImpl() {
		crudDao = new ICrudDaoImple();
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
	public List<CrudVO> search(int num) {
		return crudDao.search(num);
	
	}
	
}
