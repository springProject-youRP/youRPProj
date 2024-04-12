package yurp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InoutMapper {

	@Select("<script>"
			+ "select "
			+ "a.sell_no,  "
			+ "a.s_code,  "
			+ "c.s_name,  "
			+ "a.sell_date,  "
			+ "b.p_num,  "
			+ "b.color,  "
			+ "b.p_size,  "
			+ "b.season,  "
			+ "b.p_name,  "
			+ "b.li_price,  "
			+ "b.discount,  "
			+ "b.p_price,  "
			+ "a.cnt,  "
			+ "b.p_price*a.cnt as tot_price  "
			+ "from sell as a  "
			+ "left join product as b on a.p_code = b.p_code  "
			+ "left join store as c on a.s_code = c.s_code"
			+ "<where>"
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			
			+ "		<if test='pNum != null and pNum != \"\"' > "
			+ "			b.p_num like concat('%',#{pNum},'%') and"
			+ "		</if> "
			+ "		<if test='pName != null and pName != \"\"' > "
			+ "			b.p_name like concat('%',#{pName},'%') and"
			+ "		</if> "
			
			+ "		<if test='sName != null and sName != \"\"' > "
			+ "			c.s_name like concat('%',#{sName},'%') and"
			+ "		</if> "
			
			+ "		<if test='start != null and start != \"\"' > "
			+ "			a.sell_date >= #{start} and"
			+ "		</if> "
			
			+ "		<if test='end != null and end != \"\"' > "
			+ "			 #{end} >= a.sell_date and"
			+ "		</if> "
			
			+ "		<if test='start != null and start != \"\" and end != null and end != \"\"' > "
			+ "			a.sell_date BETWEEN #{start} and #{end}"
			+ "		</if> "
			+ "	</trim>"
			+ "</where> "
			+ "</script> "
			 )
	List<InoutDTO> list(InoutDTO dto);
	
	@Select("<script> "
			+ "select "
			+ "sum(b.p_price*a.cnt) as all_tot "
			+ "from sell as a "
			+ "left join product as b on a.p_code = b.p_code "
			+ "left join store as c on a.s_code = c.s_code"
			+ "<where>"
			+ "	<trim prefix=' ' suffixOverrides = 'and | or'> "
			+ "		<if test='pNum != null and pNum != \"\"' > "
			+ "			b.p_num like concat('%',#{pNum},'%') and"
			+ "		</if> "
			+ "		<if test='pName != null and pName != \"\"' > "
			+ "			b.p_name like concat('%',#{pName},'%') and"
			+ "		</if> "
			
			+ "		<if test='sName != null and sName != \"\"' > "
			+ "			c.s_name like concat('%',#{sName},'%') and"
			+ "		</if> "
			
			+ "		<if test='start != null and start != \"\"' > "
			+ "			a.sell_date >= #{start} and"
			+ "		</if> "
			
			+ "		<if test='end != null and end != \"\"' > "
			+ "			 #{end} >= a.sell_date and"
			+ "		</if> "
			
			+ "		<if test='start != null and start != \"\" and end != null and end != \"\"' > "
			+ "			a.sell_date BETWEEN #{start} and #{end}"
			+ "		</if> "
			+ "	</trim>"
			+ "</where> "
			+ "</script> ")
	List<InoutDTO> tot(InoutDTO dto);
	

	
}
