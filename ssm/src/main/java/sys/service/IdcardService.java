package sys.service;


import sys.entity.Idcard;

public interface IdcardService {
	 void save(Idcard idcard);
	 Idcard getIdcard(Integer id);
}
