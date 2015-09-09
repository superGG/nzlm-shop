<%@ page contentType="text/html;charset=gbk"
	import="java.io.*,javax.servlet.*,com.util.MyConverter,com.model.DB"
	import="com.model.DB,java.util.*"%>

<%
	String params1 = request.getParameter("params1").trim();
	String params2 = request.getParameter("params2").trim();
	String u1 = MyConverter.unescape(params1);
	String cur_num = MyConverter.unescape(params2);

	Vector<String> travel = new Vector<String>();
	StringBuffer msg = new StringBuffer();

	String msg02 = new String();
	travel = DB.get_travel_more(u1, cur_num);
	for (String s : travel) {
		msg.append(s);

	}
	String s = msg.toString();
	out.println(MyConverter.escape(s));
	System.out.println(s + "获取更多用户旅行记录");

	//System.out.print(u1);
	//System.out.print(u2);
%>


