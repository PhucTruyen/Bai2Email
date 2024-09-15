<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>

<body>
    <div class="container">
        <h1>Thank you for completing our survey!</h1>

        <p>Here is the information that you entered:</p>
        <label class = "label-regular">First Name:</label>
        <span class = "label-thk">${user.firstName}</span><br>

        <label class = "label-regular">Last Name:</label>
        <span class = "label-thk">${user.lastName}</span><br>

        <label class = "label-regular">Email:</label>
        <span class = "label-thk">${user.email}</span><br>

        <label class = "label-regular">Date of Birth:</label>
        <span class = "label-thk">${user.dateOfBirth}</span><br>

        <label class = "label-regular">How did you hear about us:</label>
        <span class = "label-thk">${user.hearabout}</span><br>

        <label class = "label-regular">Receive announcements:</label>
        <span class = "label-thk">${user.announcements}</span><br>

        <label class = "label-regular">Contact method:</label>
        <span class = "label-thk">${user.contactMethod}</span><br>

        <p>To enter another email address, click on the Back 
        button in your browser or the Return button shown 
        below.</p>

        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
    </div>

</body>
</html>
