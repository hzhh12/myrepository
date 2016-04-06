package sys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.dao.BaseDao;
import sys.entity.Idcard;
import sys.service.IdcardService;
@Service("idcardService")
public class IdcardServiceImpl implements IdcardService{
	 @Autowired
	    private BaseDao<Idcard,Integer> baseDao;
	@Override
	public void save(Idcard idcard) {
		baseDao.save(idcard);
		
	}
	@Override
	public Idcard getIdcard(Integer id) {
		// TODO Auto-generated method stub
		return baseDao.get(Idcard.class, id);
	}

}
