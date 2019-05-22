<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../resources/css/reset.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Document</title>
</head>
<body>
<main>
    <form action="/gerechten/update/${old.id}" method="post">

        <p>Update gerecht</p>

        <label for="description">Beschrijving</label>
        <input id="description" type="text" placeholder="Beschrijving" name="description" value="${old.description}">

        <label for="price">Prijs</label>
        <input id="price" type="text" placeholder="Prijs" name="price" value="${old.price}">

        <label for="type">Type</label>
        <select name="type" id="type">
            <option>SOEP</option>
            <option>DAGSCHOTEL</option>
            <option>VEGGIE</option>
        </select>

        <input type="submit" value="Update">

    </form>
</main>
</body>
</html>