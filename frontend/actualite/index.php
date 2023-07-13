<?php
require 'rules.php';

if (isset($_GET['pattern'])) {
    $array_of_elements = get_specify_articles($connexion, $_GET['pattern']);
} elseif (isset($_GET['id'])) {
    $specific_article = get_specify_article($connexion, $_GET['id']);
} else {
    $array_of_elements = get_all_articles($connexion);
}
?>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Site d'actualités</title>
    <link rel="shortcut icon" href="favicon.jpeg" type="image/x-icon" />
    <!-- <link rel="stylesheet" href="styles.css" /> -->
    <style>
      html, body{
    height: 99%;
}

.container{
    min-height: 100%;
    border: 4px solid black;
    border-radius: 5px;
}

.first{
    height: 50px;
    border-bottom: 4px solid black;
    text-align: center;
    text-transform: uppercase;
    font-size: 30px;
    font-weight: 900;
    padding-top: 5px;
}
.navbar{
    display: flex;
    align-items: center;
    justify-content:center;
    border-bottom: 4px solid black;
}

.navbar div{
    border: 1px solid black;
    margin-top: 5px;
    margin-bottom: 5px;
    padding: 10px;
}

.navbar div:hover{
    background-color: rgb(201, 197, 197);
    color: white;
    cursor: pointer;
}

.navbar a{
    text-decoration: none;
    color: black;
}

.info{
    position: relative;
    padding: 10px;
}

#solo{
    text-align: center;
    font-size: x-large;
}

.element{
    width: 95%;
    border: 2px solid black;
    border-radius: 5px;
    margin: 10px auto;
    text-align: justify;
    padding: 10px;
}

.element a{

    text-decoration: none;
    color: black;
}

p{
    font-size: x-large;
}

.button {
    display: flex;
    justify-content: space-between;
    margin-right: 50px;
    margin-left: 50px;
}

.button a{
    text-decoration: none;
    color: blue;
}
    </style>
  </head>
  <body>
    <div class="container">
      <div class="first">Actualités Polytchniciennes</div>
      <div class="navbar">
        <div><a href="./index.php">Accueil</a></div>
        <div><a href="./index.php?pattern=Sport">Sport</a></div>
        <div><a href="./index.php?pattern=Santé">Santé</a></div>
        <div><a href="./index.php?pattern=Education">Éducation</a></div>
        <div><a href="./index.php?pattern=Politique">Politique</a></div>
      </div>
      <div class="info">
        <div id="solo">Les dernières actualités</div>
          <?php if ($array_of_elements !== null) {
              foreach ($array_of_elements as $element) {
                  $title = $element['titre'];
                  $contain = $element['contenu'];
                  $longueurMax = 120; // Longueur maximale du début du texte à afficher
                  $debutTexte = substr($contain, 0, $longueurMax);
                  $id = $element['id'];
                  echo "<div class='element'>
                 <a href=\"./index.php?id=$id\">
                <h2>$title</h2>
                <p>$debutTexte</p>
                </a>
                </div>";
              }
          } ?>
          <?php if (
              ($specific_article == null) &
              ($array_of_elements == null)
          ) {
              echo '<h3>Aucun article correspondant !</h3>';
          } elseif (
              ($specific_article !== null) &
              ($array_of_elements == null)
          ) {

              $title = $specific_article['titre'];
              $contain = $specific_article['contenu'];
              $id = $specific_article['id'];
              $pId = $id - 1;
              $sId = $id + 1;
              echo "
                  <div class='element'>
                  <h2>$title</h2>
                  <p>$contain</p>
                  </div>
                  <div class='button'>
                  <a href=\"./index.php?id=$pId\">";
              ?>
                  <?php if ($pId == 0) {
                      echo '';
                  } else {
                      echo '<p>Précédent</p>';
                  } ?>
                  <?php echo "
                </a>
                  <a href=\"./index.php?id=$sId\">"; ?>
                  <?php if ($sId == 6) {
                      echo '';
                  } else {
                      echo '<p>Suivant</p>';
                  } ?>
                  <?php echo "
                </a>
                  </div>
                  ";
          } ?>
      </div>
    </div>
  </body>
</html>
