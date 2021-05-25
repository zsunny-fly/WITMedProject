package ekgc.witmed.util;

import java.util.HashMap;
import java.util.Map;

public class QueryMapUtil {

	public static Map getQueryMap(String table,Object query){
		Map<String,Object> map = new HashMap<>();
		map.put("table",table);
		map.put("obj",query);
		return map;
	}
}
