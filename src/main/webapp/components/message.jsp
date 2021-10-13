<%
	String message = (String) session.getAttribute("message");
	
	//Print message
	if(message != null)
	{
		%><h5 class="alert alert-danger"><%out.println(message);%></h5>
		<%}
		//remove session attribute
	session.removeAttribute("message");

%>