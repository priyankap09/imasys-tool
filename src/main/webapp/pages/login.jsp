<html>
<head>
	<link href="css/common.css" rel="stylesheet"></link>
	
	<style>
		div
		{
			text-align: center;
			padding-top: 30px;
			padding-bottom: 30px;
			padding-left: inherit;
			background-color: gray;
			border: 5px solid grey;
		}
	</style>
</head>

<div>
	<form>
	
		<label>User name:</label> 
		<input type="text" name="username" placeholder="Enter username"> 	<br><br>
		<label>Password:</label>
		<input type ="password" name="password" placeholder="Enter password" style="padding: 5px 3px"> 	<br><br>
		<label>Role:</label>
	
		<input type="submit" value="login" formaction="validate" class="btn1">
		<a href="register">Sign up</a><br><br>
		<span  style="color:orange; font-size:larger;" >${message }</span>
	</form>
</div>
</html>


