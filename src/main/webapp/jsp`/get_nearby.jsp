<%@ page contentType="text/html;charset=gbk"
	import="java.io.*,javax.servlet.*,com.util.MyConverter,com.model.DB"
	import="com.model.DB,java.util.*"%>

<%
	String params1 = request.getParameter("params1").trim();
	String params2 = request.getParameter("params2").trim();
	String params3 = request.getParameter("params3").trim();

	
	
double longtitude = Double.parseDouble(params2);
double latitude = Double.parseDouble(params3);

	Vector<String> Nearby = new Vector<String>();
	StringBuffer msg = new StringBuffer();

	Nearby = DB.getNearbyInfo(longtitude, latitude);
	for (String s : Nearby) {
		msg.append(s);
		//msg.append("|");
	}

	String s = msg.toString();
	
	out.println(MyConverter.escape(s));
	System.out.println(s + ",用户数据已经传回客户端！附近的人");

	

	//System.out.print("我在这里");
	//System.out.print(u1);
	//System.out.print(u2);
%>


