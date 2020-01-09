import ins.framework.mybatis.generator.GenConfig;
import ins.framework.mybatis.generator.GenParam;
import ins.framework.mybatis.generator.GenType;
import ins.framework.mybatis.generator.Generator;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

	public static void main(String[] args) {
		List<GenParam> paramList = new ArrayList<GenParam>();
		/**
		 * 请保持生成参数的完整，不要注释 指定module包名 和表名
		 */
		paramList.add(new GenParam("power", new String[] {"sys_power"}));
		GenConfig gc = new GenConfig();
		gc.setBasePackage("com.zywz.generator");
		// 设置要忽略的表名前缀，默认空
		gc.setIgnoreTablePrefixs(new String[] { "qrtz", "QRTZ", "ag" });
		// 设置PO是否保留前缀(设置忽略表名前缀时)，默认true
//		gc.setKeepPrefixForPO(false);
		// 设置取操作时间函数，默认空
		//gc.setOperateTimeForHisFunc("now()");
		gc.setInsertTimeForHisName("new()");
		// 设置是否默认开启二级缓存（影响base中的MapperXML），默认false
		gc.setDefaultCache(false);
		// mysql 数据库相关配置
		// 设置基本保存目录（Java源代码根目录）
		gc.setSaveDir("generator/src/main/java");
		// 可代码指定vo和xml的位置
//		 gc.setSaveDirForVo(new File(gc.getSaveDir(),
//		 "../../../../misc-vo/src/main/java").getAbsolutePath());
//		 gc.setSaveDirForXml(new File(gc.getSaveDir(),
//		 "../resources/mapper").getAbsolutePath());
		gc.setDbDriverName("com.mysql.cj.jdbc.Driver");
		gc.setDbUser("root");
		gc.setDbPassword("root");
		gc.setDbUrl("jdbc:mysql://192.168.0.97:3306/oneshot?characterEncoding=utf8&autoReconnect=true");
		// 支持生成的文件类型:生成PO、BASE_MAPPER_XML（自动覆盖）、Dao、VO、MapperXML（不覆盖）
		gc.setGenTypes(new GenType[] { GenType.VO, GenType.PO, GenType.DAO, GenType.BASE_MAPPER_XML, GenType.MAPPER_XML });
		gc.setDbCatalog("oneshot"); // MySQL的Catalog通常和数据库名一致，采用8.0+版驱动后需要设置
		Generator generator = new Generator();
		generator.setGenConfig(gc);
		generator.setParamList(paramList);
		generator.generate();
	}
}
