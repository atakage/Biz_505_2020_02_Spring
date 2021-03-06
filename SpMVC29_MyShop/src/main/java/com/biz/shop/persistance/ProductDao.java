package com.biz.shop.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.shop.domain.ProductVO;
import com.biz.shop.persistance.sql.ProductSQL;

/*
 * 상품관리 CRUD 수행할 Service
 */
public interface ProductDao {
	
	@InsertProvider(type=ProductSQL.class,method="pro_insert")
	public int insert(ProductVO productVO);
	
	@Select("SELECT * FROM tbl_product")
	public List<ProductVO> selectAll();
	
	@Select("SELECT * FROM tbl_product "
			+ "WHERE p_code = #{p_code}")
	public ProductVO findByPCode(String p_code);
	
	// mysql 중간문자열 검색하기
	@Select("SELECT * FROM tbl_product "
			+ " WHERE p_name like CONCAT('%',#{p_name},'%' ) ")
	public List<ProductVO> findByPName(String p_name);
	
	@UpdateProvider(type=ProductSQL.class,method="pro_update")
	public int update(ProductVO productVO);
	
	@Delete("DELETE FROM tbl_product WHERE p_code = #{p_code}")
	public int delete(String p_code);
	

	
	

}
