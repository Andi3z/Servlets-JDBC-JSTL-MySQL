<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit phone record</title>
</head>
<body>
<h3>Edit phone record</h3>
<form method="post">
<input type="hidden" value="${record.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${record.name}" /><br><br>
<label>Phone</label><br>
<input name="phone" value="${record.phone}" type="number" min="1" /><br><br>
<label>Note</label><br>
<input name="note" value="${record.note}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>