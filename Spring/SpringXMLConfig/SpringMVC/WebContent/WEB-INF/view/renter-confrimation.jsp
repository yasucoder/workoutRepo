<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Renter - Confirmation Form</title>
</head>
<body>

The Renter is confirmed: ${renter.firstName} ${renter.lastName}  occupied ${renter.parkinglot} parking spaces.
<br>
postal Code:  ${renter.postalCode}
<br>
Apt No:  ${renter.aptCode}


</body>
</html>