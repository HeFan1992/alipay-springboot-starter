package com.alipay.util.spider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 数据采样
 * @author he.fan
 */
public class RarsePage {
	
	private static final Log log = LogFactory.getLog(RarsePage.class);

	/**
	 * 获取期数 + 红球 数据样板如下
	 * <tr class="t_tr1">
	 * <!--
	 * <td>2</td>-->
	 * <td>18053</td>
	 * <td class="t_cfont2">01</td>
	 * <td class="t_cfont2">04</td>
	 * <td class="t_cfont2">10</td>
	 * <td class="t_cfont2">11</td>
	 * <td class="t_cfont2">14</td>
	 * <td class="t_cfont2">27</td>
	 * <td class="t_cfont4">06</td>
	 * <td class="t_cfont4">&nbsp;</td>
	 * <td>1,036,375,992</td>
	 * <td>8</td>
	 * <td>7,086,603</td>
	 * <td>104</td>
	 * <td>200,634</td>
	 * <td>336,743,448</td>
	 * <td>2018-05-10</td>
	 * </tr>
	 * 
	 * @param content
	 * @throws Exception
	 */
	public static String parseFromString(String content) throws Exception {
		// 将获取的网页 HTML 源代码转化为 Document
		Document doc = Jsoup.parse(content);

		Elements elements = doc.select("#tdata");
		log.info("--------------------------------------------------");
		if (elements.size() > 0 && elements.get(0) != null) {
			Elements element = elements.get(0).select(".t_tr1");
			StringBuffer info = new StringBuffer();
			info.append("[");
			for (int i = 0; i < element.size(); i++) {
				// 获取期数
				String date = element.get(i).childNode(1) + "";
				log.info("期数：" + RegexUtils.getDate(date));

				log.info(RegexUtils.getNumber("1:" + element.get(i).childNode(2) + ""));
				log.info(RegexUtils.getNumber("2:" + element.get(i).childNode(3) + ""));
				log.info(RegexUtils.getNumber("3:" + element.get(i).childNode(4) + ""));
				log.info(RegexUtils.getNumber("4:" + element.get(i).childNode(5) + ""));
				log.info(RegexUtils.getNumber("5:" + element.get(i).childNode(6) + ""));
				log.info(RegexUtils.getNumber("6:" + element.get(i).childNode(7) + ""));
				
				info.append("{\\\"date\\\":"+RegexUtils.getDate(date)).append(",");
				info.append("\\\"red1\\\":"+RegexUtils.getNumber(element.get(i).childNode(2)+"")).append(",");
				info.append("\\\"red2\\\":"+RegexUtils.getNumber(element.get(i).childNode(3)+"")).append(",");
				info.append("\\\"red3\\\":"+RegexUtils.getNumber(element.get(i).childNode(4)+"")).append(",");
				info.append("\\\"red4\\\":"+RegexUtils.getNumber(element.get(i).childNode(5)+"")).append(",");
				info.append("\\\"red5\\\":"+RegexUtils.getNumber(element.get(i).childNode(6)+"")).append(",");
				info.append("\\\"red6\\\":"+RegexUtils.getNumber(element.get(i).childNode(7)+"")).append("}");
			}
			info.append("]");
			info.append("parseFromString :" + info.toString());
			log.info("--------------------------------------------------");
			return info.toString();
		}else {
			log.info("--------------------------------------------------");
			return null;
		}
	}

}
