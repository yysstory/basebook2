package servlets.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import servlets.domain.Board;

@Component
public class BoardDao {

	  @Autowired
	  SqlSessionFactory sqlSessionFactory;

	  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		    this.sqlSessionFactory = sqlSessionFactory;
		  }

	 public BoardDao() {}


	  
	  public void insert(Board board) {
		    SqlSession sqlSession = sqlSessionFactory.openSession();
		    try {
		      sqlSession.insert(
		        "servlets.BoardDao.insert", board);
		      sqlSession.commit();
		    } finally {
		      sqlSession.close();
		    }
		  }
	  
	  
	  public void delete(int no) {
		    SqlSession sqlSession = sqlSessionFactory.openSession();
		    try {
		      sqlSession.delete(
		        "servlets.BoardDao.delete", no);
		      sqlSession.commit();
		    } finally {
		      sqlSession.close();
		    }
		  }
	  
	  
	  public List<Board> selectList() {
		    SqlSession sqlSession = sqlSessionFactory.openSession();
		    
		  /*  HashMap<String,Object> paramMap = new HashMap<>();
		    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		    paramMap.put("pageSize", pageSize);
		    */
		    try {
		      return sqlSession.selectList("servlets.BoardDao.selectList");
		    } finally {
		      sqlSession.close();
		    }
		  }
	 

	  public void update(Board Board) {
		    SqlSession sqlSession = sqlSessionFactory.openSession();
		    try {
		      sqlSession.update(
		        "servlets.BoardDao.update", Board);
		      sqlSession.commit();
		    } finally {
		      sqlSession.close();
		    }
		  }

}

/*@Component
public class ProductDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public ProductDao() {}

  public Product selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne(
        "java02.test19.server.ProductDao.selectOne", 
        no  new Integer(no) );
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(Product product) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.update(
        "java02.test19.server.ProductDao.update", product);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  
  

  
  public void insert(Product product) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert(
        "java02.test19.server.ProductDao.insert", product);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
}


*/