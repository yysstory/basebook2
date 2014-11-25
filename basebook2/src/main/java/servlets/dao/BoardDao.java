package servlets.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import servlets.domain.Board;

@Component("boardDao")
public class BoardDao {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public BoardDao() {
	}

	public void insert(Board board) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert("servlets.BoardDao.insert", board);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("servlets.BoardDao.delete", no);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<Board> selectList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList("servlets.BoardDao.selectList");
		} finally {
			sqlSession.close();
		}
	}

	public void update(Board Board) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update("servlets.BoardDao.update", Board);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void like(Board board) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update("servlets.BoardDao.like", board);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void unlike(Board board) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update("servlets.BoardDao.unlike", board);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}

