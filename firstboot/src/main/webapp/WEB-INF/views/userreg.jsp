<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
	<form action="testsubmit" method="post" modelAttribute="logindata">

		<div>
			User Name : <input type="text" name="userName" />
		</div>
		<div>
		User Email : <input type="text" name="userEmail" />
		</div>
		<div>
		User Phone Number : <input type="text" name="userPhoneNumber" />
		</div>
			<div>
		<button type="submit">Login</button>
</div>


	</form>


</body>
</html>