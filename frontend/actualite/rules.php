<?php
/* informations */
$servername = 'localhost';
$username = 'cheeks';
$password = 'passer123';
$dbname = 'mglsi_news';
$connexion = mysqli_connect($servername, $username, $password, $dbname);
if (!$connexion) {
    die('La connexion a échouée : ' . mysqli_connect_error());
}

function get_all_articles($connexion)
{
    $sql = 'SELECT * FROM Article';
    $result = mysqli_query($connexion, $sql);
    if (mysqli_num_rows($result) > 0) {
        $array_of_elements = [];
        while ($row = mysqli_fetch_assoc($result)) {
            $array_of_elements[] = $row;
        }
        return $array_of_elements;
    }
}

function get_specify_articles($connexion, $type)
{
    $sql = "select * from Article a join Categorie c on a.categorie = c.id where libelle= '$type'";
    $result = mysqli_query($connexion, $sql);
    if (mysqli_num_rows($result) > 0) {
        $array_of_elements = [];
        while ($row = mysqli_fetch_assoc($result)) {
            $array_of_elements[] = $row;
        }
        return $array_of_elements;
    }
}

function get_specify_article($connexion, $id)
{
    $sql = "select * from Article where id='$id'";
    $result = mysqli_query($connexion, $sql);
    if (mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);
        return $row;
    }
}

?>
