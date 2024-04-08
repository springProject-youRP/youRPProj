package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface NoticeMapper {

	@Select("select * from notice")
	List<NoticeDTO> list();
	
	@Select("select * from notice where n_no = #{n_no}")
	NoticeDTO detail(int n_no);
	
	@Insert("insert into notice (title, content, file) values (#{title},#{content},#{file})")
	int insert(NoticeDTO dto);
	
	@Update("update notice set "
			+ "title = #{title}, content = #{content}, file = #{file} "
			+ "where n_no = #{n_no}")
	int modify(NoticeDTO dto);

	@Delete("delete from notice where n_no = #{n_no}")
	int delete(NoticeDTO dto);
}